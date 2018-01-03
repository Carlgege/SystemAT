package com.carl.tc.xiaomi.launcher;

import android.os.RemoteException;
import android.support.test.uiautomator.UiObject2;

import com.carl.template.Template;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class LaunchMiHome extends Template {

    @Override
    protected void tcStep() {

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            try {
                Template.mDevice.sleep();
                sleep(2000);
                Template.mDevice.wakeUp();
                sleep(2000);
            } catch (RemoteException e) {
                e.printStackTrace();
            }

            switchScreenTo("left");

            clickByRes("com.xiaomi.smarthome:id/btn_jump");
            dumpXML();
            backTimes(1);

            //*****************************modify my step end here***********************************
        }
    }
}




