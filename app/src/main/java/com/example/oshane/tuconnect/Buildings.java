package com.example.oshane.tuconnect;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Message;
import android.preference.PreferenceManager;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


import static com.example.oshane.tuconnect.R.array.building_arrays;
import static com.example.oshane.tuconnect.R.id.parent;



public class Buildings extends AppCompatActivity  {

//This activity contains list view of buildings that users will navigate to

    public void toMenu(View view){
        Intent intent = new Intent(Buildings.this, MainActivity.class);
        startActivity(intent);

    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buildings);
        TextView textView=(TextView) findViewById(R.id.textViewID);
        textView.setText("Tap Building for Directions");

        final ListView requestListView;
        final ArrayList<String> requests=new ArrayList<String>();

        ListView listView= (ListView) findViewById(R.id.hoo);

        final ArrayList<String> friends= new ArrayList<String>();
        friends.add("Luther Foster Hall");
        friends.add("College of Business/Brimmer");
        friends.add("Tennis Courts ");


        ArrayAdapter arrayAdapter=new ArrayAdapter (this, android.R.layout.simple_list_item_1,friends);
        listView.setAdapter(arrayAdapter);



        final ArrayList<Double> tuskegeeArrayLatitude= new ArrayList<>();
        tuskegeeArrayLatitude.add(32.431624);
        tuskegeeArrayLatitude.add(32.426855);
        tuskegeeArrayLatitude.add(32.426839);

        final ArrayList<Double> tuskegeeArrayLongitude= new ArrayList<>();
        tuskegeeArrayLongitude.add(-85.709776);
        tuskegeeArrayLongitude.add(-85.702523);
        tuskegeeArrayLongitude.add(-85.705727);


        // ArrayAdapter arrayAdapter=new ArrayAdapter (this, android.R.layout.simple_list_item_1,friends);
        //listView.setAdapter(arrayAdapter);





        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


                Double tuskegeeBuildingLatitude= tuskegeeArrayLatitude.get(position);
                Double tuskegeeBuildingLongitude= tuskegeeArrayLongitude.get(position);

                Intent mapps = new Intent(getApplicationContext(), FindBuilding.class);
                Bundle tuskegeeCoordinateBundle = new Bundle();
                tuskegeeCoordinateBundle.putDouble("latitude", tuskegeeBuildingLatitude);
                tuskegeeCoordinateBundle.putDouble("longitude", tuskegeeBuildingLongitude);
                mapps.putExtras(tuskegeeCoordinateBundle);
                startActivity(mapps);



            }
        });

    };

};