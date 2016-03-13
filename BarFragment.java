package com.mahoneyapps.tapitfinal;

import android.content.Context;
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
    Context mContext;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity();

        View rootView = inflater.inflate(R.layout.list_fragment, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.list_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new PubRecyclerViewAdapter(mContext, pubsListYo);
        mRecyclerView.setAdapter(mAdapter);
//        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
//        mRecyclerView.addItemDecoration(itemDecoration);

        getPubList();


        return rootView;
    }

    private void getPubList() {

//        pubsListYo.add(new Pub("Hop Garden"));
//        pubsListYo.add(new Pub("Garage Project"));
//        pubsListYo.add(new Pub("The Rogue and Vagabond"));
//        pubsListYo.add(new Pub("The Malthouse"));
//        pubsListYo.add(new Pub("Parrotdog"));
//        pubsListYo.add(new Pub("Little Beer Quarter"));
//        pubsListYo.add(new Pub("Fork and Brewer"));

        String[] pubList = {"Garage Project", "Hop Garden", "Rogue and Vaganbond", "The Malthouse",
                            "Parrotdog", "Fork and Brewer", "Little Beer Quarter"};

        for (int index = 0; index < pubList.length ; index++){
            Pub p = new Pub(pubList[index]);
            pubsListYo.add(index, p);
        }

        Log.v("Test", String.valueOf(pubsListYo.size()));
        Log.v("Testing", String.valueOf(pubsListYo));

        mAdapter.notifyDataSetChanged();


    }

}
