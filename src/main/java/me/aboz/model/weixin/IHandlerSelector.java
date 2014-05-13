/**
 * Title:		TRS SMAS
 * Copyright:	Copyright(c) 2011-2014,TRS. All rights reserved.
 * Company:		北京拓尔思信息技术股份有限公司(www.trs.com.cn)
 */
package me.aboz.model.weixin;

/**
 * 
 * @since huangshengbo @ Mar 13, 2014 9:07:48 AM
 *
 */
public interface IHandlerSelector {

	public IHandler select(Message request);
	
}
