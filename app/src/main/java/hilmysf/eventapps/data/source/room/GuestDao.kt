package hilmysf.eventapps.data.source.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import hilmysf.eventapps.data.source.entities.GuestEntity

@Dao
interface GuestDao {

    @Query("SELECT * FROM guestentity")
    suspend fun getAllData(): List<GuestEntity>

    @Insert
    suspend fun insertData(guestLists: List<GuestEntity>)
}