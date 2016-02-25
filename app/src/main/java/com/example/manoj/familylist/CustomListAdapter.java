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


public class CustomListAdapter extends ArrayAdapter<String> {
    private Firebase mRef;


    private final Activity context;
    private final String[] itemname;
    private final Integer[] imgid;

    public CustomListAdapter(final Activity context, String[] itemname, Integer[] imgid) {
        super(context, R.layout.layout, itemname);
        mRef = new Firebase("https://familylist2-0.firebaseio.com/");
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String newCondition = (String) dataSnapshot.getValue();
                context.setContentView(Integer.parseInt(newCondition));
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



        this.context=context;
        this.itemname=itemname;
        this.imgid=imgid;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.layout, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);

        txtTitle.setText(itemname[position]);
        imageView.setImageResource(imgid[position]);
        extratxt.setText("Description "+itemname[position]);
        return rowView;

    }
}
