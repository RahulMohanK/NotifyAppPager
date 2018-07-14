package com.example.root.notifyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class GraphActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        overridePendingTransition(R.anim.slide_from_right,R.anim.slide_to_left);
    }
}
