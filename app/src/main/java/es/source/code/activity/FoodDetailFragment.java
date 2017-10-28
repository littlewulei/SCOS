package es.source.code.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import es.source.code.model.Food;

/**
 * Created by LEI on 2017/10/20.
 */

public class FoodDetailFragment extends Fragment {
    public FoodDetailFragment() {
        // Required empty public constructor
    }


    @Override
    //返回fragment 的视图
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.food_detail_fragmennt, container, false);
    }

    @Override
    //初始化fragment视图，数据初始化
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Food food = null;
        ImageView food_pic = (ImageView)getActivity().findViewById(R.id.food_pic) ;
        TextView food_title = (TextView)getActivity().findViewById(R.id.food_title);
        TextView food_price = (TextView)getActivity().findViewById(R.id.food_price);
        TextView remark = (TextView)getActivity().findViewById(R.id.remark);

        Bundle bundle = getArguments();
        //用来判断是第几个菜品详情
//        if(bundle != null){
//            int arg = bundle.getInt("arg");
//            switch (arg){
//                default:
//                    Intent intent = new Intent();
//                    food = (Food)intent.getSerializableExtra("food");
//                    food_title.setText(food.GetFoodTitle());
//                    food_price.setText(String.valueOf(food.GetPrice()));
//                    remark.setText(food.GetIntroduce());
//                    break;
//            }
//        }


    }


}
