package com.carl.tc.xiaomi.music;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class AddDelPlaylist extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("音乐");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            clickByDesc("本地歌曲.*");

            longPressObj(objByRes("com.miui.player:id/title_container"));

            clickByText("添加到");

            clickByText("新建歌单");

            clickByRes("com.miui.player:id/ok");

            backTimes(1);
            sleep(1000);

            clickByDesc("新播放列表.*");

            clickByDesc("播放全部歌曲");

            dumpXML();

            clickByDesc("删除");

            clickByRes("com.miui.player:id/ok");
            sleep(1000);
            //*****************************modify my step end here***********************************
        }
    }
}




