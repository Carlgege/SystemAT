package com.carl.tc.xiaomi.security;

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

            Launcher.launchAP("安全中心");
            if (i == 1) {
                if (waitForExist(selectorByText("同意并继续"), 3)) {
                    clickByText("同意并继续");
                }
                if (waitForExist(selectorByText("确定"), 3)) {
                    clickByText("确定");
                }
            }

            getMem(this.getClass().getPackage().getName() + "." + this.getClass().getSimpleName());

            backTimes(2);

            //*****************************modify my step end here***********************************
        }
    }
}




