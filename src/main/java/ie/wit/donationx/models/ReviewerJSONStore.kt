/*
package ie.wit.donationx.models


import android.content.Context
import android.net.Uri
import com.google.gson.*
import com.google.gson.reflect.TypeToken
import ie.wit.donationx.helpers.*
import timber.log.Timber
import java.lang.reflect.Type
import java.util.*

const val JSON_FILE = "reviewers.json"
val gsonBuilder: Gson = GsonBuilder().setPrettyPrinting()
    .registerTypeAdapter(Uri::class.java, UriParser())
    .create()
val listType: Type = object : TypeToken<ArrayList<ReviewerModel>>() {}.type

fun generateRandomId(): Long {
    return Random().nextLong()
}

class ReviewerJSONStore(private val context: Context) : ReviewerStore {

    var reviewers = mutableListOf<ReviewerModel>()

    init {
        if (exists(context, JSON_FILE)) {
            deserialize()
        }
    }

    override fun findAll(): MutableList<ReviewerModel> {
        logAll()
        return reviewers
    }

    override fun create(placemark: ReviewerModel) {
        placemark.id = generateRandomId()
        reviewers.add(reviewer)
        serialize()
    }


    override fun update(reviewer: ReviewerModel) {
        // todo
    }

    private fun serialize() {
        val jsonString = gsonBuilder.toJson(reviewers, listType)
        write(context, JSON_FILE, jsonString)
    }

    private fun deserialize() {
        val jsonString = read(context, JSON_FILE)
        reviewers = gsonBuilder.fromJson(jsonString, listType)
    }

    private fun logAll() {
        reviewers.forEach { Timber.i("$it") }
    }
}

class UriParser : JsonDeserializer<Uri>,JsonSerializer<Uri> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Uri {
        return Uri.parse(json?.asString)
    }

    override fun serialize(
        src: Uri?,
        typeOfSrc: Type?,
        context: JsonSerializationContext?
    ): JsonElement {
        return JsonPrimitive(src.toString())
    }
}
*/
