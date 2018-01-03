package com.carl.tc.xiaomi.camera;

import com.carl.template.Template;
import com.carl.template.xiaomi.Launcher;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class SharePictureViaMessageFromGallery extends Template {

    public void tcStep() {

        Launcher.launchApplication("图库");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            clickByDesc("更多选项");
            clickByText("选择条目");

            Template.mDevice.click(screenSizeWidth / 4, screenSizeHeight / 3);

            if (objByDesc("使用短信分享") != null) {
                clickByDesc("使用短信分享");
            } else {
                clickByDesc("分享方式");
                clickByText("短信");
            }

            sleep(3000);

            backTimes(2);
            clickByText("确定");

            //*****************************modify my step end here***********************************
        }


    }

}




