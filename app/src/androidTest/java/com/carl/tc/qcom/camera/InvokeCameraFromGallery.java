package com.carl.tc.qcom.camera;

import com.carl.template.xiaomi.Launcher;import com.carl.template.Template;
/**
 * Created by F3060772 on 2016/1/18.
 */
public class InvokeCameraFromGallery extends Template {


    public void tcStep() {


        Launcher.launchApplication("图库");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            clickByDesc("切换到相机");
            sleep(1000);
            backTimes(1);

            //*****************************modify my step end here***********************************
        }


    }

}




