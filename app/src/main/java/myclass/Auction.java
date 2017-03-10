package myclass;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by Tyhj on 2017/3/1.
 */

public class Auction implements Serializable{
    //展示图片
    private String imageUrl;
    //拍品名字
    private String title;
    // 起拍价格
    private int price;
    //预期价格
    private int expectPrice;
    //  开拍时间
    private String startTime;
    //结束时间
    private String endTime;

    //保证金
    private int cashDeposit;
    //每次加价
    private int addMoney;
    //作者介绍
    private String authorIntroduce;
    //重量
    private float weight;
    //材质
    private String texture;
    //尺寸
    private String size;
    //工艺
    private String craft;
    //颜色
    private String color;
    //题材
    private String theme;
    //款式
    private String style;
    //拍品详情
    private String crowryDetails;
    //拍品banner展示图片
    private String[] crowryImages;
    //什么宣传照片
    private String[] adImages;

    //推荐人头像
    private String sugggestImage;

    //推荐人名字
    private String suggestName;


    public Auction(String imageUrl, String title, int price, int expectPrice, String startTime, String endTime, int cashDeposit, int addMoney, String authorIntroduce, float weight, String texture, String size, String craft, String color, String theme, String style, String crowryDetails, String[] crowryImages, String[] adImages, String sugggestImage, String suggestName) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.price = price;
        this.expectPrice = expectPrice;
        this.startTime = startTime;
        this.endTime = endTime;
        this.cashDeposit = cashDeposit;
        this.addMoney = addMoney;
        this.authorIntroduce = authorIntroduce;
        this.weight = weight;
        this.texture = texture;
        this.size = size;
        this.craft = craft;
        this.color = color;
        this.theme = theme;
        this.style = style;
        this.crowryDetails = crowryDetails;
        this.crowryImages = crowryImages;
        this.adImages = adImages;
        this.sugggestImage = sugggestImage;
        this.suggestName = suggestName;
    }

    public String getStartTime() {
        return "开场时间："+startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price+"";
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getExpectPrice() {
        return expectPrice+"";
    }

    public void setExpectPrice(int expectPrice) {
        this.expectPrice = expectPrice;
    }

    public String getCashDeposit() {
        return cashDeposit+"";
    }

    public void setCashDeposit(int cashDeposit) {
        this.cashDeposit = cashDeposit;
    }

    public String getAddMoney() {
        return addMoney+"";
    }

    public void setAddMoney(int addMoney) {
        this.addMoney = addMoney;
    }

    public String getAuthorIntroduce() {
        return authorIntroduce;
    }

    public void setAuthorIntroduce(String authorIntroduce) {
        this.authorIntroduce = authorIntroduce;
    }

    public String getWeight() {
        return weight+"";
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCraft() {
        return craft;
    }

    public void setCraft(String craft) {
        this.craft = craft;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getCrowryDetails() {
        return crowryDetails;
    }

    public void setCrowryDetails(String crowryDetails) {
        this.crowryDetails = crowryDetails;
    }

    public String[] getCrowryImages() {
        return crowryImages;
    }

    public void setCrowryImages(String[] crowryImages) {
        this.crowryImages = crowryImages;
    }

    public String[] getAdImages() {
        return adImages;
    }

    public void setAdImages(String[] adImages) {
        this.adImages = adImages;
    }

    public String getSugggestImage() {
        return sugggestImage;
    }

    public void setSugggestImage(String sugggestImage) {
        this.sugggestImage = sugggestImage;
    }

    public String getSuggestName() {
        return suggestName;
    }

    public void setSuggestName(String suggestName) {
        this.suggestName = suggestName;
    }

    public String getRoundprice(){
        if(price>100000000)
            return "起拍价"+(price/100000000)+"亿";
        if(price>100000000)
            return "起拍价"+(price/10000)+"万";
        if(price>1000)
            return "起拍价"+(price/1000)+"千";
        if(price>100)
            return "起拍价"+(price/100)+"百";
        return "起拍价"+(price/1)+"元";
    }

    @Override
    public String toString() {
        return "Auction{" +
                "imageUrl='" + imageUrl + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", expectPrice=" + expectPrice +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", cashDeposit=" + cashDeposit +
                ", addMoney=" + addMoney +
                ", authorIntroduce='" + authorIntroduce + '\'' +
                ", weight=" + weight +
                ", texture='" + texture + '\'' +
                ", size='" + size + '\'' +
                ", craft='" + craft + '\'' +
                ", color='" + color + '\'' +
                ", theme='" + theme + '\'' +
                ", style='" + style + '\'' +
                ", crowryDetails='" + crowryDetails + '\'' +
                ", crowryImages=" + Arrays.toString(crowryImages) +
                ", adImages=" + Arrays.toString(adImages) +
                ", sugggestImage='" + sugggestImage + '\'' +
                ", suggestName='" + suggestName + '\'' +
                '}';
    }
}
