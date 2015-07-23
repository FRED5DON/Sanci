package com.hb_module_llj.view.adapter;

import android.view.View;
import android.widget.TextView;

import com.example.hb_module_llj.R;
import com.hb_module_llj.model.SkinLabel;

public class GiftLabelHVH<T> extends CommonLstVH<T> {

	private TextView labelTxt;
	private View labelLine;

	@Override
	protected void initView(int lyId) {
		super.initView(lyId);
		initListener();

		this.labelTxt = (TextView) this.contentView
				.findViewById(R.id.label_txt);
		this.labelLine = this.contentView.findViewById(R.id.label_line);

	}

	private void initListener() {

	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void doClearBus(int arg0) {
	}

	@Override
	public void doSetDataBus(int arg0) {

		if (model != null && model instanceof SkinLabel) {

			SkinLabel skinLabel = (SkinLabel) model;

			this.labelTxt.setText(skinLabel.labelStr);

			if (skinLabel.isSelect) {
				this.labelLine.setVisibility(View.VISIBLE);
				this.labelTxt.setTextColor(0xffe93030);

			} else {
				this.labelLine.setVisibility(View.INVISIBLE);
				this.labelTxt.setTextColor(0xff434343);

			}
		}

	}

}
