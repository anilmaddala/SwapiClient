package com.abc.swapiclient.usecases

import com.abc.swapiclient.data.repository.StarWarsRepository
import javax.inject.Inject

class GetPersonUseCase @Inject constructor(repository: StarWarsRepository) {
    operator fun invoke(id: String) {

    }
}