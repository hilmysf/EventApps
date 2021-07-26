package hilmysf.eventapps.data.source.entities

data class EventEntity(
    var image: Int? = null,
    var nama: String? = null,
    var tanggal: String? = null,
    var lat: Double ,
    var long: Double
)