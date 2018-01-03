package com.carl.tc.xiaomi.messaging;

import com.carl.template.Template;
import com.carl.template.xiaomi.Camera;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class SaveDeleteMMS extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("短信");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            clickByClazz("android.widget.Button");

            setText(selectorByRes("com.android.mms:id/recipients_editor"), "10010");
            dumpXML();

            clickByRes("com.android.mms:id/switch_btn");

            clickByText("拍照");

            Camera.capturePicture();
            sleep(2000);

            Camera.confirm();

            for (int j = 0; j < 3; j++) {
                if (objByRes("com.android.mms:id/from") != null) {
                    break;
                }
                backTimes(1);
            }

            longPressObj(objByRes("com.android.mms:id/from"));

            clickByText("删除");

            dumpXML();

            clickByRes("android:id/button1");
            //*****************************modify my step end here***********************************
        }
    }
}




