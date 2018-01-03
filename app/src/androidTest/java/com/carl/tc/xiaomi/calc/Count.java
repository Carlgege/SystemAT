package com.carl.tc.xiaomi.calc;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by H2405158 on 2016/1/18.
 */
public class Count extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("计算器");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            clickByRes("com.android.calculator2:id/clear");
            clickByRes("com.android.calculator2:id/digit1");
            clickByRes("com.android.calculator2:id/plus");
            clickByRes("com.android.calculator2:id/digit9");
            clickByRes("com.android.calculator2:id/mul");
            clickByRes("com.android.calculator2:id/digit2");
            clickByRes("com.android.calculator2:id/div");
            clickByRes("com.android.calculator2:id/digit3");

            clickByRes("com.android.calculator2:id/equal");
            //*****************************modify my step end here***********************************
        }
    }
}




