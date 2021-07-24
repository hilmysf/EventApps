package hilmysf.eventapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hilmysf.eventapps.databinding.ActivityMainBinding
import hilmysf.eventapps.ui.HomeActivity
import hilmysf.eventapps.ui.HomeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnNext.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java).apply {
                putExtra(HomeFragment.EXTRA_NAME, binding.edtName.text.toString())
            }
            with(binding){
                if (edtName.text.isNullOrEmpty()){
                    binding.edtName.error = "insert your name"
                }
                else{
                    startActivity(intent)
                }
            }

        }

    }
}