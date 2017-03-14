package adpter;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import demand.example.tyhj.jubao.R;
import myclass.MyMsg;
import tools.Defined;

/**
 * Created by Tyhj on 2017/3/13.
 */

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.MsgHolder> {

    private List<MyMsg> msgList;
    private Context context;
    private LayoutInflater inflater;

    public MsgAdapter(List<MyMsg> msgList, Context context) {
        this.msgList = msgList;
        this.context = context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public MsgHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.item_msg,parent,false);
        return new MsgHolder(view);
    }

    @Override
    public void onBindViewHolder(MsgHolder holder, int position) {

        holder.tv_msg.setText(msgList.get(holder.getPosition()).getContent());
        holder.tv_msg_title.setText(msgList.get(holder.getPosition()).getTitle());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            holder.iv_msg_head.setClipToOutline(true);
            holder.iv_msg_head.setOutlineProvider(Defined.getOutline(true,10,0));
        }
        Picasso.with(context).load(msgList.get(holder.getPosition()).getHeadImage()).into(holder.iv_msg_head);
    }

    @Override
    public int getItemCount() {
        return msgList.size();
    }

    class MsgHolder extends RecyclerView.ViewHolder{
        TextView tv_msg_title,tv_msg;
        ImageView iv_msg_head;
        public MsgHolder(View itemView) {
            super(itemView);
            tv_msg_title= (TextView) itemView.findViewById(R.id.tv_msg_title);
            tv_msg= (TextView) itemView.findViewById(R.id.tv_msg);
            iv_msg_head= (ImageView) itemView.findViewById(R.id.iv_msg_head);
        }
    }
}
