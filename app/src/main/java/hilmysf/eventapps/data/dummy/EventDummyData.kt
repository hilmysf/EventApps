package hilmysf.eventapps.data.dummy

import hilmysf.eventapps.R
import hilmysf.eventapps.data.source.entities.EventEntity

object EventDummyData {
    val eventData = arrayOf(
        EventEntity(
            R.drawable.bisnis,
            "Perjalanan Bisnis",
            "Nov 09 2014",
            lat = 106.81774638170157, long = -6.363629965566655,
        ),
        EventEntity(
            R.drawable.pesta,
            "Pesta Muda-Mudi",
            "Oct 21 2014",
            lat = 106.81766663415077, long = -6.363213555932339
        ),
        EventEntity(
            R.drawable.konferensi,
            "Pertemuan Para Pemenang",
            "Jun 14 2014",
            lat = 106.81735777062892, long = -6.363568321866178,
        ),
        EventEntity(
            R.drawable.wedding,
            "Pernikahan Dini",
            "Mar 31 2014",
            lat = 106.81780334423547, long = -6.363428679986132,
        ),
    )
}