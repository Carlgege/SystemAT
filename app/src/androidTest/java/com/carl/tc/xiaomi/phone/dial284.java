package com.carl.tc.xiaomi.phone;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;
import com.carl.template.xiaomi.Notification;
import com.carl.template.xiaomi.Phone;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class dial284 extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("拨号");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            Phone.inputPhoneNum("*#*#284#*#*");
            sleep(2000);

            Notification.dragNotification();
            dumpXML();
            if (objByRes("com.android.systemui:id/clear_all_button") != null) {
                clickByRes("com.android.systemui:id/clear_all_button");
                sleep(2000);
                Notification.dragNotification();
                dumpXML();
                switchScreenTo("left");
            }

            if (!waitForExist(selectorByText("Bug报告生成完毕"), 360)) {
                logFail("could not find bugreport finished option");
            }

            backTimes(1);
            //*****************************modify my step end here***********************************
        }
    }
}




