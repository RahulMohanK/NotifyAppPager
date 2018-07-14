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


    private String[] data,data1;
    ViewPager viewPager;
    private List<ListenItem> listenItems;
    DatabaseHelper myDb;
    String pos;
    int value =-1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pager);
       /* Intent i = getIntent();
        pos= i.getStringExtra("pos");
        value = Integer.parseInt(pos);
*/
        viewPager = (ViewPager) findViewById(R.id.vertical_viewPager);

        listenItems = new ArrayList<>();
        myDb = new DatabaseHelper(this);



        initData();




        initView();

        //Selected(value);

        /*Intent iiii = new Intent(PagerActivity.this,MainActivity.class);


        startActivity(iiii);
        overridePendingTransition(R.anim.slide_from_right,R.anim.slide_to_left);*/





    }



    private void initData() {
        Cursor res = myDb.getAllData();
        while (res.moveToNext()) {
            ListenItem item = new ListenItem(res.getString(1));
            listenItems.add(item);
            }
        this.data = new String[listenItems.size()];
        }
    private void initView() {
        for (int i = 0; i < listenItems.size(); i++) {


            this.data[i]=listenItems.get(i).getLink();
            PageAdapter viewPageAdapter = new PageAdapter(getSupportFragmentManager(), data);
            viewPager.setAdapter(viewPageAdapter);
        }

    }
    private void Selected(int value){

        data1[0] = data[value];
        PageAdapter viewPageAdapter = new PageAdapter(getSupportFragmentManager(),data1);
        viewPager.setAdapter(viewPageAdapter);
    }







}

