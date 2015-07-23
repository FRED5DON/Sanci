
package com.hb_module_llj.view;

import java.util.Map;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.example.hb_module_llj.R;
import com.fw.Engine;
import com.fw.view.BaseDialogFragmentView;
import com.hb_module_llj.view.subview.ActiveSkinHLstView;
import com.hb_module_llj.view.subview.RGChooseSkinGridView;

public class GiftModuleAddGnoteFDView extends BaseDialogFragmentView
{

    /******************************************************
     * 
     * 构造相关
     * 
     ******************************************************/


	private View backView;


    private ActiveSkinHLstView sSkinHListView;

    public GiftModuleAddGnoteFDView()
    {
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
    public void preInit(Map<String, Object> params)
    {
        super.preInit(params);
        this.viewName = GiftModuleAddGnoteFDView.class.getSimpleName();

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
        
        setStyle(DialogFragment.STYLE_NORMAL,android.R.style.Theme_Black_NoTitleBar);
    }

    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState)
    {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        this.ssContentView = inflater.inflate(R.layout.page_llj_add_gnote_ly, null);
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
        this.sSkinHListView.resetData();
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

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
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
    private void initView()
    {
         this.backView = this.ssContentView.findViewById(R.id.hb_rg_launch_back_rl);
         this.sSkinHListView =(ActiveSkinHLstView) this.ssContentView.findViewById(R.id.page_add_llj_h_lst_view);
         this.sSkinHListView.init(R.layout.page_add_llj_gskin_item_ly, null, 10);
                 
                 
    }

    private void initListener()
    {
    	this.backView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Engine.viewManager.getDialogViewFromCache(GiftModuleAddGnoteFDView.class.getSimpleName()).dismiss();
				
			}
		});
         
//    	this.addpicIv.setOnClickListener(new View.OnClickListener()
//        {
//            
//            @Override
//            public void onClick(View v)
//            {
//                AppConstants.getAppSystemBus().commonSignal.disptach(AppConstants.bus_flag, RGAppConstants.bus_flag_enter_rg_launch_page_view);
//            }
//        });
    	
    }

     
}
