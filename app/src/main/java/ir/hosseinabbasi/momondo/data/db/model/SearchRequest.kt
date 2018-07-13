package ir.hosseinabbasi.momondo.data.db.model

data class SearchRequest constructor(
        val origin: String,
        val destination: String,
        val departureDate: String,
        val returnDate: String,
        val ticketCount: String
)
