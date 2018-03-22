package com.lulu.model.util;

import org.phprpc.util.AssocArray;
import org.phprpc.util.Cast;
import org.phprpc.util.PHPSerializer;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Map;

/**
 * @Description:
 * @Author: Milo.Ding
 * @Date: 2018/2/28 15:02
 */
public class PhpSerialUtil {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        String str = "a:2:{i:0;a:2:{s:7:\"orderid\";s:2:\"62\";s:5:\"level\";i:1;}i:1;a:2:{s:7:\"orderid\";s:2:\"74\";s:5:\"level\";i:1;}}";
        PHPSerializer phpSerializer = new PHPSerializer();
        Object object = phpSerializer.unserialize(str.getBytes());
        AssocArray array = null;
        if(object instanceof AssocArray){
            array = (AssocArray) object;
        }
        Map<Object,Object> map= array.toHashMap();
        initMap(map);
        System.out.println(map.toString());

    }

    public static void printMap(Map<Object,Object> map){
        for(Map.Entry<Object,Object> m: map.entrySet()){
            Object key  = m.getKey();
            Object value = m.getValue();
            if(value instanceof AssocArray){
                printMap(((AssocArray) value).toHashMap());
            }else if(value instanceof Map){
                printMap((Map<Object, Object>) value);
            }else if(value instanceof  Integer){
                System.out.println(key +":"+ Cast.cast(value,Integer.class));
            }else if(value instanceof BigDecimal){
                System.out.println(key +":"+ Cast.cast(value,BigDecimal.class));
            }else if(value instanceof  Float){
                System.out.println(key +":"+ Cast.cast(value,Float.class));
            }else if(value instanceof  Long){
                System.out.println(key +":"+ Cast.cast(value,Long.class));
            }else if(value instanceof Double){
                System.out.println(key +":"+ Cast.cast(value,Double.class));
            }else if(value instanceof  String){
                System.out.println(key + ":" + Cast.cast(value,String.class));
            }

        }
    }


    private static void initMap(Map<Object,Object> map){
        if(map != null && map.size() > 0){
            for(Object key : map.keySet()){
                Object obj = map.get(key);
                if(obj instanceof Map){
                    map.put(key, obj);
                    initMap((Map<Object, Object>) obj);
                }else if(obj instanceof AssocArray){
                    map.put(key, ((AssocArray) obj).toLinkedHashMap());
                    initMap(((AssocArray) obj).toLinkedHashMap());
                }else if(obj instanceof byte[]){
                    String value = new String((byte[]) obj);
                    map.put(key, value);
                }else if(obj instanceof String){
                    map.put(key, Cast.cast(obj,String.class));
                }else if(obj instanceof Integer){
                    map.put(key, Cast.cast(obj,Integer.class));
                }else if(obj instanceof Double){
                    map.put(key, Cast.cast(obj,Double.class));
                }else if(obj instanceof Float){
                    map.put(key, Cast.cast(obj,Float.class));
                }else if(obj instanceof Long){
                    map.put(key, Cast.cast(obj,Long.class));
                }
            }
        }
    }

}
