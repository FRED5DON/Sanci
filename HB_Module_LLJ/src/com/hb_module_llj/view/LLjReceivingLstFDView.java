package com.hb_module_llj.view;

import java.util.ArrayList;
import java.util.Map;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.example.hb_module_llj.R;
import com.fw.Engine;
import com.fw.view.BaseDialogFragmentView;
import com.hb_module_llj.bus.VCLLJGiftBus;
import com.hb_module_llj.view.adapter.ListVisitAdapter;
import com.hb_module_llj.view.subview.RGChooseSkinGridView;

public class LLjReceivingLstFDView extends BaseDialogFragmentView {

	/******************************************************
	 * 
	 * 构造相关
	 * 
	 ******************************************************/

	private View backView;

	private View addIv;

	private ListView receviceLst;

	private EditText searchEdt;

	public LLjReceivingLstFDView() {
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
		this.viewName = LLjReceivingLstFDView.class.getSimpleName();

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
		this.ssContentView = inflater.inflate(R.layout.page_receiving_lst_ly,
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

		this.receviceLst = (ListView) this.ssContentView
				.findViewById(R.id.page_receiver_lst);

		this.addIv = (ImageView) this.ssContentView
				.findViewById(R.id.llj_add_recevice_iv);
		
		this.searchEdt = (EditText)this.ssContentView.findViewById(R.id.recevice_search_edt);
		
		ArrayList<String> strings = new ArrayList<String>();
		
		for (int i = 0; i <8; i++) {
			strings.add("1");
		}
		
		this.receviceLst.setAdapter(new ListVisitAdapter(getActivity(), strings));

	}

	private void initListener() {
		this.backView.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Engine.viewManager.getDialogViewFromCache(
						LLjReceivingLstFDView.class.getSimpleName()).dismiss();

			}
		});

		this.addIv.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				VCLLJGiftBus.getInstanceBus().enterFDView(LLjAddReceivingFDView.class.getSimpleName());
			}
		});
		
		this.searchEdt.setOnEditorActionListener(new OnEditorActionListener() {
			
			@Override
			public boolean onEditorAction(TextView tv, int actionId, KeyEvent event) {
				
				if (actionId==EditorInfo.IME_ACTION_SEARCH ||(event!=null&&event.getKeyCode()== KeyEvent.KEYCODE_ENTER)) 

				{                

				//do something;   
					Engine.viewManager.toastMHandler.toastMsg("搜索");

				return true; 
				}
				
				return false;
			}
		});

	}

}
