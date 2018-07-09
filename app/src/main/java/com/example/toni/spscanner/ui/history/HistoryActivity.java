package com.example.toni.spscanner.ui.history;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.toni.spscanner.App;
import com.example.toni.spscanner.R;
import com.example.toni.spscanner.model.Scan;
import com.example.toni.spscanner.presentation.HistoryPresenter;
import com.example.toni.spscanner.presentation.HistoryPresenterImpl;
import com.example.toni.spscanner.ui.history.adapter.ScanHistoryAdapter;
import com.example.toni.spscanner.view.HistoryView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryActivity extends AppCompatActivity implements HistoryView{

    private HistoryPresenter presenter;

    @BindView(R.id.list_view)
    ListView listView;

    @BindView(R.id.emptyHistoryTv)
    TextView emptyHistoryTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ButterKnife.bind(this);

        presenter = new HistoryPresenterImpl(App.getScanInteractor());
        presenter.setView(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.readScansFromDatabase();
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
                presenter.deleteAllScansFromDatabase();
                presenter.readScansFromDatabase();
                break;
            default:
                finish();
        }
        super.onOptionsItemSelected(item);
        return true;
    }

    @Override
    public void showNoScansTextView() {
        emptyHistoryTv.setVisibility(View.VISIBLE);
    }

    @Override
    public void showScansListView(List<Scan> scans) {
        setupAdapter(scans);
    }

    private void setupAdapter(List<Scan> scans) {
        ScanHistoryAdapter adapter = new ScanHistoryAdapter();
        adapter.updateScanResultsList(scans);
        listView.setAdapter(adapter);
    }

    @Override
    public void showOnDeleteSuccess() {
        Toast.makeText(this, getString(R.string.history_deleted_text), Toast.LENGTH_SHORT).show();
    }
}




