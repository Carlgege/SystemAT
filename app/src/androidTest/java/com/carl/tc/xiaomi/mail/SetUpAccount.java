package com.carl.tc.xiaomi.mail;

import android.support.test.uiautomator.By;
import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;
import java.util.regex.Pattern;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class SetUpAccount extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("电子邮件");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            if (objByRes("com.android.email:id/account_email") != null) {
                setText(By.res(Pattern.compile("com.android.email:id/account_email")), "zzdqatest@126.com");

                setText(By.res(Pattern.compile("com.android.email:id/account_password")), "dqa123456");

                clickByRes("com.android.email:id/next");

                clickByRes("com.android.email:id/done_btn");

                dumpXML();
            }

            //*****************************modify my step end here***********************************
        }
    }
}




