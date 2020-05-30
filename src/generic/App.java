package generic;

import java.util.HashMap;

public class App {
    static HashMap<String, String> sMap = new HashMap<String, String>();
    public static void main(String[] args) {

        sMap.put("1", "23");
        sMap.put("2", "ad");
        sMap.put("3", "1.0");
        sMap.put("4", "false");
        int i = getUserInfoByKey("1", Integer.class, 1);
        String s = getUserInfoByKey("2", String.class, "null");
        float f = getUserInfoByKey("3", Float.class, -0.1f);
        boolean b = getUserInfoByKey("4", Boolean.class, true);
        System.out.println("i:"+i);
        System.out.println("s:"+s);
        System.out.println("f:"+f);
        System.out.println("b:"+b);
    }

    protected static <T> T getUserInfoByKey(String key, Class<T> clazz, T deffault) {
        T ret = null;
        String v = sMap.get(key);
        if (deffault instanceof Integer) {
            ret = (clazz.cast(Integer.parseInt(v)));
        } else if (deffault instanceof String) {
            ret = clazz.cast(v);
        } else if (deffault instanceof Double) {
            ret = clazz.cast(Double.parseDouble(v));
        } else if (deffault instanceof Float) {
            ret = clazz.cast(Float.parseFloat(v));
        } else if (deffault instanceof Long) {
            ret = clazz.cast(Long.parseLong(v));
        } else if (deffault instanceof Boolean) {
            ret = clazz.cast(Boolean.parseBoolean(v));
        }
        if (null != ret) {
            return ret;
        }
        return deffault;
    }
}