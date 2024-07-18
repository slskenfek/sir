package com.orders.sir.config.`security-back`

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.io.Serializable

class CustomUserDetails(
    var franchiseeIdx: Long,
    var userIdx: Long? = null,
    private val userPassword: String,
    private var username: String = "",
    var authLevel: Int? = null,
    private val authority: String? = null,
) : UserDetails, Serializable {
    companion object {
        const val serialVersionUID = -3210535496837346951L
    }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        val auth = ArrayList<GrantedAuthority>()
        auth.add(SimpleGrantedAuthority(authority))
        return auth
    }

    fun getAuthority() = this.authority
    override fun getPassword(): String {
        return userPassword
    }

    override fun getUsername(): String {
        return username
    }

    // 계정의 만료 여부 리턴
    override fun isAccountNonExpired(): Boolean {
        return true
    }

    // 계정의 잠김 여부 리턴
    override fun isAccountNonLocked(): Boolean {
        return true
    }

    // 비밀번호 만료 여부 리턴
    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    // 계정의 활성화 여부 리턴
    override fun isEnabled(): Boolean {
        return true
    }
}
