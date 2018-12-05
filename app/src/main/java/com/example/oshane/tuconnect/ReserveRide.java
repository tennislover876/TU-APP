package com.example.oshane.tuconnect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

import java.text.BreakIterator;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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
import static android.R.attr.fingerprintAuthDrawable;
import static android.R.attr.layout_y;


public class ReserveRide extends AppCompatActivity {
    EditText name;
    EditText Destination;
    EditText Day;
    Button postButton;
    String uploadNameText;
    String uploadDestinationText;
    String uploadDayText;
    Button buttonRider;
    Button buttonDriver;
    ListView listView;
    ArrayList<String> fren;
    ArrayList<String> frendname;
    Button menubutton;
    Button postButtonFinal;
    Intent intent;
    TextView textView;


    public void toPost(View view) {
        TextView textView = (TextView) findViewById(R.id.textViewID);
        textView.setText("Enter TU Username");

        buttonRider = (Button) findViewById(R.id.buttonRiderID);
        buttonDriver = (Button) findViewById(R.id.buttonDriverID);
        menubutton = (Button) findViewById(R.id.menuID);

        buttonRider.setVisibility(View.GONE);
        buttonDriver.setVisibility(View.GONE);


        menubutton.setVisibility(View.VISIBLE);
        menubutton = (Button) findViewById(R.id.menuID);


        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );
        params.setMargins(15, 15, 15, 15);
        menubutton.setLayoutParams(params);



        name = (EditText) findViewById(R.id.NameEditTextViewID);
        Destination = (EditText) findViewById(R.id.DestinationEditTextViewID);
        Day = (EditText) findViewById(R.id.DayEditTextViewID);
        postButton = (Button) findViewById(R.id.postButtonID);

        name.setVisibility(View.VISIBLE);
        name.setHint("Ex: jbrown1234");
        name.animate().setDuration(100).translationY(50);

        Destination.setVisibility(View.VISIBLE);
        Destination.setHint("Destination");
        Destination.animate().setDuration(100).translationY(100);

        Day.setVisibility(View.VISIBLE);
        Day.setHint("Day of travel");
        Day.animate().setDuration(100).translationY(150);

        postButton.setVisibility(View.VISIBLE);
        postButton.setText("Request");
        postButton.animate().setDuration(100).translationY(150).translationX(400);


        postButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {

                    // postButtonFinal= (Button) findViewById(R.id.driverID) ;
                    // postButtonFinal.setVisibility(View.VISIBLE);
                    TextView textView =(TextView) findViewById(R.id.textViewID);
                    textView.setText("Confirm Request");
                    name.setVisibility(View.GONE);
                    Day.setVisibility(View.GONE);
                    Destination.setVisibility(View.GONE);
                    postButton.setVisibility(View.GONE);

                    buttonRider.setVisibility(View.VISIBLE);
                    buttonRider.setText("Yes, Confirm!");


                    buttonDriver.setVisibility(View.VISIBLE);
                    buttonDriver.setText("NO");

                    menubutton.setVisibility(View.VISIBLE);


                } catch (Exception e) {
                    Toast.makeText(getBaseContext(), "Cant be clicked1", Toast.LENGTH_SHORT).show();

                }


                try {
                    buttonRider.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {



                            try{
                            uploadNameText = name.getText().toString();
                            uploadDestinationText = Destination.getText().toString();
                            uploadDayText = Day.getText().toString();

                            ParseObject score = new ParseObject("UBER");
                            score.put("RiderName", uploadNameText);
                            score.put("RiderDestination", uploadDestinationText);
                            score.put("RiderDay", uploadDayText);

                            score.saveInBackground(new SaveCallback() {
                                @Override
                                public void done(ParseException e) {

                                }
                            });}catch (Exception e){

                            }finally {
                                    intent = new Intent(ReserveRide.this, MainActivity.class);
                                    startActivity(intent);


                            }


                        }
                    });


                } catch (Exception e) {


                    Toast.makeText(getBaseContext(), "Button wont click", Toast.LENGTH_SHORT).show();
                }

            }
        });

        buttonDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //Does not bother to reserve seat. Will go to Reserve.java initial page instead.
                    Toast.makeText(getBaseContext(), "Not Requested", Toast.LENGTH_SHORT).show();
                    intent = new Intent(ReserveRide.this, ReserveRide.class);
                    startActivity(intent);
                } catch (Exception e) {
                    //Not sure yet
                }
            }
        });
    }



    public void toSeePost(View view) {
        textView= (TextView) findViewById(R.id.textViewID);
        textView.setText("Tap Row to Send Message");
        buttonRider = (Button) findViewById(R.id.buttonRiderID);
        buttonRider.setVisibility(View.GONE);

        buttonDriver = (Button) findViewById(R.id.buttonDriverID);
        buttonDriver.setVisibility(View.GONE);

        menubutton = (Button) findViewById(R.id.menuID);
        menubutton.setVisibility(View.VISIBLE);

        name = (EditText) findViewById(R.id.NameEditTextViewID);
        name.setVisibility(View.GONE);
        Destination = (EditText) findViewById(R.id.DestinationEditTextViewID);
        Destination.setVisibility(View.GONE);
        Day = (EditText) findViewById(R.id.DayEditTextViewID);
        Day.setVisibility(View.GONE);
        postButton = (Button) findViewById(R.id.postButtonID);
        postButton.setVisibility(View.GONE);



        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );
        params.setMargins(15, 15, 15, 15);
        menubutton.setLayoutParams(params);


        listView = (ListView) findViewById(R.id.idList);
        listView.setVisibility(View.VISIBLE);
        //ParseQuery<ParseObject> query = ParseQuery.getQuery("Score");
        ParseQuery<ParseObject> newQuery = ParseQuery.getQuery("UBER");
        newQuery.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {
                    ArrayList<String> fren = new ArrayList<String>();
                    frendname = new ArrayList<String>(); //using this array to get name

                    for (ParseObject object : objects) {
                        String location = object.getString("RiderDestination");
                        String date = object.getString("RiderDay");
                        String name = object.getString("RiderName");
                        String item = name + " needs ride to " + location + " on " + date;
                        fren.add(item);
                        frendname.add(name);


                    }

                    ArrayAdapter adaptersimple = new ArrayAdapter(ReserveRide.this, android.R.layout.simple_list_item_1, fren);
                    listView.setAdapter(adaptersimple);
                    listView.animate().alpha(1f).setDuration(2000);
                }


            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                Intent intenty = new Intent(getApplicationContext(), Chat.class);
                intenty.putExtra("username", frendname.get(i).toString());
                startActivity(intenty);

            }
        });


    }

    public void toMenu(View view){
        Intent intent = new Intent(ReserveRide.this, MainActivity.class);
        startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve_ride);


        Button buttonDriver= (Button) findViewById(R.id.buttonDriverID);
        buttonDriver.setVisibility(View.VISIBLE);
        buttonDriver.animate().setDuration(1/2).translationY(150);

        Button buttonRider= (Button) findViewById(R.id.buttonRiderID);
        buttonRider.setVisibility(View.VISIBLE);
        buttonRider.animate().setDuration(1/2).translationY(150);


        TextView textView=(TextView) findViewById(R.id.textViewID);
        textView.setText("Tap to Request/Offer Ride");
    }


}
