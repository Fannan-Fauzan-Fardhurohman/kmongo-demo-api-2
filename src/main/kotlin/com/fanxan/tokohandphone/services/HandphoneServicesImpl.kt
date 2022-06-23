package com.fanxan.tokohandphone.services

import com.fanxan.tokohandphone.model.DataModel
import com.fanxan.tokohandphone.repository.HandphoneRepository
import com.mongodb.client.result.DeleteResult
import com.mongodb.client.result.UpdateResult
import org.bson.types.ObjectId
import org.litote.kmongo.Id
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class HandphoneServicesImpl : HandphoneServices {
    @Autowired
    private lateinit var handphoneRepository: HandphoneRepository
    override fun getUserByName(name: String): DataModel? {
        return handphoneRepository.getUserByname(name)
    }

    override fun getHandphones(): List<DataModel> {
        return handphoneRepository.getUsers()
    }

    override fun addHandphone(user: DataModel): List<DataModel> {
        val users = user::_id
        println("INI ADALAH ID $users")
        return handphoneRepository.addUser(user)
    }

    override fun getIdHandphone(id :String):DataModel? {
        return handphoneRepository.getUserByname(id)
    }

    override fun deleteHandphone(name: String): DataModel? {
        return handphoneRepository.deleteUserByname(name)
    }

    override fun updateHandphone(user: String, update: DataModel): DataModel? {
        return handphoneRepository.updateData(user, update)
    }
}