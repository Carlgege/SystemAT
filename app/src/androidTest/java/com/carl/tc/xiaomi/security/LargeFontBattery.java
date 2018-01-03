package com.carl.tc.xiaomi.security;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class LargeFontBattery extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("设置");
        findObjFromListByRes("Vertical", "android:id/content", "字体大小", 0, "click");
        clickByText("大号");
        clickByText("确定");
        sleep(1000);
        backTimes(2);

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************//
            Launcher.launchAP("安全中心");
            clickByText(".*电量.*");
            sleep(1000);

            if (i == 1) {
                if (objByText("省电模式") != null) {
                    clickByText("省电模式");
                }
            }
            sleep(1000);
            backTimes(3);
            //*****************************modify my step end here***********************************
        }

        Launcher.launchAP("设置");
        findObjFromListByRes("Vertical", "android:id/content", "字体大小", 0, "click");
        clickByText("标准");
        clickByText("确定");
        sleep(1000);
        backTimes(2);

    }
}




