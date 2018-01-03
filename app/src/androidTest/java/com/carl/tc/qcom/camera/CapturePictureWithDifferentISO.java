package com.carl.tc.qcom.camera;

import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;

import com.carl.template.xiaomi.Launcher;import com.carl.template.Template;
/**
 * Created by F3060772 on 2016/1/18.
 */
public class CapturePictureWithDifferentISO extends Template {


    public void tcStep() {


        Launcher.launchApplication("骁龙相机");
        clickByRes("org.codeaurora.snapcam:id/camera_switcher");
        clickByDesc("切换到拍照模式");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            String iso[] = {"自动", "ISO Auto(HJR)", "ISO100", "ISO200", "ISO400", "ISO800", "ISO1600"};


            for (int m = 0; m < iso.length; m++) {
                clickByDesc("菜单按钮");
                clickByText("ISO");

                UiObject obj = new UiObject(new UiSelector().className("android.widget.ListView").instance(1));
                try {
                    UiObject choices = obj.getChild(new UiSelector().text(iso[m]));
                    choices.click();
                } catch (UiObjectNotFoundException e) {
                    e.printStackTrace();
                }

                clickByRes("org.codeaurora.snapcam:id/shutter_button");
                sleep(5000);
            }

            //*****************************modify my step end here***********************************
        }


    }

}




