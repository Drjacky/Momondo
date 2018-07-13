package ir.hosseinabbasi.momondo.data.db.model

/**
 * Created by Dr.jacky on 2018/06/29.
 */
data class MergedResponse constructor(
        val originName: String,
        val originCode: String,
        val destinationName: String,
        val destinationCode: String,
        val offer: OffersItem,
        val flight: FlightsItem,
        val segment: SegmentsItem,
        val leg: LegsItem
)