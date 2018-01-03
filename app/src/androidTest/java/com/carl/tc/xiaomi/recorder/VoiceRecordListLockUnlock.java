package com.carl.tc.xiaomi.recorder;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class VoiceRecordListLockUnlock extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("录音机");
        clickByRes("com.android.soundrecorder:id/btn_list");

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




