package myclass;

/**
 * Created by Tyhj on 2017/3/9.
 */

public class User {

    private String name,signature,sex,mainAddress,headImage;

    private String[] address;

    private volatile static User instance; //声明成 volatile

    private User (){}

    private User(String name, String signature, String sex, String mainAddress, String headImage, String[] address) {
        this.name = name;
        this.signature = signature;
        this.sex = sex;
        this.mainAddress = mainAddress;
        this.headImage = headImage;
        this.address = address;
    }

    public static User getSingleton() {
        if (instance == null) {
            synchronized (User.class) {
                if (instance == null) {
                    instance = new User();
                }
            }
        }
        return instance;
    }

    public static void setInstance(String name, String signature, String sex, String mainAddress, String headImage, String[] address){
        instance=new User(name,signature,sex,mainAddress,headImage,address);
    }



}
