package example.android.optionmenusample;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public class OptionMenuSampleActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_option_menu_sample);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_option_menu_sample, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		String action = null;
		Intent intent = null;
		switch (item.getItemId()) {
		case R.id.item1:
			// showDialog("メニューアイテム1を選択しました。");
			return true;
		case R.id.item2:
			showDialog("メニューアイテム2を選択しました。");
			return true;
		case R.id.item3:
			showDialog("メニューアイテム3を選択しました。");
			return true;
		case R.id.subitem1:
			action = "android.intent.action.DIAL";
			intent = new Intent(action);
			startActivity(intent);
			return true;
		case R.id.subitem2:
			action = "android.intent.action.VIEW";
			intent = new Intent(action);
			intent.setType("vnd.android-dir/mms-sms");
			startActivity(intent);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void showDialog(String string) {
		AlertDialog.Builder dialog = new AlertDialog.Builder(OptionMenuSampleActivity.this);
		dialog.setTitle("メニューアイテム選択結果");
		dialog.setMessage(string);
		dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				OptionMenuSampleActivity.this.setResult(Activity.RESULT_OK);
			}
		});
		dialog.create();
		dialog.show();
	}
}
