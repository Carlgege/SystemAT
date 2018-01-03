package com.carl.tc.xiaomi.camera;

import com.carl.template.Template;
import com.carl.template.xiaomi.Camera;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class CapturePictureWithDifferentHDR extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("相机");

        //switch camera if it is front cameta
        Camera.rearCamera();

        if (objByText("HDR  关闭") != null) {
            clickByRes("com.android.camera:id/v6_hdr");
        }

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            for (int m = 0; m < 2; m++) {

                Camera.capturePicture();

            }
            //*****************************modify my step end here***********************************
        }
    }
}




