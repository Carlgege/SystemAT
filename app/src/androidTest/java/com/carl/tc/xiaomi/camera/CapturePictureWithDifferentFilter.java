package com.carl.tc.xiaomi.camera;

import com.carl.template.Template;
import com.carl.template.xiaomi.Camera;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class CapturePictureWithDifferentFilter extends Template {

    public void tcStep() {

        Launcher.launchAP("相机");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            String filterMode[] = {"黑白", "生动", "往昔", "素描", "背景虚化", "马赛克", "晨光", "日系", "秋色", "靛青", "标准", "镜面"};

            for (String mode : filterMode) {
                switchScreenTo("right");
                clickByText(mode);
                sleep(1000);
                Camera.capturePicture();
                sleep(1000);
            }
            //*****************************modify my step end here***********************************
        }
    }
}




