case class Dummy()

def someMethod()(using ev: Dummy): String = "yo"

def useDummy()(f: (Dummy, Int) => Unit): Unit = {
  f(Dummy(), 1)
}

@main
def main(): Unit =
  useDummy() { implicit (dummy, _) =>
    println(someMethod())
  }
