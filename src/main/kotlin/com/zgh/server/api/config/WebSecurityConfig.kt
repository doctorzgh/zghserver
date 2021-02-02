package com.zgh.server.api.config

import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import javax.annotation.Resource


/**
 * @author  zgh
 * @date  2021/1/31 13:52
 * @Description:
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled = true, securedEnabled = true, prePostEnabled = true)
class WebSecurityConfig : WebSecurityConfigurerAdapter() {

    @Resource
    lateinit var ignoreUrlsConfig: IgnoreUrlsConfig

    override fun configure(http: HttpSecurity?) {
        http?.authorizeRequests()?.antMatchers(
            HttpMethod.GET,
            "/v3/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/doc.html/**",
            "/webjars/**"
        )
            ?.permitAll()
            ?.antMatchers(HttpMethod.OPTIONS)
            ?.permitAll()
            ?.antMatchers(*ignoreUrlsConfig.urls.toTypedArray())
            ?.permitAll()
            ?.and()
            ?.authorizeRequests()
            ?.anyRequest()
            ?.authenticated()
            // 关闭跨站请求防护及不使用session
            ?.and()
            ?.csrf()
            ?.disable()
            ?.sessionManagement()
            ?.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            // 自定义权限拒绝处理类
            ?.and()
            ?.exceptionHandling()
//            .authenticationEntryPoint(unauthorizedHandler)
            // 自定义权限拦截器JWT过滤器
            ?.and()
//            .addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter::class.java)
    }
}