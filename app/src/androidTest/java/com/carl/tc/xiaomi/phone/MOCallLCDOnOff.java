package com.carl.tc.xiaomi.phone;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class MOCallLCDOnOff extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("拨号");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            if (objByRes("com.android.contacts:id/clear_digits") != null) {
                clickByRes("com.android.contacts:id/clear_digits");
            }

            clickByRes("com.android.contacts:id/one");
            clickByRes("com.android.contacts:id/one");
            clickByRes("com.android.contacts:id/two");

            clickByClazz("android.widget.Button");

            Launcher.LCDOnOff();
            sleep(1000);

            if (waitForExist(selectorByRes("com.android.incallui:id/endButton"), 3)) {
                clickByRes("com.android.incallui:id/endButton");
            }

            //*****************************modify my step end here***********************************
        }
    }
}




