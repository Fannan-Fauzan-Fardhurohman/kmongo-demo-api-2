package com.fanxan.tokohandphone.repository

import com.fanxan.tokohandphone.model.DataModel
import com.mongodb.client.result.DeleteResult
import com.mongodb.client.result.UpdateResult

interface HandphoneRepository {
    fun getUserByname(name:String) : DataModel?
    fun getUsers():List<DataModel>
    fun addUser(data:DataModel):List<DataModel>
    fun deleteUserByname(name:String): DataModel?
    fun updateData(name:String,update:DataModel): DataModel?
}