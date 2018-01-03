package com.carl.tc.xiaomi.fmradio;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class Scan extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("收音机");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            clickByRes("com.miui.fm:id/btn_stations_list");
            if (waitForExist(selectorByText("扫描电台"), 60)) {
                clickByText("扫描电台");
                if (objByText("确定") != null) {
                    clickByText("确定");
                }
                waitForExist(selectorByText("扫描电台"), 60);
            }

            getMem(this.getClass().getPackage().getName() + "." + this.getClass().getSimpleName());

            backTimes(1);

            //*****************************modify my step end here***********************************
        }
    }
}




