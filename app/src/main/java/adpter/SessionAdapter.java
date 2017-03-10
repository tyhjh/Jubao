package adpter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import demand.example.tyhj.jubao.Cowry_;
import demand.example.tyhj.jubao.R;
import myclass.Auction;
import tools.Defined;

/**
 * Created by Tyhj on 2017/3/6.
 */
public class SessionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Auction> auctions;
    private Context context;
    private LayoutInflater layoutInflater;

    public SessionAdapter(List<Auction> auctions, Context context) {
        this.auctions = auctions;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder holder;
        if (viewType == 0) {
            view = layoutInflater.inflate(R.layout.item_introduce, parent, false);
            holder=new SessionIntroduceHolder(view);
        } else {
            view = layoutInflater.inflate(R.layout.item_session, parent, false);
            holder=new SessionHolder(view);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if(holder.getItemViewType()==0){
            SessionIntroduceHolder holder1= (SessionIntroduceHolder) holder;
            holder1.textView.setText(auctions.get(position).getCrowryDetails());
        }else {
            final SessionHolder holder1= (SessionHolder) holder;
            ImageLoader.getInstance().displayImage(auctions.get(holder.getPosition()).getImageUrl(),holder1.iv_photo, Defined.getOption());
            holder1.tv_name.setText(auctions.get(holder.getPosition()).getTitle());
            holder1.tv_price.setText("起拍价："+auctions.get(holder.getPosition()).getPrice());
            holder1.tv_time.setText(auctions.get(holder.getPosition()).getStartTime());
            holder1.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context, Cowry_.class);
                    Bundle bundle=new Bundle();
                    bundle.putSerializable("Auction",auctions.get(holder1.getPosition()));
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return auctions.size();
    }


    @Override
    public int getItemViewType(int position) {
        if (position == 0)
            return 0;
        else
            return 1;
    }

    class SessionIntroduceHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public SessionIntroduceHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_introduce);
        }
    }

    class SessionHolder extends RecyclerView.ViewHolder {
        TextView tv_name, tv_price,tv_time;
        ImageView iv_photo;

        public SessionHolder(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_price = (TextView) itemView.findViewById(R.id.tv_price);
            iv_photo = (ImageView) itemView.findViewById(R.id.iv_photo);
            tv_time= (TextView) itemView.findViewById(R.id.tv_time);
        }
    }
}
