package hilmysf.eventapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.core.content.res.ResourcesCompat
import dagger.hilt.android.AndroidEntryPoint
import hilmysf.eventapps.databinding.ActivityMainBinding
import hilmysf.eventapps.ui.HomeActivity
import hilmysf.eventapps.ui.HomeFragment
import hilmysf.eventapps.utils.Helper
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnNext.setOnClickListener {
            with(binding) {
                if (edtName.text.isNullOrEmpty()) {
                    binding.edtName.error = "insert your name"
                } else {
                    btnNext.background = ResourcesCompat.getDrawable(resources, R.drawable.btn_signup_selected, theme)
                    showDialog(binding.edtName.text.toString())
                }
            }

        }

    }

    private fun showDialog(name: String) {
        val alertDialog = AlertDialog.Builder(this).apply {
            setTitle("Palindrome or Not?")
            if (Helper.isPalindrome(name)) setMessage("isPalindrome") else setMessage(
                "not palindrome"
            )
            setPositiveButton("OK") { _, _ ->
                val intent = Intent(this@MainActivity, HomeActivity::class.java).apply {
                    putExtra(HomeFragment.EXTRA_NAME, binding.edtName.text.toString())
                    startActivity(this)
                }
            }
            setNegativeButton("BACK") { _, _ ->
                true
            }
            val alert = this.create()
            alert.show()
        }
    }
}