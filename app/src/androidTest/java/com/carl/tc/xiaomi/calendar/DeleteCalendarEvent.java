package com.carl.tc.xiaomi.calendar;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class DeleteCalendarEvent extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("日历");
        dumpXML();
        clickByText("更多");
        dumpXML();
        clickByText("日程", 1);

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            clickByRes("com.android.calendar:id/agenda_item_text_container");
            if (waitForExist(selectorByText("继续使用"), 2)) {
                clickByText("继续使用");
            }
            clickByText("删除");
            clickByText("确定");

            //*****************************modify my step end here***********************************
        }
    }
}




