package com.carl.template;

import android.os.Environment;
import android.os.RemoteException;
import android.os.SystemClock;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.StaleObjectException;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.UiWatcher;
import android.support.test.uiautomator.Until;
import android.test.InstrumentationTestCase;
import android.view.KeyEvent;
import com.carl.template.xiaomi.Launcher;
import com.carl.template.xiaomi.Settings;
import com.carl.utils.GetDeviceInfo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static android.support.test.InstrumentationRegistry.getContext;

public class Template extends InstrumentationTestCase {

    public static final long waitTimeout = 1000;
    public static final long windowUpdateTimeout = 1000;
    public static UiDevice mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    public static String TCName = "";
    public static long startTime;
    public static int currentCycle = 1;
    public static String resultFolder = Environment.getExternalStorageDirectory().getPath() + "/ShellResult";
    public static String imageFolder = resultFolder + "/Image";
    public static String bugFolder = resultFolder + "/Bug";
    public static String memoryFolder = resultFolder + "/DeviceStatus/Memory";
    public static String cpuFreqFolder = resultFolder + "/DeviceStatus/CpuFreq";
    public static String cpuUsageFolder = resultFolder + "/DeviceStatus/CpuUsage";
    public static String batteryInfoFolder = resultFolder + "/DeviceStatus/BatteryInfo";
    public static String logFolder = resultFolder + "/Log";
    public static String tempFolder = resultFolder + "/Temp";
    public static String logFile = logFolder + "/Result.txt";
    public static String jsonLogFile = logFolder + "/Result.json";
    //public static String detailLogFile = logFolder + "/RunDetail.txt";
    public static String screenshotFileName = "";
    public static int screenSizeWidth;
    public static int screenSizeHeight;
    public long endTime;

    public static String getDate() {

        Date date = new Date();
        //DateFormat format = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        //System.out.println(format.format(date));

        return format.format(date);

    }

    public static String getSIMChoose() {
        //simChoose: SIM1, SIM2
        return InstrumentationRegistry.getArguments().getString("SIMChoose", "noInput");
    }

    public static String getPhoneNum() {

        String phoneNum = InstrumentationRegistry.getArguments().getString("PhoneNum", "noInput");
        //String simChoose = InstrumentationRegistry.getArguments().getString("SIMChoose", "noInput");

        if (phoneNum.equals("noInput")) {
            GetDeviceInfo.getSIMType();

            if (getSIMChoose().equals("noInput")) {

                if (GetDeviceInfo.SIM1Operator.contains("CMCC")) {
                    return "10086";
                } else if (GetDeviceInfo.SIM1Operator.contains("UNICOM")) {
                    return "10010";
                } else if (GetDeviceInfo.SIM2Operator.contains("CMCC")) {
                    return "10086";
                } else if (GetDeviceInfo.SIM2Operator.contains("UNICOM")) {
                    return "10010";
                }

                return "112";
            } else {
                if (getSIMChoose().equals("SIM1")) {
                    if (GetDeviceInfo.SIM1Operator.contains("CMCC")) {
                        return "10086";
                    } else if (GetDeviceInfo.SIM1Operator.contains("UNICOM")) {
                        return "10010";
                    }
                } else if (getSIMChoose().equals("SIM2")) {
                    if (GetDeviceInfo.SIM2Operator.contains("CMCC")) {
                        return "10086";
                    } else if (GetDeviceInfo.SIM2Operator.contains("UNICOM")) {
                        return "10010";
                    }
                }
                return "112";
            }
        }

        return phoneNum;
    }

    public static String countDuration(long start, long end) {

        double runtimeDuration = (end - start) / 1000000000.0;

        NumberFormat df = NumberFormat.getNumberInstance();
        df.setMaximumFractionDigits(3);

        //System.out.println("tcduration=start=" + start);
        //System.out.println("tcyduration=end=" + end);
        //System.out.println("tcduration=" + runtimeDuration);

        if (runtimeDuration >= 86400.0) {
            return (int) runtimeDuration / 86400 + "D" + (int) (runtimeDuration % 86400) / 3600 + "H" + (int) (runtimeDuration % 86400 % 3600) / 60 + "M" + df.format(runtimeDuration % 60) + "S";
        }
        if (runtimeDuration >= 3600.0) {
            return (int) runtimeDuration / 3600 + "H" + (int) (runtimeDuration % 3600) / 60 + "M" + df.format(runtimeDuration % 60) + "S";
        }
        if (runtimeDuration >= 60.0) {
            return (int) runtimeDuration / 60 + "M" + df.format(runtimeDuration % 60) + "S";
        }

        return df.format(runtimeDuration) + "S";
    }

    public static void capScreenshot() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

