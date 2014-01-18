package com.pluu.android.navigation;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.pluu.android.R;

public class DrawLayoutRight extends Activity {
	private DrawerLayout mDrawerLayout;
    private ListView mDrawer;
    private TextView mContent;

    private ActionBarHelper mActionBar;

//    private ActionBarDrawerToggle mDrawerToggle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_draw_layout_right);
	
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
	    mDrawer = (ListView) findViewById(R.id.left_drawer);
	    mContent = (TextView) findViewById(R.id.content_text);
	
//	    mDrawerLayout.setDrawerListener(new DemoDrawerListener());
//	    mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
	
	    mDrawer.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
	            Shakespeare.TITLES));
	    mDrawer.setOnItemClickListener(new DrawerItemClickListener());
	
	    mActionBar = createActionBarHelper();
	    mActionBar.init();
	
	    // ActionBarDrawerToggle provides convenient helpers for tying together the
	    // prescribed interactions between a top-level sliding drawer and the action bar.
//	    mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
//	            R.drawable.ic_drawer, R.string.drawer_open, R.string.drawer_close);
	}
	
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
	    super.onPostCreate(savedInstanceState);
//	    mDrawerToggle.syncState();
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
//	    if (mDrawerToggle.onOptionsItemSelected(item)) {
//	        return true;
//	    }
	    return super.onOptionsItemSelected(item);
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
	    super.onConfigurationChanged(newConfig);
//	    mDrawerToggle.onConfigurationChanged(newConfig);
	}
	
	private class DrawerItemClickListener implements ListView.OnItemClickListener {
	    @Override
	    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	        mContent.setText(Shakespeare.DIALOGUE[position]);
	        mActionBar.setTitle(Shakespeare.TITLES[position]);
	        mDrawerLayout.closeDrawer(mDrawer);
	    }
	}
	
	/**
	 * A drawer listener can be used to respond to drawer events such as becoming
	 * fully opened or closed. You should always prefer to perform expensive operations
	 * such as drastic relayout when no animation is currently in progress, either before
	 * or after the drawer animates.
	 *
	 * When using ActionBarDrawerToggle, all DrawerLayout listener methods should be forwarded
	 * if the ActionBarDrawerToggle is not used as the DrawerLayout listener directly.
	 */
	private class DemoDrawerListener implements DrawerLayout.DrawerListener {
	    @Override
	    public void onDrawerOpened(View drawerView) {
//	        mDrawerToggle.onDrawerOpened(drawerView);
	        mActionBar.onDrawerOpened();
	    }
	
	    @Override
	    public void onDrawerClosed(View drawerView) {
//	        mDrawerToggle.onDrawerClosed(drawerView);
	        mActionBar.onDrawerClosed();
	    }
	
	    @Override
	    public void onDrawerSlide(View drawerView, float slideOffset) {
//	        mDrawerToggle.onDrawerSlide(drawerView, slideOffset);
	    }
	
	    @Override
	    public void onDrawerStateChanged(int newState) {
//	        mDrawerToggle.onDrawerStateChanged(newState);
	    }
	}
	
	/**
	 * Create a compatible helper that will manipulate the action bar if available.
	 */
	private ActionBarHelper createActionBarHelper() {
	    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
	        return new ActionBarHelperICS();
	    } else {
	        return new ActionBarHelper();
	    }
	}
	
	/**
	 * Stub action bar helper; this does nothing.
	 */
	private class ActionBarHelper {
	    public void init() {}
	    public void onDrawerClosed() {}
	    public void onDrawerOpened() {}
	    public void setTitle(CharSequence title) {}
	}
	
	/**
	 * Action bar helper for use on ICS and newer devices.
	 */
	private class ActionBarHelperICS extends ActionBarHelper {
	    private final ActionBar mActionBar;
	    private CharSequence mDrawerTitle;
	    private CharSequence mTitle;
	
	    ActionBarHelperICS() {
	        mActionBar = getActionBar();
	    }
	
	    @Override
	    public void init() {
	        mActionBar.setDisplayHomeAsUpEnabled(true);
	        mActionBar.setHomeButtonEnabled(true);
	        mTitle = mDrawerTitle = getTitle();
	    }
	
	    @Override
	    public void onDrawerClosed() {
	        super.onDrawerClosed();
	        mActionBar.setTitle(mTitle);
	    }
	
	    @Override
	    public void onDrawerOpened() {
	        super.onDrawerOpened();
	        mActionBar.setTitle(mDrawerTitle);
	    }
	
	    @Override
	    public void setTitle(CharSequence title) {
	        mTitle = title;
	    }
	}

}
