package com.zgh.server.api.controller

import com.baomidou.mybatisplus.core.toolkit.StringUtils
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport
import com.zgh.server.api.model.User
import com.zgh.server.api.response.ResponseData
import com.zgh.server.api.service.UserService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import lombok.extern.slf4j.Slf4j
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.annotation.Resource

/**
 * @author zgh
 * @date 2021/1/30 18:33
 * @Description:
 */
@Api(tags = ["User"])
@Slf4j
@RestController
@RequestMapping("/api/user")
class TestController {

    @Resource
    lateinit var userService: UserService

    @ApiOperation(value = "getList")
    @ApiOperationSupport(author = "zgh")
    @GetMapping(value = ["/getList"])
    fun getList(): ResponseData<List<User>> {
        val list = userService.ktQuery().list()
        return ResponseData.success(data = list)
    }

    @ApiOperation(value = "getPage")
    @ApiOperationSupport(author = "zgh")
    @GetMapping(value = ["/getPage"])
    fun getPage(page: Page<User>, user: User): ResponseData<Page<User>> {
        userService.ktQuery()
            .eq(Objects.nonNull(user.id), User::id, user.id)
            .like(StringUtils.isNotBlank(user.nickName), User::nickName, user.nickName)
            .like(StringUtils.isNotBlank(user.realName), User::realName, user.realName)
            .page(page)
        return ResponseData.success(data = page)
    }

    @ApiOperation(value = "saveOrUpdate")
    @ApiOperationSupport(author = "zgh")
    @PostMapping(value = ["/saveOrUpdate"])
    fun add(@RequestBody user: User): ResponseData<Nothing> {
        userService.saveOrUpdate(user)
        return ResponseData.success()
    }

}