package adpter;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import demand.example.tyhj.jubao.R;
import myclass.Order;
import tools.Defined;

/**
 * Created by Tyhj on 2017/3/8.
 */

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderHolder>{

    private List<Order> orders;
    private Context context;
    private LayoutInflater inflater;

    public OrderAdapter(List<Order> orders, Context context) {
        this.orders = orders;
        this.context = context;
        inflater=LayoutInflater.from(context);
    }


    @Override
    public OrderHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.item_order,parent,false);
        return new OrderHolder(view);
    }

    @Override
    public void onBindViewHolder(OrderHolder holder, int position) {
        ImageLoader.getInstance().displayImage(orders.get(holder.getPosition()).getCowryImage(),holder.iv_cowry, Defined.getOption());
        holder.tv_session_name.setText(orders.get(holder.getPosition()).getSessionName());
        holder.tv_end_time.setText(orders.get(holder.getPosition()).getEndTime());
        holder.tv_cowry_name.setText(orders.get(holder.getPosition()).getCowryName());
        holder.tv_start_time.setText(orders.get(holder.getPosition()).getStartTime());
        holder.tv_price.setText("¥"+orders.get(holder.getPosition()).getMoney()+"");

        int status=orders.get(holder.getPosition()).getStatus();
        switch (status){
            case 0:
                holder.tv_cowry_status.setText(context.getString(R.string.status0));
                holder.btn_handle.setText("取消订单");
                holder.btn_handle2.setText("付款");
                break;
            case 1:
                holder.tv_cowry_status.setText(context.getString(R.string.status1));
                holder.btn_handle2.setText("申请售后");
                holder.btn_handle.setText("删除订单");
                break;
            case 2:
                holder.tv_cowry_status.setText(context.getString(R.string.status2));
                holder.btn_handle2.setVisibility(View.GONE);
                holder.btn_handle.setText("删除订单");
                break;
        }


    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    class OrderHolder extends RecyclerView.ViewHolder{
        ImageView iv_cowry;
        TextView tv_session_name,tv_end_time,tv_cowry_name,tv_start_time,tv_cowry_status,tv_price;
        Button btn_handle,btn_handle2;

        public OrderHolder(View itemView) {
            super(itemView);
            iv_cowry= (ImageView) itemView.findViewById(R.id.iv_cowry);
            tv_session_name= (TextView) itemView.findViewById(R.id.tv_session_name);
            tv_end_time= (TextView) itemView.findViewById(R.id.tv_end_time);
            tv_cowry_name= (TextView) itemView.findViewById(R.id.tv_cowry_name);
            tv_start_time= (TextView) itemView.findViewById(R.id.tv_start_time);
            tv_cowry_status= (TextView) itemView.findViewById(R.id.tv_cowry_status);
            tv_price= (TextView) itemView.findViewById(R.id.tv_price);
            btn_handle= (Button) itemView.findViewById(R.id.btn_handle);
            btn_handle2= (Button) itemView.findViewById(R.id.btn_handle2);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            }
        }
    }
}
