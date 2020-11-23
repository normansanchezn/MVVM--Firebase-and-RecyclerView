package dev.norman.mvvm_firebase_recyclerview.services

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import dev.norman.mvvm_firebase_recyclerview.data.model.UserEntity
import dev.norman.mvvm_firebase_recyclerview.utils.Constants

/**
 * Created by normansn on 22/11/20.
 */
class FirebaseServices {
    private val firebaseInstance = FirebaseFirestore.getInstance()
    private val const = Constants

    fun getUsers(): MutableLiveData<MutableList<UserEntity>> {
        val userListRemote = MutableLiveData<MutableList<UserEntity>>()
        firebaseInstance.collection(const.COLLECTION_USER).get().addOnSuccessListener {
            val listOfUsuario = mutableListOf<UserEntity>()
            for (document in it){
                listOfUsuario.add(UserEntity(
                    document.getString(const.IMAGE_URL),
                    document.getString(const.NAME),
                    document.getString(const.DESCRIPTION)
                ))
            }

            userListRemote.value = listOfUsuario
        }
        return userListRemote
    }

}