
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
import com.hb_module_llj.view.LLjModifyInviateFDView;
import com.twl.uicomponents.adapter.TWLViewHold;

public class CopyOfRGSkinInfoSetVH extends CommonLstVH<String>
{



	@Override
	protected void initView(int lyId)
	{
		super.initView(lyId);

		initView();

		initListener();
	}

	private void initView()
	{
	}

	private void initListener()
	{
		this.contentView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
					VCLLJGiftBus.getInstanceBus().enterFDView(LLjModifyInviateFDView.class.getSimpleName());
			}
		});
	}

	@Override
	public void dispose()
	{
		super.dispose();
	}

	@Override
	public void doClearBus(int arg0)
	{
	}

	@Override
	public void doSetDataBus(int arg0)
	{
		if (this.model != null)
		{
		}
	}

}
