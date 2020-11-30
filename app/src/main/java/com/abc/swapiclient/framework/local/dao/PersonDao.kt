package com.abc.swapiclient.framework.local.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.abc.swapiclient.framework.local.models.Person

interface PersonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPerson(person: Person)

    @Query("SELECT * FROM Person")
    fun getAllPersons(): List<Person>

    @Query("SELECT * FROM Person WHERE id=:id")
    fun getPersonById(id: Int): Person
}
