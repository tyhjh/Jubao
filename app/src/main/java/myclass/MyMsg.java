package myclass;

/**
 * Created by Tyhj on 2017/3/13.
 */

public class MyMsg {
    private String title;
    private String content;
    private String headImage;

    public MyMsg(String title, String content, String headImage) {
        this.title = title;
        this.content = content;
        this.headImage = headImage;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }
}
