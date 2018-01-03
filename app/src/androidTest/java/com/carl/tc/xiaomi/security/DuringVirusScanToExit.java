package com.carl.tc.xiaomi.security;

import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class DuringVirusScanToExit extends Template {

    @Override
    protected void tcStep() {

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************//
            Launcher.launchAP("安全中心");

            clickByRes("com.miui.securitycenter:id/menu_item_antivirus");
            sleep(2000);

            if (i == 1) {
                if (objByText("我知道了") != null) {
                    clickByText("我知道了");
                }
            }

            clickByRes("com.miui.securitycenter:id/btn_action");
            backTimes(1);
            clickByRes("android:id/button1");
            backTimes(2);
            //*****************************modify my step end here***********************************
         }
    }
}




