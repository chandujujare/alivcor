package com.alivcor.repository

import com.alivcor.model.User
import java.util.*

class UserDataProcessor() {

    fun calculateAge(user: User): User {

        val dobCalendar = Calendar.getInstance()

        dobCalendar[Calendar.YEAR] = user.dob!!.year
        dobCalendar[Calendar.MONTH] = user.dob!!.month
        dobCalendar[Calendar.DATE] = user.dob.date

        var ageInteger = 0

        val today = Calendar.getInstance()

        ageInteger = today[Calendar.YEAR] - dobCalendar[Calendar.YEAR]

        if (today[Calendar.MONTH] == dobCalendar[Calendar.MONTH]) {
            if (today[Calendar.DAY_OF_MONTH] < dobCalendar[Calendar.DAY_OF_MONTH]) {
                ageInteger -= 1
            }
        } else if (today[Calendar.MONTH] < dobCalendar[Calendar.MONTH]) {
            ageInteger -= 1
        }
        user.age = ageInteger
        return user

    }
}