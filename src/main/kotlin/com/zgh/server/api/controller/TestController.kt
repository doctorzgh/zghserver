package com.zgh.server.api.controller

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import lombok.extern.slf4j.Slf4j
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author zgh
 * @date 2021/1/30 18:33
 * @Description:
 */
@Api(tags = ["test"])
@Slf4j
@RestController
@RequestMapping("/api/test")
class TestController {

    @ApiOperation(value = "hello")
    @ApiOperationSupport(author = "zgh")
    @GetMapping(value = ["/hello"])
    fun hello(): String {
        return "hello"
    }

}