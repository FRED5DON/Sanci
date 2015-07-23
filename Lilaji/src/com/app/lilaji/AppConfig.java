
package com.app.lilaji;

import java.io.File;

import com.fw.EngineOptions;
import com.hb_module_common.model.AppStoreModel;
import com.hb_module_common.model.AppVersionInfo;
import com.hb_module_common.model.UserInfo;

public class AppConfig extends EngineOptions
{
    /**
     * log 开关
     */
    // public static final boolean LOG_OFF_ON = true;

    public AppConfig()
    {
        super();
        currStatus = RunningStatus.release;
        this.logLevel = INFO;
        /**
         * 应用编码
         */
        this.appCode = "zlz-appeme-upgrade";
        /**
         * 应用版本
         */
        // this.appVer=SystemManager.getVersion().toString();
        /**
         * api版本
         */
        this.apiVer = "giftServer";

        this.appVer = "/GiftApi";

        /**
         * 用户登录后的ID
         */
        this.userId = "";
        /**
         * 用户登录后的token
         */
        this.token = "";
        /**
         * 应用是否处于测试状态
         */
        this.isTest = false;

        /**
         * 正式API地址
         */
        this.http_url = "http://218.244.133.198:8080/";
        this.upload_url = "http://218.244.133.198:8080/";

        /**
         * 测试API地址
         */
        this.test_http_url = "http://218.244.133.198:8080/";
        this.test_upload_url = "http://218.244.133.198:8080/";

        String appExtPath = "EME" + File.separator + "llj";
        // 缓存相关
        tmpPath = appExtPath + File.separator + "tmp";
        // 数据库相关  
        dbPath = appExtPath + File.separator + "db";
        ldbName = dbPath + File.separator + "llj.db";

        ldbVersion = 1;

        // 本地文件目录结构
        sdFilePath.add(dbPath);
        sdFilePath.add(tmpPath);
        sdFilePath.add(appExtPath + File.separator + "images");
        sdFilePath.add(tmpPath + File.separator + "skins");

        initTheLDB();
    }

    /**
     * [描述]:本地数据库ormLite
     * 
     * @date [2014年4月9日 下午3:57:37]
     * @exception
     */
    public void initTheLDB()
    {
        dbmodelClassLst.add(AppStoreModel.class);
        dbmodelClassLst.add(AppVersionInfo.class);
        dbmodelClassLst.add(UserInfo.class);
    }
}
