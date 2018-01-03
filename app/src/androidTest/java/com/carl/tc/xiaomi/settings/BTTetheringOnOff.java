package com.carl.tc.xiaomi.settings;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class BTTetheringOnOff extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("设置");
        clickByText("其他连接方式");
        clickByText("网络热点");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            clickByText("蓝牙网络共享");

            sleep(3000);

            //*****************************modify my step end here***********************************
        }
    }
}




