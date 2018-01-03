package com.carl.tc.xiaomi.calendar;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class AddCalendarEvent extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("日历");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            clickByText("新建");
            objByText("活动提醒内容").setText("FIH" + i);
            clickByRes("com.android.calendar:id/action_done");

            //*****************************modify my step end here***********************************
        }
    }
}




