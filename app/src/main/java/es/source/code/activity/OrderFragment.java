package es.source.code.activity;

/**
 * Created by LEI on 2017/10/14.
 */


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import es.source.code.model.Food;

public class OrderFragment extends Fragment {
    public OrderFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        Bundle bundle = getArguments();
        if (bundle != null) {
            int arg2 = bundle.getInt("arg2");
            switch (arg2) {
                case 1:
                    return inflater.inflate(R.layout.order_fragment, container, false);
                case 2:
                    return inflater.inflate(R.layout.order_fragment2, container, false);

            }
        }

        return inflater.inflate(R.layout.order_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //这里建一个List用来存放orderFood类
        final List<Food> list2 = new ArrayList<>();
        //创建了个ListView变量用来获取layout中的ListView
        ListView lv2 = (ListView) getView().findViewById(R.id.list_view2);
        //建一个适配的变量，将上下文和list加载到ListVIew的适配器中，然后放到适配器变量里
        OrderFragmentListViewAdapter ma2 = new OrderFragmentListViewAdapter(getActivity(), list2);
        //将适配器变量的内容加载到List里
        lv2.setAdapter(ma2);

        //获取Activity里传过来的捆绑数据
        Bundle bundle = getArguments();
        //用来判断是那一中新闻
        if (bundle != null) {
            int arg2 = bundle.getInt("arg2");
            switch (arg2) {
                case 1:
                    list2.add(new Food("宫保鸡丁", 30, 1));
                    list2.add(new Food("红烧肉", 4, 2));
                    Button commit = (Button) getActivity().findViewById(R.id.commit);
                    commit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(getActivity(), "提交成功", Toast.LENGTH_LONG).show();
                        }
                    });
                    ma2.notifyDataSetChanged();
                    break;
                case 2:
                    list2.add(new Food("大闸蟹", 50, 3));
                    list2.add(new Food("啤酒", 5, 5));
                    Button account = (Button) getActivity().findViewById(R.id.account);
                    account.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(getActivity(), "您好，老顾客，本次可享受7折优惠！", Toast.LENGTH_LONG).show();
                        }
                    });

                    ma2.notifyDataSetChanged();
                    break;
                default:
                    break;
            }
        }


    }
}
