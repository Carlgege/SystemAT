package com.carl.tc.xiaomi.settings;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class Wallpaper extends Template {

    @Override
    protected void tcStep() {

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            Launcher.launchAP("设置");

            clickByText("壁纸");

            clickByText("选择新的壁纸");

            dumpXML();

            clickByRes("com.miui.home:id/icon", i % 5);

            clickByRes("com.miui.home:id/btnApply");

            clickByRes("com.miui.home:id/btn_apply_both");
            sleep(3000);

            backTimes(4);
            //*****************************modify my step end here***********************************
        }
    }
}




