package proedge.hk.sifu.activity;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.iarcuschin.simpleratingbar.SimpleRatingBar;

import java.util.ArrayList;

import proedge.hk.sifu.R;
import proedge.hk.sifu.adapter.AdpOrderDetail;
import proedge.hk.sifu.modules.MOrderDetail;

public class OrderDetails extends AppCompatActivity {

    RecyclerView recyclerView;
    AdpOrderDetail adpOrderDetail;
    ArrayList<MOrderDetail> mOrderDetailArrayList = new ArrayList<>();
    TextView txt_cancel_order, txt_incomplete_job, txt_complete_job, txt_quote_status;
    SimpleRatingBar ratingBar_runner_rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        setUpView();

        txt_complete_job.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCompleteRatingDialog();
            }
        });
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    void setUpView() {

        txt_cancel_order = (TextView) findViewById(R.id.txt_cancel_order);
        txt_complete_job = (TextView) findViewById(R.id.txt_complete_job);
        txt_incomplete_job = (TextView) findViewById(R.id.txt_incomplete_job);
        txt_quote_status = (TextView) findViewById(R.id.txt_quote_status);

        txt_quote_status.setText("Processing");
        txt_quote_status.setBackground(getResources().getDrawable(R.drawable.bg_round_corner_blue));

        recyclerView = (RecyclerView) findViewById(R.id.order_detail_worker_list_recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(OrderDetails.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        MOrderDetail mChat = new MOrderDetail();
        mOrderDetailArrayList = mChat.getOrderDetailWorkerList();

        adpOrderDetail = new AdpOrderDetail(OrderDetails.this, mOrderDetailArrayList);
        recyclerView.setAdapter(adpOrderDetail);
        adpOrderDetail.notifyDataSetChanged();

    }


    private void showCompleteRatingDialog() {
        final Dialog dialog = new Dialog(OrderDetails.this);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog_complete_rating);

        TextView txt_cancel, txt_confirm;

        txt_cancel = (TextView) dialog.findViewById(R.id.txt_cancel);
        txt_confirm = (TextView) dialog.findViewById(R.id.txt_confirm);
        ratingBar_runner_rate = (SimpleRatingBar) dialog.findViewById(R.id.ratingBar_runner_rate);
        ratingBar_runner_rate.setStarBorderWidth(2.5f,2);
       /* LayerDrawable stars = (LayerDrawable) ratingBar_runner_rate.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_ATOP);
        stars.getDrawable(0).setColorFilter(getResources().getColor(R.color.colorWhite), PorterDuff.Mode.SRC_ATOP);
        stars.getDrawable(1).setColorFilter(getResources().getColor(R.color.color_light_yellow), PorterDuff.Mode.SRC_ATOP);
        DrawableCompat.setTint(ratingBar_runner_rate.getProgressDrawable(), getResources().getColor(R.color.color_light_yellow));


        ratingBar_runner_rate.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                ratingBar_runner_rate.setRating(v);
            }
        });
*/

        txt_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCompleteAfterRateDialog();
                dialog.dismiss();
            }
        });


        txt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }


    private void showCompleteAfterRateDialog() {
        final Dialog dialog = new Dialog(OrderDetails.this);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog_complete_after_rate);

        TextView txt_no_thanks, txt_good_sifu,txt_bad_sifu;

        txt_no_thanks = (TextView) dialog.findViewById(R.id.txt_no_thanks);
        txt_good_sifu = (TextView) dialog.findViewById(R.id.txt_good_sifu);
        txt_bad_sifu = (TextView) dialog.findViewById(R.id.txt_bad_sifu);


        txt_no_thanks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });


        txt_good_sifu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        txt_bad_sifu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }

}

