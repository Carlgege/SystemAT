package com.carl.tc.xiaomi.security;

import android.support.test.uiautomator.UiObject2;
import android.util.LogPrinter;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;
import com.carl.utils.GetDeviceInfo;

import java.io.IOException;
import java.text.StringCharacterIterator;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class CleanUpMemory extends Template {

    @Override
    protected void tcStep() {

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************//
            Launcher.launchAP("安全中心");
            clickByText("开始体检");
            sleep(5000);
            String tmp1 = "";
            UiObject2 score = objByRes("com.miui.securitycenter:id/score");
            if (score != null) {
                tmp1 = score.getText();
            }

            clickByText("占用内存");

            //findObjFromListByRes("Vertical", "com.miui.securitycenter:id/app_list", "SystemAT", 0, "click");

            UiObject2 oneAttr = objByText("SystemAT");
            if (oneAttr != null) {
                oneAttr.getParent().getParent().findObject(selectorByRes("com.miui.securitycenter:id/check")).click();;
            }

            clickByText("一键清理");
            sleep(1000);
            backTimes(1);
            String tmp2 = "";
            UiObject2 scoreVerify = objByRes("com.miui.securitycenter:id/score");
            if (scoreVerify != null) {
                tmp2 = scoreVerify.getText();
            }

            if(!tmp1.equals(tmp2)){
                logFail("体检分数会变化");
            }

            backTimes(2);
            //*****************************modify my step end here***********************************
        }
    }
}




