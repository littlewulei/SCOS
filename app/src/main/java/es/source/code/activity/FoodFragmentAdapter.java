package es.source.code.activity;

/**
 * Created by LEI on 2017/10/14.
 */
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;



public class FoodFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;
    private List<String> title;
    private Context context;

    public FoodFragmentAdapter(FragmentManager fm, List<Fragment> list,List<String> title) {
        super(fm);
        this.title = title;
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }

}



