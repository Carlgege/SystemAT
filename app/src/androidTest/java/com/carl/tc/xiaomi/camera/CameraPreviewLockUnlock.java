package com.carl.tc.xiaomi.camera;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by H2405158 on 2016/1/18.
 */
public class CameraPreviewLockUnlock extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("相机");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            Launcher.LCDOnOff();

            sleep(2000);

            //*****************************modify my step end here***********************************
        }
    }
}




