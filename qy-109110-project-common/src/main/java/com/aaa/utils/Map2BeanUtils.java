package com.aaa.utils;

import com.esotericsoftware.reflectasm.MethodAccess;
import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Map2BeanUtils {
    private Map2BeanUtils(){

    }
    private final static Objenesis OBJENESIS =new ObjenesisStd(true);
    private final static StringBuilder STRING_BUILDER =new StringBuilder();
    private final static ConcurrentHashMap<Class, MethodAccess> CONCURRENT_HASH_MAP=new ConcurrentHashMap<Class, MethodAccess>(16);
/**
 * 功能描述: <br>
 * 〈〉map--->java bean
 * @Param: [map, clazz]
 * @Return: T
 * @Author: lp123456
 * @Date: 2020/7/9 16:53
 */
    public static <T> T map2Bean(Map<String, Object> map,Class<T> clazz){
        T instance =OBJENESIS.newInstance(clazz);
        MethodAccess methodAccess=CONCURRENT_HASH_MAP.get(clazz);
        if (null ==methodAccess){
            methodAccess= MethodAccess.get(clazz);
            CONCURRENT_HASH_MAP.putIfAbsent(clazz,methodAccess);
        }
        for (Map.Entry entry:map.entrySet()){
            String setMethodName=getSetMethodName((String)entry.getKey());
            int index = methodAccess.getIndex(setMethodName, entry.getValue().getClass());
            methodAccess.invoke(instance,index,entry.getValue());
        }
        return instance;
    }
    /**
     * 功能描述: <br>
     * 〈〉通过字段拼接方法名
     * @Param: [filedName]
     * @Return: java.lang.String
     * @Author: lp123456
     * @Date: 2020/7/9 16:54
     */
    private static String getSetMethodName(String filedName){
        STRING_BUILDER.setLength(0);
        return STRING_BUILDER.append("set").append(first2UpperCasea(filedName)).toString();
    }
    /**
     * 功能描述: <br>
     * 〈〉把属性首字母大写
     * @Param: [str]
     * @Return: java.lang.String
     * @Author: lp123456
     * @Date: 2020/7/9 16:54
     */
    private static String first2UpperCasea(String str){
        return str.substring(0,1).toUpperCase() +str.substring(1);
    }
}
