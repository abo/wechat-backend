/**
 * Title:		TRS SMAS
 * Copyright:	Copyright(c) 2011-2014,TRS. All rights reserved.
 * Company:		北京拓尔思信息技术股份有限公司(www.trs.com.cn)
 */
package me.aboz.model.weixin.impl;

import java.util.ArrayList;
import java.util.List;

import me.aboz.model.weixin.IHandler;
import me.aboz.model.weixin.IHandlerSelector;
import me.aboz.model.weixin.Message;

/**
 * 
 * @since huangshengbo @ Mar 13, 2014 9:14:42 AM
 *
 */
public class HandlerChain implements IHandlerSelector {
	
	private List<IHandler> handlerChain = new ArrayList<IHandler>();
	
	public HandlerChain register(int index,IHandler handler){
		handlerChain.add(index, handler);
		return this;
	}

	/* (non-Javadoc)
	 * @see me.aboz.model.weixin.IHandlerSelector#select(me.aboz.model.weixin.Message)
	 */
	@Override
	public IHandler select(Message request) {
		for(IHandler handler : handlerChain){
			if(handler.validate(request)){
				return handler;
			}
		}
		return null;
	}

}
