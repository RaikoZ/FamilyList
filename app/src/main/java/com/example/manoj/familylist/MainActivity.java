package com.example.manoj.familylist;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;


public class MainActivity extends Activity {


    ListView list;
    String[] itemname = {
            "Me",
            "Me",
            "New Family",
            "Manoj Rath",
            "Anita Sarangi",
            "Sabyasachi Dash",
            "Sushree Dash",
            "Amit Sarangi",
            "Satyabadi Sarangi",
            "Surekha Sarangi"
    };
    String [] itemrelation = {
            "Manish Rath",
            "Manish Rath",
            "GDG BBSR",
            "Father",
            "Mother",
            "Brother",
            "Sister",
            "Uncle",
            "Grand Father",
            "Grand Mother"

    };

    Integer[] imgid = {
            R.mipmap.me,
            R.mipmap.me,
            R.mipmap.gdg,
            R.mipmap.father,
            R.mipmap.mother,
            R.mipmap.brother,
            R.mipmap.sister,
            R.mipmap.uncle,
            R.mipmap.grandfather,
            R.mipmap.grandmother
    };

    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);


        CustomListAdapter adapter = new CustomListAdapter(this,itemrelation, itemname, imgid);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);




        list.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                String Slecteditem = itemname[+position];
                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();

            }
        });


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.manoj.familylist/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.manoj.familylist/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
