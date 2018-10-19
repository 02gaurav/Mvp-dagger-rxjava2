package com.example.apple.mindsharpner.data.local

import android.os.Parcel
import android.os.Parcelable
import com.example.apple.mindsharpner.data.local.entity.BaseEntity
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName
import org.json.JSONException
import org.json.JSONObject
import java.lang.reflect.Type

class QuestionEntity() : BaseEntity<QuestionEntity>(), Parcelable {

    companion object  CREATOR : Parcelable.Creator<QuestionEntity> {

        override fun createFromParcel(parcel: Parcel): QuestionEntity {
            return QuestionEntity(parcel)
        }

        override fun newArray(size: Int): Array<QuestionEntity?> {
            return arrayOfNulls(size)
        }

        fun parseQuestion(question : JSONObject) : QuestionEntity? {

            try {
                val questionEntity =  QuestionEntity()

                questionEntity.quesId = question.getString("quesId")
                questionEntity.question = question.getString("question")
                questionEntity.option1 = question.getString("option1")
                questionEntity.option2 = question.getString("option2")
                questionEntity.option3 = question.getString("option3")
                questionEntity.option4 = question.getString("option4")
                questionEntity.isAnswered = question.getBoolean("isAnswered")

                return questionEntity

            } catch (e: JSONException) {
                e.printStackTrace()
                return null
            }
        }
    }

    @SerializedName("quesId")
    var quesId: String = ""

    @SerializedName("question")
    var question: String = ""

    @SerializedName("option1")
    var option1: String = ""

    @SerializedName("option2")
    var option2: String = ""

    @SerializedName("option3")
    var option3: String = ""

    @SerializedName("option4")
    var option4: String = ""

    @SerializedName("isAnswered")
    var isAnswered: Boolean = false

    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): QuestionEntity? {
        try {
            val question = JSONObject(json.toString())
            return parseQuestion(question)
        } catch (e: JSONException) {
            e.printStackTrace()
            return null
        }
    }

    constructor(parcel: Parcel) : this() {
        quesId = parcel.readString() ?: ""
        question = parcel.readString() ?: ""
        option1 = parcel.readString() ?: ""
        option2 = parcel.readString() ?: ""
        option3 = parcel.readString() ?: ""
        option4 = parcel.readString() ?: ""
        isAnswered = parcel.readByte() != 0.toByte()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(quesId)
        parcel.writeString(question)
        parcel.writeString(option1)
        parcel.writeString(option2)
        parcel.writeString(option3)
        parcel.writeString(option4)
        parcel.writeByte(if (isAnswered) 1 else 0)

    }

    override fun describeContents(): Int {
        return 0
    }


}
