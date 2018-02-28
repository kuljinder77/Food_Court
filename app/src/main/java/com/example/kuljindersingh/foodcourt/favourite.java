package com.example.kuljindersingh.foodcourt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import io.realm.Realm;
import io.realm.RealmResults;

public class favourite extends AppCompatActivity {

    Realm realm1;
    ListView list;
    String arr[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);
        list = (ListView) findViewById(R.id.list);
        RealmResults<realm> data=realm1.where(realm.class).findAll();
        for(int i=0;i<data.size();i++)
        {
            arr[i]=data.get(i).name;
        }
        ArrayAdapter<String> myAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr);
        list.setAdapter(myAdapter);
    }
}
