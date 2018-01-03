package com.carl.tc.xiaomi.camera;

import com.carl.template.Template;
import com.carl.template.xiaomi.Camera;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class CapturePictureThenEdit extends Template {

    public void tcStep() {

        Launcher.launchAP("相机");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            Camera.capturePicture();
            sleep(3000);

            Camera.thumbnail();

            clickByText("编辑");

            clickByText("放弃");
            sleep(1000);

            backTimes(1);

            //*****************************modify my step end here***********************************
        }
    }
}




