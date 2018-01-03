package com.carl.tc.xiaomi.mifinance;

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

            Launcher.launchAP("小米金融");
            if (i == 1) {
                if (objByText("同意并继续") != null) {
                    clickByText("同意并继续");
                }
            }

            getMem(this.getClass().getPackage().getName() + "." + this.getClass().getSimpleName());

            if (waitForExist(selectorByText("退出"), 3)) {
                clickByText("退出");
            } else {
                backTimes(3);
            }

            //*****************************modify my step end here***********************************
        }
    }
}




