package hilmysf.eventapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import hilmysf.eventapps.data.source.entities.EventEntity
import hilmysf.eventapps.databinding.ItemEventLocationBinding

class MapAdapter(val parentFragment: Fragment) :
    RecyclerView.Adapter<MapAdapter.EventViewHolder>() {
    private var listEvent: List<EventEntity> = emptyList()
    fun setEvent(event: List<EventEntity>?) {
        if (event == null) return
        this.listEvent = event
        notifyDataSetChanged()
    }

    inner class EventViewHolder(private val binding: ItemEventLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(event: EventEntity?) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(event?.image)
                    .into(imgEventLocation)
                tvEventLocation.text = event?.nama
            }
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MapAdapter.EventViewHolder {
        val itemEventLocationBinding =
            ItemEventLocationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EventViewHolder(itemEventLocationBinding)
    }

    override fun getItemCount(): Int = listEvent.size
    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = listEvent[position]
        holder.bind(event)
    }
}