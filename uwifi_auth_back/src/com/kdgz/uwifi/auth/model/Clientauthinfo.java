package com.kdgz.uwifi.auth.model;

import java.io.Serializable;

import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Model;

public class Clientauthinfo extends Model<Clientauthinfo> implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4909782112073595412L;
	/**
	 * 
	 */
	public static final Clientauthinfo dao = new Clientauthinfo();

	/**
	 * 
	 * @param stage
	 * @param mac
	 * @return
	 */
	public Clientauthinfo selectClientauthinfoByItem(String acid, String stage,
			String mac) {

		StringBuffer sql = new StringBuffer();
		sql.append("select * from clientauthinfo where 1=1 ");
		if (StrKit.notBlank(acid)) {
			sql.append(" and acid = '" + acid + "' ");
		}
		if (StrKit.notBlank(stage)) {
			sql.append(" and stage = '" + stage + "' ");
		}
		if (StrKit.notBlank(mac)) {
			sql.append(" and mac = '" + mac + "' ");
		}

		Clientauthinfo clientauthinfo = dao.findFirst(sql.toString());

		return clientauthinfo;
	}

	/**
	 * 
	 * @param acid
	 * @return
	 */
	public Clientauthinfo selectClientauthByacIds(String acids, String stage,
			String mac) {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from clientauthinfo where 1=1");
		if (StrKit.notBlank(acids)) {
			sql.append(" and acid in (" + acids + ")");
		}
		if (StrKit.notBlank(mac)) {
			sql.append(" and mac = '" + mac + "' ");
		}
		sql.append(" and stage = '" + stage + "' order by authtime desc");

		Clientauthinfo clientauthinfo = dao.findFirst(sql.toString());
		return clientauthinfo;

	}

}
