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

import demand.example.tyhj.jubao.Cowry;
import demand.example.tyhj.jubao.Cowry_;
import demand.example.tyhj.jubao.R;
import myclass.Auction;
import tools.Defined;

/**
 * Created by Tyhj on 2017/3/1.
 */

public class AuctionAdapter extends RecyclerView.Adapter<AuctionAdapter.AuctionHolder>{

    private List<Auction> auctions;
    private Context context;
    private LayoutInflater layoutInflater;

    public AuctionAdapter(List<Auction> auctions, Context context) {
        this.auctions = auctions;
        this.context = context;
        this.layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public AuctionHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.item_auction,parent,false);
        return new AuctionHolder(view);
    }

    @Override
    public void onBindViewHolder(final AuctionHolder holder, int position) {
        int mPosition=position;
        ImageLoader.getInstance().displayImage(auctions.get(mPosition).getImageUrl(), holder.iv_auction, Defined.getOption());
        holder.auction_title.setText(auctions.get(mPosition).getTitle());
        holder.auction_price.setText(auctions.get(mPosition).getRoundprice());

        holder.iv_auction.setOnClickListener(new View.OnClickListener() {
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
        ImageView iv_auction;
        TextView auction_title,auction_price;
        public AuctionHolder(View itemView) {
            super(itemView);
            iv_auction= (ImageView) itemView.findViewById(R.id.iv_auction);
            auction_title= (TextView) itemView.findViewById(R.id.auction_title);
            auction_price= (TextView) itemView.findViewById(R.id.auction_price);
        }
    }
}
