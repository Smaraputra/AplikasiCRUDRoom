package id.smaraputra.tugasroom.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import id.smaraputra.tugasroom.R;
import id.smaraputra.tugasroom.activity.EditMahasiswa;
import id.smaraputra.tugasroom.activity.ShowData;
import id.smaraputra.tugasroom.database.AppDatabase;
import id.smaraputra.tugasroom.model.MahasiswaModel;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.MyViewHolder>{

    private Context context;
    private List<MahasiswaModel> mahasiswaModels;
    private List<MahasiswaModel> mArrayList;

    public MahasiswaAdapter(Context ct, List<MahasiswaModel> mahasiswaModels_in){
        this.context = ct;
        this.mahasiswaModels = mahasiswaModels_in;
        this.mArrayList = mahasiswaModels;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_mahasiswa, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final MahasiswaModel contacts = mArrayList.get(position);
        holder.namaT.setText(contacts.getName());
        holder.nimT.setText(contacts.getNim());
        holder.headnim.setText(contacts.getNim());
        holder.idT.setText(String.valueOf(contacts.getId()));
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView namaT, nimT, idT , headnim;
        Button showdetail, delete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            namaT = itemView.findViewById(R.id.namaMahasiswaRecyler);
            nimT = itemView.findViewById(R.id.nimMahasiswaRecyler);
            idT = itemView.findViewById(R.id.idMahasiswaRecyler);
            headnim = itemView.findViewById(R.id.nimHeader);

            showdetail = itemView.findViewById(R.id.tomboldetail);
            delete = itemView.findViewById(R.id.tombolhapus);

            showdetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = mArrayList.get(getAdapterPosition()).getId();
                    Intent intent = new Intent(context, EditMahasiswa.class);
                    intent.putExtra("idu", id);
                    context.startActivity(intent);
                }
            });

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int id = mArrayList.get(getAdapterPosition()).getId();
                    AppDatabase db  = AppDatabase.getDbInstance(context);
                    db.mahasiswaDao().deleteOne(id);
                    Intent intent = new Intent(context, ShowData.class);
                    context.startActivity(intent);
                }
            });
        }
    }
}