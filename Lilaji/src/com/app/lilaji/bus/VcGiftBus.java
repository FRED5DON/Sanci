
package com.app.lilaji.bus;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;

import android.os.Message;
import android.view.View;

import com.alibaba.fastjson.JSONObject;
import com.app.lilaji.MainActivity;
import com.app.lilaji.view.RGBottomMenuView;
import com.app.lilaji.view.SHTSplashFView;
import com.fw.Engine;
import com.fw.EngineOptions;
import com.fw.bus.BaseBus;
import com.fw.bus.BaseBusHandler;
import com.fw.signals.Signal;
import com.fw.signals.SignalListener;
import com.fw.utils.JsonBuilder;
import com.fw.utils.RequestParamBuilder;
import com.hb_module_common.AppConstants;
import com.hb_module_common.AppSystemBus;
import com.hb_module_common.bus.VCMainBus;
import com.hb_module_common.model.UserInfo;
import com.hb_module_common.model.WXUserInfo;
import com.hb_module_llj.LLJAppConstants;
import com.hb_module_llj.view.GiftModuleAddRemindFDView;
import com.hb_module_llj.view.GiftModuleFoundFView;
import com.hb_module_llj.view.GiftModuleMainFView;
import com.hb_module_llj.view.GiftModuleMineFView;
import com.hb_module_llj.view.GiftModuleRemindsFDView;
import com.hb_module_llj.view.RGGiftNoteFView;
import com.login.bus.VCUserBus;
import com.loopj.android.http.RequestParams;
import com.twl.uicomponents.share.Constants;

public class VcGiftBus extends BaseBus
{
    
    /**
     * 单例
     *
     *
     * @author [王鑫]
     * @E-mail [wangxcom@126.com]
     * @Date 2015-4-24
     * @method {type_name}
     * @param @return
     * @return VCUserBus
     */
    public static VcGiftBus getInstanceBus()
    {
        return (VcGiftBus) Engine.busManager.getBus(VcGiftBus.class.getSimpleName());
    }

    /**
     * 微信获取Token、appid
     * 
     * 
     * @author [杨声明]
     * @E-mail[sicmi929@163.com]
     * @param @param code
     * @param code
     * @retruntype [void]
     * @exception
     */
    public void getWXToken(String code)
    {
        String httpUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?";

        RequestParams paramsStr = RequestParamBuilder.build().append("appid", Constants.APP_WEIXIN_ID)
                .append("secret", Constants.APP_WEIXIN_SECRET).append("code", code)
                .append("grant_type", "authorization_code").commit();

        BaseBusHandler tmpHandler = new BaseBusHandler()
        {

            @Override
            public void doLocalBus(final boolean isNetError , final String errType , final String errorMsg)
            {
                org.json.JSONObject jsonObject;
                try
                {
                    jsonObject = new org.json.JSONObject(errorMsg);
                    String access_token = jsonObject.getString("access_token");
                    String openid = jsonObject.getString("openid");
                    getWXUserInfo(access_token, openid);
                }
                catch (JSONException e)
                {
                    e.printStackTrace();

                }

            }

            @Override
            public void doNetBus(final JSONObject rs)
            {
            }
        };

        //发送请求
        Engine.helperManager.httpHelper.loadData(httpUrl, EngineOptions.GET, paramsStr, tmpHandler);
    }

    /**
     * 微信获取微信用户信息
     * 
     * 
     * @author [杨声明]
     * @E-mail[sicmi929@163.com]
     * @param @param code
     * @param code
     * @retruntype [void]
     * @exception
     */
    public void getWXUserInfo(final String access_token , final String openid)
    {
        String httpUrl = "https://api.weixin.qq.com/sns/userinfo?";
        RequestParams paramsStr = RequestParamBuilder.build().append("access_token", access_token)
                .append("openid", openid).commit();

        BaseBusHandler tmpHandler = new BaseBusHandler()
        {
            @Override
            public void doLocalBus(final boolean isNetError , final String errType , final String errorMsg)
            {
                WXUserInfo user = (WXUserInfo) JsonBuilder.getObjectFromJsonString(errorMsg, WXUserInfo.class);
                wxloginSht(access_token, openid, user);
            }

            @Override
            public void doNetBus(final JSONObject rs)
            {

            }
        };

        //发送请求
        Engine.helperManager.httpHelper.loadData(httpUrl, EngineOptions.GET, paramsStr, tmpHandler);
    }

