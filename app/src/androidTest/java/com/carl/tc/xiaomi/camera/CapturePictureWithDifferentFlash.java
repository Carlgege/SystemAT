package com.carl.tc.xiaomi.camera;

import com.carl.template.Template;
import com.carl.template.xiaomi.Camera;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class CapturePictureWithDifferentFlash extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("相机");

        //switch camera if it is front cameta
        Camera.rearCamera();

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            String choices[] = {"关闭", "打开", "自动"};

            for (String choice : choices) {

                clickByRes("com.android.camera:id/v6_flash_mode_button");

                //traveral all the choices
                clickByText(choice);

                Camera.capturePicture();

                sleep(3000);

            }
            //*****************************modify my step end here***********************************
        }
    }
}




