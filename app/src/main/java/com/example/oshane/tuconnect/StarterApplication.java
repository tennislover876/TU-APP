

/**
 * Created by TUSKEGEE on 9/10/2017.
 */


package  com.example.oshane.tuconnect;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;


public class StarterApplication extends Application {

    //This java class connects the app to parse server

    @Override
    public void onCreate() {
        super.onCreate();

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        // Add your initialization code here
        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                //.applicationId("8b260cbb11b9d86b82cc8af7074bf5a9b775464c")
                //.clientKey("88be0047eda77b9182bb2bc720481e01e4804957")
                //.server("http://ec2-54-200-137-68.us-west-2.compute.amazonaws.com:80/parse/")
                .applicationId("0df49e4a966673c5fe041f1879a5bec0a94bc421")
                .clientKey("c77d9b29e15a34e90c49ae31ae53a7300019b275") // can leave out since it is blank
                .server("http://ec2-18-220-245-18.us-east-2.compute.amazonaws.com:80/parse/")
                .build()
        );


        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        defaultACL.setPublicReadAccess(true);
        defaultACL.setPublicWriteAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);

    }
}
