package com.zgh.server.api.config

import com.baomidou.mybatisplus.annotation.DbType
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * MybatisPlus配置
 */
@Configuration
@ConditionalOnProperty(prefix = "spring.datasource", name = ["url"])
class MybatisPluginAutoConfig {
    @Bean
    fun mybatisPlusInterceptor(): MybatisPlusInterceptor {
        val mybatisPlusInterceptor = MybatisPlusInterceptor()
        mybatisPlusInterceptor.addInnerInterceptor(paginationInterceptor())
        mybatisPlusInterceptor.addInnerInterceptor(optimisticLockerInterceptor())
        return mybatisPlusInterceptor
    }

    /**
     * 新的分页插件,一缓和二缓遵循mybatis的规则,需要设置 MybatisConfiguration#useDeprecatedExecutor = false 避免缓存出现问题
     */
    @Bean
    fun paginationInterceptor(): PaginationInnerInterceptor {
        val paginationInnerInterceptor = PaginationInnerInterceptor()
        paginationInnerInterceptor.dbType = DbType.MYSQL
        return paginationInnerInterceptor
    }

    /**
     * 自定义公共字段自动注入
     */
    /*@Bean
    @ConditionalOnMissingBean
    fun metaObjectHandler(): MetaObjectHandler {
        return CustomMetaObjectHandler()
    }
*/

    /**
     * 乐观锁mybatis插件
     */
    @Bean
    fun optimisticLockerInterceptor(): OptimisticLockerInnerInterceptor {
        return OptimisticLockerInnerInterceptor()
    }

}