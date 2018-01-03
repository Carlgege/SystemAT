package com.carl.tc.xiaomi.notes;

import com.carl.template.Template;
import com.carl.template.xiaomi.Camera;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class CapturePictureDelete extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("便签");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            clickByText("新建便签");

            if (i == 1) {
                if (objByText("暂不") != null) {
                    clickByText("暂不");
                }
            }

            clickByRes("com.miui.notes:id/photo");
            sleep(2000);

            Camera.capturePicture();

            Camera.confirm();
            sleep(1000);
            Template.mDevice.click(screenSizeWidth / 2, screenSizeHeight / 2);
            sleep(1000);
            if (i == 1) {
                if (objByText("同意并继续") != null) {
                    clickByText("同意并继续");
                }
            }
            sleep(1000);
            backTimes(1);
            sleep(1000);
            Template.mDevice.pressDelete();

            clickByRes("com.miui.notes:id/home");

            //*****************************modify my step end here***********************************
        }

        //System.out.println("RunRegisterWatch"+runRegisterWatcher());
        if (!runRegisterWatcher()) {
            endTime = System.nanoTime();
            logPass(endTime);
        } else {
            logFail("crash happened");
        }

        //backTimes(3);
        removeRegisterWatcher();
    }

}




