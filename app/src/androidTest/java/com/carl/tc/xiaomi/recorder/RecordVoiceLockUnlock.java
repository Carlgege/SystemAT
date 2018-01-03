package com.carl.tc.xiaomi.recorder;

import android.support.test.uiautomator.UiObject2;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class RecordVoiceLockUnlock extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("录音机");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            UiObject2 stopRecord = objByRes("com.android.soundrecorder:id/btn_record_stop");
            int x = stopRecord.getVisibleBounds().centerX();
            int y = stopRecord.getVisibleBounds().centerY();

            clickByRes("com.android.soundrecorder:id/btn_record");
            sleep(2000);

            Launcher.LCDOnOff();
            sleep(2000);

            Template.mDevice.click(x, y);
            sleep(2000);

            //clickByRes("com.android.soundrecorder:id/discardButton");
            clickByText("确定");
            backTimes(1);
            //*****************************modify my step end here***********************************
        }
    }
}




