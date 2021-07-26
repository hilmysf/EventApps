package hilmysf.eventapps.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import dagger.hilt.android.AndroidEntryPoint
import hilmysf.eventapps.R
import hilmysf.eventapps.adapter.MapAdapter
import hilmysf.eventapps.data.dummy.EventDummyData
import hilmysf.eventapps.data.source.entities.EventEntity
import hilmysf.eventapps.databinding.FragmentEventBinding
import hilmysf.eventapps.databinding.FragmentMapBinding
import javax.inject.Inject

@AndroidEntryPoint
class MapFragment  : Fragment(),
    OnMapReadyCallback {
    private var list: ArrayList<EventEntity> = arrayListOf()
    private lateinit var binding: FragmentMapBinding
    private lateinit var mMap: GoogleMap
    private lateinit var event: EventEntity
    private lateinit var mapAdapter: MapAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMapBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.mapFragment) as? SupportMapFragment
        mapFragment?.getMapAsync(this)
        list.addAll(EventDummyData.eventData)
        setupAdapter()
        onclick()
    }

    override
    fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        showMarker()
    }

    private fun showMarker() {
        val latLang = LatLng(event.lat, event.long)
        mMap.addMarker(
            MarkerOptions()
                .position(latLang)
                .title(event.nama)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
        )
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLang))
    }
    private fun setupAdapter(){
        with(binding.rvEventSlide){
            mapAdapter = MapAdapter(this@MapFragment)
            layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
            mapAdapter.setEvent(list)
            adapter = mapAdapter
            setHasFixedSize(true)
        }
    }

    private fun onclick(){
        with(binding.include){
            ibBackBtn.setOnClickListener {
                val navController = NavHostFragment.findNavController(requireParentFragment())
                navController.navigate(R.id.action_mapFragment_to_navigation_event)

            }
            ibMediaBtn.setOnClickListener { true }
        }
    }
}
