package com.example.questnavigasitugas_159.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.questnavigasitugas_159.R

@Composable
fun Beranda(onMasuk: () -> Unit) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Selamat Datang", modifier = Modifier.padding(bottom = 16.dp))
            // ganti drawable/ic_logo dengan logo kamu di res/drawable
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier.size(220.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(text = "Muhammad Dzulfikri\n20230140159")
            Spacer(modifier = Modifier.height(32.dp))
            Button(onClick = onMasuk) {
                Text(text = stringResource(id = R.string.submit)) // gunakan string submit sebagai "Masuk"
            }
        }
    }
}