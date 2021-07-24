package hilmysf.eventapps.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import hilmysf.eventapps.adapter.GuestAdapter
import hilmysf.eventapps.data.GuestEntity
import hilmysf.eventapps.databinding.FragmentGuestBinding
import hilmysf.eventapps.utils.JsonHelper


class GuestFragment : Fragment() {
    private var list: ArrayList<GuestEntity> = arrayListOf()
    private lateinit var binding: FragmentGuestBinding
    private lateinit var guestAdapter: GuestAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGuestBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list = JsonHelper(requireContext()).loadGuests()
        list.addAll(list)
        showRecyclerView()
    }
    private fun showRecyclerView(){
        binding.apply {
            rvGuest.layoutManager = GridLayoutManager(activity, 2, GridLayoutManager.VERTICAL, false)
            guestAdapter = GuestAdapter(this@GuestFragment)
            guestAdapter.setGuest(list)
            rvGuest.adapter = guestAdapter
        }
    }

    private fun convertBirthdayToAge(){

    }
}