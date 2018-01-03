package com.carl.tc.xiaomi.settings;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class WLANOnOff extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("设置");
        clickByText("WLAN");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            clickByRes("android:id/checkbox");

            //sleep(3000);

            //*****************************modify my step end here***********************************
        }
    }
}




