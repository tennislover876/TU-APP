package com.example.oshane.tuconnect;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static android.R.attr.data;

public class FindBuilding extends FragmentActivity implements OnMapReadyCallback {

   // private GoogleMap mMap;
    //This activity is a map showing directions to building clicked from Buildings.java

    private GoogleMap mMap;




    LocationManager locationManager;
    LocationListener locationListener;





    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){

            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,locationListener);}
        }






    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_building);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Intent intent=getIntent();
        //Begining of getting location

        locationManager= (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        locationListener=new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                //Toast.makeText(FindBuilding.this, location.toString(),Toast.LENGTH_SHORT).show();


                // Add a marker in Sydney and move the camera
                float zoom= 17.0f;
                LatLng sydney = new LatLng(location.getLatitude(), location.getLongitude());
                mMap.clear();
                mMap.addMarker(new MarkerOptions().position(sydney).title("Your location"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,zoom));


            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };// if device using marshmello
         if (Build.VERSION.SDK_INT<23){
             locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,locationListener);
         }else{
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){

                //if no permission, ask for it
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);

            }
            else{
                //already have permission
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,locationListener);}

                Location lastLocation=locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                //LatLng sydney = new LatLng(lastLocation.getLatitude(), lastLocation.getLongitude());







        //end of getting locatiion
    }}

   /* *//**//**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     *//*
*/


    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_building);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }*/

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        buildingLocationMarker();
    }

public void buildingLocationMarker(){
    //This method puts a marker on map location of building clicked
    //ALways include mMap = googleMap; whenever you use this function

    Bundle tuskegeeCoordinateBundle = getIntent().getExtras();
    double receivedBuildingLatitude = tuskegeeCoordinateBundle.getDouble("latitude");
    double receivedBuildingLongitude = tuskegeeCoordinateBundle.getDouble("longitude");


    // Add a marker on building clicked and zoom in
    float tuskegeeBuildingZoom = 17.0f;
    LatLng tuskegeeBuildingCoordinate = new LatLng(receivedBuildingLatitude, receivedBuildingLongitude);
    mMap.addMarker(new MarkerOptions().position(tuskegeeBuildingCoordinate).title("Building location"));
    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tuskegeeBuildingCoordinate,tuskegeeBuildingZoom));
}





}



