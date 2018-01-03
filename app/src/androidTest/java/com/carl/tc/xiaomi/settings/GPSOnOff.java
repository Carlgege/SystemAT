package com.carl.tc.xiaomi.settings;

import com.carl.template.Template;
import com.carl.template.xiaomi.Notification;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class GPSOnOff extends Template {

    @Override
    protected void tcStep() {

        Notification.dragNotification();
        switchScreenTo("right");
        findObjFromListByRes("Vertical", "com.android.systemui:id/toggle_group", "GPS", 0, "longPress");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            clickByRes("android:id/checkbox");
            sleep(1000);
            //*****************************modify my step end here***********************************
        }
    }
}




