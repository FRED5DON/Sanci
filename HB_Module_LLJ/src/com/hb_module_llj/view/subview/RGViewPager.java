package com.hb_module_llj.view.subview;

import java.util.Map;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import com.example.hb_module_llj.R;
import com.twl.uicomponents.viewpager.TwlAdvViewPager;
import com.twl.uicomponents.viewpager.TwlViewPagerContainer;

public class RGViewPager extends TwlViewPagerContainer
{
    private boolean isInited;

    public RGViewPager(Context ctx, AttributeSet attr)
    {
        super(ctx, attr);
        ssPreInit(null);
    }

    @Override
    public void initView(Context ctx , AttributeSet attr)
    {
        LayoutInflater.from(ctx).inflate(R.layout.page_viewpager_ly, this);

        this.viewPager = (TwlAdvViewPager) this.findViewById(R.id.hb_rg_viewpager_vp);
        //不需要销毁view
        setNeedDestoryView(false);
    }

    @Override
    public void ssPreInit(Map<String, Object> params)
    {

    }

    @Override
    public void ssCreateView(Map<String, Object> params)
    {

        super.ssCreateView(params);
    }

    @Override
    public void ssDestoryView(Map<String, Object> params)
    {

        super.ssDestoryView(params);
    }

    @Override
    public void ssPause(Map<String, Object> params)
    {

        super.ssPause(params);
    }

    @Override
    public void ssResume(Map<String, Object> params)
    {

        super.ssResume(params);
    }

    @Override
    public void ssStart(Map<String, Object> params)
    {
        if (!this.isInited)
        {
            this.isInited = true;
        }
    }

    @Override
    public void ssStop(Map<String, Object> params)
    {

        super.ssStop(params);
    }

    @Override
    public void ssDispose(Map<String, Object> params)
    {

        if (this.isInited)
        {
            this.isInited = false;
        }
        super.ssDispose(params);
    }

    @Override
    public void ssDestroy(Map<String, Object> params)
    {

        if (this.isInited)
        {
            this.isInited = false;
        }
        super.ssDestroy(params);
    }
//    
//    @Override
//    protected void onMeasure(int widthMeasureSpec , int heightMeasureSpec)
//    {
//        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2 , MeasureSpec.AT_MOST);
//        super.onMeasure(widthMeasureSpec, expandSpec);
//    }


}