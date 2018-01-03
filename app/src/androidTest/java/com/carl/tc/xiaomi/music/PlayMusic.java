package com.carl.tc.xiaomi.music;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class PlayMusic extends Template {

    @Override
    public void tcStep() {

        Launcher.launchAP("音乐");
        clickByText("我的音乐");
        clickByDesc("本地歌曲.*");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            clickByRes("com.miui.player:id/play_all_list_item");
            sleep(3000);

            clickByRes("com.miui.player:id/pause");
            //*****************************modify my step end here***********************************
        }


    }

}




