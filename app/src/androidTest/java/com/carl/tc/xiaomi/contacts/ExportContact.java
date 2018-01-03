package com.carl.tc.xiaomi.contacts;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class ExportContact extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("联系人");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            longPressMenu();
            if (!waitForExist(selectorByText("导入或导出联系人"), 2)) {
                longPressMenu();
            }
            clickByText("导入或导出联系人");
            if (!waitForExist(selectorByText("导出到存储设备"), 2)) {
                backTimes(2);
                clickByText("新建联系人");
                if (i == 1) {
                    if (objByRes("com.android.contacts:id/btn_keep_local") != null) {
                        clickByRes("com.android.contacts:id/btn_keep_local");
                    }
                }

                setText(selectorByText("电话"), "10010");

                clickByRes("com.android.contacts:id/ok");
                sleep(1000);
                backTimes(1);
                sleep(1000);
                longPressMenu();
                clickByText("导入或导出联系人");
            }

            clickByText("导出到存储设备");
            clickByText("确定");
            sleep(2000);
            backTimes(2);
            sleep(2000);

            //*****************************modify my step end here***********************************
        }
    }
}




