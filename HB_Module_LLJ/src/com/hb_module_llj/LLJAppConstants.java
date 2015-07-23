
package com.hb_module_llj;

import android.os.Bundle;

import com.alibaba.fastjson.JSONObject;
import com.fw.Engine;
import com.fw.EngineOptions;
import com.fw.bus.IBusHandler;
import com.fw.utils.BundleBuilder;
import com.fw.utils.JsonBuilder;
import com.fw.utils.RequestParamBuilder;
import com.hb_module_common.AppSystemBus;
import com.hb_module_common.bus.VCMainBus;
import com.loopj.android.http.RequestParams;

public class LLJAppConstants 
{
	/******************************************************
	 * 
	 * 系统内业务逻辑的事件处理标志
	 * 
	 * 
	 * 
	 ******************************************************/

	//首页
	public static final String bus_flag_enter_main_page_view = "bus_flag_enter_main_page_view";

	//添加
	public static final String bus_flag_enter_create_page_view = "bus_flag_enter_create_page_view";

	//发现
	public static final String bus_flag_enter_search_page_view = "bus_flag_enter_search_page_view";

	//达人
	public static final String bus_flag_enter_super_page_view = "bus_flag_enter_super_page_view";

	//我的
	public static final String bus_flag_enter_me_page_view = "bus_flag_enter_me_page_view";


	//他人资料页
	public static final String bus_flag_enter_people_page_view = "bus_flag_enter_people_page_view";

	//如果详情页
	public static final String bus_flag_enter_rg_detail_page_view = "bus_flag_enter_rg_detail_page_view";
	
	//@region start 设置页
	//设置页
	public static final String bus_flag_enter_rg_settings_page_view = "bus_flag_enter_rg_settings_page_view";
	
	
	//修改个人信息
	public static final String bus_flag_enter_rg_settings_chguser_view = "bus_flag_enter_rg_settings_chguser_view";
	//修改密码
	public static final String bus_flag_enter_rg_settings_chgpwd_view = "bus_flag_enter_rg_settings_chgpwd_view";

	//告诉朋友
	public static final String bus_flag_enter_rg_settings_share_view = "bus_flag_enter_rg_settings_share_view";
	//关于我们
	public static final String bus_flag_enter_rg_settings_aboutus_view = "bus_flag_enter_rg_settings_aboutus_view";
	//反馈
	public static final String bus_flag_enter_rg_settings_feedback_view = "bus_flag_enter_rg_settings_feedback_view";
	//好评
	public static final String bus_flag_enter_rg_settings_proud_view = "bus_flag_enter_rg_settings_proud_view";
	
	//清除缓存
	public static final String bus_flag_enter_rg_settings_clrcache_view = "bus_flag_enter_rg_settings_clrcache_view";
	//版本更新
	public static final String bus_flag_enter_rg_settings_update_view = "bus_flag_enter_rg_settings_update_view";
	
	//@region end 设置页
	
	//完善资料
	public static final String bus_flag_enter_rg_perfectdata_page_view = "bus_flag_enter_rg_perfectdata_page_view";
	//添加心情
	public static final String bus_flag_enter_rg_addmotion_page_view = "bus_flag_enter_rg_addmotion_page_view";
	//添加背景音乐
	public static final String bus_flag_enter_rg_addmusic_page_view = "bus_flag_enter_rg_addmusic_page_view";
	//心情预览
	public static final String bus_flag_enter_rg_foreseen_page_view = "bus_flag_enter_rg_foreseen_page_view";
	
	
	//选择图片
    public static final String bus_flag_enter_rg_choose_page_view = "bus_flag_enter_rg_choose_page_view";



    //tf:Add:[2015-07-16 23:03:02]{
    
    /**发现事件派发中心**/
    
    //礼记文化
    public static final String bus_flag_enter_find_cultureLayout_page_view = "bus_flag_enter_find_cultureLayout_page_view";
    
    //送礼提醒
    public static final String bus_flag_enter_find_remind_page_view = "bus_flag_enter_find_remindLayout_page_view";
    
