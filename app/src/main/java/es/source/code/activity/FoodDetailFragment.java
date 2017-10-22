package es.source.code.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

        Bundle bundle = getArguments();
        //用来判断是那一中新闻
        if(bundle != null){
            int arg = bundle.getInt("arg");
            switch (arg){
                case 1:


                    break;
                case 2:


                    break;
                case 3:


                    break;
                case 4:


                    break;
                default:break;
            }
        }


    }


}
