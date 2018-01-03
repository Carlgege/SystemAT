package com.carl.tc.qcom.camera;

import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;

import com.carl.template.xiaomi.Launcher;import com.carl.template.Template;
/**
 * Created by F3060772 on 2016/1/18.
 */
public class CapturePictureWithDifferentPixel extends Template {


    public void tcStep() {


        Launcher.launchApplication("骁龙相机");
        clickByRes("org.codeaurora.snapcam:id/camera_switcher");
        clickByDesc("切换到拍照模式");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            String pixel[] = {"1200 万像素", "800万像素", "方形 (1:1)", "500万像素", "400万像素 (16:9)", "300万像素",
                    "HD1080", "200万像素", "150万像素", "130万像素", "WXGA", "HD720", "100万像素", "SVGA", "WVGA",
                    "720 x 480", "VGA", "CIF", "QVGA", "QCIF", "1300万像素"};


            for (int m = 0; m < pixel.length; m++) {
                clickByDesc("菜单按钮");
                clickByText("照片尺寸");

                UiObject obj = new UiObject(new UiSelector().className("android.widget.ListView").instance(1));
                try {
                    UiObject choices = obj.getChild(new UiSelector().text(pixel[m]));
                    UiScrollable scrollable = new UiScrollable(new UiSelector().classNameMatches("android.widget.ListView").instance(1));
                    if (choices == null) {
                        scrollable.scrollToBeginning(scrollable.getMaxSearchSwipes());
                    }
                    scrollable.getChildByText(new UiSelector().text(pixel[m]), pixel[m]);
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




