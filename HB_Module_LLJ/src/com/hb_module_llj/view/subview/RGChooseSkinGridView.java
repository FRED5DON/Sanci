
package com.hb_module_llj.view.subview;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.AttributeSet;

import com.hb_module_llj.view.adapter.RGSkinInfoSetAdapter;
import com.hb_module_llj.view.adapter.RGSkinInfoSetVH;
import com.twl.uicomponents.grid.TwlAdvGridView;

public class RGChooseSkinGridView extends TwlAdvGridView<String>
{
    public RGChooseSkinGridView(Context context)
    {
        super(context);
    }

    public RGChooseSkinGridView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public RGChooseSkinGridView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }

    @Override
    public void init(int lyId , List<String> dataSource , int pageSize)
    {
        this.adapter = new RGSkinInfoSetAdapter(lyId, RGSkinInfoSetVH.class);
        this.setAdapter(this.adapter);
//        this.dataSource = dataSource;
        this.dataSource = new ArrayList<String>();
        this.dataSource.add("1");
        this.dataSource.add("1");
        this.dataSource.add("1");
        this.dataSource.add("1");
        this.dataSource.add("1");
        this.dataSource.add("2");
        this.pageSize = pageSize;
    }

    //    @Override
    //    protected void onMeasure(int widthMeasureSpec , int heightMeasureSpec)
    //    {
    //        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
    //        super.onMeasure(widthMeasureSpec, expandSpec);
    //    }
}
