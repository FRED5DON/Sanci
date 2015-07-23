package com.hb_module_llj.view;

import java.util.Map;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;

import com.example.hb_module_llj.R;
import com.fw.Engine;
import com.fw.utils.CollectionUtils;
import com.fw.view.BaseDialogFragmentView;
import com.hb_module_common.view.imgviewpager.ImageViewPagerContainer;
import com.hb_module_llj.bus.VCLLJGiftBus;

public class LLjModifyInviateFDView extends BaseDialogFragmentView {

	private View backView;

	private ImageViewPagerContainer imageViewPagerContainer;

	private ViewPager pager;

	private View write;
	/******************************************************
	 * 
	 * 构造相关
	 * 
	 ******************************************************/
	public LLjModifyInviateFDView() {
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
		this.viewName = LLjModifyInviateFDView.class.getSimpleName();

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
		this.ssContentView = inflater.inflate(R.layout.page_llj_write_letter_ly,
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

		if (!CollectionUtils.isEmpty(VCLLJGiftBus.getInstanceBus().imgLst))
		{
			//            this.imageViewPagerContainer
			//            .setDataSourceAndTileData(VCLLJGiftBus.getInstanceBus().imgLst, null);
			//            
			//            this.imageViewPagerContainer.setCurrentPage(0);
			pager.setAdapter(new PagerAdapter() {


				@Override
				public boolean isViewFromObject(View arg0, Object arg1) {
					// TODO Auto-generated method stub
					return arg0 ==arg1;
				}

				@Override
				public int getCount() {
					// TODO Auto-generated method stub
					return Integer.MAX_VALUE;
				}

				@Override
				public void destroyItem(ViewGroup container, int position,
						Object object) {
					// TODO Auto-generated method stub
					container.removeView(VCLLJGiftBus.getInstanceBus().imgLst.get(position % VCLLJGiftBus.getInstanceBus().imgLst.size()));  

				}

				@Override
				public Object instantiateItem(ViewGroup container, int position) {

					ViewGroup parent = (ViewGroup) VCLLJGiftBus.getInstanceBus().imgLst.get(position % VCLLJGiftBus.getInstanceBus().imgLst.size()).getParent();

					if (parent != null) { 

						parent.removeAllViews();

					} 

					container.addView(VCLLJGiftBus.getInstanceBus().imgLst.get(position % VCLLJGiftBus.getInstanceBus().imgLst.size()));  
					return VCLLJGiftBus.getInstanceBus().imgLst.get(position % VCLLJGiftBus.getInstanceBus().imgLst.size());  

				}

			});
			//			LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
			//			pager.removeAllViews();
			//            for (int i = 0; i < VCLLJGiftBus.getInstanceBus().imgLst.size(); i++) {
			//            	VCLLJGiftBus.getInstanceBus().imgLst.get(i).setLayoutParams(layoutParams);
			//            	pager.addView( VCLLJGiftBus.getInstanceBus().imgLst.get(i));
			//			}
		}



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
		if (this.imageViewPagerContainer !=null) {
			this.imageViewPagerContainer.ssDispose(null);
		}
		
		if (this.pager !=null) {
			this.pager = null;
		}
		
		for (int i = 0; i < VCLLJGiftBus.getInstanceBus().imgLst.size(); i++) {
			ViewGroup parent = (ViewGroup) VCLLJGiftBus.getInstanceBus().imgLst.get(i).getParent();

			if (parent != null) { 

				parent.removeAllViews();

			} 
		}

	}

	@Override
	public void destroy(Map<String, Object> params) {
		super.destroy(params);

		if (this.imageViewPagerContainer !=null) {
			this.imageViewPagerContainer.ssDispose(null);
		}
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

		this.imageViewPagerContainer = (ImageViewPagerContainer) this.ssContentView.findViewById(R.id.llj_modify_container_ly);

		this.pager = (ViewPager)this.ssContentView.findViewById(R.id.llj_modify_container_vp);
		
		this.write = this.ssContentView.findViewById(R.id.write_imgview);

	}

	private void initListener() {
		this.backView.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Engine.viewManager.getDialogViewFromCache(
						LLjModifyInviateFDView.class.getSimpleName()).dismiss();

			}
		});
		
		this.write.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				VCLLJGiftBus.getInstanceBus().enterFDView(GiftModuleWriteInvitationFDView.class.getSimpleName());
			}
		});


	}

}
