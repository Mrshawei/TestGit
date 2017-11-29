package com.sw.controller;

import com.jfinal.core.Controller;
import com.sw.config.User;

public class PersonController extends Controller{
    public void test(){
        //renderText("hello jfinal");
        new User().set("uname","123111").save();
        renderText("aaaaa");
    }
}
