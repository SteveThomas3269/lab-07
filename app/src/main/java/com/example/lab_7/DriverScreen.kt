package com.example.lab_7

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun DriversScreen(navController: NavController) {
    var driver by remember { mutableStateOf("") }
    val drivers = remember { mutableStateListOf<String>() }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Button(onClick = { navController.popBackStack() }, modifier = Modifier.testTag("driversBackButton")) {
            Text("Back")
        }
        Text("FormulaZero Drivers", fontSize = 30.sp)

        TextField(value = driver, onValueChange = { driver = it }, label = { Text("Driver Name") },
            modifier = Modifier.testTag("driverInput"))

        Row {
            Button(onClick = { if (driver.isNotBlank()) { drivers.add(driver); driver = "" } },
                modifier = Modifier.testTag("addDriverButton")) { Text("Add") }
            Button(onClick = { drivers.clear() }, modifier = Modifier.testTag("clearDriversButton")) {
                Text("Clear")
            }
        }

        LazyColumn {
            items(drivers) { Text(it, fontSize = 24.sp) }
        }
    }
}