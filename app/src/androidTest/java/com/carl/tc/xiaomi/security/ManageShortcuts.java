package com.carl.tc.xiaomi.security;

import android.support.test.uiautomator.UiObject2;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class ManageShortcuts extends Template {

    @Override
    protected void tcStep() {
        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            Launcher.launchAP("安全中心");

            //Tap setting in security
            clickByRes("com.miui.securitycenter:id/settings");
            sleep(1000);

            clickByText("添加桌面快捷方式");

            for (int k = 0; k < 9; k++) {
                UiObject2 obj = objByRes("com.miui.securitycenter:id/sliding_button", k);
                if (obj != null && obj.isChecked()) {
                    obj.click();
                }
            }
            backTimes(3);

            //*****************************modify my step end here***********************************
        }
    }
}




