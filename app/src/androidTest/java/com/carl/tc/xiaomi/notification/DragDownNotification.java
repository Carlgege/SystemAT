package com.carl.tc.xiaomi.notification;

import com.carl.template.Template;
import com.carl.template.xiaomi.Notification;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class DragDownNotification extends Template {

    @Override
    protected void tcStep() {

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            Notification.dragNotification();
            sleep(1000);

            backTimes(1);
            //*****************************modify my step end here***********************************
        }
    }
}




