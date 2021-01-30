package com.zgh.server.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ZghApplication

fun main(args: Array<String>) {
	runApplication<ZghApplication>(*args)
}
