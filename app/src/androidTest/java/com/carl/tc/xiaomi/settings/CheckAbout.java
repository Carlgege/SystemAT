package com.carl.tc.xiaomi.settings;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class CheckAbout extends Template {

    @Override
    protected void tcStep() {

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            Launcher.launchAP("设置");

            findObjFromListByRes("Vertical", "android:id/list", "关于手机", 0, "click");

            findObjFromListByRes("Vertical", "android:id/list", "状态信息", 0, "click");

            backTimes(4);
            //*****************************modify my step end here***********************************
        }
    }
}




