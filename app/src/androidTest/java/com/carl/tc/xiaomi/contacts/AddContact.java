package com.carl.tc.xiaomi.contacts;

import android.support.test.uiautomator.By;
import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;
import java.util.regex.Pattern;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class AddContact extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("联系人");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            if (i == 1) {
                if (objByRes("com.android.contacts:id/create_contact_button") != null) {
                    clickByRes("com.android.contacts:id/create_contact_button");
                } else {
                    clickByText("新建联系人");
                }
            } else {
                clickByText("新建联系人");
            }

            dumpXML();

            if (i == 1) {
                if (objByRes("com.android.contacts:id/btn_keep_local") != null) {
                    clickByRes("com.android.contacts:id/btn_keep_local");
                }
            }

            setText(selectorByText("电话"), "10010");
            //objByText("电话").setText("10010");

            clickByRes("com.android.contacts:id/ok");
            sleep(1000);

            backTimes(1);

            //*****************************modify my step end here***********************************
        }
    }
}




