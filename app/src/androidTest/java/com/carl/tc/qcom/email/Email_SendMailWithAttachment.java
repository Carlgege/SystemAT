package com.carl.tc.qcom.email;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

import static android.os.SystemClock.sleep;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class Email_SendMailWithAttachment extends Template {

    public void tcStep() {

        Launcher.launchAP("电子邮件");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            clickByRes("com.android.email:id/compose_button");
            objByRes("com.android.email:id/to").setText("patest" + i + "@fihtdc.com");
            objByRes("com.android.email:id/subject").setText("subject " + i);
            objByRes("com.android.email:id/body").setText("body " + i);

            clickByRes("com.android.email:id/send");
            sleep(3000);

            //*****************************modify my step end here***********************************
        }
    }
}




