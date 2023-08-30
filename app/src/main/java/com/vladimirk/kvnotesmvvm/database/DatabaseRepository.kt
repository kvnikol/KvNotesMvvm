package com.vladimirk.kvnotesmvvm.database

import androidx.lifecycle.LiveData
import com.vladimirk.kvnotesmvvm.models.Note
import com.vladimirk.kvnotesmvvm.navigation.NavRoute

interface DatabaseRepository {
    val reedAll:LiveData<List<Note>>

  suspend  fun create(note:Note,onSuccess:()->Unit)

  suspend  fun update(note:Note,onSuccess:()->Unit)

  suspend  fun delete(note:Note,onSuccess:()->Unit)
}