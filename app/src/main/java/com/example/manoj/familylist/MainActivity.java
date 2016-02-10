package com.example.manoj.familylist;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends Activity{

    ListView list;
    String[] itemname ={
            "Me(Manish Rath)",
            "Me(Manish Rath)",
            "New Family(GDG BBSR)",
            "Manoj Rath(Father)",
            "Anita Sarangi(Mother)",
            "Sabyasachi Das(Brother)",
            "Sushree Dash(Sister)",
            "Amit Sarangi(Uncle)",
            "Satyabadi Sarangi(Grand Father)",
            "Surekha Sarangi(Grand Mother)"
    };

    Integer[] imgid={
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomListAdapter adapter=new CustomListAdapter(this, itemname, imgid);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                String Slecteditem= itemname[+position];
                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();

            }
        });
    }
}
