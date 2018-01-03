package com.carl.tc.xiaomi.appstore;

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

            Launcher.launchAP("应用商店");
            if (i == 1) {
                if (objByText("同意并免费使用") != null) {
                    clickByText("同意并免费使用");
                }
            }

            sleep(2000);

            getMem(this.getClass().getPackage().getName() + "." + this.getClass().getSimpleName());
			

            backTimes(2);

            //*****************************modify my step end here***********************************
        }
    }
}




