package com.carl.tc.xiaomi.camera;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class RandomFocus extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("相机");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            int x = 100;
            int y = 100;

            for (int m = 1; m <= 2; m++) {

                mDevice.click(x, y);

                sleep(1000);

                x = x + 100;
                y = y + 100;

            }

            //*****************************modify my step end here***********************************
        }


    }

}




