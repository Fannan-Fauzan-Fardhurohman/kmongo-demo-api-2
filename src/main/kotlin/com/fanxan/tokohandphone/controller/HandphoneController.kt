package com.fanxan.tokohandphone.controller

import com.fanxan.tokohandphone.BaseResponse
import com.fanxan.tokohandphone.model.DataModel
import com.fanxan.tokohandphone.services.HandphoneServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/toko/handphone")
class HandphoneController {
    @Autowired
    private lateinit var  handphoneServices: HandphoneServices
    @PostMapping
    fun addUser(
        @RequestBody user: DataModel
    ):
            BaseResponse<List<DataModel>> {
        return BaseResponse(
            status = true,
            messages = "Success",
            data = handphoneServices.addHandphone(user)
        )
    }

    @GetMapping
    fun getUsers(): BaseResponse<List<DataModel>> {
        return BaseResponse(
            status = true,
            messages = "Success",
            data = handphoneServices.getHandphones()
        )
    }

    @GetMapping("/{name}")
    fun getUser(
        @PathVariable(value = "name") userName: String
    ): BaseResponse<DataModel> {
        return BaseResponse(
            status = true,
            messages = "Success",
            data = handphoneServices.getUserByName(userName)
        )
    }

    @PutMapping("/{id}")
    fun updateHp(
        @PathVariable id: String,
        @RequestBody Hp: DataModel
    ): BaseResponse<DataModel> {
        return BaseResponse(true, "update data Hp", handphoneServices.updateHandphone(id, Hp))
    }
    @DeleteMapping("/{id}")
    fun deleteHp(
        @PathVariable(value = "id") id: String
    ): BaseResponse<DataModel> {
        return BaseResponse(true, "delete data Hp", handphoneServices.deleteHandphone(id))
    }
}