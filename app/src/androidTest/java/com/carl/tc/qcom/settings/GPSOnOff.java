package com.carl.tc.qcom.settings;

import com.carl.template.xiaomi.Launcher;import com.carl.template.Template;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class GPSOnOff extends Template {


    public void tcStep() {

        

        Launcher.launchApplication("设置");
        findObjFromListByRes("Vertical", "com.android.settings:id/dashboard", "位置信息", 0, "click");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            clickByRes("com.android.settings:id/switch_widget");

            if (objByText("同意") != null) {
                clickByText("同意");
            }

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




