package test16.bean;

import io.unnode.beans.annotationconfig.autoscan.annotation.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "unnode1，shenyang，heping");
        hashMap.put("10002", "unnode2，beijing，haidian");
        hashMap.put("10003", "unnode3，yingkou，zhanqian");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

}