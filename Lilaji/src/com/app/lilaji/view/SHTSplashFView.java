
package com.app.lilaji.view;

import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.app.lilaji.R;
import com.fw.Engine;
import com.fw.EngineOptions;
import com.fw.signals.Signal;
import com.fw.signals.SignalListener;
import com.fw.utils.DrawableUtils;
import com.fw.utils.SignalBuilder;
import com.fw.view.BaseFragmentView;
import com.hb_module_common.AppConstants;
import com.hb_module_common.AppSystemBus;

public class SHTSplashFView extends BaseFragmentView
{
    private ImageView imgView;

    public SHTSplashFView()
    {
        super();
    }

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
        this.viewName = SHTSplashFView.class.getSimpleName();

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
        Engine.logInfo("twl", "splash %s", "oncreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState)
    {
        this.ssContentView = inflater.inflate(R.layout.page_splash_ly, null);
        //设置背景图片
        //        this.bgBitmapDrawable = Engine.helperManager.skinHelper.getBitmapDrawable(R.drawable.page_splash_bg);
        //        this.ssContentView.setBackgroundDrawable(this.bgBitmapDrawable);
        this.imgView = (ImageView) this.ssContentView.findViewById(R.id.page_splash_img);
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
        this.ssContentView.postDelayed(new Runnable()
        {

            @Override
            public void run()
            {
                //                版本更新
//                AppConstants.getVCMainBus().checkVersion(SignalBuilder.build(new SignalListener()
//                {
//
//                    @Override
//                    public void execute(Signal signal , Message msg)
//                    {
//                        if (msg.getData().getBoolean(EngineOptions.flag_isSuccess))
//                        {
                            //抛出闪屏结束的事件
                            AppSystemBus.getInstanceBus().commonSignal.disptach(AppConstants.bus_flag,
                                    AppConstants.bus_flag_splash_finish);
//                        }
//                    }
//                }, 0));

            }
        }, 3000);
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
        //        if (this.ssContentView != null)
        //        {
        //            this.ssContentView.setBackgroundResource(0);
        //        }
        //        if (this.bgBitmapDrawable != null)
        //        {
        //            Engine.helperManager.skinHelper.recycleBitmapDrawable(this.bgBitmapDrawable);
        //        }

        DrawableUtils.recycleDrawable(this.imgView.getDrawable());
        Engine.viewManager.removeViewFromCache(SHTSplashFView.class.getSimpleName());
        this.ssContentView = null;
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
    }

    @Override
    public void destroy(Map<String, Object> params)
    {
        super.destroy(params);
    }
}
