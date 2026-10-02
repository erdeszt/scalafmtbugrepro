case class Dummy()

def someMethod()(using ev: Dummy): String = "yo"

def useDummy()(f: (Dummy, Int) ?=> Unit): Unit = {
  f(using Dummy(), 1)
}

@main
def main(): Unit =
  useDummy() { (dummy, _) ?=>
    println(someMethod())
  }
