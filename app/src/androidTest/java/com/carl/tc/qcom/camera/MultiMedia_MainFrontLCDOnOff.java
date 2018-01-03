package com.carl.tc.qcom.camera;

import com.carl.template.xiaomi.Launcher;import com.carl.template.Template;
/**
 * Created by F3060772 on 2016/1/18.
 */
public class MultiMedia_MainFrontLCDOnOff extends Template {


    public void tcStep() {


        Launcher.launchApplication("骁龙相机");
        clickByRes("org.codeaurora.snapcam:id/camera_switcher");
        clickByDesc("切换到拍照模式");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            Launcher.LCDOnOff();
            sleep(2000);

            clickByRes("org.codeaurora.snapcam:id/front_back_switcher");

            Launcher.LCDOnOff();
            //sleep(3000);

            //*****************************modify my step end here***********************************
        }


    }

}




