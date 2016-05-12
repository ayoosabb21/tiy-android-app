package mobile.tiy.ironchat;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener {

    ArrayAdapter<String> items;

    ListView list;
    EditText text;
    Button saveButton;

    ChatClient chatLog; // declaring variable of ChatClient
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        chatLog = new ChatClient(); // intailized variable of CHatClient
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.listView);
        text = (EditText) findViewById(R.id.editText);
        saveButton = (Button) findViewById(R.id.button);

        saveButton.setOnClickListener(this); // this is an instance of yourself (itself)
        list.setOnItemLongClickListener(this);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        items = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1); // Array is being tied to the View(onCreate)
        list.setAdapter(items); // for this list, i would like set an Adapter for items created.

    }

    @Override //implements from a sub-class
    public void onClick(View v) {
        String item = text.getText().toString();
        text.setText("");
        String returnedMessage = chatLog.sendMessage(item);
        items.add(returnedMessage);

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
     //   String item = items.getItem(position);
        return true;

    }
}