package com.zgh.server.api.response

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel(description = "通用响应返回对象")
class ResponseData<T> {

    @ApiModelProperty(value = "请求是否成功")
    var success: Boolean? = true

    @ApiModelProperty(value = "响应状态码")
    var code = 200

    @ApiModelProperty(value = "响应信息")
    var msg: String? = "成功"

    @ApiModelProperty(value = "响应对象")
    var data: T? = null

    companion object {

        fun error(code: Int = 500, msg: String = "未知异常，请联系管理员", success: Boolean = false): ResponseData<Nothing> {
            val r = ResponseData<Nothing>()
            r.code = code
            r.msg = msg
            r.success = success
            return r
        }

        fun <T> success(
            code: Int = 200,
            msg: String = "成功",
            success: Boolean = true,
            data: T? = null
        ): ResponseData<T> {
            val r = ResponseData<T>()
            r.msg = msg
            r.code = code
            r.success = success
            r.data = data
            return r
        }


    }
}
