package es.source.code.activity;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


import java.util.ArrayList;
import java.util.List;


public class FoodDetailed extends AppCompatActivity {

    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_detailed);

        //建了4个FoodFragment，并且往FoodFragment里捆绑了一些整数，用于判断
        //是哪个Fragment，或者直接新建fragment1，fragment2，fragment3，fragment4
        List<Fragment> list = new ArrayList<>();
        List<String>title = new ArrayList<>();
        title.add("红烧肉");
        title.add("拌牛肉");
        title.add("大闸蟹");
        title.add("啤酒");

        for (int i = 1; i <= title.size(); i++) {
            Fragment fragment = new FoodDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("arg", i);
            fragment.setArguments(bundle);
            list.add(fragment);
        }
        viewPager = (ViewPager) findViewById(R.id.viewpager2);
        //将存放了Fragment的列表和指示器的参量加载到适配器中，然后将适配器变量加载到ViewPager中
        FoodDetailFragmentAdapter ma = new FoodDetailFragmentAdapter(getSupportFragmentManager(),list,title);
        viewPager.setAdapter(ma);



    }


}



