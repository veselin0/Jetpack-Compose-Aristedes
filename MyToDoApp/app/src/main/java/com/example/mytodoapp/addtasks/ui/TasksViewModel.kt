package com.example.mytodoapp.addtasks.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject
import android.util.Log

class TasksViewModel @Inject constructor() : ViewModel() {

    private val _showDialog = MutableLiveData<Boolean>()
    val showDialog:LiveData<Boolean> = _showDialog

    fun onDialogClose() {
        _showDialog.value = false
    }

    fun onTasksCreated(task: String) {
        _showDialog.value = false
        Log.i("Gocho", task)
    }

    fun onShowDialogClick() {
        _showDialog.value = true
    }

}