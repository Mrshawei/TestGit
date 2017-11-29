package com.sw.controller;

import com.jfinal.core.Controller;
import com.sw.com.sw.entity.Student;

public class MainController extends Controller{
    //创建方法
    public void sayHello(){

        //返回字符串到页面
        renderText("hello Jfinal");
    }

    //添加的方法
    public void add(){
        //需要从form表单中获取数据
        String sname=getPara("sname");
        int sage=getParaToInt("sage");
        System.out.println(sname + "\t" + sage);

        //调用dao的添加方法
        new Student().set("sname",sname).set("sage",sage).save();
        //renderText("添加成功");
        render("/success.jsp");
    }

}
