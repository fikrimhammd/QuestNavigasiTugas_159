package com.example.questnavigasitugas_159.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.questnavigasitugas_159.model.Peserta

@Composable
fun ListPeserta(
    onAddNew: () -> Unit,
    onBackToHome: () -> Unit
) {
    val items = listOf(
        Peserta(nama = "Dzulfikri", jenisKelamin = "Laki-laki", statusPerkawinan = "Lajang", alamat = "Cikarang"),
        Peserta(nama = "Naila Rifka", jenisKelamin = "Perempuan", statusPerkawinan = "Lajang", alamat = "Yogyakarta")
    )


    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.SpaceBetween) {
        Text(text = "List Daftar Peserta", modifier = Modifier.padding(bottom = 12.dp), fontWeight = FontWeight.Bold) // Judul lebih tebal

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(items) { peserta ->
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),

                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                    colors = CardDefaults.cardColors()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {


                        Row(modifier = Modifier.fillMaxWidth()) {

                            Column(modifier = Modifier.weight(1f)) {
                                Text(text = "NAMA LENGKAP")
                                Text(text = peserta.nama, fontWeight = FontWeight.SemiBold)
                            }
                            // Kolom Kanan: JENIS KELAMIN (50% Lebar)
                            Column(modifier = Modifier.weight(1f)) {
                                Text(text = "JENIS KELAMIN")
                                Text(text = peserta.jenisKelamin, fontWeight = FontWeight.SemiBold)
                            }
                        }


                        Spacer(modifier = Modifier.height(12.dp))


                        Row(modifier = Modifier.fillMaxWidth()) {

                            Column(modifier = Modifier.weight(1f)) {
                                Text(text = "STATUS PERKAWINAN")
                                Text(text = peserta.statusPerkawinan, fontWeight = FontWeight.SemiBold)
                            }

                            Column(modifier = Modifier.weight(1f)) {
                                Text(text = "ALAMAT")
                                Text(text = peserta.alamat, fontWeight = FontWeight.SemiBold)
                            }
                        }
                    }
                }
            }
        }


        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            Button(onClick = onBackToHome, modifier = Modifier.padding(end = 8.dp)) {
                Text(text = "Beranda")
            }
            Button(onClick = onAddNew) {
                Text(text = "Formulir")
            }
        }
    }
}