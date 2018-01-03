package com.carl.tc.xiaomi.security;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class Security extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("安全中心");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            clickByRes("com.miui.securitycenter:id/btn_action");
            sleep(2000);

            for (int k = 0; k < 50; k++) {
                if (objByRes("com.miui.securitycenter:id/btn_quick_cleanup") != null) {
                    //clickByRes("com.miui.securitycenter:id/btn_quick_cleanup");
                    break;
                } else {
                    sleep(1000);
                }
            }

            backTimes(1);

            clickByRes("com.miui.securitycenter:id/menu_item_garbage_cleanup");
            if (i == 1) {
                if (objByText("我知道了") != null) {
                    clickByText("我知道了");
                }
            }

            backTimes(1);

            clickByRes("com.miui.securitycenter:id/menu_item_network_assistants");
            backTimes(1);

            clickByRes("com.miui.securitycenter:id/menu_item_antispam");
            sleep(1000);
            backTimes(1);

            clickByRes("com.miui.securitycenter:id/menu_item_power_manger");
            backTimes(1);

            clickByRes("com.miui.securitycenter:id/menu_item_antivirus");
            waitForExist(selectorByText("开始扫描"), 20);
            dumpXML();

            if (i == 1) {
                if (objByText("我知道了") != null) {
                    clickByText("我知道了");
                }
            }

            backTimes(1);

            clickByRes("com.miui.securitycenter:id/menu_item_license_manager");

            backTimes(1);

            //*****************************modify my step end here***********************************
        }
    }
}




