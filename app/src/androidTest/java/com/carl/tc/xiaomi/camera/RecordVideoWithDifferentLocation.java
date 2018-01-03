package com.carl.tc.xiaomi.camera;

import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by H2405158 on 2016/1/18.
 */
public class RecordVideoWithDifferentLocation extends Template {

    public void tcStep() {

        Launcher.launchApplication("骁龙相机");
        //switch to camcorder mode
        clickByRes("org.codeaurora.snapcam:id/camera_switcher");
        clickByDesc("切换到视频模式");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            String location[] = {"关", "开"};


            for (int m = 0; m < location.length; m++) {
                clickByDesc("菜单按钮");
                clickByText("存储位置信息");

                UiObject obj = new UiObject(new UiSelector().className("android.widget.ListView").instance(1));
                try {
                    UiObject choices = obj.getChild(new UiSelector().text(location[m]));
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




