package demand.example.tyhj.jubao;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import cn.sharesdk.onekeyshare.OnekeyShare;
import fragement.Frage1_;
import fragement.Frage2_;
import fragement.Frage3_;
import fragement.Frage4_;
import fragement.Frage5_;
import myView.MyViewPager;
import tools.Defined;

@EActivity(R.layout.activity_home)
public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @ViewById
    ImageView btnHome1, btnHome2, btnHome3, btnHome4, btnHome5, iv_titile;

    @ViewById
    ImageView iv_share;


    Frage3_ frage3_ = new Frage3_();

    @Click(R.id.btnHome1)
    void btnHome1() {
        vp_home.setCurrentItem(0, false);
    }

    @Click(R.id.btnHome2)
    void btnHome2() {
        vp_home.setCurrentItem(1, false);
    }

    @Click(R.id.btnHome3)
    void btnHome3() {
        frage3_.update();
        vp_home.setCurrentItem(2, false);
    }

    @Click(R.id.btnHome4)
    void btnHome4() {
        vp_home.setCurrentItem(3, false);
        initBottom();
        btnHome4.setImageResource(R.mipmap.yishujie_selected_icon);
    }

    @Click(R.id.btnHome5)
    void btnHome5() {
        vp_home.setCurrentItem(4, false);
        initBottom();
        btnHome5.setImageResource(R.mipmap.wo_selected_icon);
    }

    @Click(R.id.iv_share)
    void share() {
        showShare();
    }

    @ViewById
    MyViewPager vp_home;

    @AfterViews
    void afterView() {
        iv_titile.setImageResource(R.mipmap.home_title);
        initVpger();
        initBottom();
        iv_share.setVisibility(View.GONE);
        vp_home.setCurrentItem(0);
        btnHome1.setImageResource(R.mipmap.jubaoji_selected_icon);
    }

    //底部按钮初始化
    private void initBottom() {
        btnHome1.setImageResource(R.mipmap.jubaoji_unselected_icon);
        btnHome2.setImageResource(R.mipmap.shibei_unselected_icon);
        btnHome3.setImageResource(R.mipmap.pai_icon);
        btnHome4.setImageResource(R.mipmap.yishujie_unselected_icon);
        btnHome5.setImageResource(R.mipmap.wo_unselected_icon);
    }

    //加载分页面
    private void initVpger() {
        vp_home.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return new Frage1_();
                    case 1:
                        return new Frage2_();
                    case 2:
                        return frage3_;
                    case 3:
                        return new Frage4_();
                    case 4:
                        return new Frage5_();
                    default:
                        break;
                }
                return null;
            }

            @Override
            public int getCount() {
                return 5;
            }
        });
        vp_home.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                initBottom();
                if (iv_share.getVisibility() == View.VISIBLE)
                    iv_share.setVisibility(View.GONE);
                switch (position) {
                    case 0:
                        iv_titile.setImageResource(R.mipmap.home_title);
                        btnHome1.setImageResource(R.mipmap.jubaoji_selected_icon);
                        break;
                    case 1:
                        btnHome2.setImageResource(R.mipmap.shibei_selected_icom);
                        break;
                    case 2:
                        iv_titile.setImageResource(R.mipmap.auction_title);
                        break;
                    case 3:
                        btnHome4.setImageResource(R.mipmap.yishujie_selected_icon);
                        break;
                    case 4:
                        iv_titile.setImageResource(R.mipmap.my_title);
                        btnHome5.setImageResource(R.mipmap.wo_selected_icon);
                        iv_share.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        vp_home.setOffscreenPageLimit(5);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            btnHome3.setClipToOutline(true);
            btnHome3.setOutlineProvider(Defined.getOutline(true, 10, 0));
        }
    }


    private void showShare() {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        // title标题，印象笔记、邮箱、信息、微信、人人网、QQ和QQ空间使用
        oks.setTitle("聚宝籍");
        // titleUrl是标题的网络链接，仅在Linked-in,QQ和QQ空间使用
        oks.setTitleUrl(getString(R.string.url_share));
        // text是分享文本，所有平台都需要这个字段
        oks.setText(getString(R.string.its_signature));
        //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
        oks.setImageUrl("http://f1.sharesdk.cn/imgs/2014/02/26/owWpLZo_638x960.jpg");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl(getString(R.string.url_share));
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        //oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite("聚宝籍");
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl(getString(R.string.url_share));

// 启动分享GUI
        oks.show(this);
    }


    //监听返回键
    private long exitTime = 0;

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - exitTime > 2000) {
            exitTime = System.currentTimeMillis();
            Toast.makeText(Home.this, getString(R.string.outapp), Toast.LENGTH_SHORT).show();
        } else {
            super.onBackPressed();
        }
    }
}
