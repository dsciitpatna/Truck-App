package com.example.truck_app.Home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.truck_app.Home.contract.IHomePresenter
import com.example.truck_app.Home.contract.IHomeView
import com.example.truck_app.R
import com.example.truck_app.helper.Constant
import com.example.truck_app.helper.LocationHelper
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_home.relocate
import kotlinx.android.synthetic.main.activity_home.pick_up_from


class HomeActivity : AppCompatActivity(), IHomeView {

    private lateinit var homePresenter: IHomePresenter
    private lateinit var map: GoogleMap
    private lateinit var locationHelper: LocationHelper
    var latitude: Double = 0.0
    var longitude: Double = 0.0
    private var source = Constant.IP
    private lateinit var mapView: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        homePresenter = HomePresenter(this)
        homePresenter.onAttach(this)
        locationHelper = LocationHelper(this)
        setUp()

    }

    override fun setUp() {
        mapView = findViewById(R.id.show_map)
        getLocation()
        with(mapView) {
            onCreate(null)
            getMapAsync {
                MapsInitializer.initialize(applicationContext)
                setMapLocation(it)
            }
        }

        relocate.setOnClickListener {
            getLocation()
            setMapLocation(map)
        }

    }

    override fun setMapLocation(maps: GoogleMap) {
        with(maps) {
            clear()
            map = maps
            val position = LatLng(latitude, longitude)
            moveCamera(CameraUpdateFactory.newLatLngZoom(position, 13f))
            addMarker(MarkerOptions().position(position))
            mapType = GoogleMap.MAP_TYPE_NORMAL
            val place = homePresenter.getPlaceName(latitude, longitude)
            setPickUpLocation(place)
            setOnMapClickListener {
                latitude = map.cameraPosition.target.latitude
                longitude = map.cameraPosition.target.longitude
                setMapLocation(map)
            }
        }
    }

    override fun setPickUpLocation(place: String?) {
        pick_up_from.text = place
    }

    override fun getLocation() {
        locationHelper.getLocation()
        if (locationHelper.canGetLocation()) {
            latitude = locationHelper.latitude
            longitude = locationHelper.longitude
            source = locationHelper.source
        }

    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }
}
