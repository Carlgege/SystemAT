package com.carl.tc.xiaomi.thridap;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class Clear extends Template {

    @Override
    protected void tcStep() {

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            Launcher.launchAP("猎豹清理大师");
            if (i == 1) {
                if (objByRes("com.cleanmaster.mguard_cn:id/hi") != null) {
                    clickByRes("com.cleanmaster.mguard_cn:id/hi");
                }
                if (objByRes("com.cleanmaster.mguard_cn:id/c2h") != null) {
                    clickByRes("com.cleanmaster.mguard_cn:id/c2h");
                }
            }

            getMem(this.getClass().getPackage().getName() + "." + this.getClass().getSimpleName());
            backTimes(2);
            if (i == 1) {
                if (objByText("立即创建") != null) {
                    clickByText("立即创建");
                }
                sleep(9000);
            }
            //*****************************modify my step end here***********************************
        }
        backTimes(1);
    }
}




