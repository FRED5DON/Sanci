package com.hb_module_llj.view.adapter;

import android.view.View;
import android.view.View.OnClickListener;

import com.twl.uicomponents.adapter.TWLViewHold;

/**
 * 公共viewHold
 * @author Administrator
 *
 * @param <T>
 */
public class CommonLstVH<T> extends TWLViewHold<T>{
	
	
	private vhEvent event;
	
	
	public interface vhEvent{
		
		void onItemclick(int currPosition,Object object);
		
	}
	
	public void setVhEvent(vhEvent event){
		this.event = event;
	}
	
	@Override
	protected void initView(int lyId) {
		super.initView(lyId);
		
		if (event!=null) {
			
			this.contentView.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
					event.onItemclick(currPosition, model);
					
				}
			});
		}
	}
	
	

	@Override
	public void doClearBus(int arg0) {
		
	}

	@Override
	public void doSetDataBus(int arg0) {
		
	}

}
