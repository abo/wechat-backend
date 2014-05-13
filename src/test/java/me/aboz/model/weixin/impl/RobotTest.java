/**
 * Title:		TRS SMAS
 * Copyright:	Copyright(c) 2011-2014,TRS. All rights reserved.
 * Company:		北京拓尔思信息技术股份有限公司(www.trs.com.cn)
 */
package me.aboz.model.weixin.impl;

import static org.junit.Assert.*;

import javax.xml.stream.XMLStreamException;

import me.aboz.model.weixin.Message;
import me.aboz.model.weixin.MessageTest;

import org.junit.Test;

/**
 * @since huangshengbo @ Mar 29, 2014 3:33:25 PM
 *
 */
public class RobotTest {
	
	@Test
	public void test() throws XMLStreamException {
		Message request = Message.parseXML(MessageTest.Message_Text);
		Message response = new Robot().respond(request);
		assertEquals(request.getFrom(),response.getTo());
		assertEquals(request.getTo(),response.getFrom());
	}

}
