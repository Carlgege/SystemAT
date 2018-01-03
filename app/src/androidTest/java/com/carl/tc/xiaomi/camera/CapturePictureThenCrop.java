package com.carl.tc.xiaomi.camera;

import com.carl.template.Template;
import com.carl.template.xiaomi.Camera;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class CapturePictureThenCrop extends Template {

    public void tcStep() {

        Launcher.launchAP("相机");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            Camera.capturePicture();

            Camera.thumbnail();

            clickByText("编辑");

            clickByRes("com.miui.gallery:id/crop_textview");
            sleep(1000);

            clickByRes("com.miui.gallery:id/square_textview");
            sleep(1000);

            clickByRes("com.miui.gallery:id/crop_save_textView");

            clickByRes("com.miui.gallery:id/save");

            backTimes(1);

            //*****************************modify my step end here***********************************
        }


    }

}