    /**
     * 商海通wx登录界面
     *
     *
     * @author [王鑫]
     * @E-mail [wangxcom@126.com]
     * @Date 2015-5-23
     * @method {type_name}
     * @param @param loginName
     * @param @param password
     * @param @param remAcountAndPwd
     * @return void
     */
    public void wxloginSht(final String accessToken , final String openid , final WXUserInfo wxUserInfo)
    {
        Engine.viewManager.dialogMHandler.showProgressDialog(Engine.application);
        BaseBusHandler tmpHandler = new BaseBusHandler()
        {
            @Override
            public void doLocalBus(final boolean isNetError , final String errType , final String errorMsg)
            {
                //登录失败:后台验证错误
//                VCUserBus.getInstanceBus().doAfterLoginFailureBus();
            }

            @Override
            public void doNetBus(final JSONObject rs)
            {
                Engine.viewManager.dialogMHandler.dismissProgressDialog();

                UserInfo user = (UserInfo) JsonBuilder.getObjectFromJsonString(rs.getString("rs"), UserInfo.class);

                if (StringUtils.isEmpty(user.mobile))
                {
//                    VCUserBus.getInstanceBus().setOpenid(openid);
//                    Engine.viewManager.showDialog(
//                            Engine.viewManager.getDialogViewFromCache(SHTCompletePhoneFDView.class.getSimpleName()),
//                            false);

                }
                else
                {

                    //登录成功
                    AppSystemBus.getInstanceBus().setCurrLoginUserInfo(user);

//                    Engine.viewManager.dismissDialog(Engine.viewManager.getDialogViewFromCache(SHTMainHomeFDView.class
//                            .getSimpleName()));
//
//                    Engine.viewManager.showDialog(Engine.viewManager.getDialogViewFromCache(VCSHTCrowdfundBus
//                            .getInstanceBus().loginAfterViewName), false);
                }

            }
        };

        //发送请求
        AppConstants.loadSHTongMgData(
                AppConstants.shtong_base_loginwx,
                EngineOptions.GET,
                JsonBuilder.build().append("accessToken", accessToken).append("openid", openid)
                        .append("user", wxUserInfo).commit(), tmpHandler);
    }

    /*******************************************************************
     * 
     * 公共方法
     * 
     * 
     *******************************************************************/

    /**
     * 进入引导页
     *
     *
     * @author [王鑫]
     * @E-mail [wangxcom@126.com]
     * @Date 2015-4-24
     * @method {type_name}
     * @param 
     * @return void
     */
    public void enterApp()
    {
        VCMainBus.getInstanceBus().getInitData();

        VCUserBus.getInstanceBus().enterSplashView(SHTSplashFView.class.getSimpleName());
        
    }
    
    /**
	 * 设置底部菜单和pop显示状态
	 * 
	 * 
	 * @author [vincent]
	 * @date   [2014年8月8日]
	 * @param isVisible
	 * @retruntype [void]
	 * @exception
	 */
	public void makeBottomMenuVisible(boolean isVisible)
	{
		if (getBottomMenu() != null)
		{
			if (isVisible)
			{
				getBottomMenu().setVisibility(View.VISIBLE);
			}
			else
			{
				getBottomMenu().setVisibility(View.GONE);
			}
		}
	}

	/**
	 * 得到底部菜单
	 * 
	 * 
	 * @author [vincent]
	 * @date   [2014年8月14日]
	 * @return
	 * @retruntype [CommonMenuView]
	 * @exception
	 */
	public RGBottomMenuView getBottomMenu()
	{
		if (Engine.application instanceof MainActivity)
		{
			return ((MainActivity) (Engine.application)).bottomMenu;
		}
		return null;
	}

