package com.carl.tc.xiaomi.camera;

import com.carl.template.Template;
import com.carl.template.xiaomi.Camera;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class CapturePictureWhenFlashOn extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("相机");

        Camera.rearCamera();

        clickByRes("com.android.camera:id/v6_flash_mode_button");

        //turn on flash
        if (objByText("打开") != null) {
            clickByText("打开");
        }
        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            Camera.capturePicture();

            //*****************************modify my step end here***********************************
        }
    }
}




