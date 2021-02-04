package com.zgh.server.api.controller

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport
import com.zgh.server.api.model.User
import com.zgh.server.api.response.ResponseData
import com.zgh.server.api.service.UserService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import lombok.extern.slf4j.Slf4j
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.Resource

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

    @Resource
    lateinit var userService: UserService

    @ApiOperation(value = "hello")
    @ApiOperationSupport(author = "zgh")
    @GetMapping(value = ["/hello"])
    fun hello(): ResponseData<List<User>> {
        val list = userService.ktQuery().list()
        return ResponseData.success(data = list)
    }

}