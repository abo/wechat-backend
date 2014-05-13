/**
 * Title:		TRS SMAS
 * Copyright:	Copyright(c) 2011-2014,TRS. All rights reserved.
 * Company:		北京拓尔思信息技术股份有限公司(www.trs.com.cn)
 */
package me.aboz.model.weixin;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;


/**
 * TODO
 * @since huangshengbo @ Jan 4, 2014 11:58:31 PM
 *
 */
public class IResponderTest {

	@Test
	public void test() throws XMLStreamException, MalformedURLException, IOException {
//		URL url = new URL("http://www.piaotian.net/html/3/3072/2826912.html");
//		   // NOTE: Use ArticleExtractor unless DefaultExtractor gives better results for you
//		String text = ArticleExtractor.INSTANCE.getText(url);
//		System.out.println(text);
		Message m = Message.parseXML("<xml><ToUserName><![CDATA[oSspeuL_T_UK1KtsUY-Fo40rd6v0]]></ToUserName><FromUserName><![CDATA[gh_b099fe907f08]]></FromUserName><MsgType><![CDATA[text]]></MsgType><CreateTime>1388853194353</CreateTime><Content><![CDATA[OK]]></Content></xml>");
		m.getAdditionalInfo().remove(Message.TEXT_ELEMENT_CONTENT);
		Map<String,Object> h = new HashMap<String,Object>();
		h.put("url", "hhhhttt");
		m.getAdditionalInfo().put("VIDEO", h);
		System.out.println(m.toXML());
	}

}
