package com.mahoneyapps.tapitfinal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brendan on 3/6/2016.
 */
public class PubListRecyclerActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "PubListRecyclerActivity";
    public List<Pub> pubsListYo = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_fragment);


        mRecyclerView = (RecyclerView) findViewById(R.id.list_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new PubRecyclerViewAdapter(pubsListYo);
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);

        getPubList();
    }


    @Override
    protected void onResume() {
        super.onResume();
        ((PubRecyclerViewAdapter) mAdapter).setOnItemClickListener(new PubRecyclerViewAdapter.MyClickListener(){

            @Override
            public void onItemClick(int position, View view) {
                Log.d(LOG_TAG, " Click on " + position);
            }
        });
    }

    private void getPubList() {


            for (int index = 0; index < 8 ; index++){
                Pub p = new Pub("Some primary text " + index);
                pubsListYo.add(index, p);
            }

        Log.v("Test", String.valueOf(pubsListYo.size()));
        Log.v("Testing", String.valueOf(pubsListYo));

        mAdapter.notifyDataSetChanged();


    }
}
