package com.pdm0126.labo4.screens.GreetingScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pdm0126.labo4.components.TaskCard
import com.pdm0126.labo4.model.Task


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskListScreen(
    viewModel: TaskViewModel = viewModel(),
    onBack: () -> Unit
) {
    var showDialog by remember { mutableStateOf(false) }
    var taskToUpdate by remember { mutableStateOf<Task?>(null) }
    val taskList by viewModel.tasks.collectAsState()
    

    Scaffold(
        topBar = {
            TopAppBar(title = {Text("Tasks list")})
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {showDialog = true}) {
                Text(text = "Add")
            }
        }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(taskList) { task ->
                TaskCard(
                    task = task,
                    onDelete = { viewModel.deleteTask(it) },
                    onUpdate = { taskToUpdate = it }
                )
                Spacer(modifier = Modifier.height(24.dp))
            }
            item {
                Button(onClick = onBack) {
                    Text(text = "Back")
                }
            }
        }

        if (showDialog){
            CreateTask(
                onDismiss = { showDialog = false },
                onTaskCreated = { newTitle, newDescription ->
                    val newTask = Task(
                        id = 0,
                        title = newTitle,
                        description = newDescription
                    )
                    viewModel.addTask(newTask)
                    showDialog = false
                }
            )
        }
        if (taskToUpdate != null) {
            CreateTask(
                initialTitle = taskToUpdate!!.title,
                initialDescription = taskToUpdate!!.description,
                onDismiss = { taskToUpdate = null },
                onTaskCreated = { newTitle, newDescription ->
                    viewModel.updateTask(
                        taskToUpdate!!.copy(
                            title = newTitle,
                            description = newDescription
                        )
                    )
                    taskToUpdate = null
                }
            )
        }

    }
}

@Composable
fun CreateTask(
    initialTitle: String = "",
    initialDescription: String = "",
    onDismiss: () -> Unit,
    onTaskCreated: (String, String) -> Unit
){
    var title by remember { mutableStateOf(initialTitle) }
    var description by remember { mutableStateOf(initialDescription) }
    Dialog(
        onDismissRequest = {
            onDismiss()
        },
        properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false
        ),
    ) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .background(Color.Black),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Nueva Tarea",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Título") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))


            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Descripción") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 16.dp),
            ) {
                Button(onClick = { onDismiss()}) {
                    Text(text = "Cerrar")
                }

                Button(onClick = {
                    if (title.isNotBlank()){
                        onTaskCreated(title,description)
                    }
                },
                    enabled = title.isNotBlank()) {
                    Text("Crear")
                }
            }
        }
    }
}