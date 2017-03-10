package demand.example.tyhj.jubao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_login)
public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @ViewById
    EditText edt_number,edt_pwd;

    @ViewById
    ImageView iv_back;


    //注册
    @Click(R.id.tv_signup)
    void signUp(){
        startActivity(new Intent(this,SignUp_.class));
    }

    //找回密码
    @Click(R.id.tv_forgetpwd)
    void getPwd(){
        startActivity(new Intent(this,ResetPwd_.class));
    }


    //返回
    @Click(R.id.iv_back)
    void back(){
        this.finish();
    }


}
