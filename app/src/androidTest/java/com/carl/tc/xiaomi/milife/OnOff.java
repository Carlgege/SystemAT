package com.carl.tc.xiaomi.milife;

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

            Launcher.launchAP("小米生活");
            dumpXML();
            if (i == 1) {
                if (objByText("同意并继续") != null) {
                    clickByText("同意并继续");
                }
            }

            getMem(this.getClass().getPackage().getName() + "." + this.getClass().getSimpleName());

            backTimes(1);
            //sleep(3000);

            //*****************************modify my step end here***********************************
        }
    }
}



