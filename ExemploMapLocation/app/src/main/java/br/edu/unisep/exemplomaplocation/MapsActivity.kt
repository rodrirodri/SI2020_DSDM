package br.edu.unisep.exemplomaplocation

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity() {

    private lateinit var mMap: GoogleMap
    private lateinit var locationClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        setupMap()
        setupPermissions()
    }

    private fun setupPermissions() {

        if (checkSelfPermission(ACCESS_FINE_LOCATION) == PERMISSION_GRANTED &&
            checkSelfPermission(ACCESS_COARSE_LOCATION) == PERMISSION_GRANTED
        ) {
            getUserLocation()
        } else {
            requestPermissions(arrayOf(ACCESS_FINE_LOCATION, ACCESS_COARSE_LOCATION), 1)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (grantResults.all { res -> res == PERMISSION_GRANTED }) {
            getUserLocation()
        }
    }

    private fun getUserLocation() {
        locationClient = LocationServices.getFusedLocationProviderClient(this)
        locationClient.lastLocation.addOnSuccessListener { location ->
            if (location != null) {
                val pos = LatLng(location.latitude, location.longitude)
                mMap.addMarker(MarkerOptions().position(pos))
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pos, 12f))
            }
        }
    }

    private fun setupMap() {
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment

        mapFragment.getMapAsync { googleMap ->
            this.mMap = googleMap

            this.mMap.setOnMapClickListener { position ->
                mMap.clear()
                mMap.addMarker(MarkerOptions().position(position))
            }
        }
    }
}
