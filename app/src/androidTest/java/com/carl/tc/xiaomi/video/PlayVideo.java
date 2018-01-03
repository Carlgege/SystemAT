package com.carl.tc.xiaomi.video;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class PlayVideo extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("视频");
        sleep(6000);

        if (waitForExist(selectorByRes("com.miui.video:id/user_icon"), 5)) {
            clickByRes("com.miui.video:id/user_icon");
        }

        waitForExist(selectorByRes("com.miui.video:id/my_video_click"), 5);
        clickByRes("com.miui.video:id/my_video_click");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            clickByRes("com.miui.video:id/poster");

            sleep(2000);

            backTimes(2);

            //*****************************modify my step end here***********************************
        }
    }
}




