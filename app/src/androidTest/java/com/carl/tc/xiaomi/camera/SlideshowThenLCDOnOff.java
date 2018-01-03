package com.carl.tc.xiaomi.camera;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class SlideshowThenLCDOnOff extends Template {

    public void tcStep() {

        Launcher.launchApplication("图库");
        clickByDesc("播放幻灯片");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            Launcher.LCDOnOff();
            sleep(5000);

            //*****************************modify my step end here***********************************
        }


    }

}




