package myclass;

/**
 * Created by Tyhj on 2017/3/8.
 */

public class Order {
    private String cowryImage;
    private String sessionName;
    private String cowryName;
    private String endTime;
    private String startTime;
    private int status;
    private double money;

    public Order(String cowryImage, String sessionName, String cowryName, String endTime, String startTime, int status, float money) {
        this.cowryImage = cowryImage;
        this.sessionName = sessionName;
        this.cowryName = cowryName;
        this.endTime = endTime;
        this.startTime = startTime;
        this.status = status;
        this.money = money;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getCowryName() {
        return cowryName;
    }

    public void setCowryName(String cowryName) {
        this.cowryName = cowryName;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getCowryImage() {
        return cowryImage;
    }

    public void setCowryImage(String cowryImage) {
        this.cowryImage = cowryImage;
    }
}
