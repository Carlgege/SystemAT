package com.carl.tc.xiaomi.thridap;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class XiFM extends Template {

    @Override
    protected void tcStep() {

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            Launcher.launchAP("喜马拉雅FM");
            if (i == 1) {
                if (waitForExist(selectorByText("同意"), 3)) {
                    clickByText("同意");
                }
                sleep(10000);
            }
            sleep(5000);

            getMem(this.getClass().getPackage().getName() + "." + this.getClass().getSimpleName());

            for (int j=0; j<4; j++) {
                if (objByRes("com.ximalaya.ting.android:id/ok_btn") != null) {
                    clickByRes("com.ximalaya.ting.android:id/ok_btn");
                    break;
                } else {
                    sleep(1000);
                    backTimes(1);
                }
            }

            //*****************************modify my step end here***********************************
        }
    }
}




