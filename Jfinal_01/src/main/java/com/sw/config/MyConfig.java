package com.sw.config;

import com.jfinal.config.*;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import com.sw.com.sw.entity.Student;
import com.sw.controller.MainController;

public class MyConfig extends JFinalConfig {

    /*
    * 使用 Jfinal+easyui+mysql 添加 和 查询
    *
    * */

    public void configConstant(Constants constants) {
        //设置jfinal开发模式允许
        constants.setDevMode(true);
        //设置jfinal支持jsp
        constants.setViewType(ViewType.JSP);

    }

    public void configRoute(Routes routes) {
        //配置jfinal  Controller的访问路径
        routes.add("main", MainController.class);

    }

    public void configPlugin(Plugins plugins) {
        //添加c3p0插件
        C3p0Plugin cp = new C3p0Plugin("jdbc:mysql://localhost/test", "root", "123");
        plugins.add(cp);
        ActiveRecordPlugin arp = new ActiveRecordPlugin(cp);
        plugins.add(arp);

        arp.addMapping("student","sid", Student.class);


    }

    public void configInterceptor(Interceptors interceptors) {

    }

    public void configHandler(Handlers handlers) {

    }
}
