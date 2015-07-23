package com.hb_module_llj.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import com.example.hb_module_llj.R;
import com.fw.Engine;
import com.fw.view.BaseDialogFragmentView;
import com.hb_module_llj.bus.VCLLJGiftBus;
import com.hb_module_llj.model.SkinLabel;
import com.hb_module_llj.view.adapter.CommonLstVH.vhEvent;
import com.hb_module_llj.view.adapter.CopyOfRGSkinInfoSetVH;
import com.hb_module_llj.view.adapter.GiftLabelHVH;
import com.hb_module_llj.view.subview.CommonGridSubView;
import com.hb_module_llj.view.subview.CommonlHLstSubView;
import com.hb_module_llj.view.subview.RGChooseSkinGridView;

public class RGChooseBgFDView extends BaseDialogFragmentView {

	/******************************************************
	 * 
	 * 构造相关
	 * 
	 ******************************************************/

	private View backView;

	private View createView;

	/**
	 * 头像
	 */
	private View headView;

	private View addpicIv;

	private View imgV1;

	private View imgV2;

	private View imgV3;

	private View imgV4;

	private View imgV5;

	private CommonGridSubView sSkinGridView;

	private CommonlHLstSubView<SkinLabel> labelHLst;

	public RGChooseBgFDView() {
		super();
	}

	/******************************************************
	 * 
	 * 接口相关的方法
	 * 
	 ******************************************************/
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
		this.viewName = RGChooseBgFDView.class.getSimpleName();

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

		setStyle(DialogFragment.STYLE_NORMAL,
				android.R.style.Theme_Black_NoTitleBar);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		this.ssContentView = inflater.inflate(R.layout.page_hb_choose_skin_ly,
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
		this.sSkinGridView.resetData(0, 9);
		this.labelHLst.resetData();
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

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		return super.onCreateDialog(savedInstanceState);
	}

	/*******************************************************************
	 * 
	 * 私有方法
	 * 
	 * 
	 *******************************************************************/

	/**
	 * 初始化View
	 * 
	 * @retruntype [void]
	 * @exception
	 */
	private void initView() {
		this.backView = this.ssContentView
				.findViewById(R.id.hb_rg_launch_back_rl);
		this.sSkinGridView = (CommonGridSubView<String>) this.ssContentView
				.findViewById(R.id.page_hb_rg_launch_choose_skin_gv);
		
		List<String> labels1 = new ArrayList<String>();

		for (int i = 0; i < 6; i++) {
			
				labels1.add("1");

		}
		
		this.sSkinGridView.init(R.layout.page_hb_llj_skin_item_ly, labels1, 2,CopyOfRGSkinInfoSetVH.class);

		this.labelHLst = (CommonlHLstSubView<SkinLabel>) this.ssContentView
				.findViewById(R.id.page_hb_module_llj_label_h_lst_view);

		
		this.labelHLst.init(R.layout.page_hb_llj_label_item_ly, VCLLJGiftBus.getInstanceBus().labels, 10,
				GiftLabelHVH.class);

	}

	private void initListener() {
		
		
		
		
		this.backView.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Engine.viewManager.getDialogViewFromCache(
						RGChooseBgFDView.class.getSimpleName()).dismiss();

			}
		});

		this.labelHLst.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
//				labelHLst.scrollTo(arg2 * 150);
				for (int i = 0; i < VCLLJGiftBus.getInstanceBus().labels.size(); i++) {
					if (i == arg2) {
						VCLLJGiftBus.getInstanceBus().labels.get(i).isSelect = true;
					}else {
						VCLLJGiftBus.getInstanceBus().labels.get(i).isSelect = false;
					}
				}
				labelHLst.init(R.layout.page_hb_llj_label_item_ly, VCLLJGiftBus.getInstanceBus().labels, 10,
						GiftLabelHVH.class);
				
				labelHLst.resetData();
			}
		});

		
		this.sSkinGridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				VCLLJGiftBus.getInstanceBus().enterFDView(LLjModifyInviateFDView.class.getSimpleName());
				
			}
		});
		// this.addpicIv.setOnClickListener(new View.OnClickListener()
		// {
		//
		// @Override
		// public void onClick(View v)
		// {
		// AppConstants.getAppSystemBus().commonSignal.disptach(AppConstants.bus_flag,
		// RGAppConstants.bus_flag_enter_rg_launch_page_view);
		// }
		// });

	}

}
