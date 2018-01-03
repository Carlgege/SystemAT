package com.carl.tc.xiaomi.settings;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class WLANConnect extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("设置");
        clickByText("WLAN");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            if (objByRes("android:id/checkbox") != null) {
                if (!objByRes("android:id/checkbox").isChecked()) {
                    clickByRes("android:id/checkbox");
                }
            }

            if (objByText("点击分享密码") != null) {
                clickByRes("com.android.settings:id/detail_arrow");
                //findObjFromListByClazz("Vertical", "android.widget.ScrollView", "删除网络", 0, "");
                slideTo("down", "clazz", "android.widget.ScrollView", 0, "res", "com.android.settings:id/button_delete", 0, "click");
                clickByText("确定");
            }

            sleep(8000);

            findObjFromListByRes("Vertical", "android:id/list", "DQA", 0, "click");

            setText(selectorByRes("com.android.settings:id/password"), "yyyyyyyy");
            sleep(2000);

            clickByRes("android:id/button1");

            sleep(3000);

            for (int j = 0; j < 9; j++) {
                if (objByText("点击分享密码") != null) {
                    break;
                } else {
                    sleep(1000);
                }
            }

            if (objByText("点击分享密码") != null) {
                clickByRes("com.android.settings:id/detail_arrow");
                //findObjFromListByClazz("Vertical", "android.widget.ScrollView", "删除网络", 0, "");
                slideTo("down", "clazz", "android.widget.ScrollView", 0, "res", "com.android.settings:id/button_delete", 0, "click");
                clickByText("确定");
            } else {
                logFail("WLAN DQA connect failed");
            }

            //*****************************modify my step end here***********************************
        }
    }
}




