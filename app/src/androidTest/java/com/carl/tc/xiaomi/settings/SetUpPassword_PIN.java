package com.carl.tc.xiaomi.settings;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;
import com.carl.template.xiaomi.Settings;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class SetUpPassword_PIN extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("设置");
        findObjFromListByRes("Vertical", "android:id/list", "锁屏.*密码.*", 0, "click");
        clickByText("密码.*", 1);
        if (waitForExist(selectorByRes("com.android.settings:id/password_entry"), 2)) {
            setText(selectorByRes("com.android.settings:id/password_entry"), Settings.passwordPIN);
            clickByRes("com.android.settings:id/footerRightButton");
            clickByText("关闭密码");
            setText(selectorByRes("com.android.settings:id/password_entry"), Settings.passwordPIN);
            clickByRes("com.android.settings:id/footerRightButton");
        }

        clickByText("打开密码");
        if (objByText("数字") != null) {
            clickByText("数字");
        } else {
            clickByText("PIN.*");
        }

        setText(selectorByRes("com.android.settings:id/password_entry"), Settings.passwordPIN);
        clickByRes("com.android.settings:id/footerRightButton");
        setText(selectorByRes("com.android.settings:id/password_entry"), Settings.passwordPIN);
        clickByRes("com.android.settings:id/footerRightButton");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            Launcher.LCDOnOff();
            Launcher.unlock();
            dumpXML();

            //*****************************modify my step end here***********************************
        }

        clickByText("关闭密码");
        setText(selectorByRes("com.android.settings:id/password_entry"), Settings.passwordPIN);
        clickByRes("com.android.settings:id/footerRightButton");
        backTimes(3);

    }
}




