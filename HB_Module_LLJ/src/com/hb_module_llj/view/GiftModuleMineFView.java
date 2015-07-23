package com.hb_module_llj.view;

import java.util.ArrayList;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.hb_module_llj.R;
import com.fw.view.BaseFragmentView;
import com.hb_module_llj.bus.VCLLJGiftBus;
import com.hb_module_llj.view.subview.ActiveSkinHLstView;
import com.hb_module_llj.view.subview.ArtModuleLstSubView;
import com.hb_module_llj.view.subview.ImageCycleView;
import com.hb_module_llj.view.subview.ImageCycleView.ImageCycleViewListener;
import com.nostra13.universalimageloader.core.ImageLoader;

public class GiftModuleMineFView extends BaseFragmentView {

	private View myInviateLy;
	private View hb_llj_sign_ly;
	private View userIconImg;

	/******************************************************
	 * 
	 * 构造相关
	 * 
	 ******************************************************/
	public GiftModuleMineFView() {
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
	public void preInit(Map<String, Object> params) {
		super.preInit(params);
		this.viewName = GiftModuleMineFView.class.getSimpleName();

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
	public void init(Map<String, Object> params) {
		super.init(params);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		this.ssContentView = inflater.inflate(
				R.layout.page_hb_module_llj_mine_ly, null);
		initView();
		initListener();
		return this.ssContentView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onStart() {
		super.onStart();
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	public void onStop() {
		super.onStop();
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	@Override
	public void onDetach() {
		super.onDetach();
	}

	@Override
	public void dispose(Map<String, Object> params) {

		super.dispose(params);
	}

	@Override
	public void destroy(Map<String, Object> params) {
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
	 * @date [2015年7月6日]
	 * @retruntype [void]
	 * @exception
	 */
	private void initView() {
		this.myInviateLy = this.ssContentView
				.findViewById(R.id.hb_llj_m_myinviate_ly);
		this.hb_llj_sign_ly = this.ssContentView
				.findViewById(R.id.hb_llj_sign_ly);
		this.userIconImg = this.ssContentView
				.findViewById(R.id.llj_mine_user_icon);

	}

	private void initListener() {
		myInviateLy.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				VCLLJGiftBus.getInstanceBus().enterFDView(
						LLjMyinvitationLetterFView.class.getSimpleName());
			}
		});
		hb_llj_sign_ly.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				VCLLJGiftBus.getInstanceBus().enterFDView(
						LLSigninFDView.class.getSimpleName());
			}
		});

		userIconImg.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				VCLLJGiftBus.getInstanceBus().enterFDView(
						LLjLoginFDView.class.getSimpleName());

			};
		});

	}

}
