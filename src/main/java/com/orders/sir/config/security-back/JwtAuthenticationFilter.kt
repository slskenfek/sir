package com.orders.sir.config.`security-back`

import io.jsonwebtoken.ExpiredJwtException
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpHeaders
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetails
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtAuthenticationFilter(
    private val tokenProvider: TokenProvider,
) : OncePerRequestFilter() {
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain,
    ) {
        try {
            println("==================== 필터 in ============================")

            val token = this.parseBearerToken(request)
            if (token == "null" || token == null) {
                return filterChain.doFilter(request, response)
            }

            val user = this.parseUserSpecification(token)

            UsernamePasswordAuthenticationToken.authenticated(
                user,
                token,
                user?.authorities,
            ).apply {
                this.details = WebAuthenticationDetails(request)
            }.also {
                SecurityContextHolder.getContext().authentication = it
            }
        } catch (e: ExpiredJwtException) {
            logger.error("토큰이 만료 되었습니다.")
            return response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "토큰이 만료 되었습니다.")
        } catch (e: Exception) {
            e.printStackTrace()
            logger.error("${e.message} #토큰 검증중 에러 발생")
            return response.sendError(HttpServletResponse.SC_FORBIDDEN, "${e.message} #토큰 검증중 에러 발생")
        }
        filterChain.doFilter(request, response)
    }

    private fun parseBearerToken(request: HttpServletRequest) = request.getHeader(HttpHeaders.AUTHORIZATION)
        .takeIf {
            it?.startsWith("Bearer ", true) ?: false
        }?.substring(7)

    private fun parseUserSpecification(token: String?) = (
        token?.takeIf { it.length >= 10 }
            ?.let {
                tokenProvider.validateTokenAndGetSubject(it)
            }
        )?.let {
        CustomUserDetails(
            franchiseeIdx = it["franchisee_idx"].toString().toLong(),
            userIdx = it["user_idx"].toString().toLong(),
            userPassword = "",
            authority = it["user_role"].toString(),
        )
    }
}
