package com.fanxan.tokohandphone.model

import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id
import org.litote.kmongo.newId
import java.util.*


data class DataModel(
    @BsonId
    var _id: String = UUID.randomUUID().toString(),
//    var _id: Id<DataModel> = newId(),
    var namaModel: String,
    var harga: Double,
    var kodeMerk: String,
    var garansi: Boolean,
)
