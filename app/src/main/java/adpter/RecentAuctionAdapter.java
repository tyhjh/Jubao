package adpter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;


import demand.example.tyhj.jubao.Cowry_;
import demand.example.tyhj.jubao.R;
import myclass.Auction;
import tools.Defined;

/**
 * Created by Tyhj on 2017/3/1.
 */

public class RecentAuctionAdapter extends RecyclerView.Adapter<RecentAuctionAdapter.AuctionHolder>{

    private Context context;
    private List<Auction> auctions;
    private LayoutInflater inflater;

    public RecentAuctionAdapter(Context context, List<Auction> auctions) {
        this.context = context;
        this.auctions = auctions;
        this.inflater=LayoutInflater.from(context);
    }

    @Override
    public AuctionHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.item_recent_auction,parent,false);
        return new AuctionHolder(view);
    }

    @Override
    public void onBindViewHolder(final AuctionHolder holder, int position) {
        ImageLoader.getInstance().displayImage(auctions.get(position).getImageUrl(),holder.iv_acution, Defined.getOption());
        holder.tv_name.setText("拍卖名："+auctions.get(position).getTitle());
        holder.tv_price.setText("起拍价：¥ "+auctions.get(position).getPrice());



        holder.ib_startAuction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,
                        Cowry_.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("Auction",auctions.get(holder.getPosition()));
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        holder.iv_acution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, Cowry_.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("Auction",auctions.get(holder.getPosition()));
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return auctions.size();
    }

    class AuctionHolder extends RecyclerView.ViewHolder{
        ImageView iv_acution;
        TextView tv_name,tv_price;
        ImageButton ib_startAuction;
        public AuctionHolder(View itemView) {
            super(itemView);
            iv_acution= (ImageView) itemView.findViewById(R.id.iv_acution);
            tv_name= (TextView) itemView.findViewById(R.id.tv_name);
            tv_price= (TextView) itemView.findViewById(R.id.tv_price);
            ib_startAuction= (ImageButton) itemView.findViewById(R.id.ib_startAuction);
        }

    }
}
