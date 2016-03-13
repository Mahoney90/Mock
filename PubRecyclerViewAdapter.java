package com.mahoneyapps.tapitfinal;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Brendan on 3/6/2016.
 */
public class PubRecyclerViewAdapter extends RecyclerView.Adapter<PubRecyclerViewAdapter.PubHolder> {

    public static MyClickListener mMyClickListener;
    public static List<Pub> mPubList;
    public static AdapterView.OnClickListener mItemClickListener;
    Context mContext;
    private AdapterView.OnItemClickListener listener;

    PubRecyclerViewAdapter(Context context, List<Pub> pubList){
        this.mPubList = pubList;
        this.mContext = context;
        Log.d("context1", String.valueOf(mContext));
    }

    @Override
    public PubHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.pub_item, parent, false);
        TextView pubTextView = (TextView) view.findViewById(R.id.pub_text_view);
        view.setOnClickListener(mItemClickListener);

        Log.d("context2", String.valueOf(mContext));
        PubHolder pubHolder = new PubHolder(view, mContext);
        return pubHolder;
    }

    @Override
    public void onBindViewHolder(PubHolder holder, int position) {
        holder.pubTextView.setText(mPubList.get(position).getPubName());
    }

    @Override
    public int getItemCount() {
        return mPubList.size();
    }

    public interface MyClickListener {
        void onItemClick(Pub pub);
    }

    // setter method to set our global ClickListener equal to the arguement passed here
//    public void setOnItemClickListener(MyClickListener myClickListener){
//        mMyClickListener = myClickListener;
//    }



    public static class PubHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView pubTextView;
        Context mContext;

        public PubHolder(View itemView, Context context){
            super(itemView);
            mContext = context;
            Log.d("context3", String.valueOf(mContext));
            pubTextView = (TextView) itemView.findViewById(R.id.pub_text_view);
            pubTextView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            Log.d("context4", String.valueOf(mContext));
            Toast.makeText(mContext, "hi", Toast.LENGTH_SHORT).show();
            FragmentTransaction ft = ((FragmentActivity)mContext).getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.recycler_view_layout_container, new GarageProject()).addToBackStack(null).commit();
            Log.d("context5", String.valueOf(mContext));

            int position = getAdapterPosition();

            Log.d("position", String.valueOf(position));

        }

    }

}
