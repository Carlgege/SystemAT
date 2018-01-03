package com.carl.tc.xiaomi.contacts;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class DeleteContact extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("联系人");
        sleep(1000);

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            clickByClazz("android.view.ViewGroup", 3);
            clickByText("更多");
            sleep(2000);
            dumpXML();
            clickByText("删除联系人");
            clickByText("删除");
            //*****************************modify my step end here***********************************
        }
    }
}




