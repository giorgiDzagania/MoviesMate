package com.example.moviesmate.domain.usecases

import com.example.moviesmate.core.OperationStatus
import com.example.moviesmate.domain.repository.FirebaseRepository

class GetUserNameUseCase(
    private val firebaseRepository: FirebaseRepository
) {
    suspend fun execute(): OperationStatus<String> {
        return firebaseRepository.getUsername()
    }
}