package com.carl.tc.xiaomi.thridap;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class Discount800 extends Template {

    @Override
    protected void tcStep() {

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            Launcher.launchAP("折800");
            if (i == 1) {
                if (objByText("允许") != null) {
                    clickByText("允许");
                    sleep(3000);
                    clickByRes("com.tuan800.tao800:id/guide_convertNext");
                    clickByRes("com.tuan800.tao800:id/rb_male");
                    clickByRes("com.tuan800.tao800:id/img_identity_close");
                    clickByText("允许");
                }
            }
            getMem(this.getClass().getPackage().getName() + "." + this.getClass().getSimpleName());
            backTimes(2);
            //sleep(3000);

            //*****************************modify my step end here***********************************
        }

    }

}




