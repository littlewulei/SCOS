package es.source.code.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;


public class FoodView extends AppCompatActivity {

    private ViewPager viewPager;

    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_view);

        //建了4个FoodFragment，并且往FoodFragment里捆绑了一些整数，用于判断
        //是哪个Fragment，或者直接新建fragment1，fragment2，fragment3，fragment4
        List<Fragment> list = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            Fragment fragment = new FoodFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("arg", i);
            fragment.setArguments(bundle);
            list.add(fragment);
        }
        List<String> title = new ArrayList<>();
        title.add("热菜");
        title.add("冷菜");
        title.add("海鲜");
        title.add("酒水");
        viewPager = (ViewPager) findViewById(R.id.viewpager);//viewpager 在food_view 配置文件中
        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);//sliding_tabs 在food_view 配置文件中


        //将存放了Fragment的列表和指示器的参量加载到适配器中，然后将适配器变量加载到ViewPager中
        //最后将ViewPager放到布局的PagerSlidingTabStrip第三方控件里
        FoodFragmentAdapter ma = new FoodFragmentAdapter(getSupportFragmentManager(), list, title);
        viewPager.setAdapter(ma);
        tabLayout.setupWithViewPager(viewPager);  //将Tab layout 添加到viewpager

    }

    //添加actionbar menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.food_view_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.ordered:
                Intent intent = new Intent(FoodView.this, FoodOrderView.class);
                startActivity(intent);
                return true;
            case R.id.order_form:
                Intent intent2 = new Intent(FoodView.this, FoodOrderView.class);
                startActivity(intent2);
                return true;
            case R.id.call_server:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}



