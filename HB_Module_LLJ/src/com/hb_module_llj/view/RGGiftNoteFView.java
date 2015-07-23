package com.hb_module_llj.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.hb_module_llj.R;
import com.fw.Engine;
import com.fw.view.BaseFragmentView;
import com.hb_module_common.AppConstants;
import com.hb_module_common.AppSystemBus;
import com.hb_module_llj.bus.VCLLJGiftBus;
import com.hb_module_llj.view.subview.GiftNoteGridView;
import com.hb_module_llj.view.subview.RGChooseSkinGridView;
import com.hb_module_llj.view.subview.RGViewPager;
import com.twl.uicomponents.common.ViewCallBack;

public class RGGiftNoteFView extends BaseFragmentView {

	private RGViewPager viewPager;
	private View activeDot;
	private View processDot;
	private View friendsDot;
	private List<View> dotList;
	private GiftNoteGridView getGiftGV;
	private GiftNoteGridView giveGiftGV;
	private View modifyTxt;

	/******************************************************
	 * 
	 * 构造相关
	 * 
	 ******************************************************/
	public RGGiftNoteFView() {
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
		this.viewName = RGGiftNoteFView.class.getSimpleName();

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
		// 全屏
		// setStyle(DialogFragment.STYLE_NORMAL,
		// android.R.style.Theme_Black_NoTitleBar);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		this.ssContentView = inflater.inflate(R.layout.page_gnote_ly,
				null);
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
		this.viewPager.ssStart(null);
		this.viewPager.setBackgroundColor(0);
		this.viewPager.refresh();
		this.viewPager.setCurrentPage(0);
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
		if (this.viewPager != null) {
			this.viewPager.ssDispose(params);
		}
	}

	@Override
	public void destroy(Map<String, Object> params) {
		super.destroy(params);
		if (this.viewPager != null) {
			this.viewPager.ssDestroy(params);
			this.viewPager = null;
		}
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
	 * @author [vincent]
	 * @date [2014年8月8日]
	 * @retruntype [void]
	 * @exception
	 */
	private void initView() {
		LinearLayout.LayoutParams lyp = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.FILL_PARENT);
		this.ssContentView.setLayoutParams(lyp);

		this.viewPager = (RGViewPager) this.ssContentView
				.findViewById(R.id.hb_rg_m_me_viewpager_pager);
		
		this.modifyTxt = this.ssContentView.findViewById(R.id.gift_modify_txt);

		getGiftGV = new GiftNoteGridView(getActivity(), null);
		giveGiftGV = new GiftNoteGridView(getActivity(), null);

		this.viewPager.addViewToShow("", this.getGiftGV, null);
		this.viewPager.addViewToShow("", this.giveGiftGV, null);
		getGiftGV.ssStart(null);
		this.viewPager.setCurrentPage(0);

		this.activeDot = this.ssContentView
				.findViewById(R.id.hb_rg_person_active_txt);
		this.processDot = this.ssContentView
				.findViewById(R.id.hb_rg_person_process_txt);
		dotList = new ArrayList<View>();
		dotList.add(activeDot);
		dotList.add(processDot);
		choseStateOfTab(dotList, 0);

	}

	private void initItemEvent() {

	}

	private void choseStateOfTab(List<View> dotList, int position) {
		if (dotList == null) {
			return;
		}
		for (int i = 0; i < dotList.size(); i++) {
			dotList.get(i).setSelected(i == position);

		}

		if (position == 0) {

			activeDot.setBackgroundResource(R.drawable.llj_r_select);
			processDot.setBackgroundResource(R.drawable.llj_r_def);

		} else {
			activeDot.setBackgroundResource(R.drawable.llj_l_defult);
			processDot.setBackgroundResource(R.drawable.llj_l_sel);
		}
	}

	/**
	 * 初始化监听
	 * 
	 * 
	 * @author [vincent]
	 * @date [2014年8月8日]
	 * @retruntype [void]
	 * @exception
	 */
	private void initListener() {

		((View) this.activeDot.getParent())
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						choseStateOfTab(dotList, 0);
						viewPager.setCurrentPage(0);
					}
				});
		((View) this.processDot.getParent())
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						choseStateOfTab(dotList, 1);
						viewPager.setCurrentPage(1);
					}
				});

		this.viewPager.setPageSelectedCallBack(new ViewCallBack() {

			@Override
			public void doCallBackBus(Bundle bundle) {
				int position = bundle.getInt("position");
				choseStateOfTab(dotList, position);
				switch (position) {
				case 0:
					getGiftGV.ssStart(null);

					break;
				case 1:
					giveGiftGV.ssStart(null);
					break;

				}
			}
		});
		
		this.modifyTxt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				VCLLJGiftBus.getInstanceBus().enterFDView(LLjReceivingLstFDView.class.getSimpleName());
			}
		});
	}

}