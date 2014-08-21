package com.example.helloworld;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TutorialTwo extends ListActivity {

	String classNames[ ] = { "main", "menu", "Sweet", "TutorialOne" };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, classNames));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		String openClass = classNames[position];
		try {
			Class selected = Class.forName("com.example.helloworld." + openClass);
			Intent selectedIntent = new Intent(this, selected);
			startActivity(selectedIntent);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
		finish();
	}
	
	
	
	

}
