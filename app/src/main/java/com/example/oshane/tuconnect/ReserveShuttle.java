package com.example.oshane.tuconnect;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.CountCallback;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.button;


public class ReserveShuttle extends AppCompatActivity {
    int counter=0;
    Intent intent;
    EditText uploadText;
    String rider;
    boolean clicked=false;
    Button clearButton;
    Button uploadButton;
    Button driverbutton;
    Button yesButton;
    Button noButton;
    TextView textView;
    Button riderbutton;
    Button saveButton;
    Button menubutton;



    public void toDriverView(View view) {
        //This function shows driver a list with names of students who reserve seats.
        //Will also allow driver to clear list after each trip.

        //Please remember to add password to enter this view so only driver can see
        try {

            clearButton = (Button) findViewById(R.id.riderID);
            clearButton.setVisibility(View.VISIBLE);
            clearButton.setText("Clear List");


            saveButton = (Button) findViewById(R.id.driverID);
            saveButton.setVisibility(View.VISIBLE);
            saveButton.setText("Save List");


            textView = (TextView) findViewById(R.id.seatsRemainingTextView);
            textView.setVisibility(View.VISIBLE);
            textView.setText("Reserved seats");






        }
        catch (Exception e){
            Toast.makeText(getBaseContext(),"Try again later", Toast.LENGTH_SHORT).show();
            //try to write a code to make text remain on Reserve.java page

        }


        try{
            final ListView listView = (ListView) findViewById(R.id.fadeList);
            listView.setVisibility(View.VISIBLE);

            ParseQuery<ParseObject> query = ParseQuery.getQuery("Score");
            query.findInBackground(new FindCallback<ParseObject>() {
                @Override
                public void done(List<ParseObject> objects, ParseException e) {

                    if (e == null) {
                        ArrayList<String> trying = new ArrayList<String>();

                        for (ParseObject object : objects) {
                            rider = object.getString("username");
                            trying.add(rider);
                            Log.i("GetInBackground", "Successful");
                            //Toast.makeText(getBaseContext(),rider, Toast.LENGTH_SHORT).show();
                        }

                        ArrayAdapter adaptersimple = new ArrayAdapter(ReserveShuttle.this, android.R.layout.simple_list_item_1, trying);
                        listView.setAdapter(adaptersimple);
                        listView.animate().alpha(1f).setDuration(1/2);
                    }
                }
            });}

        catch(Exception e){
            Toast.makeText(getBaseContext(),"Cannot get listview", Toast.LENGTH_SHORT).show();

        }

        try {


            clearButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //When clicked will as driver to confirm
                    clicked = true;
                    if (clicked) {
                        clearRiders();
                    } else {
                        Toast.makeText(getBaseContext(), "Cleared button not clicked", Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }

        catch(Exception e){
            Toast.makeText(getBaseContext(),"Could not clear list", Toast.LENGTH_SHORT).show();}
    }







    public void toStudentView(View view) {
        //This function shows the student a view to reserve seat.
        try {

            seatCalculculation();
            // int seats=;//contains variable with amount of seats
            //TextView seatsRemaining= (TextView) findViewById(R.id.seatsRemainingTextView);
            // seatsRemaining.setText(seats+" Seats remaining");

            //seatsRemaining.animate().setDuration(1/2).translationY(70);

            riderbutton = (Button) findViewById(R.id.riderID);
            riderbutton.setVisibility(View.GONE);

            driverbutton = (Button) findViewById(R.id.driverID);
            driverbutton.setVisibility(View.GONE);
           // driverbutton.animate().alpha(0.5f).setDuration(1).translationY(-1000);

            uploadText = (EditText) findViewById(R.id.editTextUploadID);
            uploadText.setVisibility(View.VISIBLE);
            uploadText.animate().alpha(1).setDuration(500).translationY(100);

            uploadButton = (Button) findViewById(R.id.enterUploadID);
            uploadButton.setVisibility(View.VISIBLE);
            uploadButton.animate().alpha(1).setDuration(500).translationY(100);

            menubutton = (Button) findViewById(R.id.menuID);
            menubutton.setVisibility(View.VISIBLE);
            menubutton = (Button) findViewById(R.id.menuID);


            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
            );
            params.setMargins(15, 15, 15, 15);
            menubutton.setLayoutParams(params);



        } catch (Exception e) {
            Toast.makeText(getBaseContext(), "Try student view later", Toast.LENGTH_SHORT).show();

            //try to write a code to make text remain on Reserve.java page

        }
    }





    public void toUpload(View view){

        //ReserveSeatButton is visible in toStudentView.
        // When this button is clicked it allows student to enter name to reserve seat.
        // Student will be promted to confirm correct name before it is uploaded or not uploaded.
        //after clicking yes or no, they will be directed to Reserve.java activity
        uploadButton.animate().alpha(1).setDuration(500).translationY(-2000);//Disappear
        uploadText.animate().alpha(1).setDuration(500).translationY(-2000);//Disappear
        uploadText.setVisibility(View.GONE);    //
        uploadButton.setVisibility(View.GONE);  //
        TextView confirmTextView= (TextView) findViewById(R.id.seatsRemainingTextView);
        confirmTextView.setText("Confrim Reservation");


        yesButton= (Button) findViewById(R.id.yesClearButtonID);
        yesButton.setVisibility(View.VISIBLE);
        yesButton.animate().translationY(150);

        noButton= (Button) findViewById(R.id.noClearButtonID);
        noButton.setVisibility(View.VISIBLE);
        noButton.animate().translationY(150);


        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ///Confirm name before seat can be reserved

                try{

                    final String uploadName= uploadText.getText().toString();

                    ParseObject score = new ParseObject("Score");

                    score.put("username", uploadName);
                    score.put("score", 200);
                    score.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(com.parse.ParseException e) {

                            if (e == null ) {


                                Log.i("SaveInBackground", "Successful");
                                Toast.makeText(getBaseContext(),"Reserved for "+uploadName , Toast.LENGTH_SHORT).show();

                            } else {
                                Toast.makeText(getBaseContext(),"Please input a name" , Toast.LENGTH_SHORT).show();
                                Log.i("SaveInBackground", "Failed. Error: " + e.toString());
                            }
                        }
                    });
                } catch (Exception e){
                    Toast.makeText(getBaseContext(),"Could not upload", Toast.LENGTH_SHORT).show();
                }
                finally {
                    //I used this here so that students don't submit same name twice
                    //It will go back to Reserve.java initial screen
                    intent=new Intent(ReserveShuttle.this,MainActivity.class);
                    startActivity(intent);
                }
            }


        });

        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    //Does not bother to reserve seat. Will go to Reserve.java initial page instead.
                    Toast.makeText(getBaseContext(), "Seat not Confirmed", Toast.LENGTH_SHORT).show();
                    intent=new Intent(ReserveShuttle.this,ReserveShuttle.class);
                    startActivity(intent);
                }
                catch(Exception e){
                    //Not sure yet
                }
            }});}




