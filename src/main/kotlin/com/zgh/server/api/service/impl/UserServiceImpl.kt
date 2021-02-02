package com.zgh.server.api.service.impl

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.zgh.server.api.dao.UserMapper
import com.zgh.server.api.model.User
import com.zgh.server.api.service.UserService
import org.springframework.stereotype.Service

/**
 * @Author: zgh
 * @Date: 11/25/20 11:02 AM
 * @Description:
 *
 */
@Service
class UserServiceImpl : ServiceImpl<UserMapper, User>(), UserService {
}