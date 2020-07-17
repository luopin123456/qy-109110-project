package com.aaa.utils;

import org.springframework.util.DigestUtils;
import sun.misc.BASE64Decoder;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;

//字符串工具类
public class StringUtils {
    /**
     * 功能描述: <br>
     * 〈〉
     * @Param: [str]
     * @Return: java.lang.String
     * @Author: lp123456
     * @Date: 2020/7/10 18:54
     */
    public static String md5(String str){
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }
    /**
     * 功能描述: <br>
     * 〈〉杀空函数，将"null"和null对象转换为""
     * @Param: [str]
     * @Return: java.lang.String
     * @Author: lp123456
     * @Date: 2020/7/10 18:57
     */
    public static String killNull(String str){
        String returStr;
        if (str==null ||"null".equalsIgnoreCase(str)){
            returStr="";
        }else {
            returStr =str;
        }
        return  returStr;
    }/**
     * 功能描述: <br>
     * 〈〉去除字符串两边的空格并处理空字符串
     * @Param: [str]
     * @Return: java.lang.String
     * @Author: lp123456
     * @Date: 2020/7/10 18:59
     */
    public static String trim(String str){
        String returnStr;
        returnStr =killNull(str);
        returnStr=returnStr.trim();
        return returnStr;
    }
    /**
     * 功能描述: <br>
     * 〈〉判断字符串是否为空
     * @Param: [str]
     * @Return: boolean
     * @Author: lp123456
     * @Date: 2020/7/10 19:02
     */
    public static boolean isEmpty(String str){
        return str ==null ||str.trim().equals("");
    }
    /**
     * 功能描述: <br>
     * 〈〉判断字符串是否不为空
     * @Param: [str]
     * @Return: boolean
     * @Author: lp123456
     * @Date: 2020/7/10 19:02
     */
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }
    /**
     * 功能描述: <br>
     * 〈〉获取指定长度的随机字母和数字组合
     * @Param: [length]
     * @Return: java.lang.String指定长度的随机字母和数字组合
     * @Author: lp123456
     * @Date: 2020/7/10 19:12
     */
    public static String getCharAndNum(int length){
        String str="";
        Random random=new Random();
        for (int i = 0; i < length; i++) {
            String charOrNum =random.nextInt(2)% 2 ==0 ? "char" :"num";
            if ("char".equalsIgnoreCase(charOrNum)) {
                int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
                str +=(char)(choice+random.nextInt(26));

            }else if ("num".equalsIgnoreCase(charOrNum)){
                str+=String.valueOf(random.nextInt(10));
            }
        }
        return str;
    }
    /**
     * 功能描述: <br>
     * 〈〉将byte[]数组转为base64文本
     * @Param: [decByte]
     * @Return: java.lang.String
     * @Author: lp123456
     * @Date: 2020/7/10 19:22
     */
    public static final String byteToBase64(byte[] decByte) throws Exception{
        if (decByte==null)
            return "";
        String str="";
        try {
            str = new sun.misc.BASE64Encoder().encodeBuffer(decByte);
        }catch (Exception e){
            str="";
        }
        return str.replace("\r","").replace("\n","");
    }
    /**
     * 功能描述: <br>
     * 〈〉将 base64文本 转为  byte[]数组
     * @Param: [str]
     * @Return: byte[]
     * @Author: lp123456
     * @Date: 2020/7/10 19:26
     */
    public static final byte[] base64ToByte(String str)throws Exception{
        if (str==null)
            return null;
        byte[] decByte=null;
        try{
            new sun.misc.BASE64Decoder().decodeBuffer(str);
        }catch (Exception e){
            decByte=null;
        }
       return decByte;
    }
    /**
     * 功能描述: <br>
     * 〈〉将ErrorStack转化为String.
     * @Param: [throwable]
     * @Return: java.lang.String
     * @Author: lp123456
     * @Date: 2020/7/10 19:29
     */
    public static String getExceptionAsString(Throwable throwable){
        if (throwable==null){
            return "";
        }
        StringWriter stringWriter=new StringWriter();
        throwable.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

}
