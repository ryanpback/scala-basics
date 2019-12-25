package lectures.part2oop

object InheritanceAndTraits extends App {

  // Single class inheritance - only extend one class at a time
  class Animal {
    val creatureType = "wild"

    def eat = println("nom nom nom")
  }

  // Cat = subclass of Animal. Animal = superclass of Cat
  class Cat extends Animal {
    def crunch = {
      eat

      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  // constructors
  class Person(val name: String, val age: Int)
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  // overriding
  class Dog(override val creatureType: String) extends Animal {
    // override val creatureType = "domestic"
    override def eat = {
      super.eat
      println("crunch, crunch")
    }
  }

  // class Dog(dogType: String) extends Animal {
  //   override val creatureType = dogType
  // }

  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  // type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  // overRIDING vs overLOADING ^^

  // super

  // preventing overrides
  // 1: use final on member
  // 2: use final on class
  // 3: seal the class (`sealed` keyword) = extend classes in THIS FILE, prevent extension in other files
}
