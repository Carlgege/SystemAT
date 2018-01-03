package com.carl.tc.xiaomi.clock;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class DeleteAlarm extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("时钟");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            longPressObj(objByRes("com.android.deskclock:id/digitalClock"));
            clickByText("删除");
            clickByText("删除");

            //*****************************modify my step end here***********************************
        }


    }

}




