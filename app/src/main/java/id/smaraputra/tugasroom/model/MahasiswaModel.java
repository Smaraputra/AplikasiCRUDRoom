package id.smaraputra.tugasroom.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity (tableName = "mahasiswa")
public class MahasiswaModel {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "nim")
    private String nim;

    public MahasiswaModel(int id, String name, String nim) {
        this.id = id;
        this.name = name;
        this.nim = nim;
    }

    @Ignore
    public MahasiswaModel(String name, String nim) {
        this.name = name;
        this.nim = nim;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNim() {
        return nim;
    }
    public void setNim(String nim) {
        this.nim = nim;
    }

}
