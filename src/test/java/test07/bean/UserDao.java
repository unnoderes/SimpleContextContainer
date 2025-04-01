package test07.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "unnode");
        hashMap.put("10002", "hello");
        hashMap.put("10003", "world");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
