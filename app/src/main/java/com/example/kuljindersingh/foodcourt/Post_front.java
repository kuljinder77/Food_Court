package com.example.kuljindersingh.foodcourt;

/**
 * Created by kuljinder singh on 8/4/2017.
 */
        import android.app.Dialog;
        import android.content.Context;
        import android.content.Intent;
        import android.os.AsyncTask;
        import android.util.Log;
        import android.view.View;
        import android.view.WindowManager;
        import android.widget.AdapterView;
        import android.widget.GridView;
        import android.widget.ImageView;
        import android.widget.ListView;
        import android.widget.TextView;

        import com.squareup.picasso.Picasso;

        import org.json.JSONArray;
        import org.json.JSONObject;

        import java.util.ArrayList;


public class Post_front extends AsyncTask<String,String,String> {
    StringBuilder response;
    Post obj;
    Context c;
    ListView lst;
    Model_Getter_Setter model;
    ArrayList<Model_Getter_Setter> model_arr = new ArrayList<Model_Getter_Setter>();


    public Post_front(Context c, ListView lst)
    {

        Log.e(",,,,,,,,,aha,","ssdsdsdsd");
        this.c = c;
        this.lst = lst;
    }
    @Override
    protected String doInBackground(String... params)
    {


        String url = "https://food2fork.com/api/search?key=777da9bb53c257cdfaca03a14091c9ab&q=shredded%20chicken";
        obj = new Post(url);
        response =  obj.Connect();

        try {

            JSONObject jsonObject = new JSONObject(String.valueOf(response));
            JSONArray jsonArray = jsonObject.getJSONArray("recipes");
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                String name = jsonObject1.getString("title");
                String image = jsonObject1.getString("image_url");
                String data = jsonObject1.getString("source_url");

                model = new Model_Getter_Setter(name,image,data);

                model_arr.add(model);

            }
        }catch (Exception e)
        {

        }
        return null;
    }

    @Override
    protected void onPostExecute(String aVoid) {
        super.onPostExecute(aVoid);

        //Toast.makeText(c,""+response,Toast.LENGTH_LONG).show();
        lst.setAdapter(new myadapter(c, model_arr));
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent a = new Intent(c,Details.class);
                a.putExtra("pos",model_arr.get(position).getData());
                a.putExtra("name",model_arr.get(position).getName());
                a.putExtra("img",model_arr.get(position).getImage());

                c.startActivity(a);
            }
        });
    }


}
