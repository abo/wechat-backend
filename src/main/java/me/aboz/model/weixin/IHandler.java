/**
 * Title:		TRS SMAS
 * Copyright:	Copyright(c) 2011-2013,TRS. All rights reserved.
 * Company:		北京拓尔思信息技术股份有限公司(www.trs.com.cn)
 */
package me.aboz.model.weixin;

/**
 * 
 * @since huangshengbo @ Dec 29, 2013 1:17:59 AM
 *
 */
public interface IHandler {
	
	public boolean validate(Message request);

	public Message handle(Message request);
}
