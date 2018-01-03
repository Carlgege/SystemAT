package com.carl.tc.qcom.settings;

import com.carl.template.xiaomi.Launcher;import com.carl.template.Template;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class DataOnOff extends Template {


    public void tcStep() {

        

        Launcher.launchApplication("设置");
        clickByText("流量使用情况");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            clickByText("移动数据网络");
            if (objByText("确定") != null) {
                clickByText("确定");
            }

            sleep(1000);

            //*****************************modify my step end here***********************************
        }

        //System.out.println("RunRegisterWatch"+runRegisterWatcher());
        if (!runRegisterWatcher()) {
            endTime = System.nanoTime();
            logPass(endTime);
        } else {
            logFail("crash happened");
        }

        backTimes(3);
        removeRegisterWatcher();
    }

}




