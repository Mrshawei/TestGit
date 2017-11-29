package com.sw.config;

import com.jfinal.config.*;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;
import com.sw.controller.PersonController;

public class MyConfig extends JFinalConfig {
    public void configConstant(Constants constants) {
        constants.setDevMode(true);
        //constants.setViewType(ViewType.JSP);

    }

    public void configRoute(Routes routes) {
        routes.add("hello", PersonController.class);

    }

    public void configPlugin(Plugins plugins) {
        C3p0Plugin cp = new C3p0Plugin("jdbc:mysql://localhost/test", "root", "123");
        plugins.add(cp);
        ActiveRecordPlugin arp = new ActiveRecordPlugin(cp);

        plugins.add(arp);
        arp.addMapping("users","uid", User.class);


    }

    public void configInterceptor(Interceptors interceptors) {

    }

    public void configHandler(Handlers handlers) {

    }
}
