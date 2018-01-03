package com.carl.tc.xiaomi.security;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class LargeFontCheckScan extends Template {

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
            clickByText("开始体检");
            sleep(5000);

            if (objByText("自动优化项") != null) {
                backTimes(1);
            }
            backTimes(1);
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




