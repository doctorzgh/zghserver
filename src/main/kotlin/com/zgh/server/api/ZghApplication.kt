package com.zgh.server.api

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@MapperScan("com.zgh.server.api.dao")
class ZghApplication

fun main(args: Array<String>) {
    runApplication<ZghApplication>(*args)
}
