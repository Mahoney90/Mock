package com.mahoneyapps.tapitfinal;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Brendan on 3/6/2016.
 */
public class PubRecyclerViewAdapter extends RecyclerView.Adapter<PubRecyclerViewAdapter.PubHolder> {

    private static MyClickListener mMyClickListener;
    private static List<Pub> mPubList;

    PubRecyclerViewAdapter(List<Pub> pubList){
        mPubList = pubList;
    }

    @Override
    public PubHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.pub_item, parent, false);

        PubHolder pubHolder = new PubHolder(view);
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

    public void addItem(Pub name, int index){
        mPubList.add(name);
        notifyItemInserted(index);
    }

    public void deleteItem(int index){
        mPubList.remove(index);
        notifyItemRemoved(index);
    }

    public interface MyClickListener {
        void onItemClick(int position, View view);
    }

    public static class PubHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView pubTextView;

        public PubHolder(View itemView){
            super(itemView);
            pubTextView = (TextView) itemView.findViewById(R.id.pub_text_view);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mMyClickListener.onItemClick(getOldPosition(), v);
        }
    }

    public void setOnItemClickListener(MyClickListener myClickListener){
        mMyClickListener = myClickListener;
    }



}
