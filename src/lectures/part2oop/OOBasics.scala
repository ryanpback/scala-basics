package lectures.part2oop

object OOBasics extends App {

  val person = new Person("Ryan", 30)
  println(person.x)
  person.greet("Ry")
  person.greet2

  val author = new Writer("Truman", "Capote", 1924)
  val imposter = new Writer("Truman", "Capote", 1924)
  val novel = new Novel("In Cold Blood", 1965, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(author))
  println(novel.isWrittenBy(imposter))

  val counter = new Counter
  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10).print

}

// class params are not fields - add val for accessing
class Person(name: String, val age: Int = 0) {
  // body
  val x = 2

  println(1 + x)

  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  def greet2(): Unit = println(s"Hi, I am $name")

  // multiple constructors
  // def this(name: String) = this(name, 0) // not needed as primary constructor can take default values
}

/*
  1. Novel and Writer classes

  Writer: first name, surname, year of birth
    - full name

  Novel: name, year of release, author
    - authorAge
    - isWrittenBy(author)
    - copy (new year of release) = new instance of Novel

   2. Counter class
    - receives an int value
    - current count
    - increment/decrement => new Counter
    - overload inc/dec to receive an amount
 */

class Writer(firstName: String, surname: String, val yob: Int) {
  def fullName() =
    s"$surname, $firstName"
}

class Novel(name: String, year: Int, author: Writer) {
  def authorAge =
    year - author.yob

  def isWrittenBy(author: Writer) =
    author == this.author

  def copy(newYear: Int) =
    new Novel(name, newYear, author)
}

class Counter(val count: Int = 0) {
  def inc = {
    println("incrementing")
    new Counter(count + 1)
  }

  def dec = {
    println("decrementing")
    new Counter(count - 1)
  }

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n - 1)
  }

  def dec(n: Int): Counter = {
    if (n <= 0) this
    else dec.dec(n - 1)
  }

  def print = println(count)
}
