package com.carl.tc.xiaomi.camera;

import com.carl.template.Template;
import com.carl.template.xiaomi.Camera;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class CapturePictureWithDifferentSkinBeautify extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("相机");

        //switch to front camera
        Camera.frontCamera();

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            String choices[] = {"关", "低", "高", "中"};

            for (String choice : choices) {

                clickByRes("com.android.camera:id/skin_beatify_button");

                clickByText(choice);

                Camera.capturePicture();
            }
            //*****************************modify my step end here***********************************
        }
    }
}




