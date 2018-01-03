package com.carl.tc.xiaomi.browser;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class OpenWebsiteFromHistory extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("浏览器");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            clickByRes("com.android.browser:id/action_more");
            clickByRes("com.android.browser:id/action_menu_history");
            sleep(3000);

            backTimes(1);
            //clickByRes("com.android.browser:id/action_more");

            //*****************************modify my step end here***********************************
        }


    }

}




