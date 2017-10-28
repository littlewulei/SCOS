

package es.source.code.activity;

        import android.content.Intent;
        import android.net.Uri;
        import android.os.Bundle;
        import android.os.Handler;
        import android.os.Message;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.GridView;
        import android.widget.SimpleAdapter;
        import android.widget.Toast;

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;
        import java.util.Properties;
        import java.util.Properties;

        import javax.mail.Address;

        import javax.mail.Session;
        import javax.mail.Transport;
        import javax.mail.internet.InternetAddress;
        import javax.mail.internet.MimeMessage;

        import es.source.code.model.User;

public class SCOSHelper extends AppCompatActivity {

//    private Handler handler = new Handler() {
//
//        // 该方法运行在主线程中
//        // 接收到handler发送的消息，对UI进行操作
//        @Override
//        public void handleMessage(Message msg) {
//
//            if (msg.what == 1) {
//                Toast.makeText(getApplicationContext(), "求助邮件发送成功",
//                        Toast.LENGTH_SHORT).show();
//            }
//        }
//    };

    private GridView menu_view;
    private List<Map<String, Object>> data_list; //链表节点是一个个哈希表
    private SimpleAdapter sim_adapter;
    // 图片封装为一个数组
    private int[] icon = {R.drawable.protocol, R.drawable.about,R.drawable.telephone, R.drawable.message, R.drawable.email};
    private String[] iconName = {"用户协议", "关于系统", "电话人工帮助", "短信帮助","邮件帮助"};
    User user = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scos_helper);

        Intent intent = getIntent();
        String data = intent.getStringExtra("login_state");




            user =(User) intent.getSerializableExtra("loginUser");//接受登录界面传来的user

            menu_view = (GridView) findViewById(R.id.help_navi);
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
                            //点击协议

                            break;
                        case 1:
                            //点击关于


                            break;
                        case 2:
                            //点击电话帮助
                            Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+"5554"));
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            break;
                        case 3:
                            //点击短信
                            Uri uri2 = Uri.parse("smsto:5554");
                            Intent intent2 = new Intent(Intent.ACTION_SENDTO,uri2);
                            intent2.putExtra("sms_body", "test scos help");
                            startActivity(intent2);
                            break;
                        case 4:
                            //点击邮件
                            final Handler handler = new Handler() {
                                public void handleMessage(Message msg) {
                                    if (msg.what == 1) {
                                        Toast.makeText(getApplicationContext(), "求助邮件发送成功",
                                        Toast.LENGTH_SHORT).show();
                                    }
                                }
                            };
                            class ThreadShow implements Runnable {
                                @Override
                                public void run() {
                                    while (true) {
                                        try {
                                            Thread.sleep(1500);
                                            Message msg = new Message();
                                            msg.what = 1;
                                            handler.sendMessage(msg);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }
                            new Thread(new ThreadShow()).start();
                            break;


                    }
                }
            });

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
