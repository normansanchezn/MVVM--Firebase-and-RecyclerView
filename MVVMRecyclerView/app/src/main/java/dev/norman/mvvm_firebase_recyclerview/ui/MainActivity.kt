package dev.norman.mvvm_firebase_recyclerview.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.auth.User
import dev.norman.mvvm_firebase_recyclerview.R
import dev.norman.mvvm_firebase_recyclerview.data.model.UserEntity
import dev.norman.mvvm_firebase_recyclerview.databinding.ActivityMainBinding
import dev.norman.mvvm_firebase_recyclerview.ui.adapter.MainAdapter

/**
 * Created by normansn on 22/11/20.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var mainAdapter: MainAdapter
    private val activityMainBinding: ActivityMainBinding by lazy { DataBindingUtil.setContentView(this, R.layout.activity_main) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = activityMainBinding

        mainAdapter = MainAdapter(this)

        binding.rv.layoutManager = LinearLayoutManager(this)
        binding.rv.adapter = mainAdapter

        val dataDummy: MutableList<UserEntity> = mutableListOf(
            UserEntity("https://cnet1.cbsistatic.com/img/ysf3JxZymLvtxlV3X_bJTyRftRs=/940x0/2019/08/22/6cce6de4-4eaf-40e4-9acf-30dd4a4d0f1a/android-10.png",
            "Android",
            "Esta es una imagen de Android"),
            UserEntity("https://media.kasperskydaily.com/wp-content/uploads/sites/87/2019/12/11132630/android-device-identifiers-featured.jpg",
                "Android",
                "Esta es una imagen de Android"),
            UserEntity("https://cnet1.cbsistatic.com/img/ysf3JxZymLvtxlV3X_bJTyRftRs=/940x0/2019/08/22/6cce6de4-4eaf-40e4-9acf-30dd4a4d0f1a/android-10.png",
                "Android",
                "Esta es una imagen de Android"),
            UserEntity("https://cnet1.cbsistatic.com/img/ysf3JxZymLvtxlV3X_bJTyRftRs=/940x0/2019/08/22/6cce6de4-4eaf-40e4-9acf-30dd4a4d0f1a/android-10.png",
                "Android",
                "Esta es una imagen de Android"))

        mainAdapter.setData(dataDummy)

    }
}