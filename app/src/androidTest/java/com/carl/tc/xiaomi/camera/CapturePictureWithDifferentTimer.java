package com.carl.tc.xiaomi.camera;

import com.carl.template.Template;
import com.carl.template.xiaomi.Camera;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class CapturePictureWithDifferentTimer extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("相机");

        //switch to front camera
        Camera.frontCamera();

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            String choices[] = {"3秒", "5秒", "关闭"};

            for (String choice : choices) {

                clickByRes("com.android.camera:id/v6_countdown");

                clickByText(choice);

                Camera.capturePicture();

                sleep(5000);
            }
            //*****************************modify my step end here***********************************
        }
    }
}




