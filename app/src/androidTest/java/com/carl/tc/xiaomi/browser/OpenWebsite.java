package com.carl.tc.xiaomi.browser;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class OpenWebsite extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("浏览器");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            clickByText("上网导航");
            sleep(3000);

            backTimes(1);

            //*****************************modify my step end here***********************************
        }
    }
}




