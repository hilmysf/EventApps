package hilmysf.eventapps.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import hilmysf.eventapps.R
import hilmysf.eventapps.databinding.FragmentHomeBinding

@AndroidEntryPoint
class HomeFragment : Fragment() {
    companion object {
        var EXTRA_NAME = "extra_name"
    }

    private lateinit var binding: FragmentHomeBinding
    private lateinit var name: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = NavHostFragment.findNavController(this)
        binding.apply {
            name = activity?.intent?.getStringExtra(EXTRA_NAME).toString()
            tvYourName.text = ": $name"
            btnChooseEvent.setOnClickListener {
                navController.navigate(R.id.action_navigation_home_to_navigation_event)
            }
            btnChooseGuest.setOnClickListener {
                navController.navigate(R.id.action_navigation_home_to_navigation_guest)
            }
            if (arguments?.getString("eventName") != null) {
                btnChooseEvent.text = arguments?.getString("eventName")
            }
            if (arguments?.getString("guestName") != null) {
                btnChooseGuest.text = arguments?.getString("guestName")
            }
        }

    }
}