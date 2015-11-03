package basti.coryphaei.com.navigationbar;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends Activity implements TabbarClickListener {

    private TabBar mTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabBar = (TabBar) findViewById(R.id.tabBar);

        mTabBar.addItem(R.mipmap.home,R.mipmap.home_select,R.color.normal,R.color.select,"home");
        mTabBar.addItem(R.mipmap.cart,R.mipmap.cart_selcet,R.color.normal,R.color.select,"cart");
        mTabBar.addItem(R.mipmap.user,R.mipmap.user_select,R.color.normal,R.color.select,"user");

        mTabBar.setOnItemClickListener(this);
    }

    @Override
    public void onClick(int position) {
        Toast.makeText(this,position+"",Toast.LENGTH_SHORT).show();
    }
}
