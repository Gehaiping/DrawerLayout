package cn.ucai.drawerlayout;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private DrawerLayout mDrawerLayout;
    private ListView mMenu;
    private ActionBarDrawerToggle mDrawerToggle;
    private String lvs[] = {"个人中心", "我的收藏", "关于我们", "退出"};
    private ArrayAdapter arrayAdapter;
    private AnimationDrawable mAnimationDrawable = new AnimationDrawable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        setListener();
    }

    private void setListener() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                mAnimationDrawable.stop();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                mAnimationDrawable.start();
            }
        };
        mDrawerToggle.syncState();

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lvs);
        mMenu.setAdapter(arrayAdapter);
        mMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (lvs[position].equals("个人中心")) {
                    Toast.makeText(MainActivity.this, "个人中心", Toast.LENGTH_SHORT).show();
                }
                if (lvs[position].equals("我的收藏")) {
                    Toast.makeText(MainActivity.this, "我的收藏", Toast.LENGTH_SHORT).show();
                }
                if (lvs[position].equals("关于我们")) {
                    Toast.makeText(MainActivity.this, "关于我们", Toast.LENGTH_SHORT).show();
                }
                if (lvs[position].equals("退出")) {
                    Toast.makeText(MainActivity.this, "退出", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mMenu = (ListView) findViewById(R.id.menu);

        toolbar.setTitle("ToolBar-侧滑demo");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);//决定左上角的图标是否可以点击
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//给左上角图标的左边加上一个返回的图标
    }
}
