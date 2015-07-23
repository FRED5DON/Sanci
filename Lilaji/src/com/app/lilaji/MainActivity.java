
package com.app.lilaji;

import java.util.Map;

import android.os.Bundle;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window;

import com.app.lilaji.bus.VcGiftBus;
import com.app.lilaji.view.RGBottomMenuView;
import com.app.lilaji.view.SHTSplashFView;
import com.fw.AndroidApplication;
import com.fw.Engine;
import com.fw.EngineOptions;
import com.hb_module_common.AppConstants;
import com.hb_module_common.AppSystemBus;
import com.hb_module_common.bus.VCMainBus;
import com.hb_module_common.view.CommonAlertDetailsFDView;
import com.hb_module_common.view.CommonCheckVersionFDView;
import com.hb_module_common.view.CommonChoosePhoneFDView;
import com.hb_module_common.view.CommonRecordVoiceFDView;
import com.hb_module_common.view.CommonSpinnerFDView;
import com.hb_module_llj.bus.VCLLJGiftBus;
import com.hb_module_llj.view.GiftModuleAddGnoteFDView;
import com.hb_module_llj.view.GiftModuleAddRemindFDView;
import com.hb_module_llj.view.GiftModuleFoundFView;
import com.hb_module_llj.view.GiftModuleMainFView;
import com.hb_module_llj.view.GiftModuleMineFView;
import com.hb_module_llj.view.GiftModuleRemindsFDView;
import com.hb_module_llj.view.GiftModuleWriteInvitationFDView;
import com.hb_module_llj.view.LLSigninFDView;
import com.hb_module_llj.view.LLjAddReceivingFDView;
import com.hb_module_llj.view.LLjLoginFDView;
import com.hb_module_llj.view.LLjModifyInviateFDView;
import com.hb_module_llj.view.LLjMyinvitationLetterFView;
import com.hb_module_llj.view.LLjPolitenessFDView;
import com.hb_module_llj.view.LLjReceivingLstFDView;
import com.hb_module_llj.view.LLjRegisterFDView;
import com.hb_module_llj.view.RGChooseBgFDView;
import com.hb_module_llj.view.RGGiftNoteFView;
import com.login.bus.VCUserBus;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.twl.uicomponents.share.Constants;

public class MainActivity extends AndroidApplication
{

	public static IWXAPI api;

