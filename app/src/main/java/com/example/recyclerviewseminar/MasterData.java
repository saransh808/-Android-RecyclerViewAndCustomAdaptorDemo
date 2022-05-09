package com.example.recyclerviewseminar;

public class MasterData {
    String name;
    Integer age;
    String imgUrl;

    public MasterData(String name, Integer age, String imgUrl) {
        this.name = name;
        this.age = age;
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    @Override
    public String toString() {
        return "MasterData{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
