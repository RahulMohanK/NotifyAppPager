package com.example.root.notifyapp;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Adapter;

public class SwipeHelper extends ItemTouchHelper.SimpleCallback{


    MyAdapter adapter;

    public SwipeHelper(int dragDirs, int swipeDirs){
        super(dragDirs,swipeDirs);
    }

    public SwipeHelper(MyAdapter adapter) {
        super(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT);
        this.adapter = adapter;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

        //adapter.diss(viewHolder.getAdapterPosition());

    }
}

