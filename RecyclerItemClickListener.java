package com.mahoneyapps.tapitfinal;

import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;

/**
 * Created by Brendan on 3/10/2016.
 */
public class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener{
    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
