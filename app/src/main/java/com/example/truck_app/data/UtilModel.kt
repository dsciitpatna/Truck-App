package com.example.truck_app.data

import android.Manifest
import android.content.Context
import com.example.truck_app.data.contract.IUtilModel

class UtilModel(val context: Context) : IUtilModel {

    override fun permissionsToGet(): Array<String> {
        return arrayOf(Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_COARSE_LOCATION)
    }
}