package com.abc.swapiclient.data.repository

import com.abc.swapiclient.data.network.NetworkDataSource
import com.abc.swapiclient.data.network.mapper.*
import com.abc.swapiclient.domain.Repository
import com.abc.swapiclient.domain.models.*
import com.abc.swapiclient.domain.state.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class RepositoryImpl
@Inject constructor(
    private val networkDataSource: NetworkDataSource,
    private val filmsMapper: FilmsMapper,
    private val peopleMapper: PeopleMapper,
    private val planetsMapper: PlanetsMapper,
    private val speciesMapper: SpeciesMapper,
    private val starshipsMapper: StarshipsMapper,
    private val vehiclesMapper: VehiclesMapper,
    private val searchResponseMapper: SearchResponseMapper
) : Repository {
    override suspend fun searchPeople(
        searchQuery: String,
        pageIndex: Int
    ): Flow<State<PersonSearchResult>> {
        return flow {
            try {
                val data = networkDataSource.searchPeople(searchQuery, pageIndex)
                emit(State.Success(searchResponseMapper.mapFromEntity(data)))
            } catch (e: Exception) {
                emit(State.Error(e))
            }
        }
    }

    override suspend fun getFilm(id: String): Flow<State<Film>> {
        return flow {
            try {
                val data = networkDataSource.getFilm(id)
                emit(State.Success(filmsMapper.mapFromEntity(data)))
            } catch (e: Exception) {
                emit(State.Error(e))
            }
        }
    }

    override suspend fun getPerson(id: String): Flow<State<Person>> {
        return flow {
            try {
                val data = networkDataSource.getPeople(id)
                emit(State.Success(peopleMapper.mapFromEntity(data)))
            } catch (e: Exception) {
                emit(State.Error(e))
            }
        }
    }

    override suspend fun getPlanet(id: String): Flow<State<Planet>> {
        return flow {
            try {
                val data = networkDataSource.getPlanet(id)
                emit(State.Success(planetsMapper.mapFromEntity(data)))
            } catch (e: Exception) {
                emit(State.Error(e))
            }
        }
    }

    override suspend fun getSpecies(id: String): Flow<State<Species>> {
        return flow {
            try {
                val data = networkDataSource.getSpecies(id)
                emit(State.Success(speciesMapper.mapFromEntity(data)))
            } catch (e: Exception) {
                emit(State.Error(e))
            }
        }
    }

    override suspend fun getStarship(id: String): Flow<State<Starship>> {
        return flow {
            try {
                val data = networkDataSource.getStarship(id)
                emit(State.Success(starshipsMapper.mapFromEntity(data)))
            } catch (e: Exception) {
                emit(State.Error(e))
            }
        }
    }

    override suspend fun getVehicle(id: String): Flow<State<Vehicle>> {
        return flow {
            try {
                val data = networkDataSource.getVehicle(id)
                emit(State.Success(vehiclesMapper.mapFromEntity(data)))
            } catch (e: Exception) {
                emit(State.Error(e))
            }
        }
    }
}