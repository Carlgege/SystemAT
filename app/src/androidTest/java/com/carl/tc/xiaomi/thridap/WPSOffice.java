package com.carl.tc.xiaomi.thridap;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class WPSOffice extends Template {

    @Override
    protected void tcStep() {

        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            Launcher.launchAP("WPS Office");
            if (i == 1) {
                if (objByRes("cn.wps.moffice_eng:id/checkBox_flow") != null) {
                    clickByRes("cn.wps.moffice_eng:id/checkBox_flow");
                }
                if (objByText("同意") != null) {
                    clickByText("同意");
                }
            }

            getMem(this.getClass().getPackage().getName() + "." + this.getClass().getSimpleName());

            backTimes(2);
            //sleep(3000);

            //*****************************modify my step end here***********************************
        }
    }
}




