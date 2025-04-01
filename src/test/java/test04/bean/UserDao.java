package test04.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {

    public static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("1001","hello");
        hashMap.put("1002","world");
        hashMap.put("1003","unnode");
    }

    public String queryUserName(String uId){
        return hashMap.get(uId);
    }
}
