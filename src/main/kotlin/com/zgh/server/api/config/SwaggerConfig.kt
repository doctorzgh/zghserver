/**
 * Copyright 2018-2020 stylefeng & fengshuonan (https://gitee.com/stylefeng)
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zgh.server.api.config

import springfox.documentation.swagger2.annotations.EnableSwagger2
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration
import org.springframework.beans.factory.annotation.Autowired
import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.spi.DocumentationType
import springfox.documentation.builders.RequestHandlerSelectors
import io.swagger.annotations.ApiOperation
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import springfox.documentation.builders.PathSelectors
import springfox.documentation.spi.service.contexts.SecurityContext
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.service.*
import java.util.ArrayList

/**
 * swagger配置类
 *
 * @author fengshuonan
 * @date 2017年6月1日19:42:59
 */
@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration::class)
class SwaggerConfig @Autowired constructor(private val openApiExtensionResolver: OpenApiExtensionResolver) {
    @Bean
    fun createRestApi(): Docket {
        return Docket(DocumentationType.OAS_30)
            .apiInfo(apiInfo())
            .groupName("api")
            .select() //这里采用包含注解的方式来确定要显示的接口
            .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation::class.java))
            .paths(PathSelectors.any())
            .build()
            .securitySchemes(securitySchemes())
            .securityContexts(securityContexts())
            .extensions(openApiExtensionResolver.buildSettingExtensions())
    }

    private fun securitySchemes(): List<ApiKey> {
        val apiKeys: MutableList<ApiKey> = ArrayList()
        apiKeys.add(ApiKey("Authorization", "Authorization", "header"))
        return apiKeys
    }

    private fun securityContexts(): List<SecurityContext> {
        val securityContexts: MutableList<SecurityContext> = ArrayList()
        securityContexts.add(
            SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("^(?!auth).*$")).build()
        )
        return securityContexts
    }

    private fun defaultAuth(): List<SecurityReference> {
        val authorizationScope = AuthorizationScope("global", "accessEverything")
        val authorizationScopes = arrayOfNulls<AuthorizationScope>(1)
        authorizationScopes[0] = authorizationScope
        val securityReferences: MutableList<SecurityReference> = ArrayList()
        securityReferences.add(SecurityReference("Authorization", authorizationScopes))
        return securityReferences
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder()
            .title("ZGH Doc")
            .description("ZGH Api文档")
            .termsOfServiceUrl("https://zgh.com")
            .contact(Contact("ZGH", "https://zgh.com", ""))
            .version("1.0")
            .build()
    }
}