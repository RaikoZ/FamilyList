package com.example.manoj.familylist;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.squareup.picasso.Picasso;


public class CustomListAdapter extends ArrayAdapter<String> {


    private final Activity context;
    private final String[] itemname;
    private final String[] itemrelation;
    private final Integer[] imgid;
    public Firebase myFirebaseRef;

    public CustomListAdapter(final Activity context,String[] itemrelation, String[] itemname, Integer[] imgid) {
        super(context, R.layout.layout, itemname);

        this.context = context;
        this.itemname = itemname;
        this.imgid = imgid;
        this.itemrelation = itemrelation;

        Firebase.setAndroidContext(getContext());
        myFirebaseRef = new Firebase("https://familylist2-0.firebaseio.com/");


    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        final View rowView = inflater.inflate(R.layout.layout, null, true);

        final TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        final TextView txtRelation = (TextView) rowView.findViewById(R.id.relation1);
        final ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);


        txtTitle.setText(itemname[position]);
        txtRelation.setText(itemrelation[position]);
        imageView.setImageResource(imgid[position]);

                myFirebaseRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        txtTitle.setText(String.valueOf(dataSnapshot.child("familylist2-0").child(String.valueOf(position)).child("Name").getValue()));
                        Picasso.with(getContext()).load(String.valueOf(dataSnapshot.child("familylist2-0").child(String.valueOf(position)).child("Image").getValue())).into(imageView);


                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });
        return rowView;
    }
}

