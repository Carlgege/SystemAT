package com.carl.utils;

import android.app.ApplicationErrorReport;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.BatteryManager;

import com.carl.template.Template;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by F3060772 on 2016/1/7.
 */
public class GetDeviceInfo {

    public static String SIM1Operator = "";
    public static String SIM2Operator = "";
    public static int SIMCounter = 0;

    //public TelephonyManager telephonyManager =  (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

    public static String getCpuType() {
        //get cpu type
        String cpuModel = "";
        try {
            cpuModel = Template.mDevice.executeShellCommand("getprop ro.hardware");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (cpuModel.startsWith("mt")) {
            return "MTK";
        } else if (cpuModel.startsWith("qt")) {
            return "QT";
        }
        return "UNKNOWN";
    }

    public static void getSIMType() {
        //get cpu type
        String cpuModel = "";
        try {

            cpuModel = Template.mDevice.executeShellCommand("getprop ro.hardware");

            //System.out.println("--carl--log--" + telephonyManager.getSimOperatorName());

            if (cpuModel.startsWith("mt")) {
                //SIM1Operator = Template.mDevice.executeShellCommand("getprop gsm.operator.alpha.1");
                //SIM2Operator = Template.mDevice.executeShellCommand("getprop gsm.operator.alpha.2");
                String simOperator = Template.mDevice.executeShellCommand("getprop gsm.sim.operator.alpha");
                if (simOperator.contains(",")) {

                    SIM1Operator = simOperator.substring(0, simOperator.indexOf(","));
                    SIM2Operator = simOperator.substring(simOperator.indexOf(","), simOperator.length() - 1);
                } else {
                    SIM1Operator = simOperator;
                }
            } else if (cpuModel.startsWith("qt")) {
                SIM1Operator = Template.mDevice.executeShellCommand("getprop gsm.operator.alpha.0");
                SIM2Operator = Template.mDevice.executeShellCommand("getprop gsm.operator.alpha.1");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!SIM1Operator.equals("")) {
            SIMCounter++;
        }
        if (!SIM2Operator.equals("")) {
            SIMCounter++;
        }
        if (SIM1Operator.contains("UNICOM")) {
            SIM1Operator = "UNICOM";
        }
        if (SIM2Operator.contains("UNICOM")) {
            SIM2Operator = "UNICOM";
        }
    }

    public static void getAndroidVersion() {


    }

    public static String getLauncherPackageName(Context context) {
        final Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        final ResolveInfo res = context.getPackageManager().resolveActivity(intent, 0);
        if (res.activityInfo == null) {
            // should not happen. A home is always installed, isn't it?
            return null;
        }
        if (res.activityInfo.packageName.equals("android")) {
            // 有多个桌面程序存在，且未指定默认项时；
            return null;
        } else {
            return res.activityInfo.packageName;
        }
    }

    public static void getStatus(String testCaseName) {

        //get device status:
        /*
                 *1. current process memory
                * 2. total memory use
                * 3. cpu freq
                * 4. cpu usage
                * 5. battery - capacity
                * 6. battery - voltage
                * 7. battery - current
                * 8. battery - temperature
                * 9. signal info
                 */



        System.out.println("mylogs--capacity" + BatteryManager.BATTERY_PROPERTY_CAPACITY);
        System.out.println("mylogs--capacity" + BatteryManager.EXTRA_TEMPERATURE);
        System.out.println("mylogs--capacity" + BatteryManager.BATTERY_PROPERTY_CURRENT_NOW);
        System.out.println("mylogs--capacity" + BatteryManager.BATTERY_PROPERTY_CAPACITY);



        String pkgName = Template.mDevice.getCurrentPackageName();
        File xls = new File(Template.memoryFolder + "/" + pkgName + ".xls");
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
            System.out.print(Template.getDate());
            System.out.print("	");
            System.out.print(testCaseName);
            System.out.print("	");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            String dumpResult = Template.mDevice.executeShellCommand("dumpsys meminfo " + pkgName);
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

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
        if (ps != null) {
            ps.close();
        }
    }

}