    //活动专题
    public static final String bus_flag_enter_find_subject_page_view = "bus_flag_enter_find_subjectLayout_page_view";
    
    //消息中心
    public static final String bus_flag_enter_find_msgCenter_page_view = "bus_flag_enter_find_msgCenterLayout_page_view";
    
    //谁关心我
    public static final String bus_flag_enter_find_whocareme_page_view = "bus_flag_enter_find_whocaremeLayout_page_view";
   
    //秀祝福
    public static final String bus_flag_enter_find_blessshow_page_view = "bus_flag_enter_find_blessshowLayout_page_view";
    
    //邀请朋友
    public static final String bus_flag_enter_find_inviteFriends_page_view = "bus_flag_enter_find_inviteFriendsLayout_page_view";
    
    /** 添加提醒**/
    public static final String bus_flag_enter_find_remind_add_page_view = "bus_flag_enter_find_remind_add_page_view";
    
    
    /** 预览提醒**/
    public static final String bus_flag_enter_find_remind_foreseen_page_view = "bus_flag_enter_find_remind_foreseen_page_view";
    //}
    

    /******************************************************
     * 
     * API相关
     * 
     * 
     * 
     ******************************************************/

    // 注册LLJ
    public static final String llj_action = "http://218.244.133.198:8080/giftServer/GiftApi/GiftAction.do?";


	/******************************************************
	 * 
	 * 公共方法
	 * 
	 * 
	 ******************************************************/
	/**
	 * 请求生命动力API
	 * 
	 * 
	 * 
	 * @author [wx]
	 * @date [2014-8-25]
	 * @param api
	 * @param getOrPost
	 * @param paramsStr
	 * @param handler
	 * @retruntype [void]
	 * @exception
	 */
	public static void loadSHTongMgData(String api , String getOrPost , JSONObject paramsStr , IBusHandler handler)
	{
		Engine.helperManager.httpHelper.loadData(getEHuiSuoMgApiUrl(api), getOrPost, buildRequestParams(paramsStr),
				handler);
	}

	/**
	 * 构建返回view的bundle对象
	 * 
	 * @param stackName
	 * @return
	 * @retruntype [Bundle]
	 * @exception
	 */
	public static Bundle buildViewBackBundle(String stackName)
	{
		return BundleBuilder.build().append(EngineOptions.flag_viewStack, stackName).commit();
	}

	public static AppSystemBus getAppSystemBus()
	{
		return (AppSystemBus) Engine.busManager.getBus(AppSystemBus.class.getSimpleName());
	}

	public static VCMainBus getVCMainBus()
	{
		return (VCMainBus) Engine.busManager.getBus(VCMainBus.class.getSimpleName());
	}

	/******************************************************
	 * 
	 * 私有方法
	 * 
	 * 
	 ******************************************************/
	/**
	 * 得到上传地址
	 * 
	 * 
	 * @author [vincent]
	 * @date [2014年7月4日]
	 * @return
	 * @retruntype [String]
	 * @exception
	 */
	public static String getUploadUrl()
	{
		if (Engine.config.isTest)
		{
			return Engine.config.test_upload_url;
		}
		return Engine.config.upload_url;
	}

	private static String getEHuiSuoMgApiUrl(String api)
	{
		String tmpStr = "";
		//
		if (Engine.config.isTest)
		{
			// 处于测试状态
			tmpStr = Engine.config.test_http_url + Engine.config.apiVer + Engine.config.appVer + api + "?";
		}
		else
		{
			tmpStr = Engine.config.http_url + Engine.config.apiVer + Engine.config.appVer + api + "?";
		}
		return tmpStr;
	}

	/**
	 * 构建请求参数
	 * 
	 * @param paramsStr
	 * @return
	 * @retruntype [RequestParams]
	 * @exception
	 */
	private static RequestParams buildRequestParams(JSONObject paramsStr)
	{

		paramsStr = JsonBuilder.build().append("appcode", Engine.config.appCode).append("data", paramsStr).commit();

		return RequestParamBuilder.build().append("params", paramsStr.toString()).commit();
	}
}