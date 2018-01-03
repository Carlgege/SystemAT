package com.carl.tc.xiaomi.gallery;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class GalleryListLockUnlock extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("图库");
        clickByRes("com.miui.gallery:id/home_page_action_bar_local");
        Template.mDevice.click((int) ((305f / 1080) * screenSizeWidth), (int)((505f / 1920) * screenSizeHeight));

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            Launcher.LCDOnOff();

            sleep(2000);

            //*****************************modify my step end here***********************************
        }
    }
}




