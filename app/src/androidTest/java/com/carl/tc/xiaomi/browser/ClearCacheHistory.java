package com.carl.tc.xiaomi.browser;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class ClearCacheHistory extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("浏览器");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            clickByRes("com.android.browser:id/action_more");
            dumpXML();
            clickByRes("com.android.browser:id/action_menu_setting");

            findObjFromListByRes("Vertical", "android:id/list", "清除数据", 0, "click");
            clickByRes("com.android.browser:id/button");
            clickByText("确定");
            backTimes(2);
            //clickByRes("com.android.browser:id/action_more");

            //*****************************modify my step end here***********************************
        }
    }
}




