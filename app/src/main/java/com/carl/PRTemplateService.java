package com.carl;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.telephony.TelephonyManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PRTemplateService extends Service {

	private static final int slotId = 1;
	String result = null;
	
	public static String imei = "";
	public static String imei2 = "";
	//public static String model;
	public static String sw;
	public static String hw;
	public static String sn;
	public static String emmc;
	public static String cpuType;
	public static String dramInfo;
	public static String touchPanel;
	public static String frontCam;
	public static String mainCam;
	public static String batteryType;
//	public static String fingerPrint;

	@SuppressLint("SdCardPath")
	public int onStartCommand(Intent intent, int flags, int startId ) {

		//create a pr template file
		File sdCard = Environment.getExternalStorageDirectory();
		File prFolder = new File (sdCard.getAbsolutePath() + "/ShellResult/Temp");
		boolean f = prFolder.mkdirs();
        File PR = new File(prFolder, "PR.txt");
		f = PR.delete();

		try {
			FileOutputStream fos = new FileOutputStream(PR);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			osw.write("ID&Name&Email:" + "\r\n");
			osw.write("[前提条件]" + "\r\n");
			osw.write("1.软件版本:"+ getSW() + "\r\n");
			osw.write("2.硬件版本:"+ getHW() + "\r\n");
			osw.write("3.IMEI:" + getImei() + "\r\n");
			osw.write("4.序列号:" + getSN() + "\r\n" + "\r\n");
			
			osw.write("[复现步骤]" + "\r\n" + "1." + "\r\n" + "2." + "\r\n" + "3." + "\r\n" + "\r\n");
			osw.write("[实际结果]" + "\r\n" + "1." + "\r\n");
			osw.write("[期望结果]" + "\r\n" + "1." + "\r\n");
			osw.write("[复现概率]" + "\r\n" + "\r\n");
			osw.write("[附加信息]"  + "\r\n" + "发生时间:" + "\r\n" +
                    "CPU:" + getCpuType() + "\r\n" + "Dram:" + getDramInfo() + "\r\n" +
			        "Emmc:"+ getEmmc() + "\r\n" + "Fingerprint:" + "\r\n" +
                    "Touch panel firmware:" + getTouchPanel() + "\r\n" + "FrontCam:" + getFrontCam() + "\r\n" +
                    "MainCamera:" + getMainCam() + "\r\n" +"Battery:" + getBattery() + "\r\n" );

			osw.flush();
			osw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return START_STICKY;
	}

    /*
	//get phone model
	public String getModel() {
		
		try {
			model = exec("getprop ro.product.model");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return model;
	}
    */

	//get phone sw
	public String getSW() {
		
		sw = android.os.Build.DISPLAY;
		try {
			sw = exec("getprop ro.build.version.incremental");
			sw = android.os.Build.DISPLAY + " " + sw;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sw;
	}
	
	//get phone hw 
    // it only work on infocus
	public String getHW() {
		
		try {
			hw = exec("cat /proc/bandinfo");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return hw;
	}	
	
	//get phone imei
	@SuppressLint("NewApi")
	public String getImei() {
		
		TelephonyManager tm = (TelephonyManager) this.getSystemService(TELEPHONY_SERVICE);  
		imei = tm.getDeviceId();
		imei2 = tm.getDeviceId(slotId);
		String IMEI = null;
		if(imei != null & imei2 != null) {
			IMEI = imei + "/" + imei2;
		} else if(imei == null & imei2 != null) {
			IMEI=imei2;
		} else if(imei != null & imei2 == null) {
			IMEI=imei;
		}
		return IMEI;
	}	
	
	//get phone serial number
	public String getSN() {
		sn = android.os.Build.SERIAL;
		return sn;
	}
	
	//get emmc(2+16\3+32\4+64)
	public String getEmmc() {
		
		try {
			emmc=exec("cat /proc/AllHWList/emmcinfo");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return emmc;
	}
	
	public String getCpuType() {
		
		try {
			cpuType = exec("cat /sys/devices/soc0/machine");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cpuType;
	}
	
    public String getDramInfo() {
		
		try {
			dramInfo = exec("cat /proc/AllHWList/draminfo");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dramInfo;
	}
	
    //get Touch panel firmware
    public String getTouchPanel() {
		
		try {
			touchPanel = exec("cat /sys/android_touch/ftmgetversion");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return touchPanel;
	}
    
    /*    
    public String getFingerprint() {
    	
    	String fingerprint = null;
    	String command = null;
		try {
//			command = exec();
			command = exec("cat /sys/devices/soc/soc:fpc1020/fpc_exist");
			Log.d("miacommand:", "hello"+command);
		} catch (IOException e) {

			e.printStackTrace();
		}
//    	int get=Integer.parseInt(command);
//    	Log.d("miaresult", command+"");
  
//    	System.out.println("miacommand:"+command);
    	
    	if (command!=null){
    		fingerprint="ftp";
    	} else {
    		fingerprint="goodxi";
    	}    	
    	return fingerprint;
    }
    
    public String getFingerprint(String path) {
    	
    	String Info = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path), 256);
            try {
                Info = reader.readLine();
            } finally {
                reader.close();
            }
        }catch (Exception e) {
//            FQCLog.Loge("IOException : " + e.getMessage());
        }
        
        return "1".equalsIgnoreCase(Info) ? "FPC" : "Goodix";
        
        }
    */
    
    public String getFrontCam() {
    	try {
			frontCam = exec("cat /proc/FrontCam");
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return frontCam;
    }
	
    public String getMainCam() {
    	try {
			mainCam = exec("cat /proc/MainCam");
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return mainCam;
    }
    
    public String getBattery() {
    	try {
			batteryType = exec("cat /sys/class/power_supply/bms/battery_type");
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return batteryType;
    }

	public String exec(String command) throws IOException {
		
		try {
			String[] cmd = new String[]{"sh", "-c", command};
			Process ps = Runtime.getRuntime().exec(cmd);

			BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line).append("\n");
			}
			
			result = sb.toString();
			
			} catch (Exception e) {
				e.printStackTrace();
			}

		return result;
	}

	public void onDestroy() {
		super.onDestroy();
	}

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
