package com.carl.tc.qcom.camera;

import com.carl.template.xiaomi.Launcher;import com.carl.template.Template;
/**
 * Created by F3060772 on 2016/1/18.
 */
public class CapturePictureWithDifferentMode extends Template {


    public void tcStep() {


        Launcher.launchApplication("骁龙相机");
        clickByRes("org.codeaurora.snapcam:id/camera_switcher");
        clickByDesc("切换到拍照模式");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            String mode[] = {"HDR", "光学变焦", "肖像", "风景", "运动", "花", "背光", "烛光", "日落", "夜景", "海滩", "雪地", "自动"};

            for (int m = 0; m < mode.length; m++) {
                clickByRes("org.codeaurora.snapcam:id/scene_mode_switcher");
                findObjFromListByRes("Vertical", "org.codeaurora.snapcam:id/layout", mode[m], 1, "click");
                clickByRes("org.codeaurora.snapcam:id/shutter_button");
                sleep(2000);
            }

            //*****************************modify my step end here***********************************
        }


    }

}




