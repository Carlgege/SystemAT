package com.carl.tc.xiaomi.security;

import android.support.test.uiautomator.UiObject2;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class AddBatteryProfileMode extends Template {

    @Override
    protected void tcStep() {

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************//
            Launcher.launchAP("安全中心");
            clickByText(".*电量.*");
            sleep(1000);
            clickByText("省电模式");
            clickByText("添加自定义模式");
            sleep(1000);
            clickByText("自定义1");
            setText(selectorByText("自定义1"), "我的模式");
            //objByText("自定义1").setText("我的模式");
            clickByText("确定");
            clickByText("添加自定义模式");
            sleep(1000);
            clickByText("自定义1");
            setText(selectorByText("自定义1"), "我的模式");
            //objByText("自定义1").setText("我的模式");
            clickByText("确定");

            if (objByText("我的模式",1) != null) {
                UiObject2 oneAttr = objByText("我的模式",1).getParent().getParent();
                oneAttr.findObject(selectorByRes("com.miui.securitycenter:id/right_arrow")).click();
                clickByText("删除");
                sleep(1000);
                clickByText("确定");
            }

            UiObject2 oneAttr2 = objByText("我的模式").getParent().getParent();
            oneAttr2.findObject(selectorByRes("com.miui.securitycenter:id/right_arrow")).click();
            clickByText("删除");
            sleep(1000);
            clickByText("确定");
            backTimes(3);
            //*****************************modify my step end here***********************************
         }
    }
}




