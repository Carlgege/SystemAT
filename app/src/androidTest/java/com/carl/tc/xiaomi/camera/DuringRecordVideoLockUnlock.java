package com.carl.tc.xiaomi.camera;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class DuringRecordVideoLockUnlock extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("相机");

        clickByRes("com.android.camera:id/v6_module_picker");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            clickByRes("com.android.camera:id/v6_shutter_button_internal");

            sleep(2000);

            Launcher.LCDOnOff();

            sleep(2000);

            //*****************************modify my step end here***********************************
        }
    }
}




