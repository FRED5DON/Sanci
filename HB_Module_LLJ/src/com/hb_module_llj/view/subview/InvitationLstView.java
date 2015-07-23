
package com.hb_module_llj.view.subview;

import java.util.ArrayList;
import java.util.Map;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.hb_module_llj.R;
import com.fw.utils.CollectionUtils;
import com.fw.view.IBaseView;
import com.hb_module_llj.view.adapter.InvateLstVH;

public class InvitationLstView extends RelativeLayout implements IBaseView
{

	private CommonLstSubView invateLst;
	private ArrayList<String> list;


	public InvitationLstView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		ssPreInit(null);
		LayoutInflater.from(context).inflate(R.layout.page_hb_llj_lst_ly, this);
		initView();
		initListener();
	}

	private void initListener()
	{


	}

	private void initView()
	{
		this.invateLst = (CommonLstSubView<String>) this.findViewById(R.id.page_llj_invate_lst);
		list = new ArrayList<String>();
		for (int i = 0; i < 16; i++) {
			list.add("1");
		}
		this.invateLst.init(R.layout.llj_invate_list_item, list, 10,InvateLstVH.class);
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
	public void ssPause(Map<String, Object> arg0)
	{
	}

	@Override
	public void ssPreInit(Map<String, Object> arg0)
	{
	}

	@Override
	public void ssResume(Map<String, Object> arg0)
	{
	}

	@Override
	public void ssStart(Map<String, Object> arg0)
	{
		this.invateLst.init(R.layout.llj_invate_list_item, list, 10,InvateLstVH.class);
		this.invateLst.resetData(0, 9);
	}

	@Override
	public void ssStop(Map<String, Object> arg0)
	{
	}

	@Override
	public void ssDispose(Map<String, Object> params)
	{
		if (this.invateLst != null)
		{
			this.invateLst.dispose(params);
		}
	}

	@Override
	public void ssDestroy(Map<String, Object> params)
	{
		if (this.invateLst != null)
		{
			this.invateLst.destroy(params);
			this.invateLst = null;
		}
	}
}
