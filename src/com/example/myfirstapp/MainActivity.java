package com.example.myfirstapp;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private TaskAdapter taskAdapter;

	protected static final int ADD_TASK = 100;
	private Button tbnAddTaskSimple;
	private ListView lvTasks;

	private ArrayList<Task> tasksList;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lvTasks = (ListView) findViewById(R.id.lvTasks);
		tasksList = new ArrayList<Task>();
		for (int i = 1; i < 3; i++) {
			tasksList.add(new Task(
					"Task long text to see what it does when out of bounds nunber "
							+ i));
		}
		taskAdapter = new TaskAdapter(this, R.layout.list_item, tasksList);

		lvTasks.setAdapter(taskAdapter);

		tbnAddTaskSimple = (Button) findViewById(R.id.btnAddTaskMain);
		tbnAddTaskSimple.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,
						DisplayMessageActivity.class);
				startActivityForResult(intent, ADD_TASK);
			}
		});

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK && requestCode == ADD_TASK) {
			tasksList.add(new Task(data.getStringExtra("newTask")));
			taskAdapter.notifyDataSetChanged();
			Toast.makeText(this,
					"Task Added: " + data.getStringExtra("newTask"),
					Toast.LENGTH_LONG).show();
		}
	}
}
