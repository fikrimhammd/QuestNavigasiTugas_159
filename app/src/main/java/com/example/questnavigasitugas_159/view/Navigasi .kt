package com.example.questnavigasitugas_159.view

import TampilData
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


enum class Navigasi {
    Beranda,
    Formulirku,
    ListPeserta,
    Detail
}

@Composable
fun DataApp() {
    val navController: NavHostController = rememberNavController()

    Scaffold { isiRuang ->
        NavHost(
            navController = navController,
            startDestination = Navigasi.Beranda.name,
            modifier = androidx.compose.ui.Modifier.padding(paddingValues = isiRuang)
        ) {
            composable(route = Navigasi.Beranda.name) {
                Beranda(
                    onMasuk = { navController.navigate(Navigasi.ListPeserta.name) }
                )
            }

            composable(route = Navigasi.Formulirku.name) {
                FormIsian(
                    OnSubmitBtnClick = { peserta ->
                        navController.navigate(Navigasi.ListPeserta.name)
                    },
                    onBack = { navController.popBackStack() }
                )
            }

            composable(route = Navigasi.ListPeserta.name) {
                ListPeserta(
                    onAddNew = { navController.navigate(Navigasi.Formulirku.name) },
                    onBackToHome = { navController.navigate(Navigasi.Beranda.name) }
                )
            }

            composable(route = Navigasi.Detail.name) {
                TampilData(
                    onBackBtnClick = { navController.popBackStack() }
                )
            }
        }
    }
}