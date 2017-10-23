package com.example.toni.spscannerupdated;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HistoryActivity extends AppCompatActivity {

    @BindView(R.id.list_view)ListView listView;
    private DatabaseHandler databaseHandler;
    private ListviewAdapter listviewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        setTitle("Povijest skeniranja");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        databaseHandler = new DatabaseHandler(this);

        ButterKnife.bind(this);

        listviewAdapter = new ListviewAdapter(this, databaseHandler.getRecords());
        listView.setAdapter(listviewAdapter);

        if (listView.getCount() < 1){
            setContentView(R.layout.blank_layout);
        }

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
                if (listView.getCount() < 1){
                    setContentView(R.layout.blank_layout);
                }
                break;
            default:
                finish();
        }
        super.onOptionsItemSelected(item);
        return true;
    }
}



