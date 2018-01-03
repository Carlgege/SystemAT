package com.carl.tc.xiaomi.phone;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class YellowPage extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("拨号");
        clickByText("黄页");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            if (i == 1) {
                if (objByText("同意并继续") != null) {
                    clickByText("同意并继续");
                    sleep(4000);
                }
            }

            if (objByRes("android:id/input") == null) {
                logFail("Open YellowPage failed");
            }

            backTimes(1);
            //*****************************modify my step end here***********************************
        }


    }

}




