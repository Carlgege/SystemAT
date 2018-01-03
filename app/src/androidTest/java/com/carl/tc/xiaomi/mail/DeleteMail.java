package com.carl.tc.xiaomi.mail;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class DeleteMail extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("电子邮件");
        //clickByClazz("android.widget.ImageButton");
        //clickByText("发件箱");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            if (waitForExist(selectorByClazz("android.view.View"), 2)) {
                longPressObj(objByClazz("android.view.View"));
                clickByText("删除");
                sleep(1000);
            }

            //*****************************modify my step end here***********************************
        }
    }
}




