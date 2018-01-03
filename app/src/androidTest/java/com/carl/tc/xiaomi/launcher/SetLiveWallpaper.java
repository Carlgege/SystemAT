package com.carl.tc.xiaomi.launcher;

import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;

import com.carl.template.Template;

/**
 * Created by F3060772 on 2016/1/18.
 */
public class SetLiveWallpaper extends Template {

    @Override
    protected void tcStep() {

        //get repeat times from command line
        for (int i = 1; i <= getRepeat(); i++) {

            setCurrentCycle(i);

            //*****************************modify my step from here***********************************

            longPressMenu();
            sleep(1000);

            clickByText("修改壁纸");

            try {
                UiScrollable wallpaperList = new UiScrollable(new UiSelector().resourceId("com.miui.home:id/wallpaper_thumbnail_view"));
                wallpaperList.setAsHorizontalList();
                wallpaperList.scrollToEnd(7);
            } catch (UiObjectNotFoundException e) {
                e.printStackTrace();
            }

            clickByText("其他");
            dumpXML();
            clickByText("动态壁纸");
            if (i % 2 == 0) {
                clickByText("光环螺旋");
            } else {
                clickByText("泡泡");
            }
            sleep(3000);
            clickByText("应用");
            sleep(1000);
            clickByText("全部应用");
            sleep(1000);
            backTimes(4);
            //*****************************modify my step end here***********************************
        }
    }

}




