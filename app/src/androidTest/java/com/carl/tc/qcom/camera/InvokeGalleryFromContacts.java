package com.carl.tc.qcom.camera;

import com.carl.template.xiaomi.Launcher;import com.carl.template.Template;
/**
 * Created by F3060772 on 2016/1/18.
 */
public class InvokeGalleryFromContacts extends Template {


    public void tcStep() {


        Launcher.launchApplication("通讯录");
        clickByDesc("添加新联系人");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            clickByRes("com.android.contacts:id/photo_icon");

            clickByText("选择照片");

            sleep(2000);

            backTimes(1);

            //*****************************modify my step end here***********************************
        }

        //System.out.println("RunRegisterWatch"+runRegisterWatcher());
        if (!runRegisterWatcher()) {
            endTime = System.nanoTime();
            logPass(endTime);
        } else {
            logFail("crash happened");
        }

        backTimes(3);
        removeRegisterWatcher();
    }

}




