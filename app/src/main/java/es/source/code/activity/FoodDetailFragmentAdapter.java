package es.source.code.activity;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by LEI on 2017/10/20.
 */

    public class FoodDetailFragmentAdapter extends FragmentPagerAdapter {
        private List<Fragment> list;
        private List<String> title;
        private Context context;

        public FoodDetailFragmentAdapter(FragmentManager fm, List<Fragment> list,List<String> title) {
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




