package es.source.code.model;

import java.io.Serializable;

/**
 * Created by LEI on 2017/10/17.
 */

public class Food implements Serializable {
    String foodTitle;
    float price;
    String introduce;
    int orderNum;

    public Food()  {

    }
// 用于菜单界面的构造函数
    public Food(String foodTitle, float price, String introduce) {
        this.foodTitle = foodTitle;
        this.price = price;
        this.introduce = introduce;
    }
    //用于订单的构造函数
    public Food(String foodTitle, float price, int orderNum) {
        this.foodTitle = foodTitle;
        this.price = price;
        this.orderNum = orderNum;
    }

    public String GetFoodTitle() {
        return this.foodTitle;
    }

    public float GetPrice() {
        return this.price;
    }

    public int GetOrderNum() {
        return this.orderNum;
    }


    public String GetIntroduce() {
        return this.introduce;
    }

    public void SetOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public void SetFoodTitle(String string) {
        this.foodTitle = string;
    }

    public void SetPrice(float price) {
        this.price = price;
    }

    public void SetIntroduce(String string) {
        this.introduce = string;
    }

}
