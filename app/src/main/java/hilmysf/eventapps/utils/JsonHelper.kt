package hilmysf.eventapps.utils

import android.content.Context
import androidx.core.content.res.ResourcesCompat
import hilmysf.eventapps.R
import hilmysf.eventapps.data.GuestEntity
import hilmysf.eventapps.data.GuestImageDummy
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadGuests(): ArrayList<GuestEntity> {
        val list = ArrayList<GuestEntity>()
        try {
            val response = JSONArray(parsingFileToString("guest.json").toString())
            for (i in 0 until response.length() ) {
                val guest = response.getJSONObject(i)

                val id = guest.getInt("id")
                val name = guest.getString("name")
                val birthdate = guest.getString("birthdate")
                var image = GuestImageDummy.guestImage[i].image

                val guestEntity = GuestEntity(id, name, birthdate, image)
                list.add(guestEntity)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }
}