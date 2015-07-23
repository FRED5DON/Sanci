
package com.hb_module_llj.view.adapter;

import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hb_module_llj.R;
import com.fw.Engine;
import com.fw.EngineOptions;
import com.fw.helper.model.ImageModel;
import com.fw.signals.Signal;
import com.fw.signals.SignalListener;
import com.fw.utils.SignalBuilder;
import com.hb_module_common.AppConstants;
import com.hb_module_common.view.CircleImageView;
import com.hb_module_llj.bus.VCLLJGiftBus;
import com.hb_module_llj.view.GiftModuleAddGnoteFDView;
import com.twl.uicomponents.adapter.TWLViewHold;

public class RGSkinInfoSetVH extends TWLViewHold<String>
{

	private ImageView imgView;


	private ImageModel imageModel;


	private ImageView noteImg;


	private TextView noteName;


	private TextView noteDate;


	@Override
	protected void initView(int lyId)
	{
		super.initView(lyId);

		initView();

		initListener();
	}

	private void initView()
	{
		noteImg = (ImageView) this.contentView.findViewById(R.id.gnote_img);
		noteName = (TextView)this.contentView.findViewById(R.id.gnote_name);
		noteDate = (TextView)this.contentView.findViewById(R.id.gnote_date);
	}

	private void initListener()
	{
		this.contentView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if (model.equals("2")) {
					VCLLJGiftBus.getInstanceBus().enterFDView(GiftModuleAddGnoteFDView.class.getSimpleName());
				}
			}
		});
	}

	@Override
	public void dispose()
	{
		super.dispose();
		this.imgView = null;
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
		if (this.model != null)
		{
			if (model.equals("2")) {
				noteImg.setBackgroundResource(R.drawable.llj_add_gnote);
				noteDate.setVisibility(View.INVISIBLE);
				noteName.setVisibility(View.INVISIBLE);
				
			}
		}
	}

	//加载图片
	private void loadImg(final String imgUrl , final CircleImageView imgView)
	{
		AppConstants.getAppSystemBus().loadImage(imgUrl, EngineOptions.getImageType(imgUrl),
				SignalBuilder.build(new SignalListener()
				{
					@Override
					public void execute(Signal signal , Message msg)
					{
						if (msg.getData().getBoolean(EngineOptions.flag_isSuccess))
						{
							ImageModel tmpImageModel = (ImageModel) msg.getData().getSerializable(
									EngineOptions.flag_data);
							if (model != null && imgUrl.contains(tmpImageModel.getName()))
							{
								if (imageModel == null
										|| (imageModel != null && !imageModel.getName().equals(tmpImageModel.getName())))
								{
									//需要删除之前的图片，重新设置图片
									doClearBus(-1);
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
