package com.carl.tc.xiaomi.browser;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class AddDeleteBookmark extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("浏览器");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            clickByText("上网导航");
            sleep(3000);

            clickByRes("com.android.browser:id/action_more");
            clickByRes("com.android.browser:id/action_menu_bookmark");
            //clickByText("保存");

            clickByRes("com.android.browser:id/action_more");
            clickByRes("com.android.browser:id/action_menu_history");
            longPressObj(objByText("上网导航"));
            clickByText("删除");
            clickByText("确定");

            backTimes(2);

            //*****************************modify my step end here***********************************
        }
    }
}




