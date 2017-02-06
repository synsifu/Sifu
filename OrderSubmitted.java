package proedge.hk.sifu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import proedge.hk.sifu.R;

public class OrderSubmitted extends AppCompatActivity {

    TextView txt_order_sub_count;
    ImageView img_ok;
    Button btn_ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_submitted);

        setUpView();

    }

    private void setUpView() {
        txt_order_sub_count=(TextView)findViewById(R.id.txt_order_sub_count);
        img_ok=(ImageView)findViewById(R.id.img_ok);
        btn_ok=(Button)findViewById(R.id.btn_ok);


        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderSubmitted.this, HomeActivity.class));
                finish();
            }
        });


        img_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderSubmitted.this, OrderDetails.class));
                finish();
            }
        });

    }
}
