package com.orders.sir.config

import com.fasterxml.jackson.databind.ObjectMapper
import io.swagger.v3.core.converter.ModelConverters
import io.swagger.v3.core.jackson.ModelResolver
import io.swagger.v3.core.jackson.TypeNameResolver
import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.security.SecurityRequirement
import io.swagger.v3.oas.models.security.SecurityScheme
import io.swagger.v3.oas.models.servers.Server
import jakarta.annotation.PostConstruct
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig(private val objectMapper: ObjectMapper) {
    @PostConstruct
    fun initialize() {
        val innerClassAwareTypeNameResolver = object : TypeNameResolver() {
            override fun getNameOfClass(cls: Class<*>): String {
                return cls.name
                    .substringAfterLast(".")
                    .replace("$", ".")
            }
        }

        ModelConverters
            .getInstance()
            .addConverter(ModelResolver(objectMapper, innerClassAwareTypeNameResolver))
    }

    @Bean
    fun openAPI(): OpenAPI {
        val localServer = Server()
            .url("http://localhost:9080")
            .description("Local Server")
        val testServer = Server()
            .url("http://183.103.138.220:9080")
            .description("Test Server")
        return OpenAPI()
            .servers(listOf(localServer, testServer))
            .info(apiInfo())
            .addSecurityItem(SecurityRequirement().addList("api_key"))
            .components(
                Components()
                    .addSecuritySchemes(
                        "api_key",
                        SecurityScheme().name("api_key").description("bearer")
                            .type(SecurityScheme.Type.APIKEY)
                            .`in`(SecurityScheme.In.HEADER)
                            .name("Authorization"),
                    ),
            )
    }

    @Bean
    fun group1(): GroupedOpenApi =
        GroupedOpenApi.builder()
            .group("전체")
            .pathsToMatch("/api/**", "/view/**")
            .build()

    private fun apiInfo(): Info {
        return Info()
            .title("mobyPAY API ")
            .description("모비페이 API 정의")
            .version("1.0.0")
    }
}
