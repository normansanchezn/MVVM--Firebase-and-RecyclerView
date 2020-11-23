package dev.norman.mvvm_firebase_recyclerview.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.norman.mvvm_firebase_recyclerview.data.model.UserEntity
import dev.norman.mvvm_firebase_recyclerview.data.remote.RemoteDataRepository

/**
 * Created by normansn on 22/11/20.
 */
class MainViewModel: ViewModel() {

    private val remoteDataRepository = RemoteDataRepository()

    fun getUsers(): LiveData<MutableList<UserEntity>> {
        val data = MutableLiveData<MutableList<UserEntity>>()
        remoteDataRepository.getUsersRemote().observeForever{
            data.value = it
        }
        return data
    }

}