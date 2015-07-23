
package com.hb_module_llj.bus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.alibaba.fastjson.JSONObject;
import com.example.hb_module_llj.R;
import com.fw.Engine;
import com.fw.EngineOptions;
import com.fw.bus.BaseBus;
import com.fw.bus.BaseBusHandler;
import com.fw.helper.BaseHelper;
import com.fw.utils.JsonBuilder;
import com.fw.utils.RequestParamBuilder;
import com.hb_module_common.AppConstants;
import com.hb_module_llj.LLJAppConstants;
import com.hb_module_llj.model.GiftRemindModel;
import com.hb_module_llj.model.SkinLabel;
import com.loopj.android.http.RequestParams;

public class VCLLJGiftBus extends BaseBus
{

    public List<SkinLabel> labels;

    public ArrayList<ImageView> imgLst;

    public List<GiftRemindModel> reminds;

    /*******************************************************************
     * 
     * 公共方法
     * 
     * 
     *******************************************************************/
    /**
     * 单例
     * 
     * 
     * @author [王鑫]
     * @E-mail [wangxcom@126.com]
     * @Date 2015-4-27
     * @method {type_name}
     * @param @return
     * @return VCContactBus
     */
    public static VCLLJGiftBus getInstanceBus()
    {
        return (VCLLJGiftBus) Engine.busManager.getBus(VCLLJGiftBus.class.getSimpleName());
    }

    /**
     * 进入首页
     * 
     * 
     * @author [王鑫]
     * @E-mail [wangxcom@126.com]
     * @Date 2015-5-23
     * @method {type_name}
     * @param @param viewName
     * @return void
     */
    public void enterFView(String viewName)
    {
        Engine.viewManager.enterPage(Engine.viewManager.getViewFromCache(viewName), "");
    }

    /**
     * 进入明细
     * 
     * 
     * @author [王鑫]
     * @E-mail [wangxcom@126.com]
     * @Date 2015-5-23
     * @method {type_name}
     * @param @param viewName
     * @return void
     */
    public void enterFDView(String viewName)
    {
        Engine.viewManager.showDialog(Engine.viewManager.getDialogViewFromCache(viewName), true);
    }

    /**
     * 退出dialog
     * 
     * @param simpleName
     */
    public void dismissDialog(String viewName)
    {
        Engine.viewManager.dismissDialog(Engine.viewManager.getDialogViewFromCache(viewName));
    }

    /**
     * LLJ注册
     * @param name
     * @param pwd
     */
    public void LLjregister(String name , String pwd)
    {

        RequestParams paramsStr = RequestParamBuilder.build().append("method", "RegisterMember")
                .append("mobilePhone", name).append("password", pwd).commit();

        Engine.viewManager.dialogMHandler.showProgressDialog(Engine.application);
        BaseBusHandler tmpHandler = new BaseBusHandler()
        {

            @Override
            public void doLocalBus(final boolean isNetError , final String errType , final String errorMsg)
            {

                Engine.viewManager.dialogMHandler.dismissProgressDialog();
                Engine.viewManager.toastMHandler.toastMsg(errorMsg);

            }

            @Override
            public void doNetBus(JSONObject rs)
            {

                Engine.viewManager.dialogMHandler.dismissProgressDialog();

                Engine.viewManager.toastMHandler.toastMsg(rs.toString() + "sss");
            }

        };
        Engine.helperManager.httpHelper.loadData(LLJAppConstants.llj_action, EngineOptions.GET, paramsStr, tmpHandler);

    }

    /**
     * 登录
     * @param name
     * @param pwd
     */
    public void LLjLogin(String name , String pwd)
    {

        RequestParams paramsStr = RequestParamBuilder.build().append("method", "MemberLogin")
                .append("mobilePhone", name).append("password", pwd).commit();

        Engine.viewManager.dialogMHandler.showProgressDialog(Engine.application);
        BaseBusHandler tmpHandler = new BaseBusHandler()
        {

            @Override
            public void doLocalBus(final boolean isNetError , final String errType , final String errorMsg)
            {

                Engine.viewManager.dialogMHandler.dismissProgressDialog();

            }

            @Override
            public void doNetBus(JSONObject rs)
            {

                Engine.viewManager.dialogMHandler.dismissProgressDialog();

            }

        };
        Engine.helperManager.httpHelper.loadData(LLJAppConstants.llj_action, EngineOptions.GET, paramsStr, tmpHandler);

    }
    

    /*******************************************************************
     * 
     * 接口方法
     * 
     * 
     *******************************************************************/
    @Override
    public void init(Map<String, Object> params)
    {
        super.init(params);

        labels = new ArrayList<SkinLabel>();

        labels.add(new SkinLabel("结婚", true, ""));
        labels.add(new SkinLabel("生日", false, ""));
        labels.add(new SkinLabel("乔迁", false, ""));
        labels.add(new SkinLabel("满月", false, ""));
        labels.add(new SkinLabel("升学", false, ""));
        labels.add(new SkinLabel("商务", false, ""));
        labels.add(new SkinLabel("诞辰", false, ""));
        labels.add(new SkinLabel("寿辰", false, ""));
        labels.add(new SkinLabel("其他", false, ""));

        imgLst = new ArrayList<ImageView>();

        //		 "assets://letter_bg_1.png";
        int[] draId = { R.drawable.letter_bg_1, R.drawable.letter_bg_2, R.drawable.letter_bg_3, R.drawable.letter_bg_4,
                R.drawable.letter_bg_5, R.drawable.letter_bg_6 };
        for (int i = 0; i < draId.length; i++)
        {
            ImageView view = new ImageView(Engine.application);
            view.setBackgroundResource(draId[i]);
            imgLst.add(view);
            view = null;
        }

        //tf:add[2015-07-16 23:50:27]{
        reminds = new ArrayList<GiftRemindModel>();

        reminds.add(new GiftRemindModel("送宝宝生日礼物", "2015-07-18", "2015-07-17", 1, ""));
        reminds.add(new GiftRemindModel("送小侄子LoveLive玩偶", "2015-07-28", "2015-07-26", 2, ""));
        //}

    }

    @Override
    public void preInit(Map<String, Object> params)
    {

    }

    @Override
    public void reset(Map<String, Object> params)
    {
    }

    @Override
    public void pause(Map<String, Object> params)
    {
    }

    @Override
    public void start(Map<String, Object> params)
    {
    }

    @Override
    public void dispose(Map<String, Object> params)
    {

    }

    @Override
    public void destory(Map<String, Object> params)
    {
        super.destory(params);

    }

    public VCLLJGiftBus()
    {
        preInit(null);
    }

    /**
     * 发起dialog弹出携带源
     * 
     * @param v
     * @param bundles
     */
    public void setSourceEditor(View v , Bundle bundles)
    {
        // TODO Auto-generated method stub

    }

}
