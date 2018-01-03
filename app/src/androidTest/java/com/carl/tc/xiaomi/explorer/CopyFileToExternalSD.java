package com.carl.tc.xiaomi.explorer;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class CopyFileToExternalSD extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("文件管理");
        sleep(2000);

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            clickByText("手机");

            if (i == 1) {
                if (waitForExist(selectorByText("点此切换内部存储/SD卡"), 2)) {
                    backTimes(1);
                }
            }

            longPressObj(objByText("Alarms"));

            clickByText("更多");

            clickByText("复制");

            clickByText("SD卡");

            if (i == 1) {
                if (waitForExist(selectorByText("点此切换内部存储/SD卡"), 2)) {
                    backTimes(1);
                }
            }

            clickByText("粘贴");
            sleep(2000);

            backTimes(1);

            //*****************************modify my step end here***********************************
        }
    }
}




