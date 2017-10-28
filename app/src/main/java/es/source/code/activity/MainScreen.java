package es.source.code.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ButtonBarLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.source.code.model.User;

public class MainScreen extends AppCompatActivity {

    private GridView menu_view;
    private List<Map<String, Object>> data_list; //链表节点是一个个哈希表
    private SimpleAdapter sim_adapter;
    // 图片封装为一个数组
    private int[] icon = {R.drawable.diancan, R.drawable.dingdan, R.drawable.zhanghu, R.drawable.help};
    private String[] iconName = {"点餐", "查看订单", "登录/注册", "系统帮助"};
    User user = null;

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
                            Intent intent3 = new Intent(MainScreen.this, SCOSHelper.class);
                            startActivity(intent3);
                            break;
                    }

                }
            });

        }
// 已登录
        else if (data.equals("LoginSuccess") || data.equals("RegisterSuccess")) {

            user =(User) intent.getSerializableExtra("loginUser");
            //接受登录界面传来的user

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
                            intent.putExtra("user",user);
                            startActivity(intent);
                            //点击点餐
                            break;
                        case 1:
                            Intent intent2 = new Intent(MainScreen.this, FoodOrderView.class);
                            intent2.putExtra("user",user);
                            startActivity(intent2);
                            //点击订单
                            break;
                        case 2:
                            SharedPreferences pref = getSharedPreferences("data",MODE_PRIVATE);
                            String userName = pref.getString("userName","noUser");//第二个参数为默认值
                            String loginState = pref.getString("loginState","0");
                            if(userName=="noUser"){
                                //隐藏登录按钮
                                View view = LayoutInflater.from(MainScreen.this).inflate(R.layout.login_or_register,null);
                                Button login_in =(Button) view.findViewById(R.id.login_in);
                                login_in.setVisibility(View.INVISIBLE);
                                Toast.makeText(getApplicationContext(), "未登录",
                                        Toast.LENGTH_SHORT).show();
                                Intent intent3 = new Intent(MainScreen.this, LoginOrRegister.class);
                                startActivity(intent3);




                            }
                            else{
                                //隐藏注册，并修改登录为用户名
                                View view = LayoutInflater.from(MainScreen.this).inflate(R.layout.login_or_register,null);
                                Button login =(Button) view.findViewById(R.id.login_in);
                                login.setVisibility(View.INVISIBLE);
                                Button login_in = (Button)view.findViewById(R.id.login_in);
                                login_in.setText(userName);
                                Toast.makeText(getApplicationContext(), "已登录",
                                        Toast.LENGTH_SHORT).show();
                                Intent intent3 = new Intent(MainScreen.this, LoginOrRegister.class);
                                startActivity(intent3);
                            }

                            //点击登录
                            break;
                        case 3:
                            //点击帮助
                            Intent intent4 = new Intent(MainScreen.this, SCOSHelper.class);
//                            intent3.putExtra("user",user);
                            startActivity(intent4);
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
