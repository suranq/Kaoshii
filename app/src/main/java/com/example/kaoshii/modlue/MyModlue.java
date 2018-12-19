package com.example.kaoshii.modlue;

import com.example.kaoshii.https.MyHttp;

import java.util.Map;

/**
 * Created by 马明祥 on 2018/12/17.
 */

public class MyModlue implements MainModlue{
    @Override
    public void show(Map<String,Object>map, HttpFish httpFish) {
        MyHttp.getInsh().get(map,httpFish);
    }
}
