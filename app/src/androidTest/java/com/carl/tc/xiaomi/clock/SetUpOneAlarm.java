package com.carl.tc.xiaomi.clock;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class SetUpOneAlarm extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("时钟");
        //clickByDesc("闹钟");

        //clear alarms
        if (objByRes("com.android.deskclock:id/digitalClock") != null) {
            longPressObj(objByRes("com.android.deskclock:id/digitalClock"));
            if (objByText("全选") != null) {
                clickByText("全选");
            }
            clickByText("删除");
            clickByText("删除");
        }

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            clickByText("添加闹钟");
            clickByText("确定");

            //sleep(3000);

            //*****************************modify my step end here***********************************
        }


    }

}




