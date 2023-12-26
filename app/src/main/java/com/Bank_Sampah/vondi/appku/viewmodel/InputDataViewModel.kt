package com.Bank_Sampah.vondi.appku.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.Bank_Sampah.vondi.appku.db.ClientDatabase.Companion.getInstance
import com.Bank_Sampah.vondi.appku.db.DaoDatabase
import com.Bank_Sampah.vondi.appku.model.ModelDatabase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers

class InputDataViewModel(application: Application) : AndroidViewModel(application) {

    var daoDatabase: DaoDatabase?

    fun addDataSampah(
        nama_pengguna: String,
        jenis_sampah: String,
        berat: Int,
        harga: Int,
        tanggal: String,
        alamat: String,
        catatan: String
    ) {
        Completable.fromAction {
            val modelDatabase = ModelDatabase(
            namaPengguna = nama_pengguna,
            jenisSampah = jenis_sampah,
            berat = berat,
            harga = harga,
            tanggal = tanggal,
            alamat = alamat,
            catatan = catatan
            )
            daoDatabase?.insertData(modelDatabase)
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }

    init {
        daoDatabase = getInstance(application)?.appDatabase?.daoDatabase()
    }

}