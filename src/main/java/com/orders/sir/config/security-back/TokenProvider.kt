package com.orders.sir.config.`security-back`

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.PropertySource
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.sql.Date
import java.sql.Timestamp
import java.time.Instant
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.util.UUID
import javax.crypto.spec.SecretKeySpec

@PropertySource("classpath:jwt.yml")
@Component
class TokenProvider(
    @Value("\${secret-key}")
    private val secretKey: String,
    @Value("\${access-expiration-hours}")
    private val accessExpirationHours: Long,
    @Value("\${refresh-expiration-hours}")
    private val refreshExpirationHours: Long,
    @Value("\${issuer}")
    private val issuer: String,
) {

    fun generateToken(userDetails: UserDetails): String {
        val customUser = userDetails as CustomUserDetails
        val claims = mutableMapOf<String, Any>()

        claims["user_idx"] = customUser.userIdx.toString().toLong()
        claims["franchisee_idx"] = customUser.franchiseeIdx.toString().toLong()
        claims["user_role"] = customUser.getAuthority()!!
        return createToken(claims, "access_token_data")
    }

    fun createToken(claims: Map<String, Any>, subject: String) = Jwts.builder()
        .signWith(
            SecretKeySpec(
                secretKey.toByteArray(),
                SignatureAlgorithm.HS512.jcaName,
            ),
        ) // HS512 알고리즘을 사용하여 secretKey를 이용해 서명
        .setSubject(subject) // JWT 토큰 제목
        .setClaims(claims)
        .setIssuer(issuer) // JWT 토큰 발급자
        .setIssuedAt(Timestamp.valueOf(LocalDateTime.now())) // JWT 토큰 발급 시간
        .setExpiration(Date.from(Instant.now().plus(accessExpirationHours, ChronoUnit.MINUTES))) // 엑세스 토큰의 3분 만료시간 설정
        .compact()!! // JWT 토큰 생성

    fun refreshToken(): String = UUID.randomUUID().toString()

    fun validateTokenAndGetSubject(token: String): Claims? = try {
        Jwts.parserBuilder()
            .setSigningKey(secretKey.toByteArray())
            .build()
            .parseClaimsJws(token)
            .body
    } catch (e: Exception) {
        throw e
    }
}
