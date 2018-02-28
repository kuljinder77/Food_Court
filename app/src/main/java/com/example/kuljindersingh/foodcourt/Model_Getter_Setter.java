package com.example.kuljindersingh.foodcourt;

/**
 * Created by kuljinder singh on 8/4/2017.
 */


public class Model_Getter_Setter {

    String name;
    String image;

    public String getData() {
        return data;
    }

    public void setData(String description) {
        this.data = data;
    }

    String data;




    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Model_Getter_Setter(String name, String image , String data){

        this.name = name;
        this.data = data;
        this.image = image;


    }
}
