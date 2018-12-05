
package com.example.oshane.tuconnect;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;




public class MainActivity extends AppCompatActivity {




public void toBuilding(View view){
    //this is an item on the menu.
    // When clicked, it redirects to Buildings.Java which consist of a list view of  buildings on campus

    Intent hi =new Intent(this, Buildings.class);
    startActivity(hi);
}



public void toShuttle(View view){
    Intent intent = new Intent(this, ShuttleTracker.class);
            startActivity(intent);

}



public void toReserve(View view){
    //this is an item on the menu.
    // When clicked, it redirects to Reserve.Java
     Intent hi= new Intent(this,ReserveShuttle.class);
     startActivity(hi);
}



public void toRide(View view){
    Intent intent= new Intent(this, ReserveRide.class);
    startActivity(intent);
}


    @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



       /* ParseObject score = new ParseObject("Score");
        score.put("username", "bug");
        score.put("score", 200);
        score.saveInBackground(new SaveCallback() {
            @Override
            public void done(com.parse.ParseException e) {

                if (e == null) {

                    Log.i("SaveInBackground", "Successful");

                } else {


                    Log.i("SaveInBackground", "Failed. Error: " + e.toString());

                }

            }
        });


        ParseAnalytics.trackAppOpenedInBackground(getIntent());*/
    }
    }

