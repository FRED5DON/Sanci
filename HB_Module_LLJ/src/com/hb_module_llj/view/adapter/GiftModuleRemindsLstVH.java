
package com.hb_module_llj.view.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hb_module_llj.R;
import com.hb_module_llj.model.GiftRemindModel;
import com.twl.uicomponents.adapter.TWLViewHold;

public class GiftModuleRemindsLstVH extends TWLViewHold<GiftRemindModel>
{
    

    private TextView titleTv;
	private TextView repeatTimes;
	private ImageView calendar;
	private TextView dateTv;

	@Override
    protected void initView(int lyId)
    {
        super.initView(lyId);

        initView();
        initListener();

    }

    
    private void initView() {
    	titleTv=(TextView)this.contentView.findViewById(R.id.remind_title_tv);
    	repeatTimes=(TextView)this.contentView.findViewById(R.id.remind_date_count_tv);
    	calendar=(ImageView)this.contentView.findViewById(R.id.remind_calendartype_img);
    	dateTv=(TextView)this.contentView.findViewById(R.id.remind_date_tv);
		
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
        
    }

    @Override
    public void doClearBus(int arg0)
    {
         

    }

    @Override
    public void doSetDataBus(int arg0)
    {
        if (model!=null) {
        	titleTv.setText(model.title);
        	repeatTimes.setText(model.repeatCount==0?"不提醒":(model.repeatCount>0?"仅一次":getCNNum(model.repeatCount)));
        	dateTv.setText(model.occurDate);
        	calendar.setSelected(model.isStandardCalendar);
		}

    }


	private String getCNNum(int repeatCount) {
		if(repeatCount>6){
		return "至少一周内均提醒";	
		}
		return repeatCount+"次";
	}
 
    

}
