package com.carl.tc.xiaomi.phone;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;
import com.carl.template.xiaomi.Phone;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class HWScan extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("拨号");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            Phone.inputPhoneNum("*#*#64663#*#*");

            sleep(2000);

            backTimes(1);
            //*****************************modify my step end here***********************************
        }


    }

}




