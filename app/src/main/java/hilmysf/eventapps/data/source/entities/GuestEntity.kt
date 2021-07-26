package hilmysf.eventapps.data.source.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "guestentity")
data class GuestEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int? = 0,

    @ColumnInfo(name = "nama")
    var nama: String? = null,

    @ColumnInfo(name = "birthDate")
    var birthDate: String? = null,

    @ColumnInfo(name = "image")
    var image: Int? = 0
)