        screenshotFileName = format.format(date);
        File screenshotFile = new File(imageFolder + "/" + screenshotFileName + ".png");
        mDevice.takeScreenshot(screenshotFile);
    }

    public static BySelector selectorByText(String text) {
        return By.text(Pattern.compile(text));
    }

    public static BySelector selectorByRes(String text) {
        return By.res(Pattern.compile(text));
    }

    public static BySelector selectorByClazz(String text) {
        return By.clazz(Pattern.compile(text));
    }

    public static BySelector selectorByDesc(String text) {
        return By.desc(Pattern.compile(text));
    }

    public static UiObject2 objByText(String text) {

        BySelector objSelector = selectorByText(text);
        //mDevice.hasObject(objSelector);
        if (mDevice.wait(Until.hasObject(objSelector), waitTimeout)) {
            //if (mDevice.hasObject(objSelector)) {
            return mDevice.findObject(objSelector);
        }

        return null;
    }

    public static UiObject2 objByText(String text, int instance) {

        BySelector objSelector = selectorByText(text);
        List<UiObject2> objs = mDevice.findObjects(objSelector);
        if (objs.size() - 1 < instance) {
            return null;
        }
        if (objs.get(instance) != null) {
            return mDevice.findObjects(objSelector).get(instance);
        }

        return null;
    }

    public static UiObject2 objByRes(String text) {

        BySelector objSelector = selectorByRes(text);
        //if (mDevice.hasObject(objSelector)) {
        if (mDevice.wait(Until.hasObject(objSelector), waitTimeout)) {
            return mDevice.findObject(objSelector);
        }

        return null;
    }

    public static UiObject2 objByRes(String text, int instance) {

        BySelector objSelector = selectorByRes(text);
        List<UiObject2> objs = mDevice.findObjects(objSelector);
        if (objs.size() - 1 < instance) {
            return null;
        }
        if (objs.get(instance) != null) {
            return mDevice.findObjects(objSelector).get(instance);
        }

        return null;
    }

    public static UiObject2 objByDesc(String text) {

        BySelector objSelector = selectorByDesc(text);
        if (mDevice.wait(Until.hasObject(objSelector), waitTimeout)) {
            //if (mDevice.hasObject(objSelector)) {
            return mDevice.findObject(objSelector);
        }

        return null;
    }

    public static UiObject2 objByDesc(String text, int instance) {

        BySelector objSelector = selectorByDesc(text);
        List<UiObject2> objs = mDevice.findObjects(objSelector);
        if (objs.size() - 1 < instance) {
            return null;
        }
        if (objs.get(instance) != null) {
            return mDevice.findObjects(objSelector).get(instance);
        }

        return null;
    }

    public static UiObject2 objByClazz(String text) {

        BySelector objSelector = selectorByClazz(text);
        if (mDevice.wait(Until.hasObject(objSelector), waitTimeout)) {
            //if (mDevice.hasObject(objSelector)) {
            return mDevice.findObject(objSelector);
        }

        return null;
    }

    public static UiObject2 objByClazz(String text, int instance) {

        BySelector objSelector = selectorByClazz(text);
        List<UiObject2> objs = mDevice.findObjects(objSelector);
        if (objs.size() - 1 < instance) {
            return null;
        }
        if (objs.get(instance) != null) {
            return mDevice.findObjects(objSelector).get(instance);
        }

        return null;
    }

    public static void clickObj(UiObject2 obj) {
        //obj.click();
        mDevice.swipe(obj.getVisibleCenter().x, obj.getVisibleCenter().y, obj.getVisibleCenter().x, obj.getVisibleCenter().y, 8);
        dumpXML();
    }

    public static void clickByText(String text) {
        UiObject2 obj = objByText(text);

        if (obj != null) {
            clickObj(obj);
            testDetailLog(logFolder + "/TestDetail.html", logFolder + "/tmp.html", "clickByText:" + text);
        } else {
            capScreenshot();
            logFail("Click " + text + " failed");
            //System.exit(0); //---- it will caused crash
            //getInstrumentation().onDestroy();
            //finish();
        }
    }

    public static void clickByText(String text, int instance) {
        UiObject2 obj = objByText(text, instance);

        if (obj != null) {
            clickObj(obj);
            testDetailLog(logFolder + "/TestDetail.html", logFolder + "/tmp.html", "clickByText:" + text);
        } else {
            capScreenshot();
            logFail("Click " + text + " failed");
        }
    }

    public static void clickByRes(String text) {

        UiObject2 obj = objByRes(text);

        if (obj != null) {
            clickObj(obj);
            testDetailLog(logFolder + "/TestDetail.html", logFolder + "/tmp.html", "clickByRes:" + text);

        } else {
            capScreenshot();
            logFail("Click " + text + " failed");
            //System.exit(0); //---- it will caused crash
        }
    }

    public static void clickByRes(String text, int instance) {
        UiObject2 obj = objByRes(text, instance);

        if (obj != null) {
            clickObj(obj);
            testDetailLog(logFolder + "/TestDetail.html", logFolder + "/tmp.html", "clickByRes:" + text);
        } else {
            capScreenshot();
            logFail("Click " + text + " failed");
        }
    }

    public static void clickByDesc(String text) {
        UiObject2 obj = objByDesc(text);

        if (obj != null) {
            clickObj(obj);
            testDetailLog(logFolder + "/TestDetail.html", logFolder + "/tmp.html", "clickByDesc:" + text);
        } else {
            capScreenshot();
            logFail("Click " + text + " failed");
            //System.exit(0); //---- it will caused crash
        }
    }

    public static void clickByDesc(String text, int instance) {
        UiObject2 obj = objByDesc(text, instance);

        if (obj != null) {
            clickObj(obj);
            testDetailLog(logFolder + "/TestDetail.html", logFolder + "/tmp.html", "clickByDesc:" + text);
        } else {
            capScreenshot();
            logFail("Click " + text + " failed");
        }
    }

    public static void clickByClazz(String text) {
        UiObject2 obj = objByClazz(text);

        if (obj != null) {
            clickObj(obj);
            testDetailLog(logFolder + "/TestDetail.html", logFolder + "/tmp.html", "clickByClazz:" + text);
        } else {
            capScreenshot();
            logFail("Click " + text + " failed");
        }
    }

    public static void clickByClazz(String text, int instance) {
        UiObject2 obj = objByClazz(text, instance);

        if (obj != null) {
            clickObj(obj);
            testDetailLog(logFolder + "/TestDetail.html", logFolder + "/tmp.html", "clickByClazz:" + text);
        } else {
            capScreenshot();
            logFail("Click " + text + " failed");
        }
    }

    public static void longPressObj(UiObject2 obj) {

        if (obj != null) {
            int x = obj.getVisibleBounds().centerX();
            int y = obj.getVisibleBounds().centerY();

            mDevice.swipe(x, y, x, y, 200);
            testDetailLog(logFolder + "/TestDetail.html", logFolder + "/tmp.html", "longPressObj success");
            dumpXML();

        } else {
            capScreenshot();
            logFail("longPressObj  failed");
            //logFail("longPress " + obj.getText() + " " + obj.getResourceName() + " " + obj.getContentDescription() + " failed");
            //System.exit(0); //---- it will caused crash
        }
    }

    public static boolean waitForExist(BySelector selector, int seconds) {

        boolean flag = false;
        for (int i = 0; i < seconds; i++) {
            if (mDevice.hasObject(selector)) {
                flag = true;
                break;
            } else {
                sleep(1000);
            }
        }

        return flag;
    }

    public static void setText(BySelector by, String text) {
        if (mDevice.hasObject(by)) {
            mDevice.findObject(by).setText(text);
        } else {
            logFail("The obj " + by.toString() + "can not be found, setText failed");
        }
    }

    public static void swipeTo(String dire, String resourceId) {
        UiObject2 obj = objByRes(resourceId);
        if (obj == null) {
            logFail("can not find " + resourceId);

        }
        int top = obj.getVisibleBounds().top + 1;
        int bottom = obj.getVisibleBounds().bottom - 1;
        int left = obj.getVisibleBounds().left + 1;
        int right = obj.getVisibleBounds().right - 1;
        int centerX = obj.getVisibleBounds().centerX();
        int centerY = obj.getVisibleBounds().centerY();
        int step = 50;

//        Log.d("carllog", top+"");
//        Log.d("carllog", bottom+"");
//        Log.d("carllog", left+"");
//        Log.d("carllog", right+"");
//        Log.d("carllog", centerX+"");
//        Log.d("carllog", step+"");

        switch (dire) {
            case "up":
                mDevice.swipe(centerX, bottom, centerX, top, step);
                break;
            case "down":
                mDevice.swipe(centerX, top, centerX, bottom, step);
                break;
            case "left":
                mDevice.swipe(right, centerY, left, centerY, step);
                break;
            case "right":
                mDevice.swipe(left, centerY, right, centerY, step);
                break;
        }
        testDetailLog(logFolder + "/TestDetail.html", logFolder + "/tmp.html", "swipeTo:" + dire + " " + resourceId);
    }

    public static void dumpXML() {

        for (int i = 0; i < 5; i++) {
            try {
                String fileName = tempFolder + "/dump";
                File xmlFile = new File(fileName);
                if (xmlFile.exists()) {
                    xmlFile.delete();
                }
                //mDevice.executeShellCommand("rm "+fileName);
                mDevice.waitForWindowUpdate(mDevice.getCurrentPackageName(), Template.windowUpdateTimeout);
                mDevice.dumpWindowHierarchy(xmlFile);
                //mDevice.dumpWindowHierarchy(fileName);
                if (xmlFile.length() > 0) {
                    break;
                }

            } catch (IOException | NullPointerException | StaleObjectException e) {
                e.printStackTrace();
            }
        }

    }

    public static UiObject2 findObjFromListByRes(String dire, String resourceId, String text, int instance, String operator) {

        try {
            UiScrollable scrollable = new UiScrollable(new UiSelector().resourceIdMatches(resourceId));
            scrollable.waitForExists(2000);

            if (dire.equals("Vertical")) {
                scrollable.setAsVerticalList();
            } else {
                scrollable.setAsHorizontalList();
            }

            if (objByText(text) == null) {
                scrollable.scrollToBeginning(scrollable.getMaxSearchSwipes());
            }

            scrollable.scrollIntoView(new UiSelector().textMatches(text).instance(instance));
            //scrollable.getChildByText(new UiSelector().textMatches(text).instance(instance), text);
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }

        if (operator.equals("click")) {
            clickByText(text);
        } else if (operator.equals("longPress")) {
            longPressObj(objByText(text));
        }

        testDetailLog(logFolder + "/TestDetail.html", logFolder + "/tmp.html", "findObjFromListByRes:" + dire + " " + resourceId);

        return objByText(text);
    }

    public static UiObject2 findObjFromListByClazz(String dire, String clazz, String text, int instance, String operator) {

        UiScrollable scrollable = new UiScrollable(new UiSelector().classNameMatches(clazz));
        //System.out.println("maxsearchswipes"+scrollable.getMaxSearchSwipes());
        //scrollable.setMaxSearchSwipes(3);
        if (dire.equals("Vertical")) {
            scrollable.setAsVerticalList();
        } else {
            scrollable.setAsHorizontalList();
        }

        try {
            if (objByText(text) == null) {
                scrollable.scrollToBeginning(scrollable.getMaxSearchSwipes());
            }
            scrollable.getChildByText(new UiSelector().text(text).instance(instance), text);
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }

        if (operator.equals("click")) {
            clickByText(text);
        } else if (operator.equals("longPress")) {
            longPressObj(objByText(text));
        }

        return objByText(text);
    }

    public static boolean slideTo(String dire, String typeParent, String strParent, int insParent, String typeChild, String strChild, int insChild, String operator) {
        UiObject2 parent = null;
        switch (typeParent) {
            case "res":
                parent = objByRes(strParent);
                break;
            case "text":
                parent = objByText(strParent);
                break;
            case "desc":
                parent = objByDesc(strParent);
                break;
            case "clazz":
                parent = objByClazz(strParent);
                break;
        }

        if (parent == null) {
            return false;
        }

        int top = parent.getVisibleBounds().top;
        int bottom = parent.getVisibleBounds().bottom;
        int left = parent.getVisibleBounds().left;
        int right = parent.getVisibleBounds().right;
        int centerX = parent.getVisibleBounds().centerX();
        int centerY = parent.getVisibleBounds().centerY();

        UiObject2 child = null;
        for (int i = 0; i < 10; i++) {

            if (typeChild.equals("res")) {
                if (objByRes(strChild, insChild) != null) {
                    child = objByRes(strChild, insChild);
                    break;
                }
            } else if (typeChild.equals("text")) {
                if (objByText(strChild, insChild) != null) {
                    child = objByText(strChild, insChild);
                    break;
                }
            } else if (typeChild.equals("clazz")) {
                if (objByClazz(strChild, insChild) != null) {
                    child = objByClazz(strChild, insChild);
                    break;
                }
            } else if (typeChild.equals("desc")) {
                if (objByDesc(strChild, insChild) != null) {
                    child = objByDesc(strChild, insChild);
                    break;
                }
            }

            if (dire.equals("left")) {
                mDevice.swipe(left + 1, centerY, right - 1, centerY, (right - left) / 4);
            } else if (dire.equals("right")) {
                mDevice.swipe(right - 1, centerY, left + 1, centerY, (right - left) / 4);
            } else if (dire.equals("up")) {
                mDevice.swipe(centerX, top + 1, centerX, bottom - 1, (bottom - top) / 4);
            } else if (dire.equals("down")) {
                mDevice.swipe(centerX, bottom - 150, centerX, top + 1, (bottom - top) / 4);
            }
        }

        if (operator.equals("click")) {
            child.click();
        } else if (operator.equals("longPress")) {
            longPressObj(child);
        }

        return true;
    }

    public static void longPressPower() {

        copyFile(tempFolder, "TestResource/", "LongPressPower");
        try {
            mDevice.executeShellCommand("monkey -f " + tempFolder + "/LongPressPower 1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void longPressMenu() {

        //copyFile(tempFolder, "TestResource/", "LongPressMenu");
        try {
            mDevice.executeShellCommand("sendevent /dev/input/event1 3 57 462");
            mDevice.executeShellCommand("sendevent /dev/input/event1 3 58 67");
            mDevice.executeShellCommand("sendevent /dev/input/event1 3 53 160");
            mDevice.executeShellCommand("sendevent /dev/input/event1 3 54 1350");
            mDevice.executeShellCommand("sendevent /dev/input/event1 1 330 1");
            mDevice.executeShellCommand("sendevent /dev/input/event1 0 0 0");
            mDevice.executeShellCommand("sendevent /dev/input/event1 3 58 66");
            mDevice.executeShellCommand("sendevent /dev/input/event1 0 0 0");
            sleep(2000);
            mDevice.executeShellCommand("sendevent /dev/input/event1 3 57 -1");
            mDevice.executeShellCommand("sendevent /dev/input/event1 1 330 0");
            mDevice.executeShellCommand("sendevent /dev/input/event1 0 0 0");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void backTimes(int times) {
        for (int i = 0; i < times; i++) {
            sleep(300);
            mDevice.pressKeyCode(KeyEvent.KEYCODE_BACK);
            //sleep(1000);
            testDetailLog(logFolder + "/TestDetail.html", logFolder + "/tmp.html", "back");

            //dumpXML();
        }
        sleep(500);
    }

    public static boolean packageVerify(String packageName) {
        return mDevice.getCurrentPackageName().equals(packageName);
    }

    public static void switchScreenTo(String dire) {
        if (dire.equals("left")) {
            mDevice.swipe(1, screenSizeHeight / 2, screenSizeWidth - 1, screenSizeHeight / 2, 50);
        } else if (dire.equals("right")) {
            mDevice.swipe(screenSizeWidth - 1, screenSizeHeight / 2, 1, screenSizeHeight / 2, 50);
        }
    }

    public static void copyFile(String folderPath, String assetsFolder, String fileName) {
        String filePath = folderPath + "/" + fileName;
        try {
            File dir = new File(folderPath);

            if (!dir.exists()) {
                dir.mkdirs();
            }
            File file = new File(filePath);
            //we delete the file if it exists.
//            if (file.exists()) {
//                file.delete();
//            }

            if (!file.exists()) {
                InputStream is = getContext().getAssets().open(assetsFolder + fileName);

                FileOutputStream fs = new FileOutputStream(file);
                byte[] buffer = new byte[1024];
                int count;
                while ((count = is.read(buffer)) > 0) {
                    fs.write(buffer, 0, count);
                }

                //Log.d(tag, "copyFile() performed");
                fs.flush();
                fs.close();
                is.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sleep(long waitTime) {
        SystemClock.sleep(waitTime);
    }

    public static void getMem(String testCaseName) {

        String pkgName = mDevice.getCurrentPackageName();
        File xls = new File(memoryFolder + "/" + pkgName + ".xls");
        if (!xls.exists()) {
            try {
                xls.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        PrintStream ps = null;
        try {
            ps = new PrintStream(new FileOutputStream(xls, true));
            System.setOut(ps);
            System.out.print(getDate());
            System.out.print("	");
            System.out.print(testCaseName);
            System.out.print("	");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            String dumpResult = mDevice.executeShellCommand("dumpsys meminfo " + pkgName);
            String[] result = dumpResult.split("\n");
            for (int i = 0; i < result.length; i++) {
                if (result[i].contains("TOTAL:")) {
                    Pattern p = Pattern.compile("[0-9]{1,}");
                    Matcher m = p.matcher(result[i]);

                    boolean findResult = m.find();
                    if (findResult) {
                        System.out.print(m.group());
                    } else {
                        System.out.print("could not match.");
                    }
                }
            }

            //System.out.println("dumpinfo:"+dumpResult);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
        if (ps != null) {
            ps.close();
        }
    }

    public static void errorHandling() {

        mDevice.registerWatcher("incomingCall", new UiWatcher() {
            @Override
            public boolean checkForCondition() {

                if (mDevice.hasObject(selectorByRes("com.android.incallui:id/incoming_reject"))) {

                    capScreenshot();

                    //hang up the call
                    clickByRes("com.android.incallui:id/incoming_reject");
                }
                if (mDevice.hasObject(selectorByText("请开启网络定位"))) {
                    clickByText("请开启网络定位");
                }
                return false; // no trigger
            }
        });

        mDevice.registerWatcher("crash", new UiWatcher() {
            @Override
            public boolean checkForCondition() {

                boolean flag = false;
                for (int i = 0; i < 2; i++) {
                    /*
                                        if (mDevice.wait(Until.hasObject(By.text(Pattern.compile("Unfortunately.*"))), 3000)) {
                                            capScreenshot();
                                            clickByText("OK");

                                            return true;
                                        }
                                        */

                    if (mDevice.hasObject(By.text(Pattern.compile(".*抱歉.*")))) {
                        capScreenshot();
                        if (objByText("确定") != null) {
                            clickByText("确定");
                        }
                        if (objByText("取消") != null) {
                            clickByText("取消");
                        }

                        flag = true;
                    }

                    //if (mDevice.wait(Until.hasObject(By.text(Pattern.compile(".*无响应.*\n\n.*"))), 3000)) {
                    if (mDevice.hasObject(By.text(Pattern.compile(".*无响应.*\\n\\n.*")))) {
                        capScreenshot();
                        if (objByText("确定") != null) {
                            clickByText("确定");
                        }
                        if (objByText("取消") != null) {
                            clickByText("取消");
                        }

                        flag = true;
                    }

                    if (mDevice.hasObject(By.text(Pattern.compile("立即更新")))) {
                        capScreenshot();
                        if (objByText("取消") != null) {
                            clickByText("取消");
                        }

                        flag = false;
                    }

                    if (mDevice.hasObject(By.text(Pattern.compile(".*正在尝试.*")))) {
                        capScreenshot();
                        if (objByText("拒绝.*") != null) {
                            clickByText("拒绝.*");
                        }

                        flag = false;
                    }
                }

                return flag;
            }
        });
    }

    public void setCurrentCycle(int currentCycle) {
        Template.currentCycle = currentCycle;

    }

    public void setStartTime(long startTime) {
        Template.startTime = startTime;
        testDetailLog(logFolder + "/TestDetail.html", logFolder + "/tmp.html", "start");
    }

    public int getRepeat() {
        //get paramter from command line and default value is 1.
        return Integer.valueOf(InstrumentationRegistry.getArguments().getString("Repeat", "1"));
    }

    public String getAPName() {

        return InstrumentationRegistry.getArguments().getString("APName", "Settings");
    }

    public static void outputDeviceInfo() {

        String productName = "";
        String SN = "";
        String SW = "";
        String Incremental = "";
        String SKUID = "";
        String androidPlatformVersion = "";
        String CPUModel = "";
        String SIMOperator = "";
        String MIUI = "";

        try {
            productName = mDevice.executeShellCommand("getprop ro.product.model").replaceAll("\r|\n", "");
            SN = mDevice.executeShellCommand("getprop ro.serialno").replaceAll("\r|\n", "");
            //SW = mDevice.executeShellCommand("getprop ro.build.display.id").replaceAll("\r|\n", "");
            MIUI = mDevice.executeShellCommand("getprop ro.miui.ui.version.name").replaceAll("\r|\n", "");
            if (!MIUI.equals("")) {
                SW = SW + " MIUI " + MIUI;
            }
            Incremental = mDevice.executeShellCommand("getprop ro.build.version.incremental").replaceAll("\r|\n", "");
            SW = SW + " " + Incremental;
            SKUID = mDevice.executeShellCommand("cat /hidden/data/CDALog/ID_Final").replaceAll("\r|\n", "");
            androidPlatformVersion = mDevice.executeShellCommand("getprop ro.build.version.release").replaceAll("\r|\n", "");
            CPUModel = mDevice.executeShellCommand("getprop ro.hardware").replaceAll("\r|\n", "");
            GetDeviceInfo.getSIMType();
            if (GetDeviceInfo.SIMCounter > 1) {
                SIMOperator = GetDeviceInfo.SIM1Operator + "," + GetDeviceInfo.SIM2Operator;
            } else {
                if (GetDeviceInfo.SIM1Operator.equals("") && GetDeviceInfo.SIM2Operator.equals("")) {
                    SIMOperator = "None";
                } else if (GetDeviceInfo.SIM1Operator.equals("")) {
                    SIMOperator = GetDeviceInfo.SIM2Operator;
                } else {
                    SIMOperator = GetDeviceInfo.SIM1Operator;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        String deviceInfo = "var deviceInfo = {\"ProductName\":\"" + productName + "\"," + "\"SN\":\"" + SN + "\"," + "\"SW\":\"" + SW + "\"," + "\"SKUID\":\"" + SKUID + "\"," + "\"androidPlatformVersion\":\"" + androidPlatformVersion + "\"," + "\"CPUModel\":\"" + CPUModel + "\"," + "\"SIMOperator\":\"" + SIMOperator + "\"};";
        deviceInfo = deviceInfo.replaceAll("\r|\n", "");
        //Log.d("carlLog", deviceInfo);
        updateJavascript(logFolder + "/result.js", logFolder + "/tmp.js", deviceInfo);


        /*PrintStream ps = null;
        try {
            //System.out.println("logFilePath:"+logFile);
            ps = new PrintStream(new FileOutputStream(jsonLogFile, true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setOut(ps);

        //get product name
        System.out.print("{\"ProductName\":\"" + mDevice.getProductName() + "\",");

        //get android platform
        try {
            System.out.print("\"AndroidVersion\":\"" + mDevice.executeShellCommand("getprop ro.build.version.release").replace("\n","") + "\",");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //get screen size
        System.out.println("\"ScreenSize\":\"" + mDevice.getDisplayWidth() +"*"+ mDevice.getDisplayHeight() + "\"},");

        ps.close();*/
    }

    public static void testDetailLog(String filePath, String tmpFile, String operation) {

        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new FileReader(filePath));
            bw = new BufferedWriter(new FileWriter(tmpFile));
            String line;

            while ((line = br.readLine()) != null) {

                if (line.contains("insert result to here")) {

                    if (operation.equals("start")) {
                        bw.write("\t<tr id=\"" + startTime + "\">" + "\n");
                    } else {
                        bw.write("\t<tr>" + "\n");
                    }

                    bw.write("\t\t<td>" + getDate() + "</td>" + "\n");
                    bw.write("\t\t<td>" + TCName + "</td>" + "\n");
                    bw.write("\t\t<td>" + currentCycle + "</td>" + "\n");
                    bw.write("\t\t<td>" + operation + "</td>" + "\n");
                    bw.write("\t</tr>" + "\n");

                    bw.write(line + "\n");

                } else {
                    bw.write(line + "\n");
                }
            }
        } catch (Exception e) {
            return;
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bw != null) {
                    bw.flush();
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // Once everything is complete, delete old file..
        File oldFile = new File(filePath);
        oldFile.delete();

        // And rename tmp file's name to old file name
        File newFile = new File(tmpFile);
        newFile.renameTo(oldFile);
    }

    public static void updateJavascript(String filePath, String tmpFile, String updateStr) {

        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new FileReader(filePath));
            bw = new BufferedWriter(new FileWriter(tmpFile));
            String line;
            while ((line = br.readLine()) != null) {

                if (line.contains("var deviceInfo") && updateStr.contains("deviceInfo")) {
                    bw.write(updateStr + "\n");
                    continue;
                }

                if (line.contains("insert test result to here") && !updateStr.contains("deviceInfo")) {
                    bw.write(updateStr + "\n");
                    bw.write(line + "\n");
                } else {
                    bw.write(line + "\n");
                }
            }
        } catch (Exception e) {
            return;
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bw != null) {
                    bw.flush();
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // Once everything is complete, delete old file..
        File oldFile = new File(filePath);
        oldFile.delete();

        // And rename tmp file's name to old file name
        File newFile = new File(tmpFile);
        newFile.renameTo(oldFile);
    }

    public static void logPass(long endTime) {

        PrintStream ps = null;
        try {
            ps = new PrintStream(new FileOutputStream(logFile, true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setOut(ps);

        System.out.print(getDate());
        System.out.print("	");
        System.out.print(TCName);
        System.out.print("	");
        System.out.print(currentCycle);
        System.out.print("	");
        System.out.print("Pass");
        System.out.print("	");
        System.out.print(countDuration(startTime, endTime));
        System.out.print("	");
        System.out.print("NA");
        System.out.print("	");
        System.out.println("NA");

        if (ps != null) {
            ps.close();
        }

        //output logs as json format
        ps = null;
        try {
            ps = new PrintStream(new FileOutputStream(jsonLogFile, true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setOut(ps);

        String result = "{\"TCDate\":\"" + getDate() + "\"," + "\"TCName\":\"" + TCName + "\"," + "\"TCStartTime\":\"" + startTime + "\"," + "\"TCRepeat\":\"" + currentCycle + "\"," + "\"TCResult\":\"" + "Pass" + "\"," + "\"TCDuration\":\"" + countDuration(startTime, endTime) + "\"," + "\"TCFailReason\":\"" + "NA" + "\"," + "\"TCFailScreenshot\":\"" + "NA" + "\"},";
        System.out.println(result);

//        System.out.print("{\"TCDate\":\"" + getDate() + "\",");
//        System.out.print("\"TCName\":\"" + TCName + "\",");
//        System.out.print("\"TCRepeat\":\"" + currentCycle + "\",");
//        System.out.print("\"TCResult\":\"" + "Pass" + "\",");
//        System.out.print("\"TCDuration\":\"" + countDuration(startTime, endTime) + "\",");
//        System.out.print("\"TCFailReason\":\"" + "NA" + "\",");
//        System.out.println("\"TCFailScreenshot\":\"" + "NA" + "\"},");

        if (ps != null) {
            ps.close();
        }

        updateJavascript(logFolder + "/result.js", logFolder + "/tmp.js", result);
    }

    public static void logFail(String failReason) {

        long endTime = System.nanoTime();
        if (screenshotFileName.equals("")) {
            capScreenshot();
        }

        logBackup();
        Launcher.backToHome();

        PrintStream ps = null;
        try {
            ps = new PrintStream(new FileOutputStream(logFile, true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setOut(ps);

        System.out.print(getDate());
        System.out.print("	");
        System.out.print(TCName);
        System.out.print("	");
        System.out.print(currentCycle);
        System.out.print("	");
        System.out.print("Fail");
        System.out.print("	");
        System.out.print(countDuration(startTime, endTime));
        System.out.print("	");
        System.out.print(failReason);
        System.out.print("	");
        System.out.println(screenshotFileName);

        if (ps != null) {
            ps.close();
        }

        //output logs as json format
        ps = null;
        try {
            //System.out.println("logFilePath:"+logFile);
            ps = new PrintStream(new FileOutputStream(jsonLogFile, true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setOut(ps);

        String result = "{\"TCDate\":\"" + getDate() + "\"," + "\"TCName\":\"" + TCName + "\"," + "\"TCStartTime\":\"" + startTime + "\"," + "\"TCRepeat\":\"" + currentCycle + "\"," + "\"TCResult\":\"" + "Fail" + "\"," + "\"TCDuration\":\"" + countDuration(startTime, endTime) + "\"," + "\"TCFailReason\":\"" + failReason + "\"," + "\"TCFailScreenshot\":\"" + screenshotFileName + "\"},";
        System.out.println(result);

//        System.out.print("{\"TCDate\":\"" + getDate() + "\",");
//        System.out.print("\"TCName\":\"" + TCName + "\",");
//        System.out.print("\"TCRepeat\":\"" + currentCycle + "\",");
//        System.out.print("\"TCResult\":\"" + "Fail" + "\",");
//        System.out.print("\"TCDuration\":\"" + countDuration(startTime, endTime) + "\",");
//        System.out.print("\"TCFailReason\":\"" + failReason + "\",");
//        System.out.println("\"TCFailScreenshot\":\"" + screenshotFileName + "\"},");

        if (ps != null) {
            ps.close();
        }

        updateJavascript(logFolder + "/result.js", logFolder + "/tmp.js", result);

        System.exit(0);
    }

    public void init(String tcName) {

        try {
            mDevice.executeShellCommand("mkdir -p " + imageFolder); // create image folder from SD card
            mDevice.executeShellCommand("mkdir -p " + memoryFolder);
            mDevice.executeShellCommand("mkdir -p " + bugFolder);
            mDevice.executeShellCommand("mkdir -p " + cpuFreqFolder);
            mDevice.executeShellCommand("mkdir -p " + cpuUsageFolder);
            mDevice.executeShellCommand("mkdir -p " + batteryInfoFolder);
            mDevice.executeShellCommand("mkdir -p " + logFolder);
            mDevice.executeShellCommand("mkdir -p " + tempFolder);

            mDevice.executeShellCommand("touch " + logFile);
            mDevice.executeShellCommand("touch " + jsonLogFile);
            //mDevice.executeShellCommand("touch " + detailLogFile);

        } catch (IOException e) {
            e.printStackTrace();
        }

        screenSizeWidth = mDevice.getDisplayWidth();
        screenSizeHeight = mDevice.getDisplayHeight();

        Template.TCName = tcName;

        //copy result.js to internal storage
        copyFile(logFolder, "TestResult/", "result.js");
        copyFile(logFolder, "TestResult/", "TestResult.html");
        copyFile(logFolder, "TestResult/", "TestDetail.html");
        //copyFile(tempFolder, "TestData/", "FIH.vcf");

        errorHandling();
    }

    public static boolean runRegisterWatcher() {

        return mDevice.hasAnyWatcherTriggered();
    }

    public static void removeRegisterWatcher() {

        mDevice.removeWatcher("incomingCall");
        mDevice.removeWatcher("crash");
    }

    public static void logBackup() {
//        String aprDB = "/data/data/com.fihtdc.stbmonitor/databases/APR_INFO.db";
//        String sql="sqlite3 " + aprDB + " \"select sum(count) from apr_info where tag !='SYSTEM_BOOT' and tag!='SYSTEM_LAST_KMSG' and tag not like '%wtf'\"";
//        try {
//            String errorCount = mDevice.executeShellCommand(sql);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.CHINA);

        String bugreportFileName = "bugreport_" + format.format(date);

        PrintStream ps = null;

        try {
            ps = new PrintStream(new FileOutputStream(bugFolder + "/" + bugreportFileName, true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setOut(ps);

        try {
            System.out.println(mDevice.executeShellCommand("bugreport"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (ps != null) {
            ps.close();
        }

    }

    public void test() {

        init(this.getClass().getPackage().getName() + "." + this.getClass().getSimpleName());
        setStartTime(System.nanoTime());
        Launcher.backToHome();

        //tcPrecondition();
        tcStep();

        Launcher.backToHome();

        if (!runRegisterWatcher()) {
            endTime = System.nanoTime();
            logPass(endTime);
        } else {
            logFail("crash happened");
        }

        removeRegisterWatcher();
    }

    protected void tcStep() {

    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}







