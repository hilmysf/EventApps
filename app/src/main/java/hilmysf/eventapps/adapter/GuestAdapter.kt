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
import hilmysf.eventapps.data.GuestEntity
import hilmysf.eventapps.databinding.ItemGuestBinding
import java.text.SimpleDateFormat
import java.util.*

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
                    val handphone = convertBirthdayToHandphone(guest)
                    val bundle = bundleOf("guestName" to guestName)
                    NavHostFragment.findNavController(parentFragment)
                        .navigate(R.id.action_navigation_guest_to_navigation_home, bundle)
                    Toast.makeText(parentFragment.context, handphone, Toast.LENGTH_SHORT).show()
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

    private fun convertBirthdayToHandphone(guest: GuestEntity?): String {
        val format = SimpleDateFormat("yyyy-mm-dd")
        val date = format.parse(guest?.birthDate)
        val myCal = GregorianCalendar()
        myCal.time = date
        val birthday = myCal.get(Calendar.DAY_OF_MONTH)
        return if (birthday % 2 == 0 && birthday % 3 == 0) {
            "iOS"
        } else if (birthday % 3 == 0) {
            "android"
        } else if (birthday % 2 == 0) {
            "blackberry"
        } else {
            "feature phone"
        }
    }
}