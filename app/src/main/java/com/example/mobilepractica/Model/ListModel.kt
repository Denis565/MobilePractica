package com.example.mobilepractica.Model


class ListView  {
    var userName: String
    var userType: String
    var isActive: Boolean

    constructor(userName: String, userType: String) {
        this.userName = userName
        this.userType = userType
        isActive = true
    }

    constructor(userName: String, userType: String, active: Boolean) {
        this.userName = userName
        this.userType = userType
        isActive = active
    }

    override fun toString(): String {
        return "$userName ($userType)"
    }
}