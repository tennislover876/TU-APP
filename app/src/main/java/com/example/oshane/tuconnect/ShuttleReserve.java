package com.example.oshane.tuconnect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

public class ShuttleReserve extends AppCompatActivity {
    int counter=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shuttle_reserve);


    }


    public void toStudentView(View view) {
        //This function shows the student a view to reserve seat.
        try {
            setTitle("Reserving Seats");

            seatCalculculation();
            // int seats=;//contains variable with amount of seats
            //TextView seatsRemaining= (TextView) findViewById(R.id.seatsRemainingTextView);
            // seatsRemaining.setText(seats+" Seats remaining");

            //seatsRemaining.animate().setDuration(1/2).translationY(70);

            Button riderbutton = (Button) findViewById(R.id.riderID);
            riderbutton.setText("Reserve Seat");


            Button driverbutton = (Button) findViewById(R.id.driverID);
            driverbutton.setText("Do not Reserve Seat");

            EditText uploadText = (EditText) findViewById(R.id.editTextUploadID);
           uploadText.animate().alpha(1).setDuration(500).translationY(100);

          //  Button uploadButton = (Button) findViewById(R.id.enterUploadID);
           // uploadButton.animate().alpha(1).setDuration(500).translationY(100);

        } catch (Exception e) {
            Toast.makeText(getBaseContext(), "Try student view later", Toast.LENGTH_SHORT).show();

            //try to write a code to make text remain on Reserve.java page

        }


    }


    public void seatCalculculation(){
        //This function calculates and show # of available seats in a TextView
        ParseQuery<ParseObject> countQuery= ParseQuery.getQuery("Score");
        countQuery.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e==null){
                    for (ParseObject object:objects){
                        counter+=1;
                    }
                }
                int seats=20-counter;
                //contains variable with amount of seats
                TextView seatsRemaining= (TextView) findViewById(R.id.textView);
                seatsRemaining.setText(seats + " Seats remaining");

            }
        });
    }






}