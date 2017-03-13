package demand.example.tyhj.jubao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_suggest)
public class Suggest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Click(R.id.iv_back)
    void back(){
        this.finish();
    }

    @ViewById
    EditText et_suggest;

    @ViewById
    TextView tv_count;

    @ViewById
    Button btn_push;

    @AfterViews
    void afterView(){
        et_suggest.addTextChangedListener(textWatcher);
    }

    TextWatcher textWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            tv_count.setText(et_suggest.getText().toString().length()+"/150");
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

}
