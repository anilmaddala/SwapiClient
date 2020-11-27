package com.abc.swapiclient.data.repository

import android.util.Log
import com.abc.swapiclient.data.network.NetworkDataSource
import com.abc.swapiclient.data.network.mapper.PeopleMapper
import com.abc.swapiclient.domain.models.Person
import com.abc.swapiclient.domain.Repository
import com.abc.swapiclient.domain.state.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class RepositoryImpl
@Inject constructor(
    private val networkDataSource: NetworkDataSource,
    private val peopleMapper: PeopleMapper
):Repository {
    override suspend fun searchPeople(searchQuery: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getFilm(name: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getPerson(name: String): Flow<State<Person>> {
        return flow {
            try {
                Log.v("MVS1", name)
                val data = networkDataSource.getPeople(name)
                Log.v("MVS1", data.toString())
                emit(State.Success(peopleMapper.mapFromEntity(data)))
            } catch (e: Exception) {
                emit(State.Error(e))
            }
        }
    }

    override suspend fun getPlanet(name: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getSpecies(name: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getStarship(name: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getVehicle(name: String) {
        TODO("Not yet implemented")
    }

}