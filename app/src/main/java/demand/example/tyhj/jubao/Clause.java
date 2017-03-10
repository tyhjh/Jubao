package demand.example.tyhj.jubao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_clause)
public class Clause extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @ViewById
    TextView tv_clause;

    @Click(R.id.iv_back)
    void back(){
        this.finish();
    }

    @AfterViews
    void afterView(){
        tv_clause.setText(getString(R.string.clause_content));
    }

}
