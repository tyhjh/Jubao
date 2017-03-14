package demand.example.tyhj.jubao;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

import adpter.MsgAdapter;
import fragement.Frage1;
import myclass.MyMsg;

@EActivity(R.layout.activity_msg)
public class Msg extends AppCompatActivity {

    private List<MyMsg> msgs;
    private MsgAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @ViewById
    RecyclerView rcly_msg;

    @AfterViews
    void afterView(){
        msgs=new ArrayList<MyMsg>();
        adapter=new MsgAdapter(msgs,this);
        rcly_msg.setAdapter(adapter);
        rcly_msg.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        initDate();
    }

    //数据添加
    private void initDate() {
        msgs.add(new MyMsg("聚宝籍新版本更新",getString(R.string.author), Frage1.userHeadImage));
        msgs.add(new MyMsg("聚宝籍新版本更新",getString(R.string.author), Frage1.userHeadImage));
        msgs.add(new MyMsg("聚宝籍新版本更新",getString(R.string.author), Frage1.userHeadImage));
        msgs.add(new MyMsg("聚宝籍新版本更新",getString(R.string.author), Frage1.userHeadImage));
        msgs.add(new MyMsg("聚宝籍新版本更新",getString(R.string.author), Frage1.userHeadImage));
        adapter.notifyDataSetChanged();
    }


    @Click(R.id.iv_back)
    void back(){
        this.finish();
    }
}
