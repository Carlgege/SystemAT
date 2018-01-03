package com.carl.tc.xiaomi.phone;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class Make3GCallFromHistory extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("设置");
        clickByText(".*移动网络");
        clickByText("中国联通");
        clickByText("网络类型选择");
        clickByText("3G网络优先");

        backTimes(4);

        Launcher.launchAP("拨号");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            clickByRes("com.android.contacts:id/number");
            sleep(7000);

            clickByRes("com.android.incallui:id/endButton");
            sleep(2000);
            //*****************************modify my step end here***********************************
        }
    }
}




