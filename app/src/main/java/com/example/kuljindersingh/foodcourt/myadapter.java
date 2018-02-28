package com.example.kuljindersingh.foodcourt;

/**
 * Created by kuljinder singh on 8/4/2017.
 */


        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;

        import com.squareup.picasso.Picasso;

        import java.util.ArrayList;


public class myadapter extends BaseAdapter
{
    Context c;
    ArrayList<Model_Getter_Setter> model_arr;
    LayoutInflater linf;
    public myadapter(Context c, ArrayList<Model_Getter_Setter> model_arr)
    {
        this.c = c;
        this.model_arr = model_arr;
        linf = LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        return model_arr.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View1 v=new View1();
        convertView=linf.inflate(R.layout.custom,null);

        v.t1=(TextView)convertView.findViewById(R.id.customname);

        v.img=(ImageView)convertView.findViewById(R.id.customimage);
        v.t1.setTextSize(15);

        v.t1.setText(model_arr.get(position).getName());


        Picasso.with(c).load(model_arr.get(position).getImage()).into(v.img);
        return convertView;

    }
}

class View1
{
    TextView t1;
    ImageView img;
}