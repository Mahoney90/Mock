package com.mahoneyapps.tapitfinal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brendan on 3/7/2016.
 */
public class BarFragment extends ListFragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "PubListRecyclerActivity";
    public List<Pub> pubsListYo = new ArrayList<>();




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.list_fragment, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.list_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new PubRecyclerViewAdapter(pubsListYo);
        mRecyclerView.setAdapter(mAdapter);
//        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
//        mRecyclerView.addItemDecoration(itemDecoration);

        getPubList();


        return rootView;
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
