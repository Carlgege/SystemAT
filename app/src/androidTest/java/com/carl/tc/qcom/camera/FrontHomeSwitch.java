package com.carl.tc.qcom.camera;

import com.carl.template.xiaomi.Launcher;import com.carl.template.Template;
/**
 * Created by F3060772 on 2016/1/18.
 */
public class FrontHomeSwitch extends Template {

    public void tcStep() {

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            Launcher.launchApplication("骁龙相机");

            clickByRes("org.codeaurora.snapcam:id/front_back_switcher");
            sleep(3000);

            Template.mDevice.pressHome();

            //*****************************modify my step end here***********************************
        }


    }

}




