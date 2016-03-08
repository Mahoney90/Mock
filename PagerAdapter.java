package com.mahoneyapps.tapitfinal;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Brendan on 3/5/2016.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    Context context;
    String tabTitles[] = new String[]{"List", "Map"};

//    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
//        super(fm);
//        this.mNumOfTabs = NumOfTabs;
//    }

    public PagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Fragment listTab = new BarFragment();
                return listTab;
            case 1:
                Fragment tab2 = new GenerateMapFragment();
                return tab2;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return tabTitles[position];
    }

    public View getTabView(int position){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View tab = inflater.inflate(R.layout.pub_item, null);
        TextView textView = (TextView) tab.findViewById(R.id.pub_text_view);
        textView.setText(tabTitles[position]);
        return tab;
    }
}
