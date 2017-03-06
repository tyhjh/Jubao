package fragement;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import demand.example.tyhj.jubao.R;
import myView.BlurUtil;
import tools.Defined;
import tools.For2mat;


@EFragment(R.layout.fragment_5)
public class Frage5 extends Fragment {

    @ViewById
    LinearLayout ll_noLog;

    @ViewById
    ImageView iv_UserHeadImage, iv_userBg;

    @ViewById
    CardView card_logIn;

    @ViewById
    TextView tv_rent_Name,tv_depositName,tv_moneyName;

    @ViewById
    LinearLayout ll_set,ll_msg,ll_order;

    @AfterViews
    void afterView() {
        initView();
        getImage();
    }

    //
    private void initView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            iv_UserHeadImage.setClipToOutline(true);
            iv_UserHeadImage.setOutlineProvider(Defined.getOutline(true,15,0));
            ImageLoader.getInstance().displayImage(Frage1_.userHeadImage,iv_UserHeadImage);
        }

        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/huakang_black.TTF");
        tv_rent_Name.setTypeface(typeface);
        tv_depositName.setTypeface(typeface);
        tv_moneyName.setTypeface(typeface);
    }

    //获取背景图片
    @Background
    void getImage() {
        Bitmap bitmap = For2mat.url2Bitmap(Frage1_.images[1]);
        setBg(bitmap);
    }

    //设置背景图片
    @UiThread
    void setBg(Bitmap bitmap) {
        if (bitmap != null)
            iv_userBg.setImageBitmap(BlurUtil.doBlur(bitmap,10,15));
        else {

        }

    }

}
