package com.carl.tc.qcom.camera;

import com.carl.template.xiaomi.Launcher;import com.carl.template.Template;
/**
 * Created by F3060772 on 2016/1/18.
 */
public class InvokeCameraFromContacts extends Template {


    public void tcStep() {


        Launcher.launchApplication("通讯录");
        clickByDesc("添加新联系人");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            clickByRes("com.android.contacts:id/photo_icon");

            clickByText("拍照");

            clickByRes("org.codeaurora.snapcam:id/shutter_button");

            sleep(3000);

            //*****************************modify my step end here***********************************
        }


    }

}




