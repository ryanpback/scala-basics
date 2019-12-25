package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 30) {
    def likes(movie: String): Boolean =
      movie == favoriteMovie

    def isAlive: Boolean =
      true

    def +(person: Person): String =
      s"${this.name} is hanging out with ${person.name}"

    def +(nickName: String): Person =
      new Person(s"$name ($nickName)", favoriteMovie)

    def unary_! : String =
      s"$name, what the heck?!"

    def unary_+ : Person =
      new Person(name, favoriteMovie, age + 1)

    def apply(): String =
      s"Hi, my name is $name and I like $favoriteMovie"

    def apply(n: Int): String = {
      val singPlur: String = if (n == 1) "time" else "times"

      s"$name watched $favoriteMovie $n $singPlur"
    }

    def learns(subject: String): String =
      s"$name learns $subject"

    def learnScala: String =
      learns("Scala")
  }

  val ryan = new Person("Ryan", "Harry Potter")
  println(ryan.likes("Harry Potter"))

  // infix notation (operator notation) - syntactic sugar
  println(ryan likes "Harry Potter")

  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(ryan + tom)
  println(ryan.+(tom))

  println(1 + 2)
  println(1.+(2))
  // ALL OPERATORS ARE METHODS

  // prefix notation - syntactic sugar
  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-
  // unary_ prefix only works with (- + ~ !)

  println(!ryan)

  // postfix notation - can't have params
  println(ryan.isAlive)
  println(ryan isAlive)

  // apply
  println(ryan.apply())
  println(ryan())

  /*
    1. Overload plus (+) operator
      - mary + "the rockstar" => new Person

    2. Add an age to the Person class
       Add a unary + operator => new Person with age + 1
       +mary => with the age incrementer

     3. Add a "learns" method in the Person class => "Mary learns Scala"
        Add a learnScala method, calls the learns method with "Scala"
        Use it in postfix notation

      4. Overload the apply method
         mary.apply(2) => "Mary watch `favorite movie` n times"
   */

  println((ryan + "dev guy").name)
  println((+ryan).age)
  println(ryan learnScala)
  println(ryan(2))
}
