package com.carl.tc.xiaomi.camera;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class InvokeGalleryFromMessage extends Template {

    public void tcStep() {

        Launcher.launchApplication("短信");
        clickByDesc("新信息");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            clickByDesc("附件");
            clickByText("照片");
            sleep(2000);
            backTimes(1);

            //*****************************modify my step end here***********************************
        }


    }

}




