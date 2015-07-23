
package com.hb_module_llj.view.adapter;

import com.twl.uicomponents.adapter.TWLListAdapter;

public class CommonLstAdapter<T> extends TWLListAdapter<T, CommonLstVH<T>>
{

    public CommonLstAdapter(int lyId, Class<CommonLstVH<T>> viewHoldClass)
    {
        super(lyId, viewHoldClass);

    }

}
