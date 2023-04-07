val stateMap = Map(
  "VA" -> "Virginia",
  "LA" -> "Louisiana",
  "IL" -> "Illinois",
  "MO" -> "Missouri",
  "AZ" -> "Arizona",
  "CO" -> "Colorado"
)

val stateList = List(
  "LA",
  "IL",
  "VA",
  "CO",
  "MO",
  "AZ"
)

def statesVisited(list: List[String]): List[String] = {
  list.map(s => stateMap.getOrElse(s, "Not found"))
}

println(statesVisited(stateList))