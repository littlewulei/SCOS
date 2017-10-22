package es.source.code.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class FoodOrderView extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    Button commit, account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_order_view);

        LayoutInflater inflater =  LayoutInflater.from(FoodOrderView.this);                            //先获取当前布局的填充器
        View commitView = inflater.inflate(R.layout.order_fragment, null);   //通过填充器获取另外一个布局的对象
        commit = (Button) commitView.findViewById(R.id.commit);     //通过另外一个布局对象的findViewById获取其中的控件
        commit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Toast.makeText(getApplicationContext(), "提交成功！",
                        Toast.LENGTH_SHORT).show();
            }
        });

        View accountView = inflater.inflate(R.layout.order_fragment2, null);   //通过填充器获取另外一个布局的对象
        account = (Button) accountView.findViewById(R.id.account);     //通过另外一个布局对象的findViewById获取其中的控件
        account.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Toast.makeText(getApplicationContext(), "您好，老顾客，本次可享受7折优惠！",
                        Toast.LENGTH_SHORT).show();
            }
        });
        //来个循环，我这里弄了2次，建了2个ListViewFragment，并且往ListViewFragment里捆绑了一些整数，用于判断
        //并区分多种菜
        List<Fragment> list2 = new ArrayList<>();
        for(int i = 1;i<=2;i++){
            Fragment fragment = new OrderFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("arg2",i);
            fragment.setArguments(bundle);
            list2.add(fragment);
        }
        List<String> title = new ArrayList<>();
        title.add("未下菜单");
        title.add("已下菜单");

        viewPager = (ViewPager) findViewById(R.id.viewpager);//viewpager 在food_order_view 配置文件中
        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);//sliding_tabs 在food_order_view 配置文件中


        //将存放了Fragment的列表和指示器的参量加载到适配器中，然后将适配器变量加载到ViewPager中

        OrderFragmentAdapter ma = new OrderFragmentAdapter(getSupportFragmentManager(),list2,title);
        viewPager.setAdapter(ma);
        tabLayout.setupWithViewPager(viewPager);  //将Tab layout 添加到viewpager

    }
}
