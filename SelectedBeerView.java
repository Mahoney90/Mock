package com.mahoneyapps.tapitfinal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Brendan on 3/13/2016.
 */
public class SelectedBeerView extends Fragment {
    String mBeer;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.selected_beer_and_rating, container, false);

        TextView tv = (TextView) v.findViewById(R.id.text_beer_selected);
        String beerName = getArguments().getString("beer");
        tv.setText(beerName);

        if (container != null) {
            container.removeAllViews();
        }

        RatingBar rateBar = (RatingBar) v.findViewById(R.id.rate_bar);

        rateBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Log.d("new rating", String.valueOf(rating));
                Toast.makeText(getActivity(), "You rated this beer " + rating + " stars", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }
}
