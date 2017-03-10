package demand.example.tyhj.jubao;

import android.graphics.Typeface;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

import adpter.SessionAdapter;
import fragement.Frage1;
import myclass.Auction;
import tools.Defined;

import static fragement.Frage1.userHeadImage;

@EActivity(R.layout.activity_classes)
public class Classes extends AppCompatActivity {

    private SessionAdapter adapter;
    List<Auction> auctions;

    private static String TYPE_FAN_KAI="fonts/fan_kai.TTF";
    private static String photoUrl="http://desk.fd.zol-img.com.cn/t_s960x600c5/g5/M00/0F/0F/ChMkJ1ZpMZGIB4seAB2BJTKeeGUAAF_IwH1XDcAHYE9922.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @ViewById
    CollapsingToolbarLayout maincollapsing;


    @ViewById
    ImageView iv_classesPhoto;

    @ViewById
    RecyclerView rcly_Session;

    @ViewById
    Toolbar toobar_back;

    @Click(R.id.toobar_back)
    void back(){
        this.finish();
    }



    @AfterViews
    void afterView(){
        Typeface typeface=Typeface.createFromAsset(getAssets(),TYPE_FAN_KAI);
        maincollapsing.setTitle("大唐遗宝专场");
        maincollapsing.setCollapsedTitleTypeface(null);
        maincollapsing.setExpandedTitleTypeface(typeface);
        ImageLoader.getInstance().displayImage(photoUrl,iv_classesPhoto, Defined.getOption());
        initRecycle();
    }

    private void initRecycle() {
        auctions=new ArrayList<Auction>();

        for(int i=0;i<Frage1.images.length;i++){
            Auction auction=new Auction(Frage1.images[i], "水乡水墨书",60000,100000,
                    "201705051330","201705051530",1500,1000,getString(R.string.author),
                    50,"铜","14*13*20","冶炼","黄铜","祭祀","缸",getString(R.string.detail),
                    Frage1.images,Frage1.images,userHeadImage,"齐白石");
            auctions.add(auction);
        }

        adapter=new SessionAdapter(auctions,this);

        rcly_Session.setAdapter(adapter);
        rcly_Session.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));


    }


}
