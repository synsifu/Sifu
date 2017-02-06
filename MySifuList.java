package proedge.hk.sifu.activity;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TextView;

import proedge.hk.sifu.R;

public class MySifuList extends AppCompatActivity {

    private TabLayout tabLayout;
    private int[] tabIcons = {
            R.drawable.ic_like,
            R.drawable.ic_rounded_block
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_sifu_list);

        tabLayout = (TabLayout) findViewById(R.id.tab);
        setupTabIcons();

    }


    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
    }

   /* private void setupTabIcons() {

        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tabs, null);
        tabOne.setText("Good Sifu");
        tabOne.setTextColor(getResources().getColor(R.color.color_red_dark));
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_like, 0, 0);
        tabLayout.getTabAt(0).getIcon()
//        tabLayout.getTabAt(0).setIcon(tabIcons[0]);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tabs, null);
        tabTwo.setText("Blocked Sifu");
        tabTwo.setTextColor(getResources().getColor(R.color.color_red_dark));
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_rounded_block, 0, 0);
//        tabLayout.getTabAt(1).setIcon(tabIcons[1]);

      }*/


}
