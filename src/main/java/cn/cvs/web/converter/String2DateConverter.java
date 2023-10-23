package cn.cvs.web.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class String2DateConverter implements Converter<String, Date> {
    private final String datePattern;

    public String2DateConverter(String datePattern) {
        this.datePattern = datePattern;
    }

    /**
     * 具体的字符串转日期功能方法
     */
    @Override
    public Date convert(String dateString) {
        Date date = null;
        try {
            date = new SimpleDateFormat(datePattern).parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}
