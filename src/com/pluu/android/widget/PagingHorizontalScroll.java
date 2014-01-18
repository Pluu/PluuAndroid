package com.pluu.android.widget;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.pluu.android.R;

public class PagingHorizontalScroll extends Activity {
	private LinearLayout linearLayout;
	private PagingHorizontalScrollWidget horizontalScrollView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		int width = getResources().getDisplayMetrics().widthPixels;
		
		horizontalScrollView = new PagingHorizontalScrollWidget(this, 4, width);
		setContentView(R.layout.activity_paging_horizontal_scroll);
		linearLayout = (LinearLayout) findViewById(R.id.layer);
		linearLayout.addView(horizontalScrollView);

		LayoutParams params = new LayoutParams(width, 100);
		LinearLayout container = new LinearLayout(this);
		container.setLayoutParams(new LayoutParams(width, LayoutParams.WRAP_CONTENT));
		// container.setHeight(height);

		TextView textView = new TextView(this);
		textView.setGravity(Gravity.CENTER);
		textView.setText("First  Screen");
		textView.setBackgroundColor(Color.CYAN);
		textView.setLayoutParams(params);
		container.addView(textView);

		textView = new TextView(this);
		textView.setGravity(Gravity.CENTER);
		textView.setText("Second  Screen");
		textView.setBackgroundColor(Color.GREEN);
		textView.setLayoutParams(params);
		container.addView(textView);

		textView = new TextView(this);
		textView.setGravity(Gravity.CENTER);
		textView.setText("Third  Screen");
		textView.setBackgroundColor(Color.RED);
		textView.setLayoutParams(params);
		container.addView(textView);
		
		textView = new TextView(this);
		textView.setGravity(Gravity.CENTER);
		textView.setText("Four  Screen");
		textView.setBackgroundColor(Color.BLACK);
		textView.setTextColor(Color.WHITE);
		textView.setLayoutParams(params);
		container.addView(textView);

		horizontalScrollView.addView(container);
	}
}
