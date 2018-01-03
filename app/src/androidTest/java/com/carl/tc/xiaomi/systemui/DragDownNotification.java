package com.carl.tc.xiaomi.systemui;

import com.carl.template.Template;

/**
 * Created by H2405158 on 2016/1/18.
 */
public class DragDownNotification extends Template {

    @Override
    protected void tcStep() {

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            dragNotification();
            sleep(1000);

            backTimes(1);
            //*****************************modify my step end here***********************************
        }
    }
}




