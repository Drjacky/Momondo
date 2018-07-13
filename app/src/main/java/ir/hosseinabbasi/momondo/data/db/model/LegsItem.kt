package ir.hosseinabbasi.momondo.data.db.model

data class LegsItem(
	val destinationIndex: Int? = null,
	val arrival: Long,
	val originIndex: Int? = null,
	val id: Int? = null,
	val departure: Long,
	val airlineIndex: Int? = null,
	val flightNumber: Int? = null
)
