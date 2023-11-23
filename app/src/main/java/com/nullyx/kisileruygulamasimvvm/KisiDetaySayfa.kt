package com.nullyx.kisileruygulamasimvvm
import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nullyx.kisileruygulamasimvvm.Widgets.SayfaAppBar
import com.nullyx.kisileruygulamasimvvm.entity.Kisiler
import com.nullyx.kisileruygulamasimvvm.viewmodel.KisiDetaySayfaVM

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KisiDetaySayfa(gelenKisi:Kisiler) {
    val kisiAdiTF= remember {mutableStateOf("") }
    val kisiTelTF= remember {mutableStateOf("") }
    val localFocusManager= LocalFocusManager.current
    val vm:KisiDetaySayfaVM= viewModel()
    LaunchedEffect(key1 = true, ){
        kisiAdiTF.value=gelenKisi.kisi_ad
        kisiTelTF.value=gelenKisi.kisi_tel
    }
   Scaffold (
       topBar = {
                SayfaAppBar(baslik = "Kisi Detay")
       }
   ) {
       Column(
           Modifier.fillMaxSize(),
           verticalArrangement = Arrangement.SpaceEvenly,
           horizontalAlignment = Alignment.CenterHorizontally,
       ) {
           OutlinedTextField(
               value = kisiAdiTF.value,
               onValueChange = { kisiAdiTF.value = it },
               label = { Text(text = "Kisi Ad")},
               shape = RoundedCornerShape(corner = CornerSize(20.dp))
           )
           OutlinedTextField(
               value = kisiTelTF.value,
               onValueChange = { kisiTelTF.value = it },
               label = { Text(text = "Telefon Numarası")},
               shape = RoundedCornerShape(corner = CornerSize(20.dp))
           )
           Button(
               onClick = {
                   val kisiAd=kisiAdiTF.value
                   val kisiTel=kisiTelTF.value
                   localFocusManager.clearFocus()
                   vm.kisiGuncelle(kisiId = gelenKisi.kisi_id, kisiAd =kisiAd, kisiTel = kisiTel)
               }, modifier = Modifier.size(200.dp,50.dp)
           ) {
                Text(text = "Güncelle")
           }
       }
   }
}

