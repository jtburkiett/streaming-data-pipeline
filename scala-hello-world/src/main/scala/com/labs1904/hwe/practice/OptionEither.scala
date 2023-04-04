package com.labs1904.hwe.practice

case class Item(description: String, price: Option[Int])

case class WeatherStation(name: String, temperature: Option[Int])

object OptionEither {
  /*
    Returns age of a dog when given a human age.
    Returns None if the input is None.
  */
  def dogAge(humanAge: Option[Int]): Option[Int] = {
    humanAge.map(h => h * 7)
  }
  /*
    Returns the total cost af any item.
    If that item has a price, then the price + 7% of the price should be returned.
  */
  def totalCost(item: Item): Option[Double] = {
    item.price.map(p => Math.floor(p * .07) + p)
  }

  /*
    Given a list of weather temperatures, calculates the average temperature across all weather stations.
    Some weather stations don't report temperature
    Returns None if the list is empty or no weather stations contain any temperature reading.
   */
  def averageTemperature(temperatures: List[WeatherStation]): Option[Int] = {
    var sum = 0
    var l = 0
    temperatures.map(t => t.temperature.map(te => if(te.isValidInt) {sum += te; l+=1} ))
    if (sum != 0) {
      Option(sum / l)
    } else {
      None
    }
  }
}
