
package com.hb_module_llj.view.subview;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.AttributeSet;

import com.hb_module_llj.view.adapter.ArtModuleLstAdapter;
import com.hb_module_llj.view.adapter.ArtModuleLstVH;
import com.hb_module_llj.view.adapter.CommonLstAdapter;
import com.hb_module_llj.view.adapter.CommonLstVH;
import com.twl.uicomponents.list.TwlAdvListView2;

public class CommonLstSubView<T> extends TwlAdvListView2<T>
{
    public CommonLstSubView(Context context)
    {
        super(context);
    }

    public CommonLstSubView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public CommonLstSubView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }

	@Override
    public void init(int lyId , List<T> dataSource , int pageSize)
    {
        this.setAdapter(this.adapter);
        this.dataSource = dataSource;
        this.pageSize = pageSize;
    }
	
	 public void init(int lyId, List<T> dataSource, int pageSize,Class vh) {
			this.adapter = new CommonLstAdapter(lyId,vh);
			init(lyId, dataSource, pageSize);
		}
}
