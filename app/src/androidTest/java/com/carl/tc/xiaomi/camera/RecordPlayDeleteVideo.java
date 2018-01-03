package com.carl.tc.xiaomi.camera;

import com.carl.template.Template;
import com.carl.template.xiaomi.Camera;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class RecordPlayDeleteVideo extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("相机");

        //switch to camcorder mode
        clickByRes("com.android.camera:id/v6_module_picker");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            Camera.captureVideo(30000);

            clickByRes("com.android.camera:id/v6_thumbnail_image");
            //sleep(1000);

            if (i == 1) {
                if (objByText("同意并继续") != null) {
                    clickByText("同意并继续");
                }
            }

            clickByText("删除");
            clickByRes("android:id/button1");

            for (int k = 0; k < 3; k++) {
                if (!(objByRes("com.android.camera:id/v6_thumbnail_image") != null)) {
                    backTimes(1);
                } else {
                    break;
                }
            }

            //*****************************modify my step end here***********************************
        }


    }

}




