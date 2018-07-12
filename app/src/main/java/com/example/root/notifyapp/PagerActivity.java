package com.example.root.notifyapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class PagerActivity extends AppCompatActivity{

    private String[] data;
    ViewPager viewPager;
    private List<ListenItem> listenItems;
    DatabaseHelper myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pager);

        viewPager = (ViewPager) findViewById(R.id.vertical_viewPager);

        listenItems = new ArrayList<>();
        myDb = new DatabaseHelper(this);

        initData();
        initView();




    }



    private void initData() {
        Cursor res = myDb.getAllData();


        /*if(res.getCount()==0)
        {
            showMessage("Error","Nothing Found");
            return;
        }*/

        while (res.moveToNext()) {

            ListenItem item = new ListenItem(res.getString(1));
            listenItems.add(item);


        }

        this.data = new String[listenItems.size()];



    }
    private void initView() {
        for (int i = 0; i < listenItems.size(); i++) {

            this.data[i]=listenItems.get(i).toString();
            PageAdapter viewPageAdapter = new PageAdapter(getSupportFragmentManager(), data);
            viewPager.setAdapter(viewPageAdapter);
        }

    }






}

