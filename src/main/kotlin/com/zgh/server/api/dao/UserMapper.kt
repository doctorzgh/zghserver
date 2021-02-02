package com.zgh.server.api.dao

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.zgh.server.api.model.User
import org.springframework.stereotype.Repository

/**
 * @Author: zgh
 * @Date: 11/23/20 3:22 PM
 * @Description:
 *
 */
@Repository
interface UserMapper : BaseMapper<User> {
}