package com.vladimirk.kvnotesmvvm

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vladimirk.kvnotesmvvm.models.Note
import com.vladimirk.kvnotesmvvm.utils.TYPE_FIREBASE
import com.vladimirk.kvnotesmvvm.utils.TYPE_ROOM

class MainViewModel(application: Application) :AndroidViewModel(application) {
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


    fun initDataBase(type:String){
        dbType.value=type
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