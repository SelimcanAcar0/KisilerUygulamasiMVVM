package com.nullyx.kisileruygulamasimvvm.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nullyx.kisileruygulamasimvvm.entity.Kisiler
import com.nullyx.kisileruygulamasimvvm.repo.KisilerDaoRepository

class KisiDetaySayfaVM:ViewModel() {
    private val kisilerRepo= KisilerDaoRepository()


    fun kisiGuncelle(kisiId:Int,kisiAd:String,kisiTel:String){
        kisilerRepo.kisiGuncelle(kisiId = kisiId, kisiAd= kisiAd,kisiTel= kisiTel )
    }
}