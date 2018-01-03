package com.carl.tc.xiaomi.camera;

import android.support.test.uiautomator.UiObject2;

import com.carl.template.Template;
import com.carl.template.xiaomi.Camera;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by H2405158 on 2016/1/18.
 */
public class CapturePictureWithDifferentExposureTime extends Template {

    public void tcStep() {

        Launcher.launchAP("OnOff");

        //turn on Manual mode
        Camera.cameraMode("Manual");

        //turn on white balance
        clickByText("Exposure time");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            UiObject2 barLine = objByDesc("SeekBarLine");

            int x = barLine.getVisibleBounds().centerX();
            int y = barLine.getVisibleBounds().centerY();

            //click the center of the bar
            Template.mDevice.click(x, y);

            Camera.capturePicture();

            sleep(3000);

            //click the 1/3 of the bar
            Template.mDevice.click(screenSizeWidth / 3, y);

            Camera.capturePicture();

            sleep(3000);

            //click the 2/3 of the bar
            Template.mDevice.click(screenSizeWidth / 3 * 2, y);

            Camera.capturePicture();

            sleep(3000);


            //*****************************modify my step end here***********************************
        }

        backTimes(1);


    }

}




