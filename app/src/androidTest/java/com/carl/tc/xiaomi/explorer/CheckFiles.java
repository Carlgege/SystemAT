package com.carl.tc.xiaomi.explorer;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class CheckFiles extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("文件管理");
        clickByText("手机");


        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            sleep(1000);
            clickByRes("com.android.fileexplorer:id/search");
            objByRes("android:id/input").setText("mp4");
            sleep(1000);
            mDevice.pressEnter();
            sleep(3000);
            clickByRes("com.android.fileexplorer:id/file_name");
            sleep(3000);
            backTimes(3);

            sleep(1000);
            clickByRes("com.android.fileexplorer:id/search");
            objByRes("android:id/input").setText("mp3");
            sleep(1000);
            mDevice.pressEnter();
            sleep(1000);
            clickByRes("com.android.fileexplorer:id/file_name");
            sleep(1000);
            if (i == 1) {
                if (objByRes("android.miui:id/always_option") != null) {
                    clickByRes("android.miui:id/always_option");
                    clickByText("音乐");
                }
            }
            sleep(5000);
            backTimes(2);

            sleep(1000);
            clickByRes("com.android.fileexplorer:id/search");
            objByRes("android:id/input").setText("jpg");
            sleep(1000);
            mDevice.pressEnter();
            sleep(3000);
            clickByRes("com.android.fileexplorer:id/file_name");
            if (i == 1) {
                if (objByText("同意并继续") != null) {
                    clickByText("同意并继续");
                }
            }
            sleep(5000);
            backTimes(2);
            //*****************************modify my step end here***********************************
        }

        //System.out.println("RunRegisterWatch"+runRegisterWatcher());
        if (!runRegisterWatcher()) {
            endTime = System.nanoTime();
            logPass(endTime);
        } else {
            logFail("crash happened");
        }

        mDevice.pressBack();
        mDevice.pressBack();

        backTimes(3);
        removeRegisterWatcher();
    }

}




