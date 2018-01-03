package com.carl.tc.xiaomi.camera;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class SwitchFrontRearCapturePicture extends Template {

    public void tcStep() {

        Launcher.launchApplication("骁龙相机");
        clickByRes("org.codeaurora.snapcam:id/camera_switcher");
        clickByDesc("切换到拍照模式");


        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            clickByRes("org.codeaurora.snapcam:id/front_back_switcher");

            sleep(1000);

            clickByRes("org.codeaurora.snapcam:id/shutter_button");
            sleep(3000);
            //sleep(3000);

            //*****************************modify my step end here***********************************
        }


    }

}




