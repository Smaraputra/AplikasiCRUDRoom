package id.smaraputra.tugasroom.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import id.smaraputra.tugasroom.R;
import id.smaraputra.tugasroom.adapter.MahasiswaAdapter;
import id.smaraputra.tugasroom.database.AppDatabase;
import id.smaraputra.tugasroom.model.MahasiswaModel;

public class ShowData extends AppCompatActivity {

    private MahasiswaAdapter mAdapter;

    private List<MahasiswaModel> mahasiswaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        RecyclerView userView = (RecyclerView) findViewById(R.id.recylerViewMahasiswa);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ShowData.this);
        userView.setLayoutManager(linearLayoutManager);
        userView.setHasFixedSize(true);

        AppDatabase db = AppDatabase.getDbInstance(getApplicationContext());
        mahasiswaList =db.mahasiswaDao().listMahasiswa();

        mAdapter = new MahasiswaAdapter(ShowData.this, mahasiswaList);
        userView.setAdapter(mAdapter);
    }
}