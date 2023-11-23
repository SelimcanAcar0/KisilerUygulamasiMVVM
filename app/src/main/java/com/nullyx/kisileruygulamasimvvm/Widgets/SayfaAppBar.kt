package com.nullyx.kisileruygulamasimvvm.Widgets

import android.util.Log
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import com.nullyx.kisileruygulamasimvvm.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SayfaAppBar(baslik: String ){
    TopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(
        containerColor = colorResource(id = R.color.DDBlue),
        titleContentColor = Color.White,
        actionIconContentColor = Color.White
    ),
        title = { Text(text = baslik, fontFamily = FontFamily.SansSerif,) },
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SayfaAppBar(baslik: String, icon:Painter){

    val aramaYapiliyormu= remember {
        mutableStateOf(false)
    }
    val aramaTF = remember {
        mutableStateOf("")
    }
    TopAppBar(

        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = colorResource(id = R.color.DDBlue),
            titleContentColor = Color.White,
            actionIconContentColor = Color.White
        ),
        title = {
            if (aramaYapiliyormu.value){
                TextField(value = aramaTF.value, onValueChange ={
                    aramaTF.value=it
                    Log.e("Kişi Arama",it)
                },
                    label = { Text(text = "Ara") },
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedLabelColor = Color.White,
                        focusedIndicatorColor = Color.White,
                        disabledLabelColor = Color.White,
                        disabledIndicatorColor = Color.White,


                    )
                    )
            }
            else {
                Text(text = baslik, fontFamily = FontFamily.SansSerif,)
            }
        },
        actions = {
                if (aramaYapiliyormu.value){
                    IconButton(onClick = {
                        aramaYapiliyormu.value=false
                        aramaTF.value=""
                    }){
                        Icon(painter = painterResource(id = R.drawable.baseline_cancel_24), contentDescription ="")
                    }
                }
                else{
                IconButton(onClick = {
                    aramaYapiliyormu.value=true

                }){
                    Icon(painter = icon, contentDescription ="")

                }
                }

        })
}