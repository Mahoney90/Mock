package com.mahoneyapps.tapitfinal;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Brendan on 3/13/2016.
 */
public class UntappdAPICall extends Fragment {

    String mBeerName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.selected_beer_and_rating, container, false);

        return v;
    }

    public void searchForBeer(String beer) {
        mBeerName = beer;

        Log.d("beer name", mBeerName);

        new newUntappd(getActivity()).execute();
    }

    private class newUntappd extends AsyncTask<Void, Void, String>{

        Context mContext;

        public newUntappd(Context context){
            mContext = context;
        }
        @Override
        protected String doInBackground(Void... params) {

            String beerName;

                try {
                    Log.d("connecting..", "trying to connect");
                    URL url = new URL("https://api.untappd.com/v4/search/beer?q=" + mBeerName +
                            "client_id=8812AB1DE6D473E7939055A6F0C1E48A471F4C91&client_secret=36F6265B24BE666AC388EAA03B3DE68B936C9950");
                    Log.d("I connected", "yess");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    Log.d("truly connected", "woo");

                    try {
                        Log.d("loading buffered reader", "woo");
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        StringBuilder builder = new StringBuilder();
                        String line;
                        Log.d("loading while", "woo");
                        while ((line = bufferedReader.readLine()) != null) {
                            Log.d("loading while", "woo");
                            builder.append(line).append("\n");
                        }
                        Log.d("loading while", "woo");
                        bufferedReader.close();

                        Log.d("made it to tasty beer", "woo");
                        String tastyBeer = parseJSON(builder.toString());

                        Log.d("tasty test", tastyBeer);
                        return tastyBeer;

                    } finally {
                        connection.disconnect();
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    return null;

                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }



        }

            private String parseJSON(String s) {
                try {
                    JSONObject reader = new JSONObject(s);
                    JSONObject response = reader.getJSONObject("response");
                    JSONObject beers = response.getJSONObject("beers");
                    JSONArray items = beers.getJSONArray("items");
                    JSONObject item1 = items.getJSONObject(0);
                    JSONObject beerName = item1.getJSONObject("beer");
                    JSONObject actualBeerName = beerName.getJSONObject("beer_name");
                    String tasyBeer = beerName.optString("beer_name");
                    Log.d("Untappd", tasyBeer);
                    return tasyBeer;

                } catch (JSONException e) {
                    e.printStackTrace();
                    return null;
                }

            }

        }


//
//    public String beerSearch(String beerName) {
//        try {
//            URL url = new URL("https://api.untappd.com/v4/search/beer?q=" + beerName +
//                    "client_id=8812AB1DE6D473E7939055A6F0C1E48A471F4C91&client_secret=36F6265B24BE666AC388EAA03B3DE68B936C9950");
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//            try {
//                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//                StringBuilder builder = new StringBuilder();
//                String line;
//                while ((line = bufferedReader.readLine()) != null) {
//                    builder.append(line).append("\n");
//                }
//                bufferedReader.close();
//
//                parseJSON(builder.toString());
//
//            } finally {
//                connection.disconnect();
//            }
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//
//        }
//        return null;
//    }
//
//    private void parseJSON(String s) {
//        try {
//            JSONObject reader = new JSONObject(s);
//            JSONObject response = reader.getJSONObject("response");
//            JSONObject beers = response.getJSONObject("beers");
//            JSONArray items = beers.getJSONArray("items");
//            JSONObject item1 = items.getJSONObject(0);
//            JSONObject beerName = item1.getJSONObject("beer");
//            JSONObject actualBeerName = beerName.getJSONObject("beer_name");
//            String tasyBeer = beerName.optString("beer_name");
//            Log.d("Untappd", tasyBeer);
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
}
