package com.carl.tc.xiaomi.calculator;

import com.carl.template.Template;
import com.carl.template.xiaomi.Calc;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by H2604324 on 2016/5/5
 */
public class Count extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("计算器");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            Calc.count("log100)+2=");

            if (!waitForExist(selectorByText("4"), 3)) {
                //logFail("log3+sin2+cos8= test fail");
                logFail("log100)+2= test fail");
            }

            clickByRes("com.android.calculator2:id/del");
            //*****************************modify my step end here***********************************
            backTimes(2);
        }


    }

}




