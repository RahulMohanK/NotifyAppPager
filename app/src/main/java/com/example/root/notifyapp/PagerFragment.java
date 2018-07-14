package com.example.root.notifyapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by TomazWang on 2016/10/31.
 */

public class PagerFragment extends Fragment {


    private static final String KEY_TITLE = "key_titile";
    private static final String KEY_PAGE_ID = "key_page_id";
    private String title;
    private TextView titleView;
    private int page_id;

    ImageView imageView,imageView2;



   /* private static final int[] colors = new int[]{
            Color.CYAN,
            Color.WHITE,
            Color.RED,
            Color.BLUE,
            Color.GREEN,
            Color.GRAY,
            Color.YELLOW
    };*/



    public static PagerFragment newInstance(String title, int page_id ) {


        Bundle args = new Bundle();
        args.putString(KEY_TITLE, title);
        args.putInt(KEY_PAGE_ID, page_id);
        PagerFragment fragment = new PagerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle != null) {
            this.title = bundle.getString(KEY_TITLE);
            this.page_id = bundle.getInt(KEY_PAGE_ID);
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_page, container, false);
        this.titleView = (TextView) view.findViewById(R.id.txt_title);
        titleView.setText(title);
        this.imageView = view.findViewById(R.id.imageView);
        //this.cardView = view.findViewById(R.id.cardview1);
        this.imageView2 = view.findViewById(R.id.imageView2);
       imageView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(getActivity(),GraphActivity.class);
               startActivity(i);
              //view.startAnimation(AnimationUtils.loadAnimation(getActivity(),R.anim.slide_from_right));
           }
       });


        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),WebActivity.class);
                startActivity(i);
                //view.startAnimation(AnimationUtils.loadAnimation(getActivity(),R.anim.slide_from_right));
            }
        });


        view.setBackgroundColor(Color.WHITE);

        return view;
    }


}

