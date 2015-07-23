
package com.hb_module_llj.view;

import java.util.ArrayList;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;

import com.autonavi.aps.amapapi.h;
import com.example.hb_module_llj.R;
import com.fw.view.BaseFragmentView;
import com.hb_module_common.AppConstants;
import com.hb_module_common.AppSystemBus;
import com.hb_module_llj.LLJAppConstants;
import com.hb_module_llj.bus.VCLLJGiftBus;
import com.hb_module_llj.view.subview.ActiveSkinHLstView;
import com.hb_module_llj.view.subview.ArtModuleLstSubView;
import com.hb_module_llj.view.subview.ImageCycleView;
import com.hb_module_llj.view.subview.ImageCycleView.ImageCycleViewListener;
import com.nostra13.universalimageloader.core.ImageLoader;

public class GiftModuleMainFView extends BaseFragmentView
{

    private ArtModuleLstSubView lstView;
	private ActiveSkinHLstView hlstview;
	private ImageCycleView mAdView;
	
	private int[] adImgs = {R.drawable.home_llj_banner_one,R.drawable.home_llj_banner_two};
	private View noteLy;
	private View addGnoteLy;
	private View signLy;


    /******************************************************
     * 
     * 构造相关
     * 
     ******************************************************/
    public GiftModuleMainFView()
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
        this.viewName = GiftModuleMainFView.class.getSimpleName();

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
        this.ssContentView = inflater.inflate(R.layout.page_hb_module_llj_mian_lst_ly, null);
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
        this.lstView.resetData(0, 9);
        this.hlstview.resetData();
        ArrayList<String> imageUrlList = new ArrayList<String>();
        imageUrlList.add("0");
        imageUrlList.add("1");
        this.mAdView.setImageResources(imageUrlList, mAdCycleViewListener);
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
        if (this.lstView != null)
        {
            lstView.dispose(params);
        }
    }

    @Override
    public void destroy(Map<String, Object> params)
    {
        super.destroy(params);
        if (this.lstView != null)
        {
            lstView.destroy(params);
            lstView = null;
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
     * @author [sicmi]
     * @date   [2015年7月6日]
     * @retruntype [void]
     * @exception
     */
    private void initView()
    {
    	this.noteLy = this.ssContentView.findViewById(R.id.llj_mian_note);
    	this.addGnoteLy = this.ssContentView.findViewById(R.id.llj_mian_add_gnote);
    	this.signLy = this.ssContentView.findViewById(R.id.llj_mian_sign_in);
        this.lstView = (ArtModuleLstSubView) this.ssContentView
                .findViewById(R.id.page_hb_module_llj_home_lst_view);
        this.lstView.init(R.layout.page_hb_module_llj_mian_lst_item_ly,
                null, 10);
        this.hlstview = (ActiveSkinHLstView)this.ssContentView.findViewById(R.id.page_hb_module_llj_h_lst_view);
        this.hlstview.init(R.layout.page_hb_module_llj_h_lst_item_ly, null, 3);
        
        this.mAdView = (ImageCycleView) this.ssContentView.findViewById(R.id.ad_view);

    }

    private void initListener()
    {
    	this.hlstview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				hlstview.scrollTo(arg2*250);
				VCLLJGiftBus.getInstanceBus().enterFDView(RGChooseBgFDView.class.getSimpleName());
//				hlstview.setSelection(arg2);
				
			}
		});
    	this.noteLy.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		this.addGnoteLy.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				AppSystemBus.getInstanceBus().commonSignal.disptach(AppConstants.bus_flag,
						LLJAppConstants.bus_flag_enter_search_page_view);
				
			}
		});
		this.signLy.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				VCLLJGiftBus.getInstanceBus().enterFDView(LLSigninFDView.class.getSimpleName());
			}
		});
    	
    }
    
	private ImageCycleViewListener mAdCycleViewListener = new ImageCycleViewListener() {

		@Override
		public void onImageClick(int position, View imageView) {

		}

		@Override
		public void displayImage(String imageURL, ImageView imageView) {
			Integer valueOf = Integer.valueOf(imageURL);
			imageView.setBackgroundResource(adImgs[valueOf]);
			//ImageLoader.getInstance().displayImage(imageURL, imageView);// 此处本人使用了ImageLoader对图片进行加装！
		}
	};

}
