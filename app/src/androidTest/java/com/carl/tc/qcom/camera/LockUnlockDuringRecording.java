package com.carl.tc.qcom.camera;

import com.carl.template.xiaomi.Launcher;import com.carl.template.Template;
/**
 * Created by F3060772 on 2016/1/18.
 */
public class LockUnlockDuringRecording extends Template {


    public void tcStep() {


        Launcher.launchApplication("骁龙相机");
        //switch to camcorder mode
        clickByRes("org.codeaurora.snapcam:id/camera_switcher");
        clickByDesc("切换到视频模式");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            clickByRes("org.codeaurora.snapcam:id/shutter_button");
            sleep(10000);

            Launcher.LCDOnOff();

            //*****************************modify my step end here***********************************
        }
    }
}




