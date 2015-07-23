
package com.hb_module_llj.view;

import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hb_module_llj.R;
import com.fw.Engine;
import com.fw.view.BaseFragmentView;
import com.hb_module_common.AppConstants;
import com.hb_module_common.AppSystemBus;
import com.hb_module_llj.LLJAppConstants;
import com.hb_module_llj.bus.VCLLJGiftBus;

public class GiftModuleFoundFView extends BaseFragmentView
{

	private View cultureLayout;
	private View remindLayout;
	private View subjectLayout;
	private View msgCenterLayout;
	private View whocaremeLayout;
	private View blessshowLayout;
	private View inviteFriendsLayout;


	/******************************************************
	 * 
	 * 构造相关
	 * 
	 ******************************************************/
	public GiftModuleFoundFView()
	{
		super();
	}

	/**
	 * 预初始化
	 * 
	 * @author [谈唯雷]
	 * @E-mail [tianwang0944@126.com]
	 * @method [preInit]
	 * @retruntype [void]
	 * @exception
	 */
	@Override
	public void preInit(Map<String, Object> params)
	{
		super.preInit(params);
		this.viewName = GiftModuleFoundFView.class.getSimpleName();

	}

	/**
	 * 初始化
	 * 
	 * @author [谈唯雷]
	 * @E-mail [tianwang0944@126.com]
	 * @method [init]
	 * @param viewName
	 * @retruntype [void]
	 * @exception
	 */
	@Override
	public void init(Map<String, Object> params)
	{
		super.init(params);
	}

	@Override
	public void onAttach(Activity activity)
	{
		super.onAttach(activity);
	}

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState)
	{
		this.ssContentView = inflater.inflate(R.layout.page_hb_module_llj_found_ly, null);
		initView();
		initListener();
		return this.ssContentView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onStart()
	{
		super.onStart();
	}

	@Override
	public void onResume()
	{
		super.onResume();
	}

	@Override
	public void onPause()
	{
		super.onPause();
	}

	@Override
	public void onStop()
	{
		super.onStop();
	}

	@Override
	public void onDestroyView()
	{
		super.onDestroyView();
	}

	@Override
	public void onDestroy()
	{
		super.onDestroy();
	}

	@Override
	public void onDetach()
	{
		super.onDetach();
	}

	@Override
	public void dispose(Map<String, Object> params)
	{

		super.dispose(params);
	}

	@Override
	public void destroy(Map<String, Object> params)
	{
		super.destroy(params);
	}

	/*************************************************************************************
	 * 
	 * 
	 * 私有方法
	 * 
	 * 
	 * 
	 ************************************************************************************/
	 /**
	  * 初始化界面
	  * 
	  * 
	  * @author [sicmi]
	  * @date   [2015年7月6日]
	  * @retruntype [void]
	  * @exception
	  */
	private void initView()
	{
		//tf:Add[2015-07-16 23:04:09]{
		this.cultureLayout=this.ssContentView.findViewById(R.id.hb_module_llj_found_culture_ly);
		this.remindLayout=this.ssContentView.findViewById(R.id.hb_module_llj_found_remind_ly);
		this.subjectLayout=this.ssContentView.findViewById(R.id.hb_module_llj_found_subject_ly);
		this.msgCenterLayout=this.ssContentView.findViewById(R.id.hb_module_llj_found_msgcenter_ly);
		this.whocaremeLayout=this.ssContentView.findViewById(R.id.hb_module_llj_found_whocareme_ly);
		this.blessshowLayout=this.ssContentView.findViewById(R.id.hb_module_llj_found_blessshow_ly);
		this.inviteFriendsLayout=this.ssContentView.findViewById(R.id.hb_module_llj_found_invitefriends_ly);
		//}
	}

	private void initListener()
	{
		//tf:Add[2015-07-16 23:04:09]{
		this.cultureLayout.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				VCLLJGiftBus.getInstanceBus().enterFDView(LLjPolitenessFDView.class.getSimpleName());

			}
		});
		this.remindLayout.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				AppSystemBus.getInstanceBus().commonSignal.disptach(AppConstants.bus_flag, LLJAppConstants.bus_flag_enter_find_remind_page_view);

			}
		});
		this.subjectLayout.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

			}
		});
		this.msgCenterLayout.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

			}
		});
		this.whocaremeLayout.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

			}
		});
		this.blessshowLayout.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

			}
		});
		this.inviteFriendsLayout.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

			}
		});

		//}
}


}
