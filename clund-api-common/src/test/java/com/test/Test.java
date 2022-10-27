package com.test;

public class Test<T,W> {
    void run(T t){
        System.out.println("run");
    }
    <R> void runs(R t){

    }
    public static void main(String[] args) {
        Test test=new Test();
        test.run("aaa");
        test.run("bbb");
        FanxingTest fanxingTest=new Tests();
        fanxingTest.runs("啊啊啊");
        ww w=new ww();
        w.run(2000);
        cc c=new cc("aaaaa");

    }
}
class Tests<T> implements FanxingTest<T>{


    @Override
    public void runs(T o) {
        System.out.println(o);
    }
}
class ww extends Test<Integer,String >{
   public<T> ww(){

   }
}
class cc{
    public<T> cc(T t){
        System.out.println("cc");
    }
}
