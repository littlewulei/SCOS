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
                case 1:
                    for(int i = 1;i<10;i++){
                        list.add(new Food("拌牛肉",30,"很好次"));
                    }
                    ma.notifyDataSetChanged();
                    break;
                case 2:
                    for(int i = 1;i<10;i++){
                        list.add(new Food("红烧肉",40,"特色"));
                    }
                    ma.notifyDataSetChanged();
                    break;
                case 3:
                    for(int i = 1;i<10;i++){
                        list.add(new Food("大闸蟹",50,"阳澄湖"));
                    }
                    ma.notifyDataSetChanged();
                    break;
                case 4:
                    for(int i = 1;i<10;i++){
                        list.add(new Food("啤酒",5,"雪花"));
                    }
                    ma.notifyDataSetChanged();
                    break;
                default:break;
            }
        }

        //这里用到了监听事件，目的是点击新闻列表中的新闻后跳转到完整的新闻界面
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Food food = list.get(i);
                Toast.makeText(getActivity(),food.GetterFoodTitle(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), FoodDetailed.class);

                Bundle bundle1 = new Bundle();
                bundle1.putString("arg1","新闻详情");
                intent.putExtra("bundle",bundle1);
                startActivity(intent);
            }
        });
    }
}
