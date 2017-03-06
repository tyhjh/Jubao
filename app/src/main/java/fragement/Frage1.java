package fragement;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import adpter.AuctionAdapter;
import adpter.EssayApter;
import demand.example.tyhj.jubao.R;
import myView.AutoLinearLayoutManager;
import myView.NetworkImageHolderView;
import myclass.Auction;
import myclass.Essay;
import tools.Defined;


@EFragment(R.layout.fragment_1)
public class Frage1 extends Fragment {

    private List<String> networkImages;

    private List<Auction> auctionList = new ArrayList<Auction>();

    private List<Essay> essays=new ArrayList<Essay>();

    private AuctionAdapter auctionAdpter;

    private EssayApter essyadpter;

    public static String userHeadImage="http://ac-tv2pl6bu.clouddn.com/6qHjxSn5R6PcSDfFulfsKTT57VLU4bnC0eZwIJxm.jpg";

    public static String[] images = {"http://ac-fgtnb2h8.clouddn.com/336a73b9bb0fb0c81e0f.png",
            "http://ac-fgtnb2h8.clouddn.com/f422d4b31d95ef62e29c.png",
            "http://ac-fgtnb2h8.clouddn.com/a48b5dbd980ea7c99968.png",
            "http://s14.sinaimg.cn/mw690/63813c9cgx6D6dUQ3Uxfd&690"};

    @ViewById
    ConvenientBanner convenientBanner;

    @ViewById
    RecyclerView rcly_auction,rlcy_essay;

    @AfterViews
    void afterView() {
        initTab();
        initVp_auction();
        initEssay();
    }


    //初始化推荐好文
    private void initEssay() {
        for(int i=0;i<images.length;i++){
            essays.add(new Essay("珠宝|脱胎玉质独一品质",images[i],
                    getString(R.string.essay),
                    5,5,false,userHeadImage,
                    "Tyhj","解释就是掩饰"));
        }
        essyadpter=new EssayApter(essays,getActivity());
        rlcy_essay.setNestedScrollingEnabled(false);
        rlcy_essay.setAdapter(essyadpter);
        rlcy_essay.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
    }


    //初始化推荐的拍卖
    private void initVp_auction() {
        for(int i=0;i<images.length;i++) {
            Auction auction=new Auction(images[i], "水乡水墨书",60000,100000,
                    "201705051330","201705051530",1500,1000,getString(R.string.author),
                    50,"铜","14*13*20","冶炼","黄铜","祭祀","缸",getString(R.string.detail),
                    images,images,userHeadImage,"齐白石"
            );
            auctionList.add(auction);
        }
        auctionAdpter=new AuctionAdapter(auctionList,getActivity());
        rcly_auction.setAdapter(auctionAdpter);
        rcly_auction.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
    }

    //初始化tab图片轮播
    private void initTab() {
        //网络加载例子
        networkImages = Arrays.asList(images);
        convenientBanner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
            @Override
            public NetworkImageHolderView createHolder() {
                return new NetworkImageHolderView();
            }
        }, networkImages)
                .setPageIndicator(new int[]{R.drawable.point1, R.drawable.point2})
                //设置指示器的方向
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
        //自动翻页
        convenientBanner.startTurning(3000);
        //点击事件
        convenientBanner.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getActivity(), "" + position, Toast.LENGTH_SHORT).show();
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
