package dev.norman.mvvm_firebase_recyclerview.data.remote

import androidx.lifecycle.MutableLiveData
import dev.norman.mvvm_firebase_recyclerview.data.model.UserEntity
import dev.norman.mvvm_firebase_recyclerview.services.FirebaseServices

/**
 * Created by normansn on 22/11/20.
 */
class RemoteDataRepository {

    fun getUsersRemote(): MutableLiveData<MutableList<UserEntity>> {
        return FirebaseServices().getUsers()
    }

}