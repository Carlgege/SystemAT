package com.carl.tc.xiaomi.weather;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class Location extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("天气");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            if (!waitForExist(selectorByRes("com.miui.weather2:id/activity_main_city_name"), 10)) {
                logFail("Location failed.");
            }

            //*****************************modify my step end here***********************************
        }


    }

}




