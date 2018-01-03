package com.carl.tc.qcom.email;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

import static android.os.SystemClock.sleep;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class Email_OpenMail extends Template {

    public void tcStep() {

        Launcher.launchAP("电子邮件");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            clickByClazz("android.view.View");
            sleep(3000);

            backTimes(1);
            //*****************************modify my step end here***********************************
        }
    }
}




