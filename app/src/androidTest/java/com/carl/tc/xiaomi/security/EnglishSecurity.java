package com.carl.tc.xiaomi.security;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;
/**
 * Created by F3060772 on 2016/1/18.
 */
public class EnglishSecurity extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("设置");
        findObjFromListByRes("Vertical", "android:id/content", "其他高级设置", 0, "click");
        clickByText("语言和输入法");
        clickByText("语言", 1);
        clickByText("English");
        sleep(1000);
        backTimes(3);

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************//
            clickByText("Security");

            clickByText("Virus scan");
            sleep(2000);

            if (i == 1) {
                if (objByText("OK") != null) {
                    clickByText("OK");
                }
            }

            backTimes(2);
            //*****************************modify my step end here***********************************
        }

        clickByText("Settings");
        findObjFromListByRes("Vertical", "android:id/content", "Additional settings", 0, "click");
        clickByText("Language & input");
        clickByText("English");
        clickByText(".*简体.*");
        //clickByRes("com.android.settings:id/title", 0);
        sleep(1000);
        backTimes(3);

    }
}




