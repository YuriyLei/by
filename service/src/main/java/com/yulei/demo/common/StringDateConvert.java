package com.yulei.demo.common;

import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Bean 字段 string 类型和 Date类型的互换
 * @date 2015年12月19日 下午5:12:47
 */
public class StringDateConvert extends BidirectionalConverter<Date, String>{
	
	private static final Logger LOGGER= LoggerFactory.getLogger(StringDateConvert.class);
	
	@Override
	public String convertTo(Date source, Type<String> destinationType) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		String str=sdf.format(source);
		return str;
	}

	@Override
	public Date convertFrom(String source, Type<Date> destinationType) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(source);
		} catch (ParseException e) {
			LOGGER.error("===>>>> 重百上送日期格式错误!",e);
		} 
		return date;
	}


}
