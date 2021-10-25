package id.smaraputra.tugasroom.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import id.smaraputra.tugasroom.R;
import id.smaraputra.tugasroom.database.AppDatabase;
import id.smaraputra.tugasroom.model.MahasiswaModel;

public class FormMahasiswa extends AppCompatActivity {

    String nama_in, nim_in;
    EditText nama, nim;
    Button cancel, save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nama = (EditText) findViewById(R.id.inputnama);
        nim = (EditText) findViewById(R.id.inputnim);
        cancel = (Button) findViewById(R.id.tombolbatalbatal);
        save = (Button) findViewById(R.id.tombolkirimkirim);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FormMahasiswa.this, MainMenu.class);
                startActivity(intent);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama_in = nama.getText().toString();
                nim_in = nim.getText().toString();
                AppDatabase db  = AppDatabase.getDbInstance(getApplicationContext());
                MahasiswaModel mahasiswaModel =
                        new MahasiswaModel(nama_in, nim_in);
                db.mahasiswaDao().tambahMahasiswa(mahasiswaModel);
                Intent intent = new Intent(FormMahasiswa.this,
                        MainMenu.class);
                startActivity(intent);
            }
        });
    }
}