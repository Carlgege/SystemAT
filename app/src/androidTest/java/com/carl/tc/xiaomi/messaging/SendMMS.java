package com.carl.tc.xiaomi.messaging;

import com.carl.template.Template;
import com.carl.template.xiaomi.Camera;
import com.carl.template.xiaomi.Launcher;
import com.carl.template.xiaomi.Messaging;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class SendMMS extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("短信");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            clickByClazz("android.widget.Button");
            setText(selectorByRes("com.android.mms:id/recipients_editor"), "10010");
            if (objByRes("com.android.mms:id/confirm_recipient") != null) {
                clickByRes("com.android.mms:id/confirm_recipient");
            }

            clickByRes("com.android.mms:id/switch_btn");
            clickByText("拍.*照.*");

            Camera.capturePicture();

            sleep(2000);
            Camera.confirm();

            Messaging.send();

            Messaging.backToNewMessage();

            //*****************************modify my step end here***********************************
        }
    }
}




