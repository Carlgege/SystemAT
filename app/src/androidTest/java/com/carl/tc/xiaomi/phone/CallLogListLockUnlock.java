package com.carl.tc.xiaomi.phone;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class CallLogListLockUnlock extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("拨号");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            Launcher.LCDOnOff();

            sleep(2000);

            //*****************************modify my step end here***********************************
        }
    }
}




