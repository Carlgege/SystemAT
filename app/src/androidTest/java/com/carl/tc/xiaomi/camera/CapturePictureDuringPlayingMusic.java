package com.carl.tc.xiaomi.camera;

import com.carl.template.Template;
import com.carl.template.xiaomi.Camera;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class CapturePictureDuringPlayingMusic extends Template {

    public void tcStep() {

        //play a music
        Launcher.launchAP("音乐");
        clickByRes("com.miui.player:id/pause");
        backTimes(3);

        Launcher.launchAP("相机");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            Camera.capturePicture();
            sleep(3000);

            //*****************************modify my step end here***********************************
        }

        backTimes(3);
        Launcher.launchAP("音乐");
        clickByRes("com.miui.player:id/pause");
        backTimes(3);

    }

}




