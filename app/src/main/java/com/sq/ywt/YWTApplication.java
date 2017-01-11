package com.sq.ywt;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.sq.ywt.utils.BitmapLruCache;

/**
 * Created by wsy on 2017/1/10.
 */

public class YWTApplication extends Application {
    /**
     * 全局统一一个实例，节省资源
     */
    private RequestQueue mRequestQueue;
    private static YWTApplication instance;
    /**
     * mImageLoader: 网络加载图片并缓存
     */
    private ImageLoader mImageLoader;
    private String dirPATH = "ywt_download";

    /**
     * @return The Volley Request queue, the queue will be created if it is null
     */
    public RequestQueue getRequestQueue() {
        // lazy initialize the request queue, the queue instance will be
        // created when it is accessed for the first time
        if (mRequestQueue == null) {
            synchronized (YWTApplication.class) {
                if (mRequestQueue == null) {
                    mRequestQueue = Volley
                            .newRequestQueue(getApplicationContext());
                }
            }
        }
        return mRequestQueue;
    }

    /**
     * @return
     * @Description:图片加载网络
     */
    public ImageLoader getImageLoader() {
        if (mImageLoader == null) {
            // int memClass = ((ActivityManager)
            // getSystemService(Context.ACTIVITY_SERVICE)).getMemoryClass();
            // // Use 1/8th of the available memory for this memory cache.
            // int cacheSize = 1024 * 1024 * memClass / 4;
            mImageLoader = new ImageLoader(getRequestQueue(),
                    new BitmapLruCache());
        }
        return mImageLoader;
    }

    public static YWTApplication getInstance() {
        if (instance == null) {
            instance = new YWTApplication();
        }
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //必须首先执行这部分代码, 如果在":TCMSSevice"进程中，无需进行云旺（OpenIM）和app业务的初始化，以节省内存;
//        SysUtil.setApplication(this);
//        if (SysUtil.isTCMSServiceProcess(this)) {
//            Log.d("BXstore", "isTCMSServiceProcess");
//            return;
//        }
//        // 第一个参数是Application Context
//        // 这里的APP_KEY即应用创建时申请的APP_KEY，同时初始化必须是在主进程中
//        if (SysUtil.isMainProcess()) {
//            Log.d("BXstore", "isMainProcess");
//            YWAPI.init(this, Constants.CS_APP_KEY);
//        }
        instance = this;
    }
}
