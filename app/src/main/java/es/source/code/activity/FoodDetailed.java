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
        for (int i = 1; i <= 4; i++) {
            Fragment fragment = new FoodDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("arg", i);
            fragment.setArguments(bundle);
            list.add(fragment);
            title.add("菜品");
        }
        viewPager = (ViewPager) findViewById(R.id.viewpager2);//viewpager 在food_view 配置文件中



        //将存放了Fragment的列表和指示器的参量加载到适配器中，然后将适配器变量加载到ViewPager中
        //最后将ViewPager放到布局的PagerSlidingTabStrip第三方控件里
        FoodDetailFragmentAdapter ma = new FoodDetailFragmentAdapter(getSupportFragmentManager(),list,title);
        viewPager.setAdapter(ma);


    }


}



