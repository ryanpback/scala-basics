package lectures.part1basics

object Recursion extends App {

  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println(
        "Computing factorial of " + n + " - I first need factorial of " + (n - 1)
      )
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)

      result
    }

//  println(factorial(10))

  def anotherFactorial(n: Int): BigInt = {
    @scala.annotation.tailrec
    def factorialHelper(x: BigInt, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else
        factorialHelper(x - 1, x * accumulator) // TAIL RECURSION -use recursive call as the LAST expression

    factorialHelper(n, 1)
  }

//  println(anotherFactorial(20))
  // WHEN YOU NEED LOOPS, USE TAIL RECURSION

  /*
    1. Concat a string and times tail recursive
    2. Prime function tail recursive
    3. Fibonacci tail recursive
   */

  @scala.annotation.tailrec
  def concatTailRec(aString: String, n: Int, accumulator: String): String = {
    if (n <= 0) accumulator
    else concatTailRec(aString, n - 1, aString + accumulator)
  }

  println(concatTailRec("hello", 3, ""))

  def isPrime(n: Int): Boolean = {
    @scala.annotation.tailrec
    def isPrimeTailRec(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailRec(t - 1, n % t != 0 && isStillPrime)

    isPrimeTailRec(n / 2, true)
  }

  println(isPrime(2003))
  println(isPrime(629))

  def fibonacci(n: Int): Int = {
    def fiboTailRec(i: Int, last: Int, nextToLast: Int): Int =
      if (i >= n) last
      else fiboTailRec(i + 1, last + nextToLast, last)

    if (n <= 2) 1
    else fiboTailRec(2, 1, 1)
  }

  println(fibonacci(8))
}
