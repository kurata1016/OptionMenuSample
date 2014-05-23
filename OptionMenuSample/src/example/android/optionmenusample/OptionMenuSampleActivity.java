package example.android.optionmenusample;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

public class OptionMenuSampleActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_option_menu_sample);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.activity_option_menu_sample, menu);
		super.onCreateOptionsMenu(menu);

		MenuItem item1 = menu.add(0, 0, 0, "item1");
		item1.setIcon(android.R.drawable.ic_menu_add);

		MenuItem item2 = menu.add(0, 1, 0, "item2");
		item2.setIcon(android.R.drawable.ic_menu_call);

		MenuItem item3 = menu.add(0, 2, 0, "item3");
		item3.setIcon(android.R.drawable.ic_menu_day);

		MenuItem item4 = menu.add(0, 3, 0, "item4");
		item4.setIcon(android.R.drawable.ic_menu_my_calendar);

		MenuItem item5 = menu.add(0, 4, 0, "item5");
		item5.setIcon(android.R.drawable.ic_menu_send);

		SubMenu item6 = menu.addSubMenu(0, 5, 0, "other");
		item6.setIcon(android.R.drawable.ic_menu_view);
		item6.add(0, 10, 0, "subitem1");
		item6.add(0, 20, 0, "subitem2");

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		String action = null;
		Intent intent = null;
		switch (item.getItemId()) {
		case 0:
			 showDialog("メニューアイテム1を選択しました。");
			return true;
		case 1:
			showDialog("メニューアイテム2を選択しました。");
			return true;
		case 2:
			showDialog("メニューアイテム3を選択しました。");
			return true;
		case 3:
			action = "android.intent.action.DIAL";
			intent = new Intent(action);
			startActivity(intent);
			return true;
		case 4:
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
