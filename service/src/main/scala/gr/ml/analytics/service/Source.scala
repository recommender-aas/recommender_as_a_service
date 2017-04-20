package gr.ml.analytics.service

import org.apache.spark.sql.DataFrame

trait Source {
  /**
    * @return DataFrame of (userId: Int, itemId: Int, rating: float) triples to train model
    */
  def all: DataFrame

  /**
    * @return Set of userIds the performed latest ratings
    */
  def getUserIdsForLastNSeconds(seconds : Long): Set[Int]

  /**
    * @return DataFrame of itemIds and userIds for rating (required by CF job)
    */
  def getUserItemPairsToRate(userId: Int): DataFrame

  /**
    * @return DataFrame of itemIds and numeric features
    */
  def getAllItemsAndFeatures(): DataFrame
}