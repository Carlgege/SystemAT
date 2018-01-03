package com.carl.tc.xiaomi.explorer;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class CopyPasteFolder extends Template {

    @Override
    protected void tcStep() {

        Launcher.launchAP("文件管理");
        clickByText("手机");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************
            longPressObj(objByText("Alarms"));
            clickByText("更多");
            clickByText("复制");
            clickByText("内部存储设备");
            findObjFromListByRes("Vertical", "android:id/list", "Download", 0, "click");
            clickByText("粘贴");
            sleep(2000);

            for (int k = 0; k < 3; k++) {
                if (objByText("手机") == null) {
                    backTimes(1);
                } else {
                    break;
                }
            }
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




