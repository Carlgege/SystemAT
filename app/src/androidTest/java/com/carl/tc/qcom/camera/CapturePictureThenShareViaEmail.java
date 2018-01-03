package com.carl.tc.qcom.camera;

import com.carl.template.xiaomi.Launcher;import com.carl.template.Template;
/**
 * Created by F3060772 on 2016/1/18.
 */
public class CapturePictureThenShareViaEmail extends Template {


    public void tcStep() {


        Launcher.launchApplication("骁龙相机");
        clickByRes("org.codeaurora.snapcam:id/camera_switcher");
        clickByDesc("切换到拍照模式");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            clickByRes("org.codeaurora.snapcam:id/shutter_button");
            sleep(3000);

            clickByRes("org.codeaurora.snapcam:id/preview_thumb");

            clickByRes("com.android.gallery3d:id/photopage_bottom_control_share");
            clickByText("电子邮件");
            sleep(3000);
            backTimes(2);

            //*****************************modify my step end here***********************************
        }


    }

}




