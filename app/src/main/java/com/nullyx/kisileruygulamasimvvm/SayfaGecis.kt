package com.nullyx.kisileruygulamasimvvm

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.nullyx.kisileruygulamasimvvm.entity.Kisiler

@Composable
fun SayfaGecis(){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = "anasayfa"){
        composable("anasayfa"){
            Anasayfa(navController = navController)
        }
        composable("kisi_kayit_sayfa"){
            KisiKayitSayfa(navController = navController)
        }
        composable("kisi_detay_sayfa/{kisi}",
            arguments = listOf(navArgument("kisi"){
            type= NavType.StringType
        })){
         val json=it.arguments?.getString("kisi")
            val nesne= Gson().fromJson(json,Kisiler::class.java)
            KisiDetaySayfa(gelenKisi = nesne)
        }
    }
}