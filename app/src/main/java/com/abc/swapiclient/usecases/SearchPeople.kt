package com.abc.swapiclient.usecases

import com.abc.swapiclient.data.repository.StarWarsRepository
import javax.inject.Inject

class SearchPeople @Inject constructor(private val repository: StarWarsRepository){
//    suspend operator fun invoke(query: String) = repository.searchPeople()
}