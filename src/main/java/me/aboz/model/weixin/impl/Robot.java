/**
 * Title:		TRS SMAS
 * Copyright:	Copyright(c) 2011-2013,TRS. All rights reserved.
 * Company:		北京拓尔思信息技术股份有限公司(www.trs.com.cn)
 */
package me.aboz.model.weixin.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import me.aboz.model.weixin.IHandler;
import me.aboz.model.weixin.IHandlerSelector;
import me.aboz.model.weixin.IResponder;
import me.aboz.model.weixin.Message;

/**
 * 微信应答服务器
 * @since huangshengbo @ Dec 28, 2013 11:56:01 PM
 *
 */
public class Robot implements IResponder {
	
	private static final String [] URLs = new String []{
		"http://mmbiz.qpic.cn/mmbiz/0oficarYWFatVYYGHXg4scdG2Uicx9gWk91QZdIrSHp5ubIcn9HHeDLnnU8ckbxarse2TcVamwgIgnWwtW6AFmJg/0",
		"http://mmbiz.qpic.cn/mmbiz/0oficarYWFatVYYGHXg4scdG2Uicx9gWk9GSRKhBicYj8Ds3xOwUmnT2BiapbQiadKoTQn1JFVQy4aJfGic00r6cibibmQ/0",
		"http://mmbiz.qpic.cn/mmbiz/0oficarYWFatVYYGHXg4scdG2Uicx9gWk9BVRIxfpXB7tibJUxL63ibHre2hgia6TqEn5kR62cPOroQHsnZfZb6JSYg/0",
		"http://mmbiz.qpic.cn/mmbiz/0oficarYWFatVYYGHXg4scdG2Uicx9gWk9ic2ILzmSOWX3jqDEPLgQNnhJ7ibD3yNCLl0FBDOdfq3ymzX6PxIvjEfg/0"};
	private static final String [] MEDIAIDs = new String []{
		"GKejzmHhWXHfoD0smCfcUKPIwv_8iyvKAB05NPnZzEvcU5RiNGmtxjoquye-vj1d",
		"VF3n02BWmFHsyFCyzAXaMaVU2sV3InXSzLGlyUvYLn0Tdf5CSvlP2ldvC7XLOdBt",
		"_ybeoCGAlFGXDFQngApCpoHGWfQOJCZvVzHh-TXHOKs",
		"mAYJZp-MI6bXipUxcziPT2JhdVOPxByJ8zkJFeZqQv5bbwuVEM0T8Y40honiZHO-"
	};
	
	private IHandlerSelector selector = new HandlerMapping().register(Message.MESSAGE_TYPE_TEXT, new IHandler(){

		@Override
		public boolean validate(Message request) {
			return true;
		}

		@Override
		public Message handle(Message request) {
			Message response = new Message();
			response.setTo(request.getFrom());
			response.setFrom(request.getTo());
			response.setCreatedTime(System.currentTimeMillis());
			response.setType(Message.MESSAGE_TYPE_NEWS);
			List<Map<String,String>> articles = new ArrayList<Map<String,String>>();
			Map<String,String> article = new HashMap<String,String>();
			
			String content = (String)request.getAdditionalInfo().get(Message.TEXT_ELEMENT_CONTENT);
			int separatorIndex = -1;
			if( (separatorIndex = content.indexOf('#')) > 0){
				article.put(Message.NEWS_ELEMENT_ARTICLE_TITLE, content.substring(0, separatorIndex));
				article.put(Message.NEWS_ELEMENT_ARTICLE_DESCRIPTION, content.substring(separatorIndex+1));
			}else{
				article.put(Message.NEWS_ELEMENT_ARTICLE_TITLE, content);
				article.put(Message.NEWS_ELEMENT_ARTICLE_DESCRIPTION, content);
			}
			
			article.put(Message.NEWS_ELEMENT_ARTICLE_PICURL, URLs[new Random().nextInt(4)] );
			if(content.endsWith(")") && content.contains("(")){
				article.put(Message.NEWS_ELEMENT_ARTICLE_URL, content.substring(content.lastIndexOf("(")+1,content.length()-2)); 
			}else{
				article.put(Message.NEWS_ELEMENT_ARTICLE_URL, "http://aboz.me/");
			}
			articles.add(article);
			
			response.getAdditionalInfo().put(Message.NEWS_ELEMENT_ARTICLECOUNT, articles.size());
			response.getAdditionalInfo().put(Message.NEWS_ELEMENT_ARTICLES, articles);
			return response;
		}
		
	});
	//TODO register handlers
	
	public Message respond(Message request){
		IHandler handler = selector.select(request);
		if(handler != null){
			return handler.handle(request);
		}
		
		Message response = new Message();
		response.setTo(request.getFrom());
		response.setFrom(request.getTo());
		response.setCreatedTime(System.currentTimeMillis());
		
		response.setType(Message.MESSAGE_TYPE_IMAGE);
		Map<String,String> image = new HashMap<String,String>();
		image.put(Message.IMAGE_ELEMENT_MEDIA_ID, MEDIAIDs[new Random().nextInt(4)]);
		response.getAdditionalInfo().put(Message.IMAGE_ELEMENT_IMAGE, image);
		return response;
	}
}