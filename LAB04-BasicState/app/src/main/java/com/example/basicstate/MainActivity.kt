package com.example.basicstate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.basicstate.theme.BasicStateTheme
import com.example.basicstate.ui.wellness.WellnessTasksList
import com.example.basicstate.ui.wellness.WellnessViewModel

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    enableEdgeToEdge()
    setContent {
      BasicStateTheme { Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        val viewModel: WellnessViewModel = viewModel()
        WellnessTasksList(
          tasks = viewModel.tasks,
          onCheckedChange = viewModel::toggleTaskChecked,
          onAddTask = viewModel::addTask,
          onRemoveTask = viewModel::removeTask
        )
      } }
    }
  }
}