	public RGBottomMenuView bottomMenu;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);

		// 注：此行代码一定Engine初始前运行
		if (Engine.getInstance().isEngineOk)
		{
			// 全屏显示
			requestWindowFeature(Window.FEATURE_NO_TITLE);

			setContentView(R.layout.main);

			// 处理主容器
			Engine.viewManager.setMainContainer((ViewGroup) findViewById(R.id.appContainer));

			this.bottomMenu = (RGBottomMenuView) Engine.application.findViewById(R.id.main_menu_ly);

			api = WXAPIFactory.createWXAPI(this, Constants.APP_WEIXIN_ID, false);

			api.registerApp(Constants.APP_WEIXIN_ID);


		}
	}

	@Override
	protected void onPause()
	{
		super.onPause();
	}

	@Override
	protected void onResume()
	{
		super.onResume();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		return true;
	}

	/*******************************************************************
	 * 
	 * 接口覆盖方法
	 * 
	 * 
	 *******************************************************************/
	@Override
	public void ssPreInit(Map<String, Object> params)
	{

	}

	/**
	 * 初始化
	 * 
	 * @exception
	 * @see com.fw.AndroidApplication#ssInit()
	 */
	@Override
	public void ssInitEngine()
	{
		Engine.getInstance().initEngine(this, new AppConfig());
	}

	/**
	 * 根据业务需求覆盖此方法
	 * 
	 * @exception
	 * @see com.fw.IApplication#ssInitBus()
	 */
	@Override
	public void ssInitBus()
	{
		Engine.busManager.addBus(AppSystemBus.class.getSimpleName(), new AppSystemBus());

		Engine.busManager.addBus(VCMainBus.class.getSimpleName(), new VCMainBus());

		Engine.busManager.addBus(VCLLJGiftBus.class.getSimpleName(), new VCLLJGiftBus());

		Engine.busManager.addBus(VcGiftBus.class.getSimpleName(), new VcGiftBus());

		Engine.busManager.addBus(VCUserBus.class.getSimpleName(), new VCUserBus());
		// 创建view堆栈
		Engine.viewManager.viewStackMHandler.addBackStack(AppConstants.stack_main);
		Engine.viewManager.viewStackMHandler.changeViewStack(AppConstants.stack_main);

		/// 选择行业、营业额、城市
		Engine.viewManager.addDialogViewToCache(CommonSpinnerFDView.class.getSimpleName(), new CommonSpinnerFDView());

		// 输入内容
		Engine.viewManager.addDialogViewToCache(CommonAlertDetailsFDView.class.getSimpleName(),
				new CommonAlertDetailsFDView());
		// 声音上传界面
		Engine.viewManager.addDialogViewToCache(CommonRecordVoiceFDView.class.getSimpleName(),
				new CommonRecordVoiceFDView());
		// 版本更新界面
		Engine.viewManager.addDialogViewToCache(CommonCheckVersionFDView.class.getSimpleName(),
				new CommonCheckVersionFDView());
		// 图片上传界面
		Engine.viewManager.addDialogViewToCache(CommonChoosePhoneFDView.class.getSimpleName(),
				new CommonChoosePhoneFDView());
		// 礼记编辑
		Engine.viewManager.addDialogViewToCache(GiftModuleAddGnoteFDView.class.getSimpleName(),
				new GiftModuleAddGnoteFDView());
		// 收礼列表
		Engine.viewManager.addDialogViewToCache(LLjReceivingLstFDView.class.getSimpleName(),
				new LLjReceivingLstFDView());
		// 添加列表
		Engine.viewManager.addDialogViewToCache(LLjAddReceivingFDView.class.getSimpleName(),
				new LLjAddReceivingFDView());
		// 签到
		Engine.viewManager.addDialogViewToCache(LLSigninFDView.class.getSimpleName(),
				new LLSigninFDView());
		// 选择请帖皮肤
		Engine.viewManager.addDialogViewToCache(RGChooseBgFDView.class.getSimpleName(),
				new RGChooseBgFDView());

		// 邀请函
		Engine.viewManager.addDialogViewToCache(LLjModifyInviateFDView.class.getSimpleName(),
				new LLjModifyInviateFDView());
		//我的邀请函
		Engine.viewManager.addDialogViewToCache(LLjMyinvitationLetterFView.class.getSimpleName(),
				new LLjMyinvitationLetterFView());
		//礼记
		Engine.viewManager.addDialogViewToCache(LLjPolitenessFDView.class.getSimpleName(),
				new LLjPolitenessFDView());
		//礼记
		Engine.viewManager.addDialogViewToCache(GiftModuleWriteInvitationFDView.class.getSimpleName(),
				new GiftModuleWriteInvitationFDView());


		//tf:Add{
		//提醒列表
		Engine.viewManager.addDialogViewToCache(GiftModuleRemindsFDView.class.getSimpleName(),
				new GiftModuleRemindsFDView());
		//增加、预览提醒
		Engine.viewManager.addDialogViewToCache(GiftModuleAddRemindFDView.class.getSimpleName(),
				new GiftModuleAddRemindFDView());
		//登录
		Engine.viewManager.addDialogViewToCache(LLjLoginFDView.class.getSimpleName(),
				new LLjLoginFDView());

		//注册
		Engine.viewManager.addDialogViewToCache(LLjRegisterFDView.class.getSimpleName(),
				new LLjRegisterFDView());

		//}


		/**
		 * 页面
		 */
		//引导页
		Engine.viewManager.addViewToCache(SHTSplashFView.class.getSimpleName(), new SHTSplashFView());
		// 首页
		Engine.viewManager.addViewToCache(GiftModuleMainFView.class.getSimpleName(),
				new GiftModuleMainFView());
		// 我的
		Engine.viewManager.addViewToCache(GiftModuleMineFView.class.getSimpleName(),
				new GiftModuleMineFView());
		// 礼记
		Engine.viewManager.addViewToCache(RGGiftNoteFView.class.getSimpleName(),
				new RGGiftNoteFView());
		// 發現
		Engine.viewManager.addViewToCache(GiftModuleFoundFView.class.getSimpleName(),
				new GiftModuleFoundFView());

	}

	@Override
	public void ssInitOthers()
	{
		//加入国际化文件
		Engine.helperManager.localizationHelper.changeLang(EngineOptions.lang_zhCN,
				getResources().openRawResource(R.raw.lang_zhcn));

	}

	@Override
	public void ssStartService()
	{
	}

	@Override
	public void ssStopService()
	{
	}

	@Override
	public void ssBindService()
	{
	}

	@Override
	public void ssUnBindService()
	{
	}

	/**
	 * 应用入口
	 * 
	 * @author [谈唯雷]
	 * @method [ssEnterApp]
	 * @retruntype [void]
	 * @exception
	 */
	@Override
	public void ssEnterApp()
	{
		super.ssEnterApp();
		//进入欢迎页面
		VcGiftBus.getInstanceBus().enterApp();
	}

	@Override
	public void ssDispose()
	{
		super.ssDispose();
	}

	@Override
	public void ssDestroy()
	{
		super.ssDestroy();
	}
}