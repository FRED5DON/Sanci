
package com.app.lilaji.view;

import java.util.Map;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.fw.view.IBaseView;
import com.hb_module_common.AppConstants;
import com.hb_module_common.AppSystemBus;
import com.hb_module_common.R;

public class CommonMenuView extends RelativeLayout implements IBaseView
{

    private Button dynamicBtn;

    private Button friendBtn;

    private Button homeBtn;

    private Button circleBtn;

    private Button shareBtn;

    public CommonMenuView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        initViews(context, attrs);
        initListener();
    }
    /**
     * 外部改变底部菜单状态
     * 
     * 
     * @author [杨声明]
     * @E-mail[sicmi929@163.com]
     * @param @param state
     * @param state
     * @retruntype [void]
     * @exception
     */
    public void changeMenuState(String state)
    {
        if (state.equals(AppConstants.bottom_menu_state_home))
        {
            if (!homeBtn.isSelected())
            {
                setAllBtnNoSelected();
                homeBtn.setSelected(true);
            }
        }
    }

    /**
     * 得到底部当前选中状态
     * 
     * 
     * @author [wx]
     * @date [2014-12-31]
     * @return
     * @retruntype [String]
     * @exception
     */
    public String getCurrentBtnState()
    {

        if (this.dynamicBtn == null || this.friendBtn == null || this.homeBtn == null || this.circleBtn == null)
        {
            return "";
        }
        if (this.dynamicBtn.isSelected())
        {
            return AppConstants.bottom_menu_state_resources;
        }
        else if (this.friendBtn.isSelected())
        {
            return AppConstants.bottom_menu_state_friend;
        }
        else if (this.homeBtn.isSelected())
        {
            return AppConstants.bottom_menu_state_home;
        }
        else if (this.circleBtn.isSelected())
        {
            return AppConstants.bottom_menu_state_crowdfunding;
        }
        else
        {
            return "";
        }
    }

    /**
     * 设置动态选中
     * 
     * 
     * @author [杨声明]
     * @E-mail[sicmi929@163.com]
     * @param 
     * @retruntype [void]
     * @exception
     */
    public void setSlelctDefult(String btnName)
    {
        if ("dynamicBtn".equals(btnName))
        {
            setAllBtnNoSelected();
            this.dynamicBtn.setSelected(true);
        }
        else if ("homeBtn".equals(btnName))
        {
            setAllBtnNoSelected();
            this.homeBtn.setSelected(true);
        }

    }

    /**
     * 初始化view
     * 
     * 
     * @author [vincent]
     * @date [2014年8月1日]
     * @param context
     * @param attrs
     * @retruntype [void]
     * @exception
     */
    private void initViews(Context context , AttributeSet attrs)
    {
        LayoutInflater.from(context).inflate(R.layout.common_menu_ly, this);
        this.dynamicBtn = (Button) this.findViewById(R.id.common_bottom_menu_dynamic_btn);
        this.friendBtn = (Button) this.findViewById(R.id.common_bottom_menu_friend_btn);
        this.circleBtn = (Button) this.findViewById(R.id.common_bottom_menu_circle_btn);
        this.shareBtn = (Button) this.findViewById(R.id.common_bottom_menu_launch_btn);
        this.homeBtn = (Button) this.findViewById(R.id.common_bottom_menu_home_btn);
        this.dynamicBtn.setSelected(true);
    }

    private void initListener()
    {
        //
        this.dynamicBtn.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                if (!dynamicBtn.isSelected())
                {
                    setAllBtnNoSelected();
                    dynamicBtn.setSelected(true);
                    AppSystemBus.getInstanceBus().commonSignal.disptach(AppConstants.bus_flag,
                            AppConstants.bus_flag_enter_dynamic_view);
                    //                    AppConstants.getVCResourcesBus().enterResourcesLstFView();

                }

            }
        });
        this.circleBtn.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                if (!circleBtn.isSelected())
                {
                    setAllBtnNoSelected();
                    circleBtn.setSelected(true);
                    AppSystemBus.getInstanceBus().commonSignal.disptach(AppConstants.bus_flag,
                            AppConstants.bus_flag_enter_circle_view);
                    //                    AppConstants.getVCCircleBus().enterHomeCircleLstView();
                }

            }
        });
        this.shareBtn.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                if (!shareBtn.isSelected())
                {
                    setAllBtnNoSelected();
                    shareBtn.setSelected(true);
                    AppSystemBus.getInstanceBus().commonSignal.disptach(AppConstants.bus_flag,
                            AppConstants.bus_flag_enter_kind_share_view);
                }

            }
        });
        //
        this.friendBtn.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                if (!friendBtn.isSelected())
                {
                    setAllBtnNoSelected();
                    friendBtn.setSelected(true);
                    AppSystemBus.getInstanceBus().commonSignal.disptach(AppConstants.bus_flag,
                            AppConstants.bus_flag_enter_contact_view);
                }

                //                if (StringUtils.isEmpty(AppConstants.getVCUserBus().currUserInfo.email))
                //                {
                //                    AppConstants.getVCMainBus().JudgUserInfo();
                //
                //                }
                //                else
                //                {
                //                    if (!friendBtn.isSelected())
                //                    {
                //                        setAllBtnNoSelected();
                //                        friendBtn.setSelected(true);
                //                        AppConstants.getVCContactBus().enterContactLstFView();
                //                    }
                //                }
            }
        });

        //
        this.homeBtn.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                if (!homeBtn.isSelected())
                {
                    setAllBtnNoSelected();
                    homeBtn.setSelected(true);
                    AppSystemBus.getInstanceBus().commonSignal.disptach(AppConstants.bus_flag,
                            AppConstants.bus_flag_enter_mine_view);
                }

            }
        });

    }

    /**
     * 设置所有按钮为非选中状态
     * 
     * 
     * @author [vincent]
     * @date [2014年8月8日]
     * @retruntype [void]
     * @exception
     */
    public void setAllBtnNoSelected()
    {
        this.dynamicBtn.setSelected(false);
        this.friendBtn.setSelected(false);
        this.homeBtn.setSelected(false);
        this.circleBtn.setSelected(false);
        this.shareBtn.setSelected(false);
    }

    /********************************************************************************
     * 
     * 接口方法
     * 
     * 
     * 
     ********************************************************************************/
    @Override
    public void ssPreInit(Map<String, Object> arg0)
    {
    }

    @Override
    public void ssCreateView(Map<String, Object> arg0)
    {
    }

    @Override
    public void ssDestoryView(Map<String, Object> arg0)
    {
    }

    @Override
    public void ssDestroy(Map<String, Object> arg0)
    {
        this.dynamicBtn = null;
        this.friendBtn = null;
        this.homeBtn = null;
        this.circleBtn = null;
        this.shareBtn = null;
    }

    @Override
    public void ssDispose(Map<String, Object> arg0)
    {
    }

    @Override
    public void ssPause(Map<String, Object> arg0)
    {
    }

    @Override
    public void ssResume(Map<String, Object> arg0)
    {
    }

    @Override
    public void ssStart(Map<String, Object> arg0)
    {
        setSlelctDefult("dynamicBtn");
    }

    @Override
    public void ssStop(Map<String, Object> arg0)
    {
    }

}
