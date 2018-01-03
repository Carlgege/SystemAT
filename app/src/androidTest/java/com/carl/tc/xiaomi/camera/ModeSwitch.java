package com.carl.tc.xiaomi.camera;

import com.carl.template.Template;
import com.carl.template.xiaomi.Camera;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class ModeSwitch extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("相机");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            String[] captureMode = {"全景","倒计时","手动","水平仪","美颜","夜景防抖","场景选择","移轴摄影","鱼眼镜头"};
            for (String mode : captureMode) {
                Camera.captureMode(mode);

                if (waitForExist(selectorByRes("com.android.camera:id/camera_mode_exit_button"), 2)) {
                    clickByRes("com.android.camera:id/camera_mode_exit_button");
                }
            }

            //*****************************modify my step end here***********************************
        }
    }

}




