package hilmysf.eventapps.data.source.room

import androidx.room.Database
import androidx.room.RoomDatabase
import hilmysf.eventapps.data.source.entities.EventEntity
import hilmysf.eventapps.data.source.entities.GuestEntity

@Database(
    entities = [GuestEntity::class],
    version = 1,
    exportSchema = false
)
abstract class GuestDatabase: RoomDatabase() {
    abstract fun guestDao(): GuestDao
}