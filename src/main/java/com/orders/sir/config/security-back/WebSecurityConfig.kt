package com.orders.sir.config.`security-back`

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

/*@EnableMethodSecurity
@Configuration*/
class WebSecurityConfig(
    private val jwtAuthenticationFilter: JwtAuthenticationFilter,
    private val entryPoint: JwtAuthenticationEntryPoint,
    private val jwtAccessDeniedHandler: JwtAccessDeniedHandler,
) {
    @Value("#{'\${client.permit.hosts}'.split(',')}")
    private lateinit var hosts: List<String>

    @Bean
    fun filterChain(http: HttpSecurity): DefaultSecurityFilterChain {
        http
            .httpBasic().disable()
            .csrf().disable()
            .headers { it.frameOptions().sameOrigin() }
            .authorizeHttpRequests {
                it.requestMatchers(
                    AntPathRequestMatcher("/swagger-ui/**"),
                    AntPathRequestMatcher("/h2-console/**"),
                    AntPathRequestMatcher("/favicon.ico"),
                    AntPathRequestMatcher("/error"),
                    AntPathRequestMatcher("/swagger-ui/**"),
                    AntPathRequestMatcher("/swagger-resources/**"),
                    AntPathRequestMatcher("/v3/api-docs/**"),
                    AntPathRequestMatcher("/resources/**"),
                    AntPathRequestMatcher("/api/auth/**"),
                    AntPathRequestMatcher("/socket/**"),
                ).permitAll()
                    .anyRequest()
                    .authenticated()
            }
            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.ALWAYS) }
            .exceptionHandling {
                it.authenticationEntryPoint(entryPoint).accessDeniedHandler(jwtAccessDeniedHandler)
            }.addFilterBefore(
                jwtAuthenticationFilter,
                BasicAuthenticationFilter::class.java,
            ).cors()
        return http.build()
    }

    @Bean
    fun passwordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        val source = UrlBasedCorsConfigurationSource()
        val config = CorsConfiguration()
        config.allowedOrigins = hosts
        // 허용할 HTTP 메서드 설정
        config.allowedMethods = listOf("GET", "POST", "PUT", "DELETE")

        // 필요한 경우 허용할 헤더 설정
        config.allowedHeaders = listOf("*")

        // 인증 정보 허용 여부 설정
        config.allowCredentials = true

        source.registerCorsConfiguration("/**", config)
        return source
    }
}
