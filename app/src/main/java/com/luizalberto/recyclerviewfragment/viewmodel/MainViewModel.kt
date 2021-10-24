package com.luizalberto.recyclerviewfragment.viewmodel


import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.luizalberto.recyclerviewfragment.data.repository.Repository
import com.luizalberto.recyclerviewfragment.model.Fruit
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val repository: Repository
) : ViewModel() {

    private val fruits = repository.getFruits()

    private val selected = MutableLiveData<Fruit>()

    fun getFruits(): LiveData<List<Fruit>> {

        viewModelScope.launch {
            repository.refreshFruits()
        }

        return fruits
    }

    fun select(item: Fruit) {
        selected.value = item
    }

    fun getSelected(): LiveData<Fruit> = selected

}