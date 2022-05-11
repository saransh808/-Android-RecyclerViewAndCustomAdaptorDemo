package com.example.recyclerviewseminar;

import java.util.ArrayList;

public class DataInitializer {

    private static ArrayList<MasterData> data = new ArrayList<MasterData>();

    private static DataInitializer initializer = null;

    public static DataInitializer getSingletonInitializer(){
        if(initializer == null)
            initializer = new DataInitializer();
        if(data.isEmpty())
            initializer.generateData();
        return initializer;
    }

    private void generateData(){
        data.add(new MasterData("Saransh",26,"https://www.dmarge.com/wp-content/uploads/2021/01/dwayne-the-rock-.jpg"));
        data.add(new MasterData("Agarwal",46,"https://www.dmarge.com/wp-content/uploads/2021/01/dwayne-the-rock-.jpg"));
        data.add(new MasterData("Sachin",65,"https://d.newsweek.com/en/full/1619534/john-cena-raw-underground-thoughts.jpg?w=1600&h=1200&l=28&t=25&q=88&f=0556b7e88b2e65ac9a509392582789c7"));
        data.add(new MasterData("Devdhar",86,"https://yt3.ggpht.com/ytc/AKedOLSmeQwYzKscVUVnkVYFB7TTgVUnOuIXPcMv-o4H=s900-c-k-c0x00ffffff-no-rj"));
        data.add(new MasterData("Humber",10,"https://d.newsweek.com/en/full/1619534/john-cena-raw-underground-thoughts.jpg?w=1600&h=1200&l=28&t=25&q=88&f=0556b7e88b2e65ac9a509392582789c7"));
        data.add(new MasterData("Gulph Humber",7,"https://yt3.ggpht.com/ytc/AKedOLSmeQwYzKscVUVnkVYFB7TTgVUnOuIXPcMv-o4H=s900-c-k-c0x00ffffff-no-rj"));
    }

    public void addData(String name, Integer age, String url){
        data.add(new MasterData(name,age,url));
        System.out.println("Data Size is "+data.size());
    }

    public ArrayList<MasterData> getData(){
        return data;
    }


}
