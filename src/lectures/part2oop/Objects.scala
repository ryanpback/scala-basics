package lectures.part2oop

object Objects extends App {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")

  object Person { // type + its only instance
    // "static"/"class" - class level functionality
    val N_EYES = 2

    def canFly: Boolean =
      false

    //  factory method
    def apply(mother: Person, father: Person): Person =
      new Person("Bobby")
  }

  class Person(val name: String) {
    // instance level functionality
  }
  // COMPANIONS - Object & Class

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala object = SINGLETON INSTANCE
  val ryan = Person
  val lilly = Person

  println(ryan == lilly) // true

  val laura = new Person("laura")
  val john = new Person("john")
  println(laura == john)

  val person1 = Person
  val person2 = Person
  println(person1 == person2)

  val bobby = Person(laura, john)
  println(bobby.name)

  // Scala Applications = Scala object
  // def main(args: Array[String]): Unit

}
