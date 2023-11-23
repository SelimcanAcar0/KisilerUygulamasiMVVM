package com.nullyx.kisileruygulamasimvvm.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.nullyx.kisileruygulamasimvvm.entity.Kisiler

class KisilerDaoRepository {
    private var kisilerListesi=MutableLiveData<List<Kisiler>>()

    init {
        kisilerListesi= MutableLiveData()
    }

    fun kisileriGetir():MutableLiveData<List<Kisiler>>{
        return kisilerListesi;
    }
    fun tumKisiler(){
        val liste= mutableListOf<Kisiler>()
        val k1 = Kisiler(kisi_id = 1, kisi_ad = "Selim", kisi_tel = "1111")
        val k2 = Kisiler(kisi_id = 2, kisi_ad = "Salih", kisi_tel = "2222")
        liste.add(k1)
        liste.add(k2)
        kisilerListesi.value=liste
    }

    fun kisiAra(aramaKelimesi:String){
        Log.e("Kişi arama",aramaKelimesi)
    }
    fun kisiKayit(kisiAd:String,kisiTel:String){
        Log.e("Kisi Kayit","$kisiAd - $kisiTel")
    }
    fun kisiGuncelle(kisiId:Int,kisiAd:String,kisiTel:String){
        Log.e("Kisi Güncelle","$kisiId -  $kisiAd - $kisiTel")
    }
    fun kisiSil(kisiID:Int){
        Log.e("Kişi Sil","$kisiID ")
    }

}