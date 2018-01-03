package com.carl.tc.xiaomi.download;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class OnOff extends Template {

    @Override
    protected void tcStep() {

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            Launcher.launchAP("下载.*");

            if (i == 1) {
                sleep(3000);
                if (objByText("确定") != null) {
                    clickByText("确定");
                }
            }

            getMem(this.getClass().getPackage().getName() + "." + this.getClass().getSimpleName());

            backTimes(2);

            //*****************************modify my step end here***********************************
        }
    }
}




