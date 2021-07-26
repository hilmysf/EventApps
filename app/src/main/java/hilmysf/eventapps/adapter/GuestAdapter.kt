package hilmysf.eventapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import hilmysf.eventapps.R
import hilmysf.eventapps.data.source.entities.GuestEntity
import hilmysf.eventapps.databinding.ItemGuestBinding
import hilmysf.eventapps.utils.Helper

class GuestAdapter(val parentFragment: Fragment) :
    RecyclerView.Adapter<GuestAdapter.GuestViewHolder>() {
    var listGuest: List<GuestEntity?> = emptyList()
    fun setGuest(guest: List<GuestEntity>?) {
        if (guest == null) return
        this.listGuest = guest
        notifyDataSetChanged()
    }

    inner class GuestViewHolder(private val binding: ItemGuestBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(guest: GuestEntity?) {
            binding.apply {
                Glide.with(itemView.context)
                    .load(guest?.image)
                    .into(imgGuest)
                tvGuestName.text = guest?.nama
                itemView.setOnClickListener {
                    val guestName = tvGuestName.text.toString()
                    val handphone = Helper.convertBirthdayToHandphone(guest)
                    val month = Helper.isPrime(guest)
                    val bundle = bundleOf("guestName" to guestName)
                    NavHostFragment.findNavController(parentFragment)
                        .navigate(R.id.action_navigation_guest_to_navigation_home, bundle)
                    Toast.makeText(parentFragment.context, "$handphone and it is $month", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {
        val itemGuestBinding =
            ItemGuestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GuestViewHolder(itemGuestBinding)
    }

    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {
        val guest = listGuest[position]
        holder.bind(guest)
    }

    override fun getItemCount(): Int = listGuest.size / 2

}