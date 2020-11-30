package com.abc.swapiclient.framework.local.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.abc.swapiclient.framework.local.models.Film

interface FilmDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFilm(film: Film)

    @Query("SELECT * FROM Film")
    fun getAllFilms(): List<Film>

    @Query("SELECT * FROM Film WHERE id=:id")
    fun getFilmById(id: Int): Film
}