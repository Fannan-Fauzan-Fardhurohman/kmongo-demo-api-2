package com.fanxan.tokohandphone

data class BaseResponse<T> (
    var status: Boolean = false,
    var messages: String = "",
    var data: T? = null
)