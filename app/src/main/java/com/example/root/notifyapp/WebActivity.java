package com.example.root.notifyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        overridePendingTransition(R.anim.slide_from_left,R.anim.slide_to_right);
    }
}
