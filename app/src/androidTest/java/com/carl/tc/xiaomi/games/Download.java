package com.carl.tc.xiaomi.games;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class Download extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("游戏");
        sleep(3000);

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            if (objByRes("com.xiaomi.gamecenter:id/item_content") != null) {
                clickByRes("com.xiaomi.gamecenter:id/item_content");
            }

            if (objByRes("com.xiaomi.gamecenter:id/content") != null) {
                clickByRes("com.xiaomi.gamecenter:id/content");
            }

            backTimes(1);
            //sleep(3000);

            //*****************************modify my step end here***********************************
        }
    }
}




