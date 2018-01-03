package com.carl.tc.xiaomi.camera;

import com.carl.template.Template;
import com.carl.template.xiaomi.Camera;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class SwitchCameraAndVideoOnFront extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("相机");

        //switch camera to  front cameta
        Camera.frontCamera();

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            clickByRes("com.android.camera:id/v6_module_picker");

            sleep(1000);

            //*****************************modify my step end here***********************************
        }


    }

}




