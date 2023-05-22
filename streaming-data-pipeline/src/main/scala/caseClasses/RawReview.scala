package caseClasses

case class RawReview(marketplace: String, customerId: Int, reviewId: String, productId: String, productParent: String,
                                          productTitle: String, productCategory: String, starRating: Int, helpfulVotes: Int,
                                          totalVotes: Int, vine: String, verifiedPurchase: String, reviewHeadline: String,
                                          reviewBody: String, reviewDate: String)
object RawReviewConstructor {
  def rawReviewFromCSV(input: String): RawReview = {
    val entries = input.split("\t")
    RawReview(
      entries(0),
      entries(1).toInt,
      entries(2),
      entries(3),
      entries(4),
      entries(5),
      entries(6),
      entries(7).toInt,
      entries(8).toInt,
      entries(9).toInt,
      entries(10),
      entries(11),
      entries(12),
      entries(13),
      entries(14),
    )
  }
}