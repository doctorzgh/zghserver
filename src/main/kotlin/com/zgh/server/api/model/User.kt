package com.zgh.server.api.model

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName

/**
 * @Author: zgh
 * @Date: 11/23/20 3:22 PM
 * @Description:
 *
 */
@TableName("user")
data class User(
    @TableId(type = IdType.AUTO)
    var id: Long? = null,
    var nickName: String? = "",
    var realName: String? = "",
)