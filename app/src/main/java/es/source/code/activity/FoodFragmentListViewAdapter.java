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

public class FoodFragmentListViewAdapter extends BaseAdapter {
    private Context context;
    private List<Food> list;

    public FoodFragmentListViewAdapter(Context context, List<Food> list) {
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
        ViewHolder vh;
        if(view == null){
            vh = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.food_list_item,null);
            vh.title = (TextView) view.findViewById(R.id.food_title);
            vh.price = (TextView) view.findViewById(R.id.food_price);
            vh.introduce = (TextView) view.findViewById(R.id.food_introduce);
            vh.order = (Button) view.findViewById(R.id.order) ;
            view.setTag(vh);
        }else {
            vh = (ViewHolder) view.getTag();
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FoodDetailed.class);
                context.startActivity(intent);
            }
        });
        vh.order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = view.findViewById(R.id.order);
                if(button.getText()=="点菜")
                {
                    button.setText("退点");
                    Toast.makeText(context,"点菜成功",Toast.LENGTH_SHORT).show();}

                // 添加到已点点菜
                else
                {
                    button.setText("点菜");
                    Toast.makeText(context,"退点成功",Toast.LENGTH_SHORT).show();
                    // 从已点菜中删除

                }


            }
        });
        Food  food = list.get(i);
        vh.title.setText(food.GetterFoodTitle());
        float price =food.GetterPrice();
        vh.price.setText(String.valueOf(price)+"元");
        vh.introduce.setText(food.GetterIntroduce());
        return view;
    }
    public class ViewHolder{
        TextView title;
        TextView price;
        TextView introduce;
        Button order;
    }

}

