package com.fanxan.tokohandphone.repository

import com.fanxan.tokohandphone.database.DatabaseComponent
import com.fanxan.tokohandphone.model.DataModel
import com.mongodb.client.MongoCollection
import org.bson.types.ObjectId
import org.litote.kmongo.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class HandphoneRepositoryImpl : HandphoneRepository {
    @Autowired
    private lateinit var databaseComponent: DatabaseComponent

    private fun handphoneCollection(): MongoCollection<DataModel> =
        databaseComponent.database.getDatabase("toko_hp").getCollection()

//    override fun getUserByname(kodeMerk: String): DataModel? {
//        return handphoneCollection().findOne {
//            DataModel::kodeMerk eq kodeMerk
//        }
//    }


    override fun getUserByname(id: String): DataModel? {
        return handphoneCollection().findOneById(id)
    }

    override fun getUsers(): List<DataModel> {
        return handphoneCollection().find().toList()
    }

    override fun addUser(data: DataModel): List<DataModel> {
        val insert = handphoneCollection().insertOne(data)
        return if (insert.wasAcknowledged()) {
            getUsers()
        } else {
            throw IllegalStateException("insert gagal")
        }
    }

    override fun deleteUserByname(id: String): DataModel? {
        val delete = handphoneCollection().deleteOneById(id)

        return if (delete.wasAcknowledged()) {
            getUserByname(id)
        } else {
            throw IllegalStateException("update gagal")
        }
    }

    override fun updateData(name: String, update: DataModel): DataModel? {
        val update = handphoneCollection().updateOneById(name, update)
        println("<><><> $name")
        return if (update.wasAcknowledged()) {
            getUserByname(name)
        } else {
            throw IllegalStateException("update gagal")
        }
    }
}