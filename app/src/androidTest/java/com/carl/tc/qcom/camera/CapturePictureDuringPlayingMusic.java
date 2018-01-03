package com.carl.tc.qcom.camera;

import com.carl.template.xiaomi.Launcher;import com.carl.template.Template;
/**
 * Created by F3060772 on 2016/1/18.
 */
public class CapturePictureDuringPlayingMusic extends Template {

    public void tcStep() {

        //play a musci
        Launcher.launchApplication("音乐");
        clickByDesc("drawer");
        clickByText("歌曲");
        clickByRes("com.android.music:id/iconLayout");
        backTimes(3);


        Launcher.launchApplication("骁龙相机");
        clickByRes("org.codeaurora.snapcam:id/camera_switcher");
        clickByDesc("切换到拍照模式");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            clickByRes("org.codeaurora.snapcam:id/shutter_button");
            sleep(3000);
            //sleep(3000);

            //*****************************modify my step end here***********************************
        }

        Launcher.launchApplication("音乐");
        clickByRes("com.android.music:id/nowplay_icon");
        backTimes(3);


    }

}




