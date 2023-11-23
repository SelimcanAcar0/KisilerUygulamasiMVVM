package com.nullyx.kisileruygulamasimvvm.viewmodel

import androidx.lifecycle.ViewModel
import com.nullyx.kisileruygulamasimvvm.repo.KisilerDaoRepository

class KisiKayitSayfaVM:ViewModel() {
    private val kisilerRepo= KisilerDaoRepository()

    fun kisiKayit(kisiAd:String,kisiTel:String){
        kisilerRepo.kisiKayit(kisiAd,kisiTel)
    }
}