package com.example.truck_app.Main

import android.content.Context
import android.util.Log
import com.example.truck_app.Main.contract.IMainPresenter
import com.example.truck_app.Main.contract.IMainView
import com.example.truck_app.data.UtilModel

class MainPresenter(context: Context):IMainPresenter {
    private lateinit var mainView: IMainView
    private val utilModel: UtilModel = UtilModel(context)

    override fun onAttach(mainView: IMainView) {
        this.mainView = mainView
    }

    override fun getPermissions() {
        val permissionsRequired = utilModel.permissionsToGet()


        val permissionsGranted = arrayOfNulls<String>(3)
        var counter = 0

        for(permission in  permissionsRequired){
            if (!( mainView.checkPermission(permission))) {
                permissionsGranted[counter] = permission
                counter++
            }
        }

        if (counter > 0) {
            mainView.askForPermission(permissionsGranted)
        }
        Log.d("KHANKI","Executed")
    }

    override fun onDetach() {
        // To destroy references if required later
    }
}