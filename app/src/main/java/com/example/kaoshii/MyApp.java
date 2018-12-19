package com.example.kaoshii;

import android.app.Application;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

/**
 * Created by 马明祥 on 2018/12/17.
 */

public class MyApp extends Application {
    private static MyApp sMyApp;
    @Override
    public void onCreate() {
        super.onCreate();
        sMyApp = this;
        UMConfigure.setLogEnabled(true);
        UMConfigure.init(this, "5b248738a40fa37c010000a3", "MyYouMeng", UMConfigure.DEVICE_TYPE_PHONE, "");
        PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
    }
}
