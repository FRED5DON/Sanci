
package com.hb_module_llj.view.subview;

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

public class GiftNoteGridView extends RelativeLayout implements IBaseView
{

	private RGChooseSkinGridView giftGv;


	public GiftNoteGridView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		ssPreInit(null);
		LayoutInflater.from(context).inflate(R.layout.page_hb_llj_grid_ly, this);
		initView();
		initListener();
	}

	private void initListener()
	{


	}

	private void initView()
	{
		this.giftGv = (RGChooseSkinGridView) this.findViewById(R.id.page_hb_rg_launch_choose_skin_gv);
		this.giftGv.init(R.layout.page_hb_llj_gift_item_ly, null, 10);
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
		this.giftGv.init(R.layout.page_hb_llj_gift_item_ly, null, 10);
		this.giftGv.resetData(0, 9);
	}

	@Override
	public void ssStop(Map<String, Object> arg0)
	{
	}

	@Override
	public void ssDispose(Map<String, Object> params)
	{
		if (this.giftGv != null)
		{
			this.giftGv.dispose(params);
		}
	}

	@Override
	public void ssDestroy(Map<String, Object> params)
	{
		if (this.giftGv != null)
		{
			this.giftGv.destroy(params);
			this.giftGv = null;
		}
	}
}
