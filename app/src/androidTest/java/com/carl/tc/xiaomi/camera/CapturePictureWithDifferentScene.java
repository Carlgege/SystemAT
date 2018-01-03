package com.carl.tc.xiaomi.camera;

import com.carl.template.Template;
import com.carl.template.xiaomi.Camera;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class CapturePictureWithDifferentScene extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("相机");

        //turn on Manual mode
        Camera.captureMode("场景选择");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            String[] sceneModes = {"人像", "风景", "运动", "夜景", "夜景人像", "海边", "雪景", "夕阳", "烟花", "逆光", "花卉", "自动"};
            for (String scene : sceneModes) {
                findObjFromListByRes("", "com.android.camera:id/settings_grid", scene, 0, "click");
                Camera.capturePicture();
                //sleep(1000);
            }

            //*****************************modify my step end here***********************************
        }
        backTimes(1);
    }
}




