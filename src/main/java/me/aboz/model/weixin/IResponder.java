/**
 * Title:		TRS SMAS
 * Copyright:	Copyright(c) 2011-2013,TRS. All rights reserved.
 * Company:		北京拓尔思信息技术股份有限公司(www.trs.com.cn)
 */
package me.aboz.model.weixin;

/**
 * 微信应答服务接口
 * @since huangshengbo @ Dec 29, 2013 1:27:46 AM
 *
 */
public interface IResponder {

	public Message respond(Message request);
	
}
