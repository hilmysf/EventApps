package hilmysf.eventapps.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import hilmysf.eventapps.R
import hilmysf.eventapps.adapter.EventAdapter
import hilmysf.eventapps.data.dummy.EventDummyData
import hilmysf.eventapps.data.source.entities.EventEntity
import hilmysf.eventapps.databinding.FragmentEventBinding

@AndroidEntryPoint
class EventFragment : Fragment() {
    private var list: ArrayList<EventEntity> = arrayListOf()
    private lateinit var binding: FragmentEventBinding
    private lateinit var eventAdapter: EventAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEventBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list.addAll(EventDummyData.eventData)
        showRecyclerView()
        binding.include.ibBackBtn.setOnClickListener {
            binding.include.ibBackBtn.setImageResource(R.drawable.btn_back_article_selected)
            val navController = NavHostFragment.findNavController(this)
            navController.navigate(R.id.action_navigation_event_to_navigation_home)
        }
        binding.include.ibMediaBtn.setOnClickListener {
            binding.include.ibMediaBtn.setImageResource(R.drawable.btn_new_media_article_selected)
            val navController = NavHostFragment.findNavController(this)
            navController.navigate(R.id.action_navigation_event_to_mapFragment)
        }
    }
    private fun showRecyclerView(){
        binding.apply {
            rvEvent.layoutManager = LinearLayoutManager(activity)
            eventAdapter = EventAdapter(this@EventFragment)
            eventAdapter.setEvent(list)
            rvEvent.adapter = eventAdapter
        }
    }
}