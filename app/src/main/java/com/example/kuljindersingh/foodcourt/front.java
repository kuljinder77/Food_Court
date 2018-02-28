package com.example.kuljindersingh.foodcourt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

public class front extends AppCompatActivity {

    ListView grid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);


        grid=(ListView) findViewById(R.id.listview);
        new Post_front(front.this,grid).execute();
    }
}
