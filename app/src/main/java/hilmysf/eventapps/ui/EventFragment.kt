package hilmysf.eventapps.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import hilmysf.eventapps.adapter.EventAdapter
import hilmysf.eventapps.data.EventDummyData
import hilmysf.eventapps.data.EventEntity
import hilmysf.eventapps.databinding.FragmentEventBinding

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