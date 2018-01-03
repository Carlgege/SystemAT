package com.carl.tc.xiaomi.camera;

import com.carl.template.Template;
import com.carl.template.xiaomi.Camera;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class CapturePictureWithDifferentContrast extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("相机");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            String contrast[] = {"低", "高", "标准"};

            for (int m = 0; m < contrast.length; m++) {
                sleep(1000);
                //turn on Manual mode
                Camera.captureMode("设置");

                findObjFromListByRes("Vertical", "android:id/list", "对比度", 1, "click");

                clickByText(contrast[m]);

                backTimes(1);

                Camera.capturePicture();

                sleep(2000);

            }

            //*****************************modify my step end here***********************************
        }
    }
}




