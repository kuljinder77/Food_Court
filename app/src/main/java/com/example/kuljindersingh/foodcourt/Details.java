package com.example.kuljindersingh.foodcourt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmObject;

public class Details extends AppCompatActivity {
    String url;
    String name ;
    String img;
    Realm realm;
    TextView name1 , url1 ;
    ImageView image;
    Button fav;
    ArrayList<Model_Getter_Setter> model_arr =  new ArrayList<Model_Getter_Setter>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        url = getIntent().getStringExtra("pos");
        name = getIntent().getStringExtra("name");
        img = getIntent().getStringExtra("img");
        fav = (Button) findViewById(R.id.add);
        url1 = (TextView) findViewById(R.id.url);
        name1 = (TextView) findViewById(R.id.name);
        image = (ImageView) findViewById(R.id.img);
        url1.setText(url);
        name1.setText(name);
        Picasso.with(this).load(img).into(image);
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Realm.init(getApplicationContext());
                realm=Realm.getDefaultInstance();
                realm obj=new realm();
                obj.name=name;
                try {
                    realm.beginTransaction();
                    realm.copyToRealm(obj);
                    realm.commitTransaction();
                    Toast.makeText(Details.this, "Saved To Favourites", Toast.LENGTH_SHORT).show();
                    Intent a = new Intent(getApplicationContext(),favourite.class);
                    startActivity(a);
                }catch (Exception e)
                {
                    Toast.makeText(Details.this, "Already added", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
