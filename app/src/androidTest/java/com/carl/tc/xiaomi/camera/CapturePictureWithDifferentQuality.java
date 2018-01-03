package com.carl.tc.xiaomi.camera;

import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by H2405158 on 2016/1/18.
 */
public class CapturePictureWithDifferentQuality extends Template {


    public void tcStep() {


        Launcher.launchApplication("骁龙相机");
        clickByRes("org.codeaurora.snapcam:id/camera_switcher");
        clickByDesc("切换到拍照模式");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            String quality[] = {"低画质", "标准", "高画质"};


            for (int m = 0; m < quality.length; m++) {
                clickByDesc("菜单按钮");
                clickByText("照片质量");

                UiObject obj = new UiObject(new UiSelector().className("android.widget.ListView").instance(1));
                try {
                    UiObject choices = obj.getChild(new UiSelector().text(quality[m]));
                    choices.click();
                } catch (UiObjectNotFoundException e) {
                    e.printStackTrace();
                }


                clickByRes("org.codeaurora.snapcam:id/shutter_button");
                sleep(2000);
            }

            //*****************************modify my step end here***********************************
        }


    }

}




