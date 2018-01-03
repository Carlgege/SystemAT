package com.carl.tc.qcom.email;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class Email_DeleteMail extends Template {


    public void tcStep() {

        Launcher.launchAP("电子邮件");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            longPressObj(objByClazz("android.view.View"));
            clickByRes("com.android.email:id/delete");
            sleep(1000);

            //*****************************modify my step end here***********************************
        }
    }
}




