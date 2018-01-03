package com.carl.tc.xiaomi.security;

import android.support.test.uiautomator.UiObject2;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class BatterySecurity extends Template {

    @Override
    protected void tcStep() {

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************//
            Launcher.launchAP("安全中心");
            clickByText(".*电量.*");
            sleep(1000);
            clickByText("省电模式");
            backTimes(1);
            clickByText("低电量时省电");
            backTimes(1);
            clickByText("按时省电");
            backTimes(1);
            clickByText("定时开关机");
            backTimes(3);
            //*****************************modify my step end here***********************************
         }
    }
}




