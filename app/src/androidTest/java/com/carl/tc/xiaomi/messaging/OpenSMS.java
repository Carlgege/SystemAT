package com.carl.tc.xiaomi.messaging;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;
import com.carl.template.xiaomi.Messaging;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class OpenSMS extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("短信");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            clickByRes("com.android.mms:id/from");
            if (objByRes("com.android.mms:id/from") != null) {
                clickByRes("com.android.mms:id/from");
            }
            sleep(1000);
            Messaging.backToNewMessage();

            //*****************************modify my step end here***********************************
        }


    }

}




