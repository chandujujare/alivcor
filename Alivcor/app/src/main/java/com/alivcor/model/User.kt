package com.alivcor.model

import java.util.*

data class User(val firstName:String, val lastName:String, val dob: Date?, var age:Int=0)
