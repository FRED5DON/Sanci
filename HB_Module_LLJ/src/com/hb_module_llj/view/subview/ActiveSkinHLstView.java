
package com.hb_module_llj.view.subview;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.AttributeSet;

import com.hb_module_common.model.ActiveApplyModel;
import com.hb_module_llj.view.adapter.ActiveUserHAdapter;
import com.hb_module_llj.view.adapter.ActiveUserHVH;
import com.twl.uicomponents.hlistview.TwlAdvHListView;

public class ActiveSkinHLstView extends TwlAdvHListView<ActiveApplyModel>
{

	public ActiveSkinHLstView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		preInit(null);
	}

	@Override
	public void init(int lyId , List<ActiveApplyModel> dataSource , int pageSize)
	{
		this.adapter = new ActiveUserHAdapter(lyId, ActiveUserHVH.class);
		this.setAdapter(this.adapter);
		//        this.dataSource = dataSource;
		ArrayList<ActiveApplyModel> activeApplyModels = new ArrayList<ActiveApplyModel>();
		activeApplyModels.add(new ActiveApplyModel());
		activeApplyModels.add(new ActiveApplyModel());
		activeApplyModels.add(new ActiveApplyModel());
		activeApplyModels.add(new ActiveApplyModel());
		activeApplyModels.add(new ActiveApplyModel());
		activeApplyModels.add(new ActiveApplyModel());
		activeApplyModels.add(new ActiveApplyModel());
		activeApplyModels.add(new ActiveApplyModel());
		activeApplyModels.add(new ActiveApplyModel());
		this.dataSource = activeApplyModels;
		this.pageSize = pageSize;
	}

}
