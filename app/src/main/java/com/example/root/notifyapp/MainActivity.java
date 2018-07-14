package com.example.root.notifyapp;

import android.app.ActivityOptions;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;

    private static Button show_text,got,star,vv;
    private static TextView clipboardData;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);

        show_text = (Button) findViewById(R.id.show_text);
        linearLayout = findViewById(R.id.linear_layout);

        got = (Button) findViewById(R.id.button);

        star= (Button) findViewById(R.id.button2);


        vv=(Button)findViewById(R.id.button3);

        //clipboardData = (TextView) findViewById(R.id.clipboard_data);//

        Intent intent = new Intent(MainActivity.this,TheService.class);

        startService(intent);

        got.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ii = new Intent(MainActivity.this,BackgroundActivity.class);


                startActivity(ii);
            }
        });


        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent iii = new Intent(MainActivity.this,StarActivity.class);
                startActivity(iii);
            }
        });

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ii = new Intent(MainActivity.this,BackgroundActivity.class);


                startActivity(ii);
                overridePendingTransition(R.anim.slide_from_left,R.anim.slide_to_right);
            }
        });

       vv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iiii = new Intent(MainActivity.this,PagerActivity.class);


                startActivity(iiii);

            }
        });

        /*Intent iiii = new Intent(MainActivity.this,StarActivity.class);

        overridePendingTransition(R.anim.slide_from_right,R.anim.slide_to_left);

        startActivity(iiii);*/

        //showData();//


    }





    public void showData(View view ){

        show_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor res = myDb.getUpdateData();

                if(res.getCount()==0)
                {
                    showMessage("Error","Nothing Found");
                    return;
                }

                StringBuffer stringBuffer =new StringBuffer();

                while(res.moveToNext()){

                    stringBuffer.append("Link : "+ res.getString(1)+"\n\n\n");

                }

                showMessage("Data",stringBuffer.toString());
            }
        });

    }



    public void showMessage(String title,String message){

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setMessage(message);
        builder.setTitle(title);
        builder.show();



    }




}