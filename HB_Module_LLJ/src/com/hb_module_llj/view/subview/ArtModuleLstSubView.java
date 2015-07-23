
package com.hb_module_llj.view.subview;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.AttributeSet;

import com.hb_module_llj.view.adapter.ArtModuleLstAdapter;
import com.hb_module_llj.view.adapter.ArtModuleLstVH;
import com.twl.uicomponents.list.TwlAdvListView2;

public class ArtModuleLstSubView extends TwlAdvListView2<String>
{
    public ArtModuleLstSubView(Context context)
    {
        super(context);
    }

    public ArtModuleLstSubView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public ArtModuleLstSubView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }

    @Override
    public void init(int lyId , List<String> dataSource , int pageSize)
    {
        this.adapter = new ArtModuleLstAdapter(lyId, ArtModuleLstVH.class);
        this.setAdapter(this.adapter);
//        this.dataSource = dataSource;
        ArrayList<String> list = new ArrayList<String>();
        
        for (int i = 0; i < 16; i++) {
			
        	list.add("1");
		}
        this.dataSource = list;
        this.pageSize = pageSize;
    }
}
