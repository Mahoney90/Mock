package com.mahoneyapps.tapitfinal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Brendan on 3/13/2016.
 */
public class SelectedBeerView extends Fragment {
    String mBeerName;
    int mRating;
    TextView getRatingText;
    TextView getNumOfTimesHad;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.selected_beer_and_rating, container, false);

        TextView tv = (TextView) v.findViewById(R.id.text_beer_selected);
        final String beerName = getArguments().getString("beer");
        mBeerName = beerName;
        tv.setText(mBeerName);

        Button button = (Button) v.findViewById(R.id.save_button);

        getRatingText = (TextView) v.findViewById(R.id.show_rating_text);
        getNumOfTimesHad = (TextView) v.findViewById(R.id.show_number_of_times_had);

        if (container != null) {
            container.removeAllViews();
        }

        RatingBar rateBar = (RatingBar) v.findViewById(R.id.rate_bar);

        rateBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Log.d("new rating", String.valueOf(rating));
                mRating = Math.round(rating);
                Toast.makeText(getActivity(), "You rated this beer " + rating + " stars", Toast.LENGTH_SHORT).show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                BeerHandler handler = new BeerHandler(getActivity());
                BeerCatalogue catalogue = new BeerCatalogue(1, mBeerName, mRating, "Brendan");
                handler.addRating(catalogue);

                showRating(catalogue);
            }
        });

        return v;
    }

    private void showRating(BeerCatalogue catalogue) {
        int rating = catalogue.getRating();
        getRatingText.setText("You have rated this beer " + rating + " stars!");

        BeerHandler handler = new BeerHandler(getActivity());
        int count = handler.getCount(mBeerName);
        getNumOfTimesHad.setText("You have drank this beer " + count + " times" );


    }
}
