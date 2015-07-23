package com.hb_module_llj.view.subview;

import java.util.List;

import android.content.Context;
import android.util.AttributeSet;

import com.hb_module_llj.view.adapter.CommonLstAdapter;
import com.hb_module_llj.view.adapter.CommonLstVH;
import com.twl.uicomponents.hlistview.TwlAdvHListView;

public class CommonlHLstSubView<T> extends TwlAdvHListView<T> {

	public CommonlHLstSubView(Context context, AttributeSet attrs) {
		super(context, attrs);
		preInit(null);
	}

	@Override
	public void init(int lyId, List<T> dataSource, int pageSize) {
		this.setAdapter(this.adapter);
		 this.dataSource = dataSource;
		this.pageSize = pageSize;
	}
	
	public void init(int lyId, List<T> dataSource, int pageSize,Class vh) {
		this.adapter = new CommonLstAdapter(lyId,vh);
		init(lyId, dataSource, pageSize);
	}


}
