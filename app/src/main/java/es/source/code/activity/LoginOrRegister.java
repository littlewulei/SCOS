package es.source.code.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import es.source.code.activity.R;
import es.source.code.model.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginOrRegister extends AppCompatActivity {



    EditText username, userpassward;
    String regEX = "^[0-9a-zA-Z]+$";
    String TAG = "MyLog";
    Pattern pattern = Pattern.compile(regEX);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_or_register);

//--------------------------------------------------------------------------------------------
        //点击登录按钮要做的事情
        Button button1 = (Button) findViewById(R.id.login_in);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressBar m_progressbar = (ProgressBar) findViewById(R.id.my_progress_bar);
                m_progressbar.setVisibility(View.VISIBLE);//显示进度条

                final Handler handler = new Handler() {
                    public void handleMessage(Message msg) {
                        if (msg.what == 1) {
                            //关闭进度条
                            ProgressBar m_progressbar = (ProgressBar) findViewById(R.id.my_progress_bar);
                            m_progressbar.setVisibility(View.INVISIBLE);

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

                //判断输入是否合法
                username = (EditText) findViewById(R.id.login_username);
                userpassward = (EditText) findViewById(R.id.login_userpassward);
                String str1 = username.getText().toString();
                String str2 = userpassward.getText().toString();
                Matcher matcher1 = pattern.matcher(str1);
                Matcher matcher2 = pattern.matcher(str2);
                boolean rs1 = matcher1.matches();
                boolean rs2 = matcher2.matches();

                if (!rs1) {
                    //用户名格式错误
                    username.setError("用户名输入不合法");

                } else {
                    if (!rs2) {
                        //密码格式错误
                        userpassward.setError("密码输入不合法");
                    } else {
                        //输入合法

                        User loginUser = User.getInstance();//获取 User实例
                        loginUser.SetuserName(str1);
                        loginUser.Setpassword(str2);
                        loginUser.SetoldUser(false);

                        Intent intent = new Intent(LoginOrRegister.this, MainScreen.class);
                        String data = "LoginSuccess";
                        intent.putExtra("login_state", data);
                        intent.putExtra("loginUser",loginUser);
                        SharedPreferences pref = LoginOrRegister.this.getSharedPreferences("data",MODE_PRIVATE);
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putString("userName",str1);
                        editor.putString("loginState","1");
                        editor.commit();
                        Toast.makeText(getApplicationContext(), "登录成功",
                                Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        finish();
                    }
                }

            }
        });

//--------------------------------------------------------------------------------------------
        //点击返回按钮
        Button button2 = (Button) findViewById(R.id.login_return);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginOrRegister.this, MainScreen.class);
                String data3 = "return";
                intent.putExtra("login_state", data3);
                startActivity(intent);
                finish();
            }

        });

//--------------------------------------------------------------------------------------------
        //点击注册按钮
        Button button3 = (Button) findViewById(R.id.login);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressBar m_progressbar = (ProgressBar) findViewById(R.id.my_progress_bar);
                m_progressbar.setVisibility(View.VISIBLE);//显示进度条

                final Handler handler = new Handler() {
                    public void handleMessage(Message msg) {
                        if (msg.what == 1) {
                            //关闭进度条
                            ProgressBar m_progressbar = (ProgressBar) findViewById(R.id.my_progress_bar);
                            m_progressbar.setVisibility(View.INVISIBLE);

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

                //判断输入是否合法
                username = (EditText) findViewById(R.id.login_username);
                userpassward = (EditText) findViewById(R.id.login_userpassward);
                String str1 = username.getText().toString();
                String str2 = userpassward.getText().toString();
                Matcher matcher1 = pattern.matcher(str1);
                Matcher matcher2 = pattern.matcher(str2);
                boolean rs1 = matcher1.matches();
                boolean rs2 = matcher2.matches();

                if (!rs1) {
                    //用户名格式错误
                    username.setError("用户名输入不合法");

                } else {
                    if (!rs2) {
                        //密码格式错误
                        userpassward.setError("密码输入不合法");
                    } else {
                        //输入合法，注册到数据库

                        User loginUser = User.getInstance();//获取 User实例
                        loginUser.SetuserName(str1);
                        loginUser.Setpassword(str2);
                        loginUser.SetoldUser(false);

                        Intent intent = new Intent(LoginOrRegister.this, MainScreen.class);
                        String data = "RegisterSuccess";
                        intent.putExtra("login_state", data);
                        intent.putExtra("loginUser",loginUser);
                        SharedPreferences pref = LoginOrRegister.this.getSharedPreferences("data",MODE_PRIVATE);
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putString("userName",str1);
                        editor.putString("loginState","1");
                        editor.commit();

                        Toast.makeText(getApplicationContext(), "欢迎您成为SCOS新用户！",
                                Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });


    }
}
