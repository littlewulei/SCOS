package es.source.code.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainScreen extends AppCompatActivity {

    private GridView menu_view;
    private List<Map<String, Object>> data_list; //链表节点是一个个哈希表
    private SimpleAdapter sim_adapter;
    // 图片封装为一个数组
    private int[] icon = {R.drawable.diancan, R.drawable.dingdan, R.drawable.zhanghu, R.drawable.help};
    private String[] iconName = {"点餐", "查看订单", "登录/注册", "系统帮助"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);

        Intent intent = getIntent();
        String data = intent.getStringExtra("login_state");


// 未登录
        if (data.equals("return") || data.equals("FromEntry")) {

            menu_view = (GridView) findViewById(R.id.menu_navi);
            //新建List
            data_list = new ArrayList<Map<String, Object>>();
            //给链表赋值
            getDataNoLogin();
            //新建适配器
            String[] item_key = {"image", "text"};
            int[] item_id = {R.id.image, R.id.text};
            sim_adapter = new SimpleAdapter(this, data_list, R.layout.menu_item, item_key, item_id);
            //配置适配器
            menu_view.setAdapter(sim_adapter);
            //item点击事件
            menu_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                    switch (arg2) {
                        case 0:
                            Intent intent2 = new Intent(MainScreen.this, LoginOrRegister.class);
                            startActivity(intent2);
                            finish();
                            break;
                        case 1:
                            break;
                    }

                }
            });

        }
// 已登录
        else if (data.equals("LoginSuccess") || data.equals("RegisterSuccess")) {
            menu_view = (GridView) findViewById(R.id.menu_navi);
            //新建List
            data_list = new ArrayList<Map<String, Object>>();
            //给链表赋值
            getData();
            //新建适配器
            String[] item_key = {"image", "text"};
            int[] item_id = {R.id.image, R.id.text};
            sim_adapter = new SimpleAdapter(this, data_list, R.layout.menu_item, item_key, item_id);
            //配置适配器
            menu_view.setAdapter(sim_adapter);
            //item点击事件
            menu_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

                    switch (arg2) {
                        case 0:
                            Intent intent = new Intent(MainScreen.this, FoodView.class);
                            startActivity(intent);
                            //点击点餐
                            break;
                        case 1:
                            Intent intent2 = new Intent(MainScreen.this, FoodOrderView.class);
                            startActivity(intent2);
                            //点击订单
                            break;
                        case 2:
                            //点击登录
                            break;
                        case 3:
                            //点击帮助
                            break;


                    }
                }
            });

        }
    }

    //显示所有菜单
    public List<Map<String, Object>> getData() {
        for (int i = 0; i < icon.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            data_list.add(map);
        }

        return data_list;
    }

    //只显示登录和查看帮助
    public List<Map<String, Object>> getDataNoLogin() {

        for (int i = 2; i < icon.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            data_list.add(map);
        }
        return data_list;
    }

}
