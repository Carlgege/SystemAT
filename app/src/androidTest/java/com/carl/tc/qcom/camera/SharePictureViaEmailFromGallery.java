package com.carl.tc.qcom.camera;

import com.carl.template.xiaomi.Launcher;import com.carl.template.Template;
/**
 * Created by F3060772 on 2016/1/18.
 */
public class SharePictureViaEmailFromGallery extends Template {


    public void tcStep() {


        Launcher.launchApplication("图库");

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            clickByDesc("更多选项");
            clickByText("选择条目");

            Template.mDevice.click(screenSizeWidth / 4, screenSizeHeight / 3);

            if (objByDesc("使用电子邮件分享") != null) {
                clickByDesc("使用电子邮件分享");
            } else {
                clickByDesc("分享方式");
                clickByText("电子邮件");
            }


            sleep(3000);

            backTimes(1);

            //*****************************modify my step end here***********************************
        }


    }

}




