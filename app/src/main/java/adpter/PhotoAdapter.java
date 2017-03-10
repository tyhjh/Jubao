package adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import demand.example.tyhj.jubao.R;
import myclass.ShowPhoto;
import tools.Defined;

/**
 * Created by Tyhj on 2017/3/6.
 */

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoHolder>{
    private Context context;
    private LayoutInflater layoutInflater;
    private List<ShowPhoto> photos;


    public PhotoAdapter(Context context, List<ShowPhoto> photos) {
        this.context = context;
        this.photos = photos;
        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public PhotoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.item_photos,parent,false);
        return new PhotoHolder(view);
    }

    @Override
    public void onBindViewHolder(PhotoHolder holder, int position) {
        ImageLoader.getInstance().displayImage(photos.get(holder.getPosition()).getPhoto(),holder.imageView, Defined.getOption());
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    class PhotoHolder extends RecyclerView.ViewHolder{
         ImageView imageView;
         public PhotoHolder(View itemView) {
             super(itemView);
             imageView= (ImageView) itemView.findViewById(R.id.iv_photoList);
         }
     }
}
