package proedge.hk.sifu.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import proedge.hk.sifu.R;
import proedge.hk.sifu.fragment.Chat;
import proedge.hk.sifu.fragment.MyOrders;
import proedge.hk.sifu.fragment.Orders;
import proedge.hk.sifu.fragment.Settings;
import proedge.hk.sifu.utils.ThemeSetting;

public class HomeActivity extends AppCompatActivity {

    Toolbar toolbar;
    ImageView img_plus;
    TextView title, action;
    Fragment fragment=null;

    TextView txt_orders,txt_my_records,txt_chat,txt_seting;
    ImageView img_orders,img_my_records,img_chat,img_seting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getSupportActionBar().hide();
        setContentView(R.layout.activity_home);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        img_plus = (ImageView) toolbar.findViewById(R.id.plus);
        title = (TextView) toolbar.findViewById(R.id.title);
        action = (TextView) toolbar.findViewById(R.id.action);
        setSupportActionBar(toolbar);

        setUpView();

        onTabSelected(((LinearLayout) findViewById(R.id.orders)));

    }

    private void setUpView() {
        txt_orders =(TextView)findViewById(R.id.txt_orders);
        txt_my_records =(TextView)findViewById(R.id.txt_my_records);
        txt_chat =(TextView)findViewById(R.id.txt_chat);
        txt_seting =(TextView)findViewById(R.id.txt_setting);

        img_orders =(ImageView)findViewById(R.id.img_orders);
        img_my_records =(ImageView)findViewById(R.id.img_my_records);
        img_chat  =(ImageView)findViewById(R.id.img_chat);
        img_seting =(ImageView)findViewById(R.id.img_setting);

    }


    public void onTabSelected(View view) {

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        switch (view.getId()) {
            case R.id.orders:
                fragment=new Orders();
//                hiLightSelected(img_orders, txt_orders);
                txt_orders.setTextColor(getResources().getColor(R.color.color_text_selected));
                txt_my_records.setTextColor(getResources().getColor(R.color.color_text));
                txt_chat.setTextColor(getResources().getColor(R.color.color_text));
                txt_seting.setTextColor(getResources().getColor(R.color.color_text));

                title.setText("Choose Service");
                ft.replace(R.id.frame, new Orders());
                ft.commit();

                break;

            case R.id.my_records:
                fragment=new MyOrders();
                txt_my_records.setTextColor(getResources().getColor(R.color.color_text_selected));
                txt_orders.setTextColor(getResources().getColor(R.color.color_text));
                txt_chat.setTextColor(getResources().getColor(R.color.color_text));
                txt_seting.setTextColor(getResources().getColor(R.color.color_text));

                title.setText("My Orders");
                ft.replace(R.id.frame, new MyOrders());
                ft.commit();
                break;

            case R.id.chat:
                fragment=new Chat();
                txt_chat.setTextColor(getResources().getColor(R.color.color_text_selected));
                txt_orders.setTextColor(getResources().getColor(R.color.color_text));
                txt_my_records.setTextColor(getResources().getColor(R.color.color_text));
                txt_seting.setTextColor(getResources().getColor(R.color.color_text));

                title.setText("Chats");
                ft.replace(R.id.frame, new Chat());
                ft.commit();
                break;

            case R.id.setting:
                fragment=new Settings();
                txt_seting.setTextColor(getResources().getColor(R.color.color_text_selected));
                txt_orders.setTextColor(getResources().getColor(R.color.color_text));
                txt_my_records.setTextColor(getResources().getColor(R.color.color_text));
                txt_chat.setTextColor(getResources().getColor(R.color.color_text));

                title.setText("Settings");
                ft.replace(R.id.frame, new Settings());
                ft.commit();
                break;


        }
    }




    public void hiLightSelected(ImageView imageView, TextView textView) {
        txt_orders.setTextColor(getResources().getColor(R.color.color_text));
        txt_my_records.setTextColor(getResources().getColor(R.color.color_text));
        txt_chat.setTextColor(getResources().getColor(R.color.color_text));
        txt_seting.setTextColor(getResources().getColor(R.color.color_text));

        img_orders.setBackgroundResource(R.drawable.ic_orders);
        img_my_records.setBackgroundResource(R.drawable.ic_my_records);
        img_chat.setBackgroundResource(R.drawable.ic_chat);
        img_seting.setBackgroundResource(R.drawable.ic_setting);

        ThemeSetting.setDefaultImageColor(HomeActivity.this, new ImageView[]{img_orders, img_my_records, img_chat, img_seting},
                new int[]{R.drawable.ic_orders, R.drawable.ic_my_records, R.drawable.ic_chat, R.drawable.ic_setting});
        ThemeSetting.setTextColor(new TextView[]{textView});

        switch (imageView.getId()) {
            case R.id.img_orders:
                ThemeSetting.setImageColor(HomeActivity.this, new ImageView[]{img_orders}, new int[]{R.drawable.ic_orders});
//                img_homeWork.setBackgroundResource(R.drawable.ic_file_selected);
                break;
            case R.id.img_my_records:
                ThemeSetting.setImageColor(HomeActivity.this, new ImageView[]{img_my_records}, new int[]{R.drawable.ic_my_records});
//                img_checklist.setBackgroundResource(R.drawable.ic_checkbox_selected_blue);
                break;
            case R.id.img_chat:
                ThemeSetting.setImageColor(HomeActivity.this, new ImageView[]{img_chat}, new int[]{R.drawable.ic_chat});
//                img_my_class.setBackgroundResource(R.drawable.ic_screen_selected);
                break;
            case R.id.img_setting:
                ThemeSetting.setImageColor(HomeActivity.this, new ImageView[]{img_seting}, new int[]{R.drawable.ic_setting});
//                img_children.setBackgroundResource(R.drawable.ic_kids_couple_selected);
                break;
        }
    }



}
