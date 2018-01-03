package com.carl.tc.xiaomi.themes;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class SwitchStyle extends Template {

    @Override
    protected void tcStep() {

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            Launcher.launchAP("个性主题");
            dumpXML();
            if (objByText("本地") != null) {
                clickByText("本地");
            }

            if (objByRes("com.android.thememanager:id/applyBtn") != null) {
                backTimes(1);
            }

            clickByRes("com.android.thememanager:id/root_flag", i % 5);
            clickByRes("com.android.thememanager:id/applyBtn");
            sleep(7000);

            //*****************************modify my step end here***********************************
        }
    }
}




