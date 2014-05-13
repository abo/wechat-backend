/**
 * Title:		TRS SMAS
 * Copyright:	Copyright(c) 2011-2014,TRS. All rights reserved.
 * Company:		北京拓尔思信息技术股份有限公司(www.trs.com.cn)
 */
package me.aboz.model.weixin;

import static org.junit.Assert.*;

import javax.xml.stream.XMLStreamException;

import org.junit.Test;

/**
 * 
 * @since huangshengbo @ Mar 29, 2014 4:27:48 PM
 * 
 */
public class MessageTest {

	public static final String Message_Image = "<xml><ToUserName><![CDATA[gh_b099fe907f08]]></ToUserName><FromUserName><![CDATA[oSspeuL_T_UK1KtsUY-Fo40rd6v0]]></FromUserName><CreateTime>1396017990</CreateTime><MsgType><![CDATA[image]]></MsgType><PicUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz/0oficarYWFavLU52yeBhqf7pLgrouQsIIsvjQDzdh3kAl4VNyCCAdsoYsVvAdzOiccAeq1oCaWuPJl7kRz4Y1OHw/0]]></PicUrl><MsgId>5995851611877864625</MsgId><MediaId><![CDATA[tx9lef23QRPALs1NGZu3aXwIOhRy7q8fmt31AiETGiE3jIF-nPoFO3KJZXSnLJKA]]></MediaId></xml>";
	public static final String Message_Location = "<xml><ToUserName><![CDATA[gh_b099fe907f08]]></ToUserName><FromUserName><![CDATA[oSspeuL_T_UK1KtsUY-Fo40rd6v0]]></FromUserName><CreateTime>1396018352</CreateTime><MsgType><![CDATA[location]]></MsgType><Location_X>40.033352</Location_X><Location_Y>116.354295</Location_Y><Scale>17</Scale><Label><![CDATA[]]></Label><MsgId>5995853166656025803</MsgId></xml>";
	public static final String Message_Text = "<xml><ToUserName><![CDATA[gh_b099fe907f08]]></ToUserName><FromUserName><![CDATA[oSspeuL_T_UK1KtsUY-Fo40rd6v0]]></FromUserName><CreateTime>1396018458</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[法国发生过好就可以特吃 v 胡 uu]]></Content><MsgId>5995853621922559183</MsgId></xml>";
	public static final String Message_Link = "<xml><ToUserName><![CDATA[gh_b099fe907f08]]></ToUserName><FromUserName><![CDATA[oSspeuL_T_UK1KtsUY-Fo40rd6v0]]></FromUserName><CreateTime>1396018678</CreateTime><MsgType><![CDATA[link]]></MsgType><Title><![CDATA[一个90后美女教你如何用互联网思维做情趣用品_ChinaVenture投资中国网]]></Title><Description><![CDATA[http://life.chinaventure.com.cn/life-661-1.html]]></Description><Url><![CDATA[http://life.chinaventure.com.cn/life-661-1.html]]></Url><MsgId>5995854566815364320</MsgId></xml>";
	public static final String Message_Voice = "<xml><ToUserName><![CDATA[gh_b099fe907f08]]></ToUserName><FromUserName><![CDATA[oSspeuL_T_UK1KtsUY-Fo40rd6v0]]></FromUserName><CreateTime>1396019581</CreateTime><MsgType><![CDATA[voice]]></MsgType><MediaId><![CDATA[KuFmIEtMKonNLXg2D_OMEmTz_lxwDKu6hMIbv3EODZBi_XOchIZQz_NfRXDxTDWq]]></MediaId><Format><![CDATA[amr]]></Format><MsgId>5995858445170832666</MsgId><Recognition><![CDATA[]]></Recognition></xml>";
	public static final String Message_Image_1 = "<xml><ToUserName><![CDATA[gh_b099fe907f08]]></ToUserName><FromUserName><![CDATA[oSspeuL_T_UK1KtsUY-Fo40rd6v0]]></FromUserName><CreateTime>1396082457</CreateTime><MsgType><![CDATA[image]]></MsgType><PicUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz/0oficarYWFatVYYGHXg4scdG2Uicx9gWk91QZdIrSHp5ubIcn9HHeDLnnU8ckbxarse2TcVamwgIgnWwtW6AFmJg/0]]></PicUrl><MsgId>5996128495534537903</MsgId><MediaId><![CDATA[GKejzmHhWXHfoD0smCfcUKPIwv_8iyvKAB05NPnZzEvcU5RiNGmtxjoquye-vj1d]]></MediaId></xml>";
	public static final String Message_Image_2 = "<xml><ToUserName><![CDATA[gh_b099fe907f08]]></ToUserName><FromUserName><![CDATA[oSspeuL_T_UK1KtsUY-Fo40rd6v0]]></FromUserName><CreateTime>1396082632</CreateTime><MsgType><![CDATA[image]]></MsgType><PicUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz/0oficarYWFatVYYGHXg4scdG2Uicx9gWk9GSRKhBicYj8Ds3xOwUmnT2BiapbQiadKoTQn1JFVQy4aJfGic00r6cibibmQ/0]]></PicUrl><MsgId>5996129247153814711</MsgId><MediaId><![CDATA[VF3n02BWmFHsyFCyzAXaMaVU2sV3InXSzLGlyUvYLn0Tdf5CSvlP2ldvC7XLOdBt]]></MediaId></xml>";
	public static final String Message_Image_3 = "<xml><ToUserName><![CDATA[gh_b099fe907f08]]></ToUserName><FromUserName><![CDATA[oSspeuL_T_UK1KtsUY-Fo40rd6v0]]></FromUserName><CreateTime>1396082781</CreateTime><MsgType><![CDATA[image]]></MsgType><PicUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz/0oficarYWFatVYYGHXg4scdG2Uicx9gWk9BVRIxfpXB7tibJUxL63ibHre2hgia6TqEn5kR62cPOroQHsnZfZb6JSYg/0]]></PicUrl><MsgId>5996129887103941828</MsgId><MediaId><![CDATA[_ybeoCGAlFGXDFQngApCpoHGWfQOJCZvVzHh-TXHOKs]]></MediaId></xml>";
	public static final String Message_Image_4 = "<xml><ToUserName><![CDATA[gh_b099fe907f08]]></ToUserName><FromUserName><![CDATA[oSspeuL_T_UK1KtsUY-Fo40rd6v0]]></FromUserName><CreateTime>1396082836</CreateTime><MsgType><![CDATA[image]]></MsgType><PicUrl><![CDATA[http://mmbiz.qpic.cn/mmbiz/0oficarYWFatVYYGHXg4scdG2Uicx9gWk9ic2ILzmSOWX3jqDEPLgQNnhJ7ibD3yNCLl0FBDOdfq3ymzX6PxIvjEfg/0]]></PicUrl><MsgId>5996130123327143120</MsgId><MediaId><![CDATA[mAYJZp-MI6bXipUxcziPT2JhdVOPxByJ8zkJFeZqQv5bbwuVEM0T8Y40honiZHO-]]></MediaId></xml>";

	@Test
	public void test() throws XMLStreamException {
		Message imageRequest = Message.parseXML(Message_Image);
		assertEquals("oSspeuL_T_UK1KtsUY-Fo40rd6v0",imageRequest.getFrom());
		assertEquals("gh_b099fe907f08",imageRequest.getTo());
		assertEquals("image",imageRequest.getType());
		
		Message.parseXML(Message_Location);
		Message.parseXML(Message_Text);
		Message.parseXML(Message_Link);
		Message.parseXML(Message_Voice);
	}

}
