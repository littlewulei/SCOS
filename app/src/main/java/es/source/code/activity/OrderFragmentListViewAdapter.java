package es.source.code.activity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import es.source.code.model.Food;

/**
 * Created by LEI on 2017/10/17.
 */

public class OrderFragmentListViewAdapter extends BaseAdapter {
    private Context context;
    private List<Food> list;

    public OrderFragmentListViewAdapter(Context context, List<Food> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder vh2;
        if(view == null){
            vh2 = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.order_food_list_item,null);
            vh2.title = (TextView) view.findViewById(R.id.food_title);
            vh2.price = (TextView) view.findViewById(R.id.food_price);
            vh2.order_num = (TextView) view.findViewById(R.id.order_number);
            vh2.unorder = (Button) view.findViewById(R.id.unorder) ;
            view.setTag(vh2);
        }else {
            vh2 = (ViewHolder) view.getTag();
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FoodDetailed.class);
                context.startActivity(intent);
            }
        });
        vh2.unorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Toast.makeText(context,"退点成功",Toast.LENGTH_SHORT).show();
                    // 从已点菜中删除
            }
        });
        Food  food = list.get(i);
        vh2.title.setText(food.GetFoodTitle());
        float price =food.GetPrice();
        int order_num = food.GetOrderNum();
        vh2.order_num.setText(String.valueOf(order_num));
        vh2.price.setText(String.valueOf(price*order_num)+"元");


        return view;
    }
    public class ViewHolder{
        TextView title;
        TextView price;
        TextView order_num;
        Button unorder;
    }

}


