package ir.hosseinabbasi.momondo.data.db.model

data class SearchResponse(
	val offers: List<OffersItem?>? = null,
	val destinationCode: String,
	val suppliers: List<SuppliersItem?>? = null,
	val destinationName: String,
	val legs: List<LegsItem?>? = null,
	val airlines: List<AirlinesItem?>? = null,
	val originCode: String,
	val ticketClasses: List<TicketClassesItem?>? = null,
	val flights: List<FlightsItem?>? = null,
	val originName: String,
	val airports: List<AirportsItem?>? = null,
	val segments: List<SegmentsItem?>? = null
)
