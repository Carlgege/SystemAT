package com.carl.tc.xiaomi.settings;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class APMOnOff extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("设置");
        clickByText("其他连接方式");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            clickByText("飞行模式");
            sleep(3000);

            clickByText("飞行模式");
            sleep(3000);
            //*****************************modify my step end here***********************************
        }
    }
}




