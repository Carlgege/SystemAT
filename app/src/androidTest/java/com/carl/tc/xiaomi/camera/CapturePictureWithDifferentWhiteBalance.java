package com.carl.tc.xiaomi.camera;

import com.carl.template.Template;
import com.carl.template.xiaomi.Camera;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class CapturePictureWithDifferentWhiteBalance extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("相机");

        Camera.rearCamera();

        //turn on Manual mode
        Camera.captureMode("手动");

        //turn on white balance
        clickByText("白平衡");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            String whiteBalance[] = {"白炽光", "日光", "荧光灯", "阴天", "自动"};

            for (String balance : whiteBalance) {

                clickByText(balance);
                sleep(1000);

                Camera.capturePicture();
            }
            //*****************************modify my step end here***********************************
        }
    }
}




