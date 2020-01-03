package lectures.part2oop

object AbstractDataTypes extends App {

  // abstract
  abstract class Animal {
    val creatureType: String = "wild"

    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"

    def eat: Unit = println("crunch crunch")
  }

  // traits
  trait Carnivore {
    def eat(animal: Animal): Unit
    def preferredMeal: String = "fresh meat"
  }

  trait ColdBlooded
  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"

    def eat: Unit = println("nom nom nom")
    def eat(animal: Animal): Unit =
      println(s"I'm a $creatureType and I'm eating a ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat
  croc.eat(dog)

  /*
    • traits vs abstract classes
    1. Both can have abstract and non-abstract members
    2. Traits do not have constructor parameters
    3. Only can extend 1 class. Can multiple traits can be inherited
    4. Traits = behavior; abstract class = description
 */

}