    /*******************************************************************
     * 
     * 私有方法
     * 
     * 
     *******************************************************************/
    /**
     * 处理业务逻辑
     *
     *
     * @author [王鑫]
     * @E-mail [wangxcom@126.com]
     * @Date 2015-4-24
     * @method {type_name}
     * @param @param signal
     * @param @param msg
     * @return void
     */
    private void doListenerBus(Signal signal , Message msg)
    {
        String flag = msg.getData().getString(AppConstants.bus_flag);

        if (flag.equals(AppConstants.bus_flag_splash_finish))
        {
            //闪屏结束:进入主界面
        	Engine.viewManager.enterPage(Engine.viewManager.getViewFromCache(GiftModuleMainFView.class.getSimpleName()));
        	
        	if (getBottomMenu() != null && getBottomMenu().getVisibility()==View.VISIBLE)
			{
			}else{
				makeBottomMenuVisible(true);
				getBottomMenu().ssStart(null);
			}
            
        }
        else if (flag.equals(AppConstants.bus_flag_enter_main_home_view))
        {
            //进入首页
        	Engine.viewManager.enterPage(Engine.viewManager.getViewFromCache(GiftModuleMainFView.class.getSimpleName()));
        }
        else if (flag.equals(LLJAppConstants.bus_flag_enter_me_page_view))
        {
        	//进入个人中心
        	Engine.viewManager.enterPage(Engine.viewManager.getViewFromCache(GiftModuleMineFView.class.getSimpleName()));
        }
        else if (flag.equals(LLJAppConstants.bus_flag_enter_search_page_view))
        {
        	//进入礼记
        	getBottomMenu().setAllBtnNoSelected();
        	getBottomMenu().searchTab.setSelected(true);
        	Engine.viewManager.enterPage(Engine.viewManager.getViewFromCache(RGGiftNoteFView.class.getSimpleName()));
        }
        else if (flag.equals(LLJAppConstants.bus_flag_enter_super_page_view))
        {
        	//进入礼记
        	Engine.viewManager.enterPage(Engine.viewManager.getViewFromCache(GiftModuleFoundFView.class.getSimpleName()));
        }
        else if (flag.equals(AppConstants.bus_flag_enter_login_view))
        {
            //主界面：进入登录界面

        }
        else if (flag.equals(AppConstants.bus_flag_login_exit))
        {
            //主界面：退出登录界面
        }
        else if (flag.equals(AppConstants.bus_flag_enter_register_view))
        {
            //主界面：进入注册界面

        }
        else if (flag.equals(AppConstants.bus_flag_exit_register_view))
        {
            //主界面：退出注册界面

        }
        else if (flag.equals(AppConstants.bus_flag_enter_complete_view))
        {
            //进入完善资料界面

        }
        else if (flag.equals(AppConstants.bus_flag_exit_complete_view))
        {
            //退出完善资料界面
        }
      //tf:Add[2015-07-17 00:24:34]{
        else if (flag.equals(LLJAppConstants.bus_flag_enter_find_remind_page_view))
        {
        	//提醒列表
        	enterFDView(GiftModuleRemindsFDView.class.getSimpleName());
        }
        else if (flag.equals(LLJAppConstants.bus_flag_enter_find_remind_add_page_view))
        {
            //增加提醒
        	enterFDView(GiftModuleAddRemindFDView.class.getSimpleName());
        }
        else if (flag.equals(LLJAppConstants.bus_flag_enter_find_remind_foreseen_page_view))
        {
            //预览提醒
        	enterFDView(GiftModuleAddRemindFDView.class.getSimpleName());
        }
        
        //}
    }

    
 //tf:add[2015-07-17 00:21:16]{
    
    /**
     * 跳转Fragment
     * @param viewName
     */
    public void enterFView(String viewName)
    {
    	Engine.viewManager.enterPage(Engine.viewManager.getViewFromCache(viewName));
    }
    
    /**
     * 跳转FragmentDialog
     * @param viewName
     */
    public void enterFDView(String viewName)
    {
    	Engine.viewManager.showDialog(Engine.viewManager.getDialogViewFromCache(viewName),false);
    }
    
    //}
    
    /*******************************************************************
     * 
     * 接口方法
     * 
     * 
     *******************************************************************/

    @Override
    public void init(Map<String, Object> params)
    {
        super.init(params);

        AppSystemBus.getInstanceBus().commonSignal.addListener(new SignalListener()
        {

            @Override
            public void execute(Signal signal , Message msg)
            {
                doListenerBus(signal, msg);
            }
        }, 0);

    }

    @Override
    public void preInit(Map<String, Object> params)
    {

    }

    @Override
    public void reset(Map<String, Object> params)
    {
    }

    @Override
    public void pause(Map<String, Object> params)
    {
    }

    @Override
    public void start(Map<String, Object> params)
    {
    }

    @Override
    public void dispose(Map<String, Object> params)
    {
        super.dispose(params);
    }

    @Override
    public void destory(Map<String, Object> params)
    {
        super.destory(params);
    }

    public VcGiftBus()
    {
        preInit(null);
    }
}
