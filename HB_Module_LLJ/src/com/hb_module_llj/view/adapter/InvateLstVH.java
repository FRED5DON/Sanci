
package com.hb_module_llj.view.adapter;

import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.fw.Engine;
import com.fw.EngineOptions;
import com.fw.helper.model.ImageModel;
import com.fw.signals.Signal;
import com.fw.signals.SignalListener;
import com.fw.utils.SignalBuilder;
import com.hb_module_common.AppConstants;
import com.twl.uicomponents.adapter.TWLViewHold;

public class InvateLstVH extends TWLViewHold<String>
{
    private ImageView imgView;

    private TextView titleTxt;

    private TextView priceTxt;

    private TextView buyNumTxt;

    private TextView commentNumTxt;

    private TextView priseNumTxt;

    private TextView starNumTxt;

    private ProgressBar progressBar;

    private TextView remaidayTxt;

    private ImageModel imageModel;

    private TextView tagTxt;

    private Button paTagBtn;

    @Override
    protected void initView(int lyId)
    {
        super.initView(lyId);

        initListener();

    }

    private void initListener()
    {
        this.contentView.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
            }
        });

    }

    @Override
    public void dispose()
    {
        super.dispose();
        this.titleTxt = null;
    }

    @Override
    public void doClearBus(int arg0)
    {
        if (imageModel != null)
        {
            Engine.helperManager.cacheHelper.imageCache.recyleImageModel(imageModel);
            imageModel = null;
        }

    }

    @Override
    public void doSetDataBus(int arg0)
    {
        

    }

    /**
     * 加载图片
     * 
     * 
     * @author [ysm]
     * @date   [2014-11-16]
     * @param iconStr
     * @retruntype [void]
     * @exception
     */

    private void loadImgView(final String iconStr)
    {
        AppConstants.getAppSystemBus().loadImage(iconStr, EngineOptions.getImageType(iconStr),
                SignalBuilder.build(new SignalListener()
                {
                    @Override
                    public void execute(Signal signal , Message msg)
                    {
                        if (msg.getData().getBoolean(EngineOptions.flag_isSuccess))
                        {
                            ImageModel tmpImageModel = (ImageModel) msg.getData().getSerializable(
                                    EngineOptions.flag_data);
                            if (iconStr.contains(tmpImageModel.getName()))
                            {
                                if (imageModel == null
                                        || (imageModel != null && !imageModel.getName().equals(tmpImageModel.getName())))
                                {
                                    //回收imageModel
                                    doClearBus(-1);
                                    //需要删除之前的图片，重新设置图片
                                    imageModel = tmpImageModel;
                                    imageModel.resize(imgView.getWidth(), imgView.getWidth()
                                            * imageModel.getBitmap().getHeight() / imageModel.getBitmap().getWidth());
                                    imgView.setImageBitmap(imageModel.getBitmap());
                                    
                                     //                                        imgView.setScaleType(ScaleType.FIT_START);
                                }
                                else
                                {
                                    //不需要重新设置
                                    Engine.helperManager.cacheHelper.imageCache.recyleImageModel(tmpImageModel);
                                }
                            }
                            else
                            {
                                //如果此图片不是本次所需要加载的图片
                                Engine.helperManager.cacheHelper.imageCache.recyleImageModel(tmpImageModel);
                            }

                        }
                        signal.dispose();
                    }
                }, 0), false);
    }
    
    

}
