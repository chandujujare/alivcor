package com.alivcor.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alivcor.model.User
import java.util.*

class HomeActivityViewModel: ViewModel() {

    private val model = HomeActivityModel()
    val age = MutableLiveData<User>()

    fun setUser(firstName:String, lastName:String, date:Date){
        var  user= User(firstName,lastName,date)
        age.postValue(model.getAge(user))
    }

}