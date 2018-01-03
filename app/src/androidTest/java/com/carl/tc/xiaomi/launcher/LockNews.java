package com.carl.tc.xiaomi.launcher;

import android.os.RemoteException;

import com.carl.template.Template;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class LockNews extends Template {

    @Override
    protected void tcStep() {

        try {
            Template.mDevice.sleep();
            sleep(2000);
            Template.mDevice.wakeUp();
            sleep(2000);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            clickByRes("com.android.keyguard:id/item_container");

            if (i == 1) {
                if (objByRes("com.mfashiongallery.emag:id/apply") != null) {
                    clickByRes("com.mfashiongallery.emag:id/apply");
                }
            }

            sleep(2000);
            switchScreenTo("right");

            clickByText("设为");

            //*****************************modify my step end here***********************************
        }
    }
}




