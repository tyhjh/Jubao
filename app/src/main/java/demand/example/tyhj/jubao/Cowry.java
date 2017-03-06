package demand.example.tyhj.jubao;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.Arrays;
import java.util.List;

import fragement.Frage1;
import fragement.Frage1_;
import myView.NetworkImageHolderView;
import myclass.Auction;
import tools.Defined;

@EActivity(R.layout.activity_cowry)
public class Cowry extends AppCompatActivity {

    private Auction auction;

    private List<String> networkImages;

    @ViewById
    ConvenientBanner banner_cowry;

    @ViewById
    NestedScrollView activity_cowry;

    @ViewById
    TextView tv_cowryName,tv_cowryDetail,tv_startTime,tv_introduce,
            tv_auction_price,tv_deposit_price,tv_addMoney_price,
            tv_rule,tv_suggestName,
            tv_weight,tv_texture,tv_size,tv_craft,tv_color,tv_theme,tv_style;

    @ViewById
    View view_bar;

    @ViewById
    Button btn_offer;

    @ViewById
    ImageView iv_suggestHead;

    @ViewById
    RecyclerView cowry_photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auction= (Auction) getIntent().getSerializableExtra("Auction");
        //Log.e("Cowry",auction.toString());
    }

    @AfterViews
    void afterView(){

        initText();

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/huakang_black.TTF");
        tv_suggestName.setTypeface(typeface);

        initTab();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            iv_suggestHead.setClipToOutline(true);
            iv_suggestHead.setOutlineProvider(Defined.getOutline(true,20,0));
        }
        ImageLoader.getInstance().displayImage(Frage1.userHeadImage,iv_suggestHead);
        tv_startTime.setText(auction.getStartTime());


        activity_cowry.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if(scrollY<=500){
                    if(view_bar.getVisibility()==View.VISIBLE)
                        view_bar.setVisibility(View.INVISIBLE);
                }else {
                    if(view_bar.getVisibility()==View.INVISIBLE)
                        view_bar.setVisibility(View.VISIBLE);
                }
                //Log.e("Cowry","scrollX："+scrollX+"scrollY："+scrollY+"oldScrollX："+oldScrollX+"oldScrollY："+oldScrollY);
            }
        });

    }

    private void initText() {
        tv_cowryName.setText(auction.getTitle());
        tv_cowryDetail.setText(auction.getCrowryDetails());
        tv_introduce.setText(auction.getAuthorIntroduce());
        tv_auction_price.setText(auction.getPrice()+"");
        tv_deposit_price.setText(auction.getExpectPrice()+"");
        tv_addMoney_price.setText(auction.getAddMoney()+"");
        tv_suggestName.setText(auction.getSuggestName());
        tv_weight.setText(auction.getWeight()+"g");
        tv_texture.setText(auction.getTexture());
        tv_size.setText(auction.getSize());
        tv_craft.setText(auction.getCraft());
        tv_color.setText(auction.getColor());
        tv_theme.setText(auction.getTheme());
        tv_style.setText(auction.getStyle());
    }

    //初始化tab图片轮播
    private void initTab() {
        //网络加载例子
        networkImages = Arrays.asList(Frage1_.images);
        banner_cowry.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
            @Override
            public NetworkImageHolderView createHolder() {
                return new NetworkImageHolderView();
            }
        }, networkImages)
                .setPageIndicator(new int[]{R.drawable.point1, R.drawable.point2})
                //设置指示器的方向
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
        //自动翻页
        banner_cowry.startTurning(3000);
        //点击事件
        banner_cowry.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                switch (position) {
                    case 0:

                        break;
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                }
            }
        });
    }

}
