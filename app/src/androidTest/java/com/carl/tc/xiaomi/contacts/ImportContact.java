package com.carl.tc.xiaomi.contacts;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class ImportContact extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("联系人");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            if (objByRes("com.android.contacts:id/import_contacts_button") != null) {
                clickByRes("com.android.contacts:id/import_contacts_button");
            } else {
                longPressMenu();
                if (!waitForExist(selectorByText("导入或导出联系人"), 2)) {
                    longPressMenu();
                }
                clickByText("导入或导出联系人");
                clickByText("从存储设备导入");
            }
            sleep(3000);

            if (objByText("导入一个 vCard 文件") != null) {
                clickByText("导入一个 vCard 文件");
            }
            clickByText("确定");

            //*****************************modify my step end here***********************************
        }
    }
}




