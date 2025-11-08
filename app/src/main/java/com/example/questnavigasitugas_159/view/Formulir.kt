package com.example.questnavigasitugas_159.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.questnavigasitugas_159.model.Peserta

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormIsian(
    jenisK: List<String> = listOf("Laki-laki", "Perempuan"),
    OnSubmitBtnClick: (Peserta) -> Unit,
    onBack: () -> Unit
) {
    // states
    val namaState = remember { mutableStateOf("") }
    val alamatState = remember { mutableStateOf("") }
    val jenisState = remember { mutableStateOf(jenisK.first()) }
    val statusOptions = listOf("Janda", "Lajang", "Duda")
    val statusState = remember { mutableStateOf(statusOptions[1]) } // default Lajang
    val showDialog = remember { mutableStateOf(false) }
    val dialogPeserta = remember { mutableStateOf<Peserta?>(null) }

    Surface(modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.background)) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Formulir Pendaftaran", modifier = Modifier.padding(bottom = 12.dp))
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "NAMA LENGKAP")
                    OutlinedTextField(
                        value = namaState.value,
                        onValueChange = { namaState.value = it },
                        placeholder = { Text(text = "Isikan nama lengkap") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

                    Text(text = "JENIS KELAMIN")
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        jenisK.forEach { item ->
                            Row(
                                modifier = Modifier.padding(end = 12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(
                                    selected = (jenisState.value == item),
                                    onClick = { jenisState.value = item }
                                )
                                Text(text = item)
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

                    Text(text = "STATUS PERKAWINAN")
                    Row {
                        statusOptions.forEach { s ->
                            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(end = 12.dp)) {
                                RadioButton(
                                    selected = (statusState.value == s),
                                    onClick = { statusState.value = s }
                                )
                                Text(text = s)
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

                    Text(text = "ALAMAT")
                    OutlinedTextField(
                        value = alamatState.value,
                        onValueChange = { alamatState.value = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp),
                        placeholder = { Text(text = "Isikan alamat") }
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(onClick = onBack, modifier = Modifier.width(140.dp)) {
                    Text(text = "Beranda")
                }
                Button(onClick = {
                    // buat object peserta
                    val peserta = Peserta(
                        nama = namaState.value.ifBlank { "Tidak diisi" },
                        jenisKelamin = jenisState.value,
                        statusPerkawinan = statusState.value,
                        alamat = alamatState.value.ifBlank { "-" }
                    )
                    dialogPeserta.value = peserta
                    showDialog.value = true
                }, modifier = Modifier.width(140.dp)) {
                    Text(text = "Submit")
                }
            }
        }
    }

    if (showDialog.value && dialogPeserta.value != null) {
        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            title = { Text(text = "Data Berhasil Disimpan") },
            text = {
                Column {
                    Text("Nama: ${dialogPeserta.value!!.nama}")
                    Text("Jenis Kelamin: ${dialogPeserta.value!!.jenisKelamin}")
                    Text("Status: ${dialogPeserta.value!!.statusPerkawinan}")
                    Text("Alamat: ${dialogPeserta.value!!.alamat}")
                }
            },
            confirmButton = {
                Button(onClick = {
                    // simpan dan close dialog
                    OnSubmitBtnClick(dialogPeserta.value!!)
                    showDialog.value = false
                }) {
                    Text("OK")
                }
            }
        )
    }
}