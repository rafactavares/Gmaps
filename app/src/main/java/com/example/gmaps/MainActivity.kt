package com.example.gmaps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

// 53.3387693,-6.2382478
// 1 Grand Canal Plaza, Grand Canal Street Upper, Dublin, D04 HR25
private val places = arrayListOf(
    Place ("Google", LatLng(53.3387693,-6.2382478), "1 Grand Canal Plaza, Grand Canal Street Upper", 4.8f) ,
            Place ("Spire", LatLng(53.3498146,-6.2628274), "O'Connell Street Upper, North City, Dublin", 4.8f)
)
// 53.3498146,-6.2628274
//O'Connell Street Upper, North City, Dublin
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map_fragment) as SupportMapFragment
        mapFragment.getMapAsync {googleMap ->
            addMarkers(googleMap)
        }
    }



    private fun addMarkers(googleMap: GoogleMap) {

        places.forEach { place ->
            val market = googleMap.addMarker(
                MarkerOptions()
                    .title(place.name)
                    .snippet(place.address)
                    .position(place.latLng)
                    .icon()
            )
        }


    }



}


data class Place(

    val name: String,
    val latLng: LatLng,
    val address: String,
    val rating: Float
)