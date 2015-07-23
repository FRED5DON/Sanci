
package com.app.lilaji.view;

import java.util.Map;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.app.lilaji.R;
import com.fw.view.IBaseView;
import com.hb_module_common.AppConstants;
import com.hb_module_common.AppSystemBus;
import com.hb_module_llj.LLJAppConstants;

public class RGBottomMenuView extends RelativeLayout implements IBaseView, View.OnClickListener
{


	public View homeTab;
	public View searchTab;
	public View superTab;
	public View meTab;

	public RGBottomMenuView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		initViews(context, attrs);
		initListener();
	}




	/**
	 * 初始化view
	 * 
	 * 
	 * @author [vincent]
	 * @date [2014年8月1日]
	 * @param context
	 * @param attrs
	 * @retruntype [void]
	 * @exception
	 */
	private void initViews(Context context , AttributeSet attrs)
	{
		LayoutInflater.from(context).inflate(R.layout.page_hb_rg_menu_ly, this);
		this.homeTab =  this.findViewById(R.id.hb_rg_menu_home_ly);
		this.searchTab =  this.findViewById(R.id.hb_rg_menu_search_ly);
		this.superTab =  this.findViewById(R.id.hb_rg_menu_super_ly);
		this.meTab =  this.findViewById(R.id.hb_rg_menu_me_ly);
		this.homeTab.setSelected(true);

	}

	private void initListener()
	{
		this.homeTab.setOnClickListener(this);
		this.searchTab.setOnClickListener(this);
		this.superTab.setOnClickListener(this); 
		this.meTab .setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		
		if(v.isSelected()) return;
		
		if(v==this.homeTab){
			//首页
			 AppSystemBus.getInstanceBus().commonSignal.disptach(AppConstants.bus_flag,
		                AppConstants.bus_flag_enter_main_home_view);
		}
		else if(v==this.searchTab){
			//礼记
			AppSystemBus.getInstanceBus().commonSignal.disptach(AppConstants.bus_flag,
					LLJAppConstants.bus_flag_enter_search_page_view);
		}
		else if(v==this.superTab){
			//发现
			AppSystemBus.getInstanceBus().commonSignal.disptach(AppConstants.bus_flag,
					LLJAppConstants.bus_flag_enter_super_page_view);
		}
		else if(v==this.meTab){
			//我的
			AppSystemBus.getInstanceBus().commonSignal.disptach(AppConstants.bus_flag,
					LLJAppConstants.bus_flag_enter_me_page_view);
		}
		setAllBtnNoSelected();
        v.setSelected(true);
	}

	/**
	 * 设置所有按钮为非选中状态
	 * 
	 * 
	 * @author [vincent]
	 * @date [2014年8月8日]
	 * @retruntype [void]
	 * @exception
	 */
	public void setAllBtnNoSelected()
	{
		this.homeTab.setSelected(false);
		this.searchTab.setSelected(false);
		this.superTab.setSelected(false);
		this.meTab.setSelected(false);
	}

	/********************************************************************************
	 * 
	 * 接口方法
	 * 
	 * 
	 * 
	 ********************************************************************************/
	@Override
	public void ssPreInit(Map<String, Object> arg0)
	{
	}

	@Override
	public void ssCreateView(Map<String, Object> arg0)
	{
	}

	@Override
	public void ssDestoryView(Map<String, Object> arg0)
	{
	}

	@Override
	public void ssDestroy(Map<String, Object> arg0)
	{
		this.homeTab = null;
		this.searchTab= null;
		this.superTab= null;
		this.meTab= null;

	}

	@Override
	public void ssDispose(Map<String, Object> arg0)
	{
	}

	@Override
	public void ssPause(Map<String, Object> arg0)
	{
	}

	@Override
	public void ssResume(Map<String, Object> arg0)
	{
	}

	@Override
	public void ssStart(Map<String, Object> arg0)
	{

	}

	@Override
	public void ssStop(Map<String, Object> arg0)
	{
	}

}
