package adpter;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;

import demand.example.tyhj.jubao.R;
import demand.example.tyhj.jubao.ShowEssay;
import demand.example.tyhj.jubao.ShowEssay_;
import myclass.Essay;
import tools.Defined;
import tools.For2mat;

/**
 * Created by Tyhj on 2017/3/1.
 */

public class EssayApter extends RecyclerView.Adapter<EssayApter.EssayHolder> {

    private List<Essay> essays;
    private Context context;
    private LayoutInflater layoutInflater;
    ObjectAnimator animator, animator2;
    AnimatedVectorDrawable anim;

    public EssayApter(List<Essay> essays, Context context) {
        this.essays = essays;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);

         animator = (ObjectAnimator) AnimatorInflater.loadAnimator(context,
                R.animator.likes);
         animator2 = (ObjectAnimator) AnimatorInflater.loadAnimator(context,
                R.animator.notlikes);

        anim = new AnimatedVectorDrawable();

    }

    @Override
    public EssayHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_essay, parent, false);
        return new EssayHolder(view);
    }

    @Override
    public void onBindViewHolder(final EssayHolder holder, final int position) {
        ImageLoader.getInstance().displayImage(essays.get(holder.getPosition()).getImageUrl(), holder.iv_essay, Defined.getOption());
        holder.iv_readed.setImageResource(R.drawable.ic_readed);
        holder.tv_name.setText(essays.get(holder.getPosition()).getName());
        holder.tv_details.setText(essays.get(holder.getPosition()).getDetails());
        holder.tv_likesCount.setText(essays.get(holder.getPosition()).getLikes() + "");
        holder.tv_readedCount.setText(essays.get(holder.getPosition()).getReaded() + "");

        if (essays.get(holder.getPosition()).isLike())
            holder.iv_likes.setImageResource(R.drawable.icmecollected);
        else
            holder.iv_likes.setImageResource(R.drawable.icmecollect);


        click(holder);

        //初始化bitmap
        new Thread(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap=For2mat.url2Bitmap(essays.get(holder.getPosition()).getImageUrl());
                HashMap<String, Bitmap> hashMap=new HashMap<String, Bitmap>();
                hashMap.put(position+"",bitmap);
                ShowEssay_.addBitmap(hashMap);
            }
        }).start();

    }

    //点击事件处理
    private void click(final EssayHolder holder) {
        //点赞数
        holder.iv_likes.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                if (essays.get(holder.getPosition()).isLike()) {
                    anim = (AnimatedVectorDrawable) context.getDrawable(R.drawable.essaynotcollect);
                    if (essays.get(holder.getPosition()).getLikes() > 0) {
                        int likes = essays.get(holder.getPosition()).getLikes();
                        likes--;
                        holder.tv_likesCount.setText(likes + "");
                        essays.get(holder.getPosition()).setLikes(likes);
                    }
                    animator2.setTarget(holder.iv_likes);
                    animator2.start();
                } else {
                    anim = (AnimatedVectorDrawable) context.getDrawable(R.drawable.essaycollect);
                    int likes=essays.get(holder.getPosition()).getLikes();
                    likes++;
                    holder.tv_likesCount.setText(likes + "");
                    essays.get(holder.getPosition()).setLikes(likes);
                    animator.setTarget(holder.iv_likes);
                    animator.start();
                }
                holder.iv_likes.setImageDrawable(anim);
                anim.start();

                essays.get(holder.getPosition()).setLike(!essays.get(holder.getPosition()).isLike());
            }
        });

        //点击跳转到文章页面
        holder.iv_essay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle=new Bundle();
                essays.get(holder.getPosition()).setId(holder.getPosition());
                bundle.putSerializable("essay",essays.get(holder.getPosition()));

                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context,
                        new Pair(holder.iv_essay, ShowEssay.transition_essayImage),
                        new Pair(holder.tv_name, ShowEssay.transition_title),
                        new Pair(holder.iv_likes, ShowEssay.transition_likeIcon),
                        new Pair(holder.tv_likesCount, ShowEssay.transition_likes),
                        new Pair(holder.tv_details, ShowEssay.transition_essayContent)
                );

                Intent i=new Intent(context, ShowEssay_.class);
                i.putExtras(bundle);
                ActivityCompat.startActivity(context,i,options.toBundle());
            }
        });
    }


    @Override
    public int getItemCount() {
        return essays.size();
    }


    class EssayHolder extends RecyclerView.ViewHolder {
        ImageView iv_essay, iv_readed, iv_likes;
        TextView tv_name, tv_details, tv_readedCount, tv_likesCount;

        public EssayHolder(View itemView) {
            super(itemView);
            iv_essay = (ImageView) itemView.findViewById(R.id.iv_essay);
            iv_readed = (ImageView) itemView.findViewById(R.id.iv_readed);
            iv_likes = (ImageView) itemView.findViewById(R.id.iv_likes);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_details = (TextView) itemView.findViewById(R.id.tv_details);
            tv_readedCount = (TextView) itemView.findViewById(R.id.tv_readedCount);
            tv_likesCount = (TextView) itemView.findViewById(R.id.tv_likesCount);
        }
    }
}
