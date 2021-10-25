package id.smaraputra.tugasroom.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

import id.smaraputra.tugasroom.R;
import id.smaraputra.tugasroom.database.AppDatabase;
import id.smaraputra.tugasroom.model.MahasiswaModel;

public class EditMahasiswa extends AppCompatActivity {

    EditText nameedit, nimedit;
    Button canceled, saveed;

    private List<MahasiswaModel> mahasiswaData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_mahasiswa);

        nameedit = (EditText) findViewById(R.id.namaEdit);
        nimedit = (EditText) findViewById(R.id.nimEdit);

        canceled = findViewById(R.id.tombolbataled);
        saveed = findViewById(R.id.tombolkirimed);

        Intent intent = getIntent();
        int iduser = intent.getIntExtra("idu", 1);

        AppDatabase db = AppDatabase.getDbInstance(getApplicationContext());
        mahasiswaData =db.mahasiswaDao().listMahasiswaOne(iduser);

        nameedit.setText(mahasiswaData.get(0).getName());
        nimedit.setText(mahasiswaData.get(0).getNim());

        canceled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EditMahasiswa.this, ShowData.class);
                startActivity(intent);
            }
        });

        saveed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namabaru = nameedit.getText().toString();
                String nimbaru = nimedit.getText().toString();
                MahasiswaModel mahasiswaModel =
                        new MahasiswaModel(iduser, namabaru, nimbaru);
                db.mahasiswaDao().updateMahasiswa(mahasiswaModel);
                Intent intent = new Intent(EditMahasiswa.this,
                        ShowData.class);
                startActivity(intent);
            }
        });
    }
}