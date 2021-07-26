package hilmysf.eventapps.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import hilmysf.eventapps.data.source.LocalDataSource
import hilmysf.eventapps.data.source.entities.EventEntity
import hilmysf.eventapps.data.source.room.GuestDao
import hilmysf.eventapps.data.source.room.GuestDatabase
import hilmysf.eventapps.ui.MapFragment
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    //    @Singleton
//    @Provides
//    fun provideEvent(event: EventEntity): MapFragment = MapFragment(event)
    @Singleton
    @Provides
    fun provideGuestDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        GuestDatabase::class.java,
        "guest.db"
    ).build()

    @Singleton
    @Provides
    fun provideDao(db: GuestDatabase) = db.guestDao()

    @Singleton
    @Provides
    fun provideLocalDataSource(mGuestDao: GuestDao): LocalDataSource =
        LocalDataSource(mGuestDao)
}