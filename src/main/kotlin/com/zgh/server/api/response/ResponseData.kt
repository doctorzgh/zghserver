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

        fun error(msg: String): ResponseData<Nothing> {
            return error(500, msg)
        }

        @JvmOverloads
        fun error(code: Int = 500, msg: String = "未知异常，请联系管理员"): ResponseData<Nothing> {
            val r = ResponseData<Nothing>()
            r.code = code
            r.msg = msg
            r.success = false
            return r
        }

        fun success(msg: String): ResponseData<Nothing> {
            val r = ResponseData<Nothing>()
            r.msg = msg
            return r
        }

        fun <T> success(data: T?): ResponseData<T> {
            val r = ResponseData<T>()
            r.data = data
            return r
        }

        fun success(): ResponseData<Nothing> {
            return ResponseData()
        }
    }
}
