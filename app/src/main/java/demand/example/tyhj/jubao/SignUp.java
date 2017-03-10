package demand.example.tyhj.jubao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_sign_up)
public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @ViewById
    TextView clause;

    @Click(R.id.iv_back)
    void back(){
        this.finish();
    }

    //查看条款
    @Click(R.id.clause)
    void clause(){
        startActivity(new Intent(SignUp.this,Clause_.class));
    }


    @AfterViews
    void afterView(){
        clause.setText(Html.fromHtml(getString(R.string.clause)));
    }


}
