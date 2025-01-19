package com.example.lista_7

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel


class StudentViewModel: ViewModel(){
    private val _students = MutableLiveData(dummyStudents)
    val students: LiveData<List<Student>> = _students

    private val _selectedStudent = MutableLiveData<Student?>()
    val selectedStudent: LiveData<Student?> = _selectedStudent

    fun selectStudent(student: Student){
        _selectedStudent.value = student
    }

}