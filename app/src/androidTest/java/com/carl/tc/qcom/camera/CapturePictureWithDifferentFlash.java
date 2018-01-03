package com.carl.tc.qcom.camera;

import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import com.carl.template.xiaomi.Launcher;import com.carl.template.Template;
/**
 * Created by F3060772 on 2016/1/18.
 */
public class CapturePictureWithDifferentFlash extends Template {


    public void tcStep() {


        Launcher.launchApplication("骁龙相机");
        clickByRes("org.codeaurora.snapcam:id/camera_switcher");
        clickByDesc("切换到拍照模式");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            String flash[] = {"自动", "开", "关"};


            for (int m = 0; m < flash.length; m++) {
                clickByDesc("菜单按钮");
                clickByText("闪光灯模式");

                UiObject obj = new UiObject(new UiSelector().className("android.widget.ListView").instance(1));
                try {
                    UiObject choices = obj.getChild(new UiSelector().text(flash[m]));
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



