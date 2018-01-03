package com.carl.tc.xiaomi.thridap;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class iQiYi extends Template {

    @Override
    protected void tcStep() {

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            Launcher.launchAP("爱奇艺");
            sleep(8000);
            if (i == 1) {

                if (objByRes("com.qiyi.video:id/dataaltcheck") != null) {
                    clickByRes("com.qiyi.video:id/dataaltcheck");
                }
                dumpXML();
                if (objByText("确认") != null) {
                    clickByText("确认");
                }
                sleep(1000);
            }

            getMem(this.getClass().getPackage().getName() + "." + this.getClass().getSimpleName());

            backTimes(1);
            dumpXML();

            clickByText("退出");

            backTimes(1);

            //*****************************modify my step end here***********************************
        }
    }
}




