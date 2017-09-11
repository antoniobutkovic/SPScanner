package com.example.toni.spscannerupdated;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;


public class HistoryActivity extends AppCompatActivity {

    private ListviewAdapter listviewAdapter;
    private DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        setTitle("Povijest skeniranja");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        databaseHandler = new DatabaseHandler(this);

        ListView listView = (ListView) findViewById(R.id.list_view);
        listviewAdapter = new ListviewAdapter(this, databaseHandler.getRecords());
        listView.setAdapter(listviewAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.custom_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.clear:
                databaseHandler.clearHistory();
                listviewAdapter.changeCursor(databaseHandler.getRecords());
                break;
            default:
                finish();
        }
        super.onOptionsItemSelected(item);
        return true;
    }
}



