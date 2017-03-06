package demand.example.tyhj.jubao;

import android.graphics.Bitmap;
import android.os.Build;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import myView.BlurUtil;
import myclass.Essay;
import tools.Defined;
import tools.For2mat;

@EActivity(R.layout.activity_show_essay)
public class ShowEssay extends AppCompatActivity {

    public static String transition_essayImage="transition_essayImage";
    public static String transition_title="transition_title";
    public static String transition_essayContent="";
    public static String transition_likeIcon="transition_likeIcon";
    public static String transition_likes="transition_likes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        essay= (Essay) getIntent().getSerializableExtra("essay");
        bitmap=bitmapList.get(essay.getId()+"");
    }

    public static HashMap<String,Bitmap> bitmapList= new HashMap<String,Bitmap>();

    private Essay essay;

    private Bitmap bitmap;

    @ViewById
    CollapsingToolbarLayout maincollapsing;
    @ViewById
    TextView tvEssayBody, tv_name, tv_signature,tv_likesCount;
    @ViewById
    ImageView BlurredView2,iv_likes;
    @ViewById
    Toolbar maintoolbar;
    @ViewById
    ImageView iv_userHeadImage;

    @Click(R.id.maintoolbar)
    void back() {
        this.finish();
    }

    @Background
    void setBlurredImg(){
        if(bitmap==null)
            bitmap= For2mat.url2Bitmap(essay.getImageUrl());
        else
            getBlurredImg(bitmap);
    }

    @AfterViews
    void afterView(){
        setBlurredImg();
        maincollapsing.setTitle(essay.getName() + "");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            iv_userHeadImage.setClipToOutline(true);
            iv_userHeadImage.setOutlineProvider(Defined.getOutline(true, 10, 0));
        }

        if (essay.getUserHeadImageUrl() != null)
            Picasso.with(this).load(essay.getUserHeadImageUrl()).error(R.mipmap.girl).into(iv_userHeadImage);
        else
            Picasso.with(this).load(R.mipmap.girl).into(iv_userHeadImage);


        tv_name.setText(essay.getUserName());

        tvEssayBody.setText(essay.getDetails());

        tv_signature.setText(essay.getSignature());

        setTransitions();

    }

    private void setTransitions() {
        ViewCompat.setTransitionName(tvEssayBody, transition_essayContent);
        ViewCompat.setTransitionName(BlurredView2, transition_essayImage);
        ViewCompat.setTransitionName(tv_name, transition_title);
        ViewCompat.setTransitionName(tv_likesCount, transition_likes);
        ViewCompat.setTransitionName(iv_likes, transition_likeIcon);
    }


    @UiThread
    void getBlurredImg(Bitmap bitmap) {
        if (bitmap != null)
            BlurredView2.setImageBitmap(BlurUtil.doBlur(bitmap,10,5));
    }

    public static void addBitmap(HashMap<String,Bitmap> bitmapHashMap){
        bitmapList.putAll(bitmapHashMap);
    }

}
