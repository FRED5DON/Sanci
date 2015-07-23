package com.hb_module_llj.view.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.swipe.SwipeAdapter;
import com.daimajia.swipe.SwipeLayout;
import com.example.hb_module_llj.R;

public class ListVisitAdapter extends SwipeAdapter {

    private Context mContext;
    private ArrayList<String> completions;

    public ListVisitAdapter(Context mContext,ArrayList<String> completions) {
        this.mContext = mContext;
        this.completions = completions;
         
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe;
        
    }

    @Override
    public View generateView(final int position, ViewGroup parent) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.listview_item, null);
        final SwipeLayout swipeLayout = (SwipeLayout)v.findViewById(getSwipeLayoutResourceId(position));
        
        LinearLayout item = (LinearLayout) v.findViewById(R.id.item);
        
        final TextView delete = (TextView) v.findViewById(R.id.delete);
        TextView search = (TextView) v.findViewById(R.id.search);
        
       
        delete.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				
			}
			
		});
        
        swipeLayout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				swipeLayout.close();
			}
		});
        
        
        search.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(mContext, "search item", 3000).show();
				swipeLayout.close();
			}
		});
        
        
        swipeLayout.addSwipeListener(new SwipeLayout.SwipeListener() {
            @Override
            public void onClose(SwipeLayout layout) {

            }

            @Override
            public void onUpdate(SwipeLayout layout, int leftOffset, int topOffset) {
            }

            @Override
            public void onOpen(SwipeLayout layout) {
            	
            }

            @Override
            public void onHandRelease(SwipeLayout layout, float xvel, float yvel) {
            	
            }
        });
        return v;
    }

    @Override
    public void fillValues(int position, View convertView) {
    	TextView tv_merName = (TextView) convertView.findViewById(R.id.tv_businessName);
		TextView tv_merDate = (TextView) convertView.findViewById(R.id.tv_date);
		TextView tv_state = (TextView) convertView.findViewById(R.id.tv_state);
		
    }

    @Override
    public int getCount() {
        return completions.size();
    }

    @Override
    public Object getItem(int position) {
        return completions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
