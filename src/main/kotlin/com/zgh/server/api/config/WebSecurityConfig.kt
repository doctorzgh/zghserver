package com.zgh.server.api.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

/**
 * @author  zgh
 * @date  2021/1/31 13:52
 * @Description:
 */
@Configuration
@EnableWebSecurity
class WebSecurityConfig :WebSecurityConfigurerAdapter(){

}