package com.nullyx.kisileruygulamasimvvm.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nullyx.kisileruygulamasimvvm.entity.Kisiler
import com.nullyx.kisileruygulamasimvvm.repo.KisilerDaoRepository

class AnasayfaVM:ViewModel() {
    private val kisilerRepo= KisilerDaoRepository()
    var kisilerListesi=MutableLiveData<List<Kisiler>>()


    init {
        kisileriGetir()
        kisilerListesi=kisilerRepo.kisileriGetir()
    }
    fun kisileriGetir(){
         kisilerRepo.tumKisiler()
    }
    fun kisiAra(aramaKelimesi:String){
        kisilerRepo.kisiAra(aramaKelimesi)
    }
    fun kisiSil(kisiID:Int){
        kisilerRepo.kisiSil(kisiID)
    }
}