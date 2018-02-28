package com.example.kuljindersingh.foodcourt;

/**
 * Created by kuljinder singh on 8/4/2017.
 */


        import android.util.Log;

        import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.net.URL;
        import java.net.URLConnection;


public class Post {

    StringBuilder stringBuilder;
    String url;

    Post(String url) {
        this.url = url;
        stringBuilder = new StringBuilder();
    }


    StringBuilder Connect() {
        try {
            URL url1 = new URL(url);
            URLConnection urlConnection = url1.openConnection();
            InputStreamReader inputStreamReader = new InputStreamReader(urlConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String data;
            while ((data = bufferedReader.readLine()) != null) {
                stringBuilder.append(data);

            }
            Log.e("response", stringBuilder + "");
            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuilder;
    }
}