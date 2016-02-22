package sn.eclemarker;

import android.app.SearchManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import sn.eclemarker.datas.Tab;
import sn.eclemarker.fragments.DiscoverFragment;
import sn.eclemarker.fragments.HotFragment;
import sn.eclemarker.fragments.MailCarFragment;
import sn.eclemarker.fragments.MainFragment;
import sn.eclemarker.fragments.UserFragment;
import sn.eclemarker.widget.CusToolBar;

/**
 * 主界面tab显示界面，tab切换 必须继承FrameActivity
 *
 * @author sn
 *         2016/2/19  11:42
 */
public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "TAG";
    //    定义相关的变量
    private FragmentTabHost mTabHost;
    private LayoutInflater layoutInflater;
    private List<Tab> tabs;
    private CusToolBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        initView();
    }

    /**
     * 实例化Tab
     *
     * @author sn
     * 2016/2/19  12:33
     */
    private void initView() {
        layoutInflater = LayoutInflater.from(this);
        mTabHost = (FragmentTabHost) findViewById(R.id.framHost);
        toolbar = (CusToolBar) findViewById(R.id.setToolbar);
        setSupportActionBar(toolbar);


        // 必须调用setup方法
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        //将信息封装在Tab里
        Tab tab_home = new Tab(MainFragment.class, R.drawable.mian_statelist, R.string.main_show);
        Tab tab_discover = new Tab(DiscoverFragment.class, R.drawable.discover_state, R.string.main_discover);
        Tab tab_hot = new Tab(HotFragment.class, R.drawable.hot_state, R.string.main_hot);
        Tab tab_mailcar = new Tab(MailCarFragment.class, R.drawable.mail_car_state, R.string.mail_car);
        Tab tab_user = new Tab(UserFragment.class, R.drawable.user_state, R.string.user_center);

        tabs = new ArrayList<Tab>();
        tabs.add(tab_home);
        tabs.add(tab_discover);
        tabs.add(tab_hot);
        tabs.add(tab_mailcar);
        tabs.add(tab_user);

        for (Tab tab : tabs) {
            addTags(tab);
        }
        mTabHost.setClickable(true);
        mTabHost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        mTabHost.setCurrentTab(0);
    }

    /**
     * 私有添加tab
     *
     * @author sn
     * 2016/2/19  14:55
     */
    private void addTags(Tab tab) {
        TabHost.TabSpec spec = mTabHost.newTabSpec(getString(tab.getText()));
        View tabView = layoutInflater.inflate(R.layout.tabhost, null);
        ImageView tabImage = (ImageView) tabView.findViewById(R.id.tabImag);
        TextView tabText = (TextView) tabView.findViewById(R.id.tabText);
        tabImage.setImageResource(tab.getImage());
        tabText.setText(tab.getText());
        spec.setIndicator(tabView);
        mTabHost.addTab(spec, tab.getaClass(), null);
    }


}
