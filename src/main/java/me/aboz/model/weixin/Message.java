/**
 * Title:		TRS SMAS
 * Copyright:	Copyright(c) 2011-2013,TRS. All rights reserved.
 * Company:		北京拓尔思信息技术股份有限公司(www.trs.com.cn)
 */
package me.aboz.model.weixin;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 
 * @since huangshengbo @ Dec 28, 2013 10:50:03 PM
 * 
 */
public class Message {

	public static final String MESSAGE_TYPE_TEXT = "text";
	public static final String MESSAGE_TYPE_IMAGE = "image";
	public static final String MESSAGE_TYPE_VOICE = "voice";
	public static final String MESSAGE_TYPE_VIDEO = "video";
	public static final String MESSAGE_TYPE_LOCATION = "location";
	public static final String MESSAGE_TYPE_LINK = "link";
	public static final String MESSAGE_TYPE_NEWS = "news";

	public static final String ELEMENT_FROM_USER = "FromUserName";
	public static final String ELEMENT_TO_USER = "ToUserName";
	public static final String ELEMENT_CREATE_TIME = "CreateTime";
	public static final String ELEMENT_MSG_TYPE = "MsgType";
	public static final String ELEMENT_MSG_ID = "MsgId";
	
	public static final String ELEMENT_LIST_ITEM = "item";

	public static final String TEXT_ELEMENT_CONTENT = "Content";

	public static final String IMAGE_ELEMENT_PICTURE_URL = "PicUrl";
	public static final String IMAGE_ELEMENT_MEDIA_ID = "MediaId";
	public static final String IMAGE_ELEMENT_IMAGE = "Image";

	public static final String VOICE_ELEMENT_MEDIA_ID = "MediaId";
	public static final String VOICE_ELEMENT_FORMAT = "MediaId";

	public static final String VIDEO_ELEMENT_THUMB_MEDIA_ID = "MediaId";
	public static final String VIDEO_ELEMENT_MEDIA_ID = "MediaId";

	public static final String LOCATION_ELEMENT_LATITUDE = "Location_X";
	public static final String LOCATION_ELEMENT_LONGITUDE = "Location_Y";
	public static final String LOCATION_ELEMENT_SCALE = "Scale";
	public static final String LOCATION_ELEMENT_LABEL = "Label";

	public static final String LINK_ELEMENT_TITLE = "Title";
	public static final String LINK_ELEMENT_DESCRIPTION = "Description";
	public static final String LINK_ELEMENT_URL = "Url";
	
	public static final String NEWS_ELEMENT_ARTICLECOUNT = "ArticleCount";
	public static final String NEWS_ELEMENT_ARTICLES = "Articles";
	public static final String NEWS_ELEMENT_ARTICLE = "item";
	public static final String NEWS_ELEMENT_ARTICLE_TITLE = "Title";
	public static final String NEWS_ELEMENT_ARTICLE_DESCRIPTION = "Description";
	public static final String NEWS_ELEMENT_ARTICLE_PICURL = "PicUrl";
	public static final String NEWS_ELEMENT_ARTICLE_URL = "Url";
	
	private String to;
	private String from;
	private long createdTime;
	private String type;
	private long id;
	private Map<String, Object> additionalInfo = new HashMap<String, Object>();

	public Map<String, Object> getAdditionalInfo() {
		return additionalInfo;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public long getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(long createdTime) {
		this.createdTime = createdTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("type", type)
				.append("createdtime", createdTime).append("from", from)
				.append("to", to).append("additional",additionalInfo).build();
	}

	public static Message parseXML(String xml) throws XMLStreamException {
		XMLInputFactory f = XMLInputFactory.newInstance();
		XMLStreamReader r = f.createXMLStreamReader(new StringReader(xml));
		Message result = new Message();
		String currentElement = null;
		while (r.hasNext()) {
			switch (r.next()) {
			case XMLStreamReader.START_ELEMENT:
				currentElement = r.getLocalName();
				break;
			case XMLStreamReader.END_ELEMENT:
				currentElement = null;
				break;
			case XMLStreamReader.CHARACTERS:
				if (!r.isWhiteSpace()) {
					String text = r.getText();
					if (ELEMENT_TO_USER.equals(currentElement)) {
						result.setTo(text);
					} else if (ELEMENT_FROM_USER.equals(currentElement)) {
						result.setFrom(text);
					} else if (ELEMENT_CREATE_TIME.equals(currentElement)) {
						result.setCreatedTime(Long.parseLong(text));
					} else if (ELEMENT_MSG_TYPE.equals(currentElement)) {
						result.setType(text);
					} else if (ELEMENT_MSG_ID.equals(currentElement)) {
						result.setId(Long.parseLong(text));
					} else {
						result.additionalInfo.put(currentElement, text);
					}
				}
			}
		}
		return result;
	}

	public String toXML() throws XMLStreamException {
		XMLOutputFactory f = XMLOutputFactory.newInstance();
		StringWriter sw = new StringWriter();
		XMLStreamWriter w = f.createXMLStreamWriter(sw);
		w.writeStartDocument();
		w.writeStartElement("xml");
		if (!StringUtils.isEmpty(this.getTo())) {
			w.writeStartElement(ELEMENT_TO_USER);
			w.writeCData(this.getTo());
			w.writeEndElement();
		}
		if (!StringUtils.isEmpty(this.getFrom())) {
			w.writeStartElement(ELEMENT_FROM_USER);
			w.writeCData(this.getFrom());
			w.writeEndElement();
		}
		if (!StringUtils.isEmpty(this.getType())) {
			w.writeStartElement(ELEMENT_MSG_TYPE);
			w.writeCData(this.getType());
			w.writeEndElement();
		}
		if (this.getCreatedTime() > 0) {
			w.writeStartElement(ELEMENT_CREATE_TIME);
			w.writeCharacters(String.valueOf(this.getCreatedTime()));
			w.writeEndElement();
		}
		if (this.getId() > 0) {
			w.writeStartElement(ELEMENT_MSG_ID);
			w.writeCharacters(String.valueOf(this.getId()));
			w.writeEndElement();
		}

		writeMap(w, this.additionalInfo);

		w.writeEndDocument();
		w.flush();
		sw.flush();
		return sw.toString();
	}
	
	protected static void writeMap(XMLStreamWriter writer,Map<String,Object> content) throws XMLStreamException{
		Iterator<String> iter = content.keySet().iterator();
		while (iter.hasNext()) {
			String ele = iter.next();
			write(writer, ele, content.get(ele));
		}
	}
	
	protected static void writeList(XMLStreamWriter writer,List<Object> content) throws XMLStreamException{
		Iterator<Object> iter = content.iterator();
		while (iter.hasNext()) {
			write(writer,ELEMENT_LIST_ITEM, iter.next());
		}
	}
	
	private static void write(XMLStreamWriter writer, String name, Object content) throws XMLStreamException{
		writer.writeStartElement(name);
		if (content instanceof Map<? ,?>){
			@SuppressWarnings("unchecked")
			Map<String,Object> m = (Map<String,Object>)content;
			writeMap(writer, m);
		} else if(content instanceof List){
			@SuppressWarnings("unchecked")
			List<Object> l = (List<Object>)content;
			writeList(writer, l);
		}else if (content instanceof String) {
			writer.writeCData(String.valueOf(content));
		} else {
			writer.writeCharacters(String.valueOf(content));
		}
		writer.writeEndElement();
	}
}
