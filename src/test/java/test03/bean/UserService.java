package test03.bean;

public class UserService {

    String name;

    public UserService(String name) {
        this.name = name;
    }

    public void queryUserInfo(){
        System.out.println("hello" + name);
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("").append(name);
        return stringBuilder.toString();
    }
}
