package com.carl.tc.xiaomi.launcher;

import android.os.RemoteException;
import com.carl.template.Template;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class LaunchCameraFromLock extends Template {

    @Override
    protected void tcStep() {

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            try {
                mDevice.sleep();
                sleep(2000);
                mDevice.wakeUp();
                sleep(2000);
            } catch (RemoteException e) {
                e.printStackTrace();
            }

            switchScreenTo("right");
            //*****************************modify my step end here***********************************
        }

        backTimes(2);
    }
}




