package com.alivcor.viewmodel

import com.alivcor.model.User
import com.alivcor.repository.UserDataProcessor

class HomeActivityModel {

    private val dataProcessor = UserDataProcessor()

    fun getAge(user: User): User = dataProcessor.calculateAge(user)

}
