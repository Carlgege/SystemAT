package com.carl.tc.xiaomi.camera;

import android.support.test.uiautomator.UiObject2;

import com.carl.template.Template;
import com.carl.template.xiaomi.Camera;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class CapturePictureWithDifferentISO extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("相机");

        //turn on Manual mode
        Camera.captureMode("手动");

        //turn on white balance
        clickByText("感光度");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            UiObject2 barLine = objByRes("com.android.camera:id/seek_bar");

            int x = barLine.getVisibleBounds().centerX();
            int y = barLine.getVisibleBounds().centerY();

            //click the center of the bar
            mDevice.click(x, y);

            Camera.capturePicture();

            sleep(3000);

            //click the 1/3 of the bar
            mDevice.click(screenSizeWidth / 3, y);

            Camera.capturePicture();

            sleep(3000);

            //click the 2/3 of the bar
            mDevice.click(screenSizeWidth / 3 * 2, y);

            Camera.capturePicture();

            sleep(3000);


            //*****************************modify my step end here***********************************
        }

        backTimes(1);


    }

}




