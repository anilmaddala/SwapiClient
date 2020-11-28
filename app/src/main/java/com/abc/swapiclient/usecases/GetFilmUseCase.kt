package com.abc.swapiclient.usecases

import com.abc.swapiclient.data.repository.RepositoryImpl
import com.abc.swapiclient.domain.models.Film
import com.abc.swapiclient.domain.state.State
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * UseCase for getting Film based on film id
 */
class GetFilmUseCase @Inject constructor(private val repository: RepositoryImpl) {
    suspend operator fun invoke(id: String): Flow<State<Film>> {
        return repository.getFilm(id)
    }
}