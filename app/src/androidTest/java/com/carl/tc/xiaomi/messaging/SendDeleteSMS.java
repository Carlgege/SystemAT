package com.carl.tc.xiaomi.messaging;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;
import com.carl.template.xiaomi.Messaging;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class SendDeleteSMS extends Template {

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

            setText(selectorByRes("com.android.mms:id/embedded_text_editor"), "FIH" + i);
            sleep(1000);

            Messaging.send();

            longPressObj(objByRes("com.android.mms:id/message_item"));

            clickByText("删除");
            clickByRes("android:id/button1");

            Messaging.backToNewMessage();

            //*****************************modify my step end here***********************************
        }


    }

}




