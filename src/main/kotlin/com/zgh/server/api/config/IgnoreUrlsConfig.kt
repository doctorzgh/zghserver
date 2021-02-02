package com.zgh.server.api.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

/**
 * 用于配置白名单资源路径
 * Created by macro on 2018/11/5.
 */
@Component
@ConfigurationProperties(prefix = "secure.ignored")
data class IgnoreUrlsConfig(val urls: List<String> = ArrayList())