
package com.hb_module_llj.view.subview;

import java.util.List;

import android.content.Context;
import android.util.AttributeSet;

import com.hb_module_llj.view.adapter.CommonLstAdapter;
import com.twl.uicomponents.grid.TwlAdvGridView;

public class CommonGridSubView<T> extends TwlAdvGridView<T>
{
    public CommonGridSubView(Context context)
    {
        super(context);
    }

    public CommonGridSubView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public CommonGridSubView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
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


    //    @Override
    //    protected void onMeasure(int widthMeasureSpec , int heightMeasureSpec)
    //    {
    //        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
    //        super.onMeasure(widthMeasureSpec, expandSpec);
    //    }
}
