package course.examples.DataManagement.PreferenceFragment;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

public class PreferencesActivityExample extends AppCompatActivity {
	TextView textView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		textView = findViewById(R.id.textView);

		// Open a User Preferences Entry Activity 
		Button button = findViewById(R.id.check_pref_button);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(
						PreferencesActivityExample.this,
						MySettingsActivity.class));
			}
		});

	}

	@Override
	protected void onStart() {
		super.onStart();
		SharedPreferences sharedPreferences =
				PreferenceManager.getDefaultSharedPreferences(this);
		String name = sharedPreferences.getString("signature", "");
		textView.setText("Signature: " + name);
	}
}