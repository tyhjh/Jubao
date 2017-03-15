package demand.example.tyhj.jubao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tencent.bugly.beta.Beta;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_setting)
public class Setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @ViewById
    LinearLayout ll_personal_setting;

    @ViewById
    ImageView iv_personal_setting;

    @ViewById
    TextView tv_personal_setting;


    @Click(R.id.iv_back)
    void clik(){
        this.finish();
    }

    //个人设置
    @Click({R.id.ll_personal_setting,R.id.tv_personal_setting,R.id.iv_personal_setting})
    void personalSetting(){
        startActivity(new Intent(this,PersonalSetting_.class));
    }
    //建议反馈
    @Click({R.id.ll_suggest,R.id.tv_suggest,R.id.iv_suggest})
    void suggest(){
        startActivity(new Intent(this,Suggest_.class));
    }
    //关于
    @Click({R.id.ll_about,R.id.iv_about,R.id.tv_about})
    void about(){
        startActivity(new Intent(this,About_.class));
    }

    // 评价
    @Click({R.id.ll_appraise,R.id.iv_appraise,R.id.tv_appraise})
    void appraise(){

    }

    //检查更新
    @Click({R.id.ll_update,R.id.iv_update,R.id.tv_update})
    void update(){
        Beta.checkUpgrade(true,false);
    }

}
