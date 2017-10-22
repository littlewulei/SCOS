package es.source.code.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

import es.source.code.activity.R;


public class SCOSEntry extends Activity {
    //手指按下的点为(x1, y1)手指离开屏幕的点为(x2, y2)
    float x1 = 0;
    float x2 = 0;
    float y1 = 0;
    float y2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //继承了Activity的onTouchEvent方法，直接监听点击事件
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            //当手指按下的时候
            x1 = event.getX();
            y1 = event.getY();
        }
        if (event.getAction() == MotionEvent.ACTION_UP) {
            //当手指离开的时候
            x2 = event.getX();
            y2 = event.getY();
            if (y1 - y2 > 50) {
                // 向上滑
            } else if (y2 - y1 > 50) {
                // 向下滑

            } else if (x1 - x2 > 50) {
                // 向左滑
                //这里就可以跳转了
                Intent intent = new Intent(this, MainScreen.class);  //方法1
                String data = "FromEntry";
                intent.putExtra("login_state", data);
                startActivity(intent);
                finish();
            } else if (x2 - x1 > 50) {
                //向右滑
            }
        }
        return super.onTouchEvent(event);
    }

}
