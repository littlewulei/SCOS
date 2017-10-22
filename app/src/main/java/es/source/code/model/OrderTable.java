package es.source.code.model;

/**
 * Created by LEI on 2017/10/17.
 */
import java.util.ArrayList;
import java.util.List;

import es.source.code.activity.OrderFragment;
import es.source.code.model.Food;
public class OrderTable{
    final List<Food> orderfood = new ArrayList<>();
    int orderNum = 0;
    float price = 0;
    int GetterOrderNum(){
        return orderNum;
    }
    void SetterOrderNum(int orderNum){this.orderNum = orderNum;}
//    void SetterPrice(price){};
    float GetterPrice(){
        return price;
    }
    List<Food> GetterOrderFood(){
        return orderfood;
    }
    void AddFood(Food food){
        orderfood.add(food);
    }
    void RemoveFood(Food food){
        orderfood.remove(food);
    }

}
