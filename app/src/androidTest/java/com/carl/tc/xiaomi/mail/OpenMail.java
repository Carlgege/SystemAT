package com.carl.tc.xiaomi.mail;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class OpenMail extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("电子邮件");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            if (waitForExist(selectorByClazz("android.view.View"), 3)) {
                clickByClazz("android.view.View");
            }
            sleep(3000);

            backTimes(1);
            //*****************************modify my step end here***********************************
        }
    }
}