/// Functions without onClick Below


    public void clearRiders(){
        //This function gives option to clear list of riders in server or not.
        // It is called in toDriverView
        

        yesButton= (Button) findViewById(R.id.riderID);
        noButton= (Button) findViewById(R.id.driverID);
        yesButton.setText("Yes, Clear List");
        noButton.setText("Don't Clear");


        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //this function resets the list of reserve seats for another week.
                try{
                    ParseQuery <ParseObject> clearQuery= ParseQuery.getQuery("Score");
                    clearQuery.findInBackground(new FindCallback<ParseObject>() {
                        @Override
                        public void done(List<ParseObject> objects, ParseException e) {

                            if (e==null){
                                for (ParseObject object:objects){
                                    object.deleteInBackground();
                                    //object.remove("username");
                                    //object.remove("score");
                                    //object.remove("createdAt");
                                    //object.remove("objectID");
                                    //object.remove("updatedAt");
                                    //object.remove("ACL");

                                    //Log.i("GetInBackground", "Successful");
                                    //Toast.makeText(getBaseContext(),"List cleared", Toast.LENGTH_SHORT).show();
                                    object.saveInBackground();
                                }
                            }
                            Toast.makeText(getBaseContext(), "List cleared", Toast.LENGTH_SHORT).show();
                            intent = new Intent (ReserveShuttle.this, MainActivity.class);
                            startActivity(intent);
                        }
                    });
                }catch(Exception e){
                    Toast.makeText(getBaseContext(),"objects cannot be removed", Toast.LENGTH_SHORT).show();
                }

            }
        });

        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getBaseContext(),"Okay, wont clear", Toast.LENGTH_SHORT).show();
                intent = new Intent (ReserveShuttle.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }





    public void seatCalculculation(){
        //This function calculates and show # of available seats in a TextView
        ParseQuery <ParseObject> countQuery= ParseQuery.getQuery("Score");
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
                TextView seatsRemaining= (TextView) findViewById(R.id.seatsRemainingTextView);
                seatsRemaining.setText(seats+" Seats remaining");
                seatsRemaining.animate().setDuration(1/2).translationY(70);
            }
        });
    }





    public void toMenu(View view){
        Intent intent = new Intent(ReserveShuttle.this, MainActivity.class);
        startActivity(intent);

    }







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve_shuttle);
    }

}
