package dev.norman.mvvm_firebase_recyclerview.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.auth.User
import dev.norman.mvvm_firebase_recyclerview.R
import dev.norman.mvvm_firebase_recyclerview.data.model.UserEntity
import dev.norman.mvvm_firebase_recyclerview.databinding.ActivityMainBinding
import dev.norman.mvvm_firebase_recyclerview.ui.adapter.MainAdapter
import dev.norman.mvvm_firebase_recyclerview.ui.viewmodel.MainViewModel

/**
 * Created by normansn on 22/11/20.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var mainAdapter: MainAdapter
    private val activityMainBinding: ActivityMainBinding by lazy { DataBindingUtil.setContentView(this, R.layout.activity_main) }
    private val viewModel by lazy { ViewModelProviders.of(this).get(MainViewModel::class.java)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = activityMainBinding

        mainAdapter = MainAdapter(this)

        binding.rv.layoutManager = LinearLayoutManager(this)
        binding.rv.adapter = mainAdapter

        viewModel.getUsers().observe(this, {
            mainAdapter.setData(it)
        })

    }
}