package com.carl.tc.xiaomi.phone;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class MakeMOCall extends Template {

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
            clickByRes("com.android.contacts:id/zero");
            clickByRes("com.android.contacts:id/zero");
            clickByRes("com.android.contacts:id/one");
            clickByRes("com.android.contacts:id/zero");

            clickByClazz("android.widget.Button");
            sleep(7000);

            clickByRes("com.android.incallui:id/endButton");
            //*****************************modify my step end here***********************************
        }
    }
}




