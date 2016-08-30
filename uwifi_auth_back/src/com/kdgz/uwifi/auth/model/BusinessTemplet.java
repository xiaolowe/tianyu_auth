package com.kdgz.uwifi.auth.model;

import com.jfinal.plugin.activerecord.Model;

@SuppressWarnings("serial")
public class BusinessTemplet extends Model<BusinessTemplet> {

	/**
	 * 
	 */
	public static final BusinessTemplet dao = new BusinessTemplet();

	/**
	 * 获取认证页模块
	 * 
	 * @param businessid
	 * @return
	 */
	public BusinessTemplet selectBusTemplate(final int businessid) {


						return BusinessTemplet.dao
								.findFirst(
										"select * from businesstemplet where businessid = ?",
										new Object[] { businessid });
	}

}
