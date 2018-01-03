package com.carl.tc.xiaomi.security;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class CHTCheckScan extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("设置");
        findObjFromListByRes("Vertical", "android:id/content", "其他高级设置", 0, "click");
        clickByText("语言和输入法");
        clickByText("语言", 1);
        clickByText(".*繁體.*");
        sleep(1000);
        backTimes(3);

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************//
            clickByText("安全中心");

            clickByText("開始體檢");
            sleep(5000);

            if (objByText("自動最佳化項目") != null) {
                backTimes(1);;
            }

            backTimes(1);
            //*****************************modify my step end here***********************************
        }

        clickByText("設定");
        findObjFromListByRes("Vertical", "android:id/content", "其他進階設定", 0, "click");
        clickByText("語言與輸入設定");
        clickByText(".*繁體.*");
        clickByText(".*简体.*");
        //clickByRes("com.android.settings:id/title", 0);
        sleep(1000);
        backTimes(3);

    }
}




