package com.carl.tc.xiaomi.mail;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class SendMailWithAttachment extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("电子邮件");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            clickByText("写邮件");
            objByRes("com.android.email:id/to").setText("zzdqatest@126.com");
            objByRes("com.android.email:id/subject").setText("subject " + i);
            objByRes("com.android.email:id/body").setText("body " + i);

            clickByRes("com.android.email:id/compose_send_btn");
            sleep(3000);

            //*****************************modify my step end here***********************************
        }


    }

}




