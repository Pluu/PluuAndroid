package com.pluu.android.anim;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import com.pluu.android.R;

public class AnimationActivity extends Activity {

	private LinearLayout mHiddenLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_anim_expand_collapse);
		
		mHiddenLayout = (LinearLayout) findViewById(R.id.hiddenLayout);
	}
	
	public void onExpand(View v) {
		mHiddenLayout.measure(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
	    final int targtetHeight = mHiddenLayout.getMeasuredHeight();

	    mHiddenLayout.getLayoutParams().height = 0;
	    mHiddenLayout.setVisibility(View.VISIBLE);
	    Animation a = new Animation()
	    {
	        @Override
	        protected void applyTransformation(float interpolatedTime, Transformation t) {
	        	mHiddenLayout.getLayoutParams().height = interpolatedTime == 1
	                    ? LayoutParams.WRAP_CONTENT
	                    : (int)(targtetHeight * interpolatedTime);
	            mHiddenLayout.requestLayout();
	        }

	        @Override
	        public boolean willChangeBounds() {
	            return true;
	        }
	    };

	    // 250ms
	    a.setDuration(250);
	    a.setInterpolator(this, android.R.anim.accelerate_interpolator);
	    mHiddenLayout.startAnimation(a);
	}
	
	public void onCollapse(View v) {
		final int initialHeight = mHiddenLayout.getMeasuredHeight();

	    Animation a = new Animation()
	    {
	        @Override
	        protected void applyTransformation(float interpolatedTime, Transformation t) {
	            if(interpolatedTime == 1){
	            	mHiddenLayout.setVisibility(View.GONE);
	            }else{
	            	mHiddenLayout.getLayoutParams().height = initialHeight - (int)(initialHeight * interpolatedTime);
	            	mHiddenLayout.requestLayout();
	            }
	        }

	        @Override
	        public boolean willChangeBounds() {
	            return true;
	        }
	    };

	    // 250ms
	    a.setDuration(250);
	    a.setInterpolator(this, android.R.anim.accelerate_interpolator);
	    mHiddenLayout.startAnimation(a);
	}
	
}
