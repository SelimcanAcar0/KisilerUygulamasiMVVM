package com.nullyx.kisileruygulamasimvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.google.gson.Gson
import com.nullyx.kisileruygulamasimvvm.Widgets.SayfaAppBar
import com.nullyx.kisileruygulamasimvvm.ui.theme.KisilerUygulamasiMVVMTheme
import com.nullyx.kisileruygulamasimvvm.viewmodel.AnasayfaVM

class AnaSayfa : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KisilerUygulamasiMVVMTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SayfaGecis()
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Anasayfa(navController: NavController){


    val vm:AnasayfaVM= viewModel()
    val kisilerListesi=vm.kisilerListesi.observeAsState(listOf())

  Scaffold (
      topBar = {
          SayfaAppBar(baslik = "Kisiler", icon = painterResource(id = R.drawable.baseline_search_24))
      },
      content = {
          Surface (modifier = Modifier.padding(top = it.calculateTopPadding())){
              LazyColumn {
                  items(
                      count = kisilerListesi.value.count(),
                      itemContent = { index ->
                          val kisi = kisilerListesi.value[index]
                          Card(
                              modifier = Modifier
                                  .padding(5.dp)
                                  .fillMaxWidth()
                          ) {
                              Row(modifier = Modifier.clickable {
                                  val kisiJson=Gson().toJson(kisi)
                                  navController.navigate("kisi_detay_sayfa/$kisiJson")

                              }) {
                                  Row(
                                      modifier = Modifier
                                          .padding(10.dp)
                                          .fillMaxWidth(),
                                      horizontalArrangement = Arrangement.SpaceBetween,
                                      verticalAlignment = Alignment.CenterVertically
                                  ) {
                                      Text(text = "${kisi.kisi_ad} - ${kisi.kisi_tel}")
                                      Icon(
                                          painter = painterResource(id = R.drawable.ekle_icon),
                                          contentDescription = ""
                                      )
                                  }
                              }
                          }
                      }
                  )
              }
          }

      },
      floatingActionButton = {
          FloatingActionButton(onClick ={
             navController.navigate("kisi_kayit_sayfa")
          },) {
              Icon(painter = painterResource(id = R.drawable.ekle_icon), contentDescription ="" )
          }
      }

      )
}
