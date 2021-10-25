package id.smaraputra.tugasroom.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import id.smaraputra.tugasroom.model.MahasiswaModel;

@Dao
public interface MahasiswaDao {

    @Query("Select * from mahasiswa")
    List<MahasiswaModel> listMahasiswa();

    @Query("SELECT * FROM mahasiswa WHERE id = :idmasuk")
    List<MahasiswaModel> listMahasiswaOne(int idmasuk);

    @Query("DELETE FROM mahasiswa WHERE id = :idmasuk")
    void deleteOne(int idmasuk);

    @Insert
    void tambahMahasiswa(MahasiswaModel mahasiswaModel);

    @Update
    void updateMahasiswa(MahasiswaModel mahasiswaModel);

    @Delete
    void hapusMahasiswa(MahasiswaModel mahasiswaModel);
}
