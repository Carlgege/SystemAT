package com.carl.tc.xiaomi.fmradio;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class RecordPlayDelete extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("收音机");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            clickByDesc("更多选项");

            clickByText("开始录音");
            sleep(5000);

            clickByDesc("更多选项");

            clickByText("停止录音");

            //*****************************modify my step end here***********************************
        }
    }
}




