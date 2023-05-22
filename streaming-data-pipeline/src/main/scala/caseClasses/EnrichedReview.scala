package caseClasses

case class EnrichedReview(marketplace: String, customerId: Int, reviewId: String, productId: String,
                          productParent: String, productTitle: String, productCategory: String, starRating: Int,
                          helpfulVotes: Int, totalVotes: Int, vine: String, verifiedPurchase: String,
                          reviewHeadline: String, reviewBody: String, reviewDate: String, username: String,
                          name: String, sex: String, birthdate: String, mail: String)

object EnrichedReviewConstructor {
  def createEnrichedReview(rawReview: RawReview, userInfo: UserInfo): EnrichedReview ={

    EnrichedReview(
      rawReview.marketplace,
      rawReview.customerId,
      rawReview.reviewId,
      rawReview.productId,
      rawReview.productParent,
      rawReview.productTitle,
      rawReview.productCategory,
      rawReview.starRating,
      rawReview.helpfulVotes,
      rawReview.totalVotes,
      rawReview.vine,
      rawReview.verifiedPurchase,
      rawReview.reviewHeadline,
      rawReview.reviewBody,
      rawReview.reviewDate,
      userInfo.username,
      userInfo.name,
      userInfo.sex,
      userInfo.birthdate,
      userInfo.mail
    )
  }
}
