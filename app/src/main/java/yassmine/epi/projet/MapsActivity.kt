package yassmine.epi.projet

import android.content.ContentProviderClient
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.location.Location
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.LocationServices.getFusedLocationProviderClient

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import yassmine.epi.projet.databinding.ActivityMapsBinding
import java.util.jar.Manifest

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fusedLocationClient= getFusedLocationProviderClient(this)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val sousse = LatLng(35.83, 10.64)
        mMap.addMarker(MarkerOptions().position(sousse).title("Sousse"))

        val hopitalSahloul =LatLng(35.83726321759246, 10.590567322446848)
        mMap.addMarker(MarkerOptions().position(hopitalSahloul).title("Hopital Sahloul"))

        val stade = LatLng(35.82425041066016, 10.612582894084522)
        mMap.addMarker(MarkerOptions().position(stade).title("Stade Olympique de Sousse"))

        val stadesoussien = LatLng(35.817882403978004, 10.63704464025073)
        mMap.addMarker(MarkerOptions().position(stadesoussien).title("Stade Soussien Mohamed Zaaboub"))

        val cameraPosition = CameraPosition.Builder()
            .target(sousse)
            .zoom(15f)
            .bearing(45f)
            .tilt(90f)
            .build()
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))

        mMap.mapType = GoogleMap.MAP_TYPE_HYBRID

        mMap.setOnMapClickListener { latIng ->
            val lat = latIng.latitude
            val lng = latIng.longitude
            Toast.makeText(this, "Latitude=$lat \n Longitude = $lng", Toast.LENGTH_LONG).show()
        }

        mMap.setOnMarkerClickListener { Marker ->
            val place=Marker.title
            if (Marker.title == place) {
                val uri = Uri.parse("https://en.wikipedia.org/wiki/$place")
                val i = Intent(Intent.ACTION_VIEW,uri)
                startActivity(i)
            }
            false
        }



   
   
   
   
       }


}