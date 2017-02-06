package proedge.hk.sifu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import proedge.hk.sifu.R;

public class PlaceOrder extends AppCompatActivity {

    ImageView img_back;
    TextView txt_place_order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);


        img_back=(ImageView)findViewById(R.id.img_back);
        txt_place_order=(TextView)findViewById(R.id.txt_place_order);

        txt_place_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlaceOrder.this, OrderSubmitted.class));
                finish();
            }
        });

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
