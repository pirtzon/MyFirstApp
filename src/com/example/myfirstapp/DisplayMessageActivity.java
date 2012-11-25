package com.example.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DisplayMessageActivity extends Activity {
		
	private EditText etAddTaskSimple;
	private Button btnReturnTask;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        
        etAddTaskSimple = (EditText)findViewById(R.id.etAddTask);
        etAddTaskSimple.setText("");
        btnReturnTask = (Button)findViewById(R.id.btnAddTask);
        btnReturnTask.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				String task = etAddTaskSimple.getText().toString();
				if(task.equals("")) {
					Toast.makeText(DisplayMessageActivity.this, "Cant add Empty task ", Toast.LENGTH_SHORT).show();
					return;
				}
				Intent intent = new Intent(DisplayMessageActivity.this, MainActivity.class);
				intent.putExtra("newTask", task);
				setResult(RESULT_OK,intent);
				finish();

			}
		});
        
    }
}
