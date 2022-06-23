package com.fanxan.tokohandphone.services

import com.fanxan.tokohandphone.model.DataModel
import com.mongodb.client.result.DeleteResult
import com.mongodb.client.result.UpdateResult
import org.litote.kmongo.Id

interface HandphoneServices {
    fun getUserByName(name: String): DataModel?
    fun getHandphones(): List<DataModel>
    fun addHandphone(user: DataModel): List<DataModel>
    fun getIdHandphone(id:String): DataModel?
    fun deleteHandphone(name:String): DataModel?
    fun updateHandphone(user:String,update:DataModel): DataModel?
}