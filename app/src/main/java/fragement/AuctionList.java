package fragement;

import android.support.v4.app.Fragment;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import demand.example.tyhj.jubao.R;


@EFragment(R.layout.item_auction)
public class AuctionList extends Fragment {
    private String url;
    private String imageUrl;


    public void init(String imageUrl,String url){
        this.url=url;
        this.imageUrl=imageUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    @ViewById
    ImageView iv_auction;

    @AfterViews
    void afterView(){
        ImageLoader.getInstance().displayImage(imageUrl, iv_auction);
    }

}
