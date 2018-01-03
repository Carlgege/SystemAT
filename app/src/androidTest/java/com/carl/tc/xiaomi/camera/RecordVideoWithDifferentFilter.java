package com.carl.tc.xiaomi.camera;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class RecordVideoWithDifferentFilter extends Template {

    public void tcStep() {

        Launcher.launchApplication("骁龙相机");

        //switch to camcorder mode
        clickByRes("org.codeaurora.snapcam:id/camera_switcher");
        clickByDesc("切换到视频模式");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            String filterMode[] = {"单色", "深褐色", "负片", "曝光过度", "色调分离", "浅绿色", "浮雕", "素描", "霓虹灯", "无"};

            for (int m = 0; m < filterMode.length; m++) {
                clickByRes("org.codeaurora.snapcam:id/filter_mode_switcher");
                findObjFromListByRes("Vertical", "org.codeaurora.snapcam:id/layout", filterMode[m], 1, "click");
                backTimes(1);
                clickByRes("org.codeaurora.snapcam:id/shutter_button");
                sleep(30000);

                clickByRes("org.codeaurora.snapcam:id/shutter_button");
                sleep(1000);
            }

            //*****************************modify my step end here***********************************
        }


    }

}




