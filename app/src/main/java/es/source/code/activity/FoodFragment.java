package es.source.code.activity;

/**
 * Created by LEI on 2017/10/14.
 */


        import android.content.Intent;
        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.AdapterView;
        import android.widget.ListView;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.ArrayList;
        import java.util.List;
        import es.source.code.model.Food;

public class FoodFragment extends Fragment {
    public FoodFragment() {
        // Required empty public constructor
    }


    @Override
    //返回fragment 的视图
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.food_fragment, container, false);
    }

    @Override
    //初始化fragment视图，数据初始化
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //这里建一个List用来存放Food类
        final List<Food> list = new ArrayList<>();
        //创建了个ListView变量用来获取layout中的ListView
        ListView lv1 = (ListView) getView().findViewById(R.id.list_view);//获取listView视图

        FoodFragmentListViewAdapter ma = new FoodFragmentListViewAdapter(getActivity(),list);
        //新建ListView的适配器
        lv1.setAdapter(ma);
        //获取Activity里传过来的捆绑数据
        Bundle bundle = getArguments();
        //用来判断是那一中新闻
        if(bundle != null){
            int arg = bundle.getInt("arg");
            switch (arg){
                case 1://热菜

                    list.add(new Food("红烧肉",40,"特色"));
                    list.add(new Food("清蒸桂鱼",45,"特色"));
                    list.add(new Food("小鸡炖蘑菇",30,"特色"));
                    list.add(new Food("宫保鸡丁",25,"特色"));
                    ma.notifyDataSetChanged();
                    break;
                case 2://冷菜

                    list.add(new Food("拌牛肉",30,"很好次"));
                    list.add(new Food("白切鸡",20,"很好次"));
                    list.add(new Food("泡椒凤爪",15,"很好次"));
                    list.add(new Food("红油腐竹",10,"很好次"));


                    ma.notifyDataSetChanged();
                    break;
                case 3://海鲜

                    list.add(new Food("大闸蟹",50,"阳澄湖"));
                    list.add(new Food("椒盐虾",35,"新鲜"));
                    list.add(new Food("花甲",25,"新鲜"));

                    ma.notifyDataSetChanged();
                    break;
                case 4://酒水

                    list.add(new Food("啤酒",5,"雪花"));
                    list.add(new Food("可乐",8,"百世"));
                    list.add(new Food("雪碧",8,"可口可乐"));
                    list.add(new Food("果粒橙",10,"美汁源"));


                    ma.notifyDataSetChanged();
                    break;
                default:break;
            }
        }

        //这里用到了监听事件，目的是点击食物列表后跳转到食物详细介绍
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Food food = list.get(i);
                Toast.makeText(getActivity(),food.GetFoodTitle(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), FoodDetailed.class);
                intent.putExtra("food",food);
                startActivity(intent);
            }
        });
    }
}
