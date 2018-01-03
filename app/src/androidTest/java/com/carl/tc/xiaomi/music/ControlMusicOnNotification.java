package com.carl.tc.xiaomi.music;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class ControlMusicOnNotification extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("音乐");
        clickByText("我的音乐");
        clickByDesc("本地歌曲.*");
        clickByRes("com.miui.player:id/play_all_list_item");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            mDevice.swipe(screenSizeWidth / 2, 1, screenSizeWidth / 2, screenSizeHeight, 20);
            sleep(1000);

            clickByRes("com.miui.player:id/st_next");
            sleep(1000);
            clickByRes("com.miui.player:id/st_pause");
            sleep(1000);
            backTimes(1);
            //*****************************modify my step end here***********************************
        }


    }

}




