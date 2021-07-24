package hilmysf.eventapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import hilmysf.eventapps.R
import hilmysf.eventapps.data.EventEntity
import hilmysf.eventapps.databinding.ItemEventBinding

class EventAdapter(val parentFragment: Fragment) :
    RecyclerView.Adapter<EventAdapter.EventViewHolder>() {
    private var listEvent: List<EventEntity> = emptyList()
    fun setEvent(event: List<EventEntity>?) {
        if (event == null) return
        this.listEvent = event
        notifyDataSetChanged()
    }

    inner class EventViewHolder(private val binding: ItemEventBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(event: EventEntity?) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(event?.image)
                    .into(imgEvent)
                tvTitleEvent.text = event?.nama
                tvDate.text = event?.tanggal
                itemView.setOnClickListener {
                    val eventName = tvTitleEvent.text.toString()
                    val bundle = bundleOf("eventName" to eventName)
                    NavHostFragment.findNavController(parentFragment)
                        .navigate(R.id.action_navigation_event_to_navigation_home, bundle)
                }
            }
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EventAdapter.EventViewHolder {
        val itemsEventBinding =
            ItemEventBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EventViewHolder(itemsEventBinding)
    }

    override fun onBindViewHolder(holder: EventAdapter.EventViewHolder, position: Int) {
        val event = listEvent[position]
        holder.bind(event)
    }

    override fun getItemCount(): Int = listEvent.size
}