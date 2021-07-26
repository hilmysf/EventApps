package hilmysf.eventapps.data.repositories

import hilmysf.eventapps.data.source.LocalDataSource
import hilmysf.eventapps.data.source.entities.GuestEntity
import javax.inject.Inject

class GuestRepository @Inject constructor(private val localDataSource: LocalDataSource) {
    suspend fun insertData(guestLists: List<GuestEntity>) = localDataSource.insertData(guestLists)

    suspend fun getAllData(): List<GuestEntity> = localDataSource.getAllData()
}