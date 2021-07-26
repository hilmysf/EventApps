package hilmysf.eventapps.data.source

import hilmysf.eventapps.data.source.entities.GuestEntity
import hilmysf.eventapps.data.source.room.GuestDao
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val mGuestDao: GuestDao){

    suspend fun getAllData(): List<GuestEntity> = mGuestDao.getAllData()

    suspend fun insertData(guestLists: List<GuestEntity>) = mGuestDao.insertData(guestLists)
}