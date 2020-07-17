package com.aaa.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/*
* json转换工具类
* */
public class JSONUtils {
    /*1 定义私有的静态常量ObjectMapper(明明规则:所有字母大写单词之间_链接
    * ObjectMapper:就是fastjson包中的进行类型转换的工具类*/
    private static final ObjectMapper OBJECT_MAPPER=new ObjectMapper();
    /**
     * 功能描述: <br>
     * 〈〉
     * 把对象转化为json字符串
     * @Param: [object]
     * @Return: java.lang.String
     * @Author: lp123456
     * @Date: 2020/7/10 17:49
     */
    public static String toJsonString(Object object){
        try{
            String jsonString = OBJECT_MAPPER.writeValueAsString(object);
            return jsonString;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 功能描述: <br>
     * 〈〉把json转化为指定的对象
     * <T> 定义了一个类型
     * T 返回值类型
     * @Param: [jsonData,传入json的对象
     *          beanType]所需要转化为对象的目标类型
     * @Return: T
     * @Author: lp123456
     * @Date: 2020/7/10 17:54
     */
    public static <T> T toObject(String jsonData,Class<T> beanType){
        try {
            T t = OBJECT_MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 功能描述: <br>
     * 〈〉把json转化为List集合
     * @Param: [jsonData, beanType]
     * @Return: java.util.List<T>
     * @Author: lp123456
     * @Date: 2020/7/10 18:50
     */
    public static <T> List<T> toList(String jsonData,Class<T> beanType){
        //位list集合添加指定的泛型
        //List User.class----->通过construParametricType方法把List和User合并.也就是说为List指定一个User对象的泛型(List<User>)
        JavaType javaType=OBJECT_MAPPER.getTypeFactory().constructParametricType(List.class,beanType);
        try {
            List<T> list = OBJECT_MAPPER.readValue(jsonData, javaType);
            return list;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
