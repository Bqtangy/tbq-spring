package com.study.effective.builder;

/**
 * 构建器builder模式
 * Created by Administrator on 2017/9/3.
 */
public class Atest {

    private String cake;
    private String meat;
    private String milk;
    private String drink;

    public static class Builder{
        private String meat; //必须要初始化的参数
        private String cake;
        private String milk;
        private String drink;

        public Builder(String meat){
            this.meat = meat;
        }

        public Builder addCake(String cake){
            this.cake = cake;
            return this;
        }

        public Builder addMilk(String milk){
            this.milk = milk;
            return this;
        }

        public Builder addDrink(String drink){
            this.drink = drink;
            return this;
        }

        public Atest create(){
            return new Atest(this);
        }
    }

    private Atest(Builder builder){
        this.meat = builder.meat;
        this.cake = builder.cake;
        this.milk = builder.milk;
        this.drink = builder.drink;
    }



    public static void main(String[] args) {

        Atest.Builder   builder = new  Atest.Builder("meart");

        //用多个参数形成的对象， 使用构建器模式进行创建
        Atest   atest = builder.addCake("cake").addDrink("drink").addMilk("mike").create();

    }




}
