package com.vladimirk.kvnotesmvvm

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.vladimirk.kvnotesmvvm.models.Note
import com.vladimirk.kvnotesmvvm.room.AppRoomDataBase
import com.vladimirk.kvnotesmvvm.room.repository.RoomRepository
import com.vladimirk.kvnotesmvvm.utils.REPOSITORY
import com.vladimirk.kvnotesmvvm.utils.TYPE_FIREBASE
import com.vladimirk.kvnotesmvvm.utils.TYPE_ROOM
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) :AndroidViewModel(application) {
   // private val _creditCards = MutableLiveData<List<CreditCard>>()
   // val creditCards: LiveData<List<CreditCard>> = _creditCards

    val context=application
    val readText:MutableLiveData<List<Note>> by lazy {
        MutableLiveData<List<Note>>()
    }
    val dbType:MutableLiveData<String> by lazy {
        MutableLiveData<String>(TYPE_ROOM)
    }
    init {
        readText.value=
            when(dbType.value){
                TYPE_ROOM->{
                    listOf<Note>(
                               Note(title = "note 1", subtitle = "subtitle for note 1"),
                                Note(title = "note 2", subtitle = "subtitle for note 2"),
                                Note(title = "note 3", subtitle = "subtitle for note 3"),
                                Note(title = "note 4", subtitle = "subtitle for note 4")
                    )
                }
                TYPE_FIREBASE->{
                    listOf<Note>()
                }
                else -> listOf()
            }
    }

    fun addNote(note: Note,onSuccess: () -> Unit){
        viewModelScope.launch(Dispatchers.IO){
          REPOSITORY.create(note = note){
              viewModelScope.launch (Dispatchers.Main){
                  onSuccess()
              }

          }
        }
    }
     fun readAllNotes()= REPOSITORY.reedAll



    fun initDataBase(type:String,onSuccess:()->Unit){
       // dbType.value=type
        when(type){
            TYPE_ROOM->{
                val dao=AppRoomDataBase.getInstance(context = context).getRoomDao()
                REPOSITORY= RoomRepository(dao)
                onSuccess()
            }
        }
        Log.i("Tag","init data base from application database state : $type")
    }
}



class  MainViewModelFactory(private  val  application: Application):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if( modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(application = application)as T
        }
        throw java.lang.IllegalArgumentException("uncnown ViewModel")
    }

}