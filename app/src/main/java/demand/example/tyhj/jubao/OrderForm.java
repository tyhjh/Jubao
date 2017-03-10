package demand.example.tyhj.jubao;

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

import adpter.OrderAdapter;
import fragement.Frage1;
import myclass.Order;

@EActivity(R.layout.activity_order_form)
public class OrderForm extends AppCompatActivity {

    List<Order> order;
    OrderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @ViewById
    RecyclerView rlcy_order;

    @AfterViews
    void afterView(){
        initRcly();

    }

    @Click(R.id.iv_back)
    void back(){
        this.finish();
    }

    private void initRcly() {
        order=new ArrayList<Order>();
        for(int i=0;i<5;i++){
            order.add(new Order(Frage1.images[0],"大唐遗物专场","大唐玉玺","00:59:00","3月2日 13:11:00",i%3,5000));
        }
        adapter=new OrderAdapter(order,this);
        rlcy_order.setAdapter(adapter);
        rlcy_order.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }

}
