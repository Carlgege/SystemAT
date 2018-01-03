package com.carl.tc.xiaomi.calculator;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by H2604324 on 2016/5/5
 */
public class StandardScienceModeSwitch extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("计算器");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            clickByRes("com.android.calculator2:id/switch_btn");

            //*****************************modify my step end here***********************************
        }
        backTimes(2);


    }
}





