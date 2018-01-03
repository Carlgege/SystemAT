package com.carl.tc.xiaomi.security;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class Permissions extends Template {

    @Override
    protected void tcStep() {

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************//
            Launcher.launchAP("安全中心");

            clickByText("授权管理");
            clickByText("自启动管理");

            if (i == 1) {
                if (objByText("关于自启动的说明") != null) {
                    clickByText("确定");
                }
            }

            clickByClazz("android.widget.Button");

            if (objByText("MIUI从系统底层管理应用的自启动行为，一些安全软件会错误显示被MIUI禁止的应用可以自启动，请以MIUI的显示为准。") != null) {
                clickByText("确定");
            } else {
                logFail("关于自启动的字符串无法找到");
            }

            backTimes(3);
            //*****************************modify my step end here***********************************
         }
    }
}




