package com.carl.tc.xiaomi.security;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiWatcher;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

import java.io.IOException;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class DuringCheckScanToExit extends Template {

    @Override
    protected void tcStep() {

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************//
            Launcher.launchAP("安全中心");

            UiObject2 startVerify = objByText("开始体检");

            int x = 0, y =0;
            if (startVerify != null) {
                x = startVerify.getVisibleCenter().x;
                y = startVerify.getVisibleCenter().y;
            }

            //clickByText("开始体检");
            //clickByRes("取消体检");

            try {
                mDevice.executeShellCommand("input tap "+x+" "+y);
                sleep(500);
                mDevice.executeShellCommand("input tap "+346+" "+1190);
            } catch (IOException e) {
                e.printStackTrace();
            }

            sleep(1000);
            if (objByText("上次体检已被取消，建议立即体检") != null) {
                sleep(500);
            } else {
                logFail("开始体检没有被执行中断");
            }

            backTimes(1);
            //*****************************modify my step end here***********************************
         }
    }
}




