package com.example.truck_app.Main.contract

interface IMainView {

    fun checkPermission(permission: String): Boolean

    fun askForPermission(permissions: Array<String?>)

    fun initialSetup()
}