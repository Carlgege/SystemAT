package com.carl.tc.qcom.settings;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.Until;

import com.carl.template.xiaomi.Launcher;import com.carl.template.Template;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class BTScan extends Template {


    public void tcStep() {

        

        Launcher.launchApplication("设置");
        clickByText("蓝牙");
        if (!objByRes("com.android.settings:id/switch_widget").getText().toString().equals("开启")) {
            clickByRes("com.android.settings:id/switch_widget");
        }
        sleep(3000);

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            clickByDesc("更多选项");
            mDevice.wait(Until.hasObject(By.text("刷新")), 20000);

            clickByText("刷新");
            sleep(3000);

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




