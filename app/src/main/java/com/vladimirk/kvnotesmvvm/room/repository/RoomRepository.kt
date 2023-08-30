package com.vladimirk.kvnotesmvvm.room.repository

import androidx.lifecycle.LiveData
import com.vladimirk.kvnotesmvvm.database.DatabaseRepository
import com.vladimirk.kvnotesmvvm.models.Note
import com.vladimirk.kvnotesmvvm.room.NoteRoomDao

  class RoomRepository (private val noteRoomDao: NoteRoomDao):DatabaseRepository{
      override val reedAll: LiveData<List<Note>>
          get() = noteRoomDao.getAllNotes()

      override suspend fun create(note: Note, onSuccess: () -> Unit) {
        noteRoomDao.addNote(note=note)
          onSuccess()
      }

      override suspend fun update(note: Note, onSuccess: () -> Unit) {
        noteRoomDao.updateNote(note = note)
          onSuccess()
      }

      override suspend fun delete(note: Note, onSuccess: () -> Unit) {
          noteRoomDao.deleteNote(note = note)
          onSuccess()
      }
  }