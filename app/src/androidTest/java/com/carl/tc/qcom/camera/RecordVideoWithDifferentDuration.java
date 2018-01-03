package com.carl.tc.qcom.camera;

import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import com.carl.template.xiaomi.Launcher;import com.carl.template.Template;
/**
 * Created by F3060772 on 2016/1/18.
 */
public class RecordVideoWithDifferentDuration extends Template {


    public void tcStep() {


        Launcher.launchApplication("骁龙相机");
        //switch to camcorder mode
        clickByRes("org.codeaurora.snapcam:id/camera_switcher");
        clickByDesc("切换到视频模式");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            String duration[] = {"30 秒 (MMS)", "10 分钟", "30 分钟", "无限制"};


            for (int m = 0; m < duration.length; m++) {
                clickByDesc("菜单按钮");
                clickByText("视频持续时间");

                UiObject obj = new UiObject(new UiSelector().className("android.widget.ListView").instance(1));
                try {
                    UiObject choices = obj.getChild(new UiSelector().text(duration[m]));
                    choices.click();
                } catch (UiObjectNotFoundException e) {
                    e.printStackTrace();
                }

                clickByRes("org.codeaurora.snapcam:id/shutter_button");
                sleep(30000);

                clickByRes("org.codeaurora.snapcam:id/shutter_button");
                sleep(1000);

            }

            //*****************************modify my step end here***********************************
        }


    }

}




