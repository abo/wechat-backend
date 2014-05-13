/**
 * Title:		TRS SMAS
 * Copyright:	Copyright(c) 2011-2014,TRS. All rights reserved.
 * Company:		北京拓尔思信息技术股份有限公司(www.trs.com.cn)
 */
package me.aboz.model.weixin.impl;

import java.util.HashMap;
import java.util.Map;

import me.aboz.model.weixin.IHandler;
import me.aboz.model.weixin.IHandlerSelector;
import me.aboz.model.weixin.Message;

/**
 * 
 * @since huangshengbo @ Mar 13, 2014 9:09:49 AM
 *
 */
public class HandlerMapping implements IHandlerSelector {
	
	private Map<String, IHandler> handlerMapping = new HashMap<String,IHandler>();
	
	public HandlerMapping register(String messageType, IHandler handler){
		handlerMapping.put(messageType, handler);
		return this;
	}

	/* (non-Javadoc)
	 * @see me.aboz.model.weixin.IHandlerSelector#select(me.aboz.model.weixin.Message)
	 */
	@Override
	public IHandler select(Message request) {
		return handlerMapping.get(request.getType());
	}
}
