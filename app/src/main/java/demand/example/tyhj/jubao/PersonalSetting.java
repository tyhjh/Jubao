package demand.example.tyhj.jubao;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_personal_setting)
public class PersonalSetting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @ViewById
    ImageView iv_head;

    @Click(R.id.iv_back)
    void back(){
        ifSava();
    }

    //地址管理
    @Click({R.id.ll_manage_address,R.id.iv_manage_address})
    void manageAdress(){
        
    }

    @Override
    public void onBackPressed() {
        ifSava();
    }

    //返回处理
    long time=0;
    private void ifSava() {
        if(System.currentTimeMillis()-time>2000) {
            time=System.currentTimeMillis();
            Snackbar.make(iv_head, "是否保存修改", Snackbar.LENGTH_LONG).setAction("确认", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(PersonalSetting.this, getString(R.string.savaed), Toast.LENGTH_SHORT).show();
                    PersonalSetting.this.finish();
                }
            }).show();
        }else {
            this.finish();
        }
    }
}
