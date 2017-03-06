package fragement;

import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

import adpter.RecentAuctionAdapter;
import demand.example.tyhj.jubao.R;
import myclass.Auction;
import tools.Defined;

import static fragement.Frage1.userHeadImage;


@EFragment(R.layout.fragment_3)
public class Frage3 extends Fragment {

    private static String TYPE_FAN_KAI="fonts/fan_kai.TTF";
    private String url1="http://i2.w.yun.hjfile.cn/doc/201303/f2a991a1-f4b2-4525-b037-6d9202f62973_04.jpg";
    private String url2="http://ac-fgtnb2h8.clouddn.com/f422d4b31d95ef62e29c.png";
    private Typeface typeFace ;
    private List<Auction> auctionRecents;
    private RecentAuctionAdapter auctionAdapter;
    @ViewById
    RecyclerView rlcy_recent;

    @ViewById
    NestedScrollView scrollView;

    @ViewById
    TextView tv_time_atTime,tv_timeDetail_atTime,tv_time_nextTime,tv_timeDetail_nextTime,tv_nextTime,tv_atTime;

    @ViewById
    ImageView iv_atTime,iv_nextTime;

    @AfterViews
    void afterView(){
        typeFace = Typeface.createFromAsset(getActivity().getAssets(), TYPE_FAN_KAI);
        tv_nextTime.setTypeface(typeFace);
        tv_atTime.setTypeface(typeFace);
        ImageLoader.getInstance().displayImage(url1,iv_atTime, Defined.getOption());
        ImageLoader.getInstance().displayImage(url2,iv_nextTime, Defined.getOption());
        initRclyView();
        scrollView.smoothScrollTo(0,0);
    }

    private void initRclyView() {
        auctionRecents=new ArrayList<Auction>();
        for(int i=0;i<Frage1_.images.length;i++){
            auctionRecents.add(new Auction(Frage1.images[i], "水乡水墨书",60000,100000,
                    "201705051330","201705051530",1500,1000,getString(R.string.author),
                    50,"铜","14*13*20","冶炼","黄铜","祭祀","缸",getString(R.string.detail),
                    Frage1.images,Frage1.images,userHeadImage,"齐白石")
            );
        }
        auctionAdapter=new RecentAuctionAdapter(getActivity(),auctionRecents);
        rlcy_recent.setAdapter(auctionAdapter);
        rlcy_recent.setNestedScrollingEnabled(false);
        rlcy_recent.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
    }

    public void update(){
        scrollView.smoothScrollTo(0,0);
    }

}
