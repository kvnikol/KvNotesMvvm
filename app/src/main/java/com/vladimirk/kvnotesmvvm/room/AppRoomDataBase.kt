package com.vladimirk.kvnotesmvvm.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.vladimirk.kvnotesmvvm.models.Note

@Database(entities = [Note::class], version = 1)
abstract class AppRoomDataBase:RoomDatabase() {
    abstract fun getRoomDao():NoteRoomDao

    companion object{
        @Volatile
        private var INSTANCE:AppRoomDataBase?=null

       fun getInstance(context: Context):AppRoomDataBase
       {
           return if (INSTANCE==null){
               INSTANCE=Room.databaseBuilder(
                   context,
                   AppRoomDataBase::class.java,
                   "notes_database"
               ).build()
               INSTANCE as AppRoomDataBase
           }
           else{
               INSTANCE as AppRoomDataBase
           }
       }
    }
}