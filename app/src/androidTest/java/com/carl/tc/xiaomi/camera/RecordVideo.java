package com.carl.tc.xiaomi.camera;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class RecordVideo extends Template {

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
            sleep(30000);

            clickByRes("org.codeaurora.snapcam:id/shutter_button");
            sleep(1000);

            //*****************************modify my step end here***********************************
        }


    }

}




