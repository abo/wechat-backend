/**
 * Title:		TRS SMAS
 * Copyright:	Copyright(c) 2011-2014,TRS. All rights reserved.
 * Company:		北京拓尔思信息技术股份有限公司(www.trs.com.cn)
 */
package me.aboz.util;

import java.nio.charset.Charset;

import org.springframework.http.converter.StringHttpMessageConverter;

/**
 * 
 * @since huangshengbo @ Jan 5, 2014 12:54:34 AM
 *
 */
public class UTF8StringHttpMessageConverter extends StringHttpMessageConverter {

	public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

	public UTF8StringHttpMessageConverter() {
		super(DEFAULT_CHARSET);
	}

}
