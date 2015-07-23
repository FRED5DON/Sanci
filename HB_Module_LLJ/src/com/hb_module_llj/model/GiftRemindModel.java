package com.hb_module_llj.model;

import java.io.Serializable;

/**
 * 送礼提醒bean
 * @author Fred
 *
 */
public class GiftRemindModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4298889460010287043L;

	/**
	 * 主题名称
	 */
	public String title;
	
	/**
	 * 发生日期
	 */
	public String occurDate;
	
	/**
	 * 提醒日期
	 */
	public String remindDate;
	
	/**
	 * 重复次数
	 */
	public int repeatCount;
	
	/**
	 * 详细描述（备注）
	 */
	public String desc;

	
	/**
	 * 是否是公历
	 */
	public boolean isStandardCalendar;
	
	
	
	public GiftRemindModel() {
		this.title="";
		this.occurDate="";
		this.remindDate="";
		this.desc="";
		isStandardCalendar=true;
	}
	
	
	
	public GiftRemindModel(String title, String occurDate, String remindDate,
			int repeatCount, String desc) {
		super();
		this.title = title;
		this.occurDate = occurDate;
		this.remindDate = remindDate;
		this.repeatCount = repeatCount;
		this.desc = desc;
	}



	public GiftRemindModel(String title, String occurDate, String remindDate,
			int repeatCount, String desc, boolean calendar) {
		super();
		this.title = title;
		this.occurDate = occurDate;
		this.remindDate = remindDate;
		this.repeatCount = repeatCount;
		this.desc = desc;
		this.isStandardCalendar = calendar;
	}



	@Override
	public String toString() {
		return "GiftRemindModel [title=" + title + ", occurDate=" + occurDate
				+ ", remindDate=" + remindDate + ", repeatCount=" + repeatCount
				+ ", desc=" + desc + ", calendar=" + isStandardCalendar + "]";
	}



	 
	
	
}
