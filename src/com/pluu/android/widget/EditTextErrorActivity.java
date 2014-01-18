package com.pluu.android.widget;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.pluu.android.R;

public class EditTextErrorActivity extends Activity {
	private EditText etEdit = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_text_error);

		etEdit = (EditText) findViewById(R.id.editText1);
		etEdit.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				showError(s);
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
			}
		});
	}

	public void onValidator(View v) {
		showError(etEdit.getText());
	}

	private void showError(CharSequence s) {
		if (s.length() > 0) {
			etEdit.setError("Error Message");
		} else {
			etEdit.setError(null);
		}
	}

}
