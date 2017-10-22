package es.source.code.model;

/**
 * Created by LEI on 2017/10/17.
 */

public class Food {
    String foodTitle;
    float price;
    String introduce;
    int orderNum;

    public Food() {

    }

    public Food(String foodTitle, float price, String introduce) {
        this.foodTitle = foodTitle;
        this.price = price;
        this.introduce = introduce;
    }
    public Food(String foodTitle, float price, int orderNum) {
        this.foodTitle = foodTitle;
        this.price = price;
        this.orderNum = orderNum;
    }

    public String GetterFoodTitle() {
        return this.foodTitle;
    }

    public float GetterPrice() {
        return this.price;
    }

    public int GetterOrderNum() {
        return this.orderNum;
    }


    public String GetterIntroduce() {
        return this.introduce;
    }

    public void SetterOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public void SetterFoodTitle(String string) {
        this.foodTitle = string;
    }

    public void SetterPrice(float price) {
        this.price = price;
    }

    public void SetterIntroduce(String string) {
        this.introduce = string;
    }

}
