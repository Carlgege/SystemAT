package com.carl.tc.xiaomi.camera;

import android.support.test.uiautomator.UiObject2;

import com.carl.template.Template;
import com.carl.template.xiaomi.Camera;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class CapturePictureWithTimeWatermark extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("相机");

        //turn on Manual mode
        Camera.captureMode("设置");

        UiObject2 watermarkParent = objByText("时间水印");
        if (watermarkParent != null) {
            UiObject2 watermark = watermarkParent.getParent().getParent().findObject(selectorByRes("android:id/checkbox"));
            if (!watermark.isChecked()) {
                watermark.click();
            }
        }

        backTimes(1);
        sleep(2000);

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            Camera.capturePicture();
            sleep(2000);

            //*****************************modify my step end here***********************************
        }
        backTimes(1);
    }
}




