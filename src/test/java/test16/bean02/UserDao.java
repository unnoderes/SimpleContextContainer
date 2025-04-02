package test16.bean02;

import io.unnode.beans.annotationconfig.autoscan.annotation.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "unnodeX，xxx，111");
        hashMap.put("10002", "unnodeY，yyy，222");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
