package lectures.part1basics

object ValuesVariablesTypes extends App {

  // VALS ARE IMMUTABLE
  // Types can be inferred
  val x = 42
  println(x)



  val aString: String = "Hello, Scala"
  val aBoolean: Boolean = true
  val aChar: Char = 'a'
  val anInt: Int = 23 // 4 bytes
  val aShort: Short = 21 // 2 bytes
  val aLong: Long = 12312321121232323L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  // variables - side effects
  var aVariable: Int = 4
  aVariable = 3
}
