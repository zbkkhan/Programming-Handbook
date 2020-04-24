/**
* Inspired by Hayois's Programming Blog: https://www.lihaoyi.com/post/ImplicitDesignPatternsinScala.html
*
* A common scenario of JSON type conversion is presented below
* 
* sealed trait Json
* object Json{
*   case class Str(s: String) extends Json
*   case class Num(value: Double) extends Json
*   // ... many more definitions
* }
* 
* def convertToJson(x: Any): Json = {
*  x match{
*    case s: String => Json.Str(s)
*    case d: Double => Json.Num(d)
*    case i: Int => Json.Num(i.toDouble)
*    // maybe more cases for float, short, etc.
*  }
* }
* 
* The problem with this implementation is that it runs into runtime errors 
* if fed the wrong input
* 
* Good execution:
* 
* @ convertToJson("hello")
* res: Json = Str("hello")
* @ convertToJson(1234)
* res: Json = Num(1234.0) 
* 
* Bad execution:
* 
* @ convertToJson(new java.io.File("."))
* scala.MatchError: . (of class java.io.File)
*   $sess.cmd2$.convertToJson(cmd2.sc:5)
*   $sess.cmd6$.<init>(cmd6.sc:1)
*   $sess.cmd6$.<clinit>(cmd6.sc:-1)
* 
* What implicit type classes do is they convert the run-time error 
* to a compilation error which is more desirable 
*
**/

trait Jsonable[T]{
  def serialize(t: T): Json
}
object Jsonable{
  implicit object StringJsonable extends Jsonable[String]{
    def serialize(t: String) = Json.Str(t)
  }
  implicit object DoubleJsonable extends Jsonable[Double]{
    def serialize(t: Double) = Json.Num(t)
  }
  implicit object IntJsonable extends Jsonable[Int]{
    def serialize(t: Int) = Json.Num(t.toDouble)
  }
}

/*
* Good execution:
* 
* @ convertToJson("hello")
* res: Json = Str("hello")
* 
* @ convertToJson(123)
* res: Json = Num(123.0)
* 
* @ convertToJson(123.56)
* res: Json = Num(123.56)
* 
* Bad execution:
* 
* @ convertToJson(new java.io.File("."))
* could not find implicit value for parameter converterJsonable[java.io.File]
* convertToJson(new java.io.File("."))
*               ^
* Compilation Failed
*/

def convertToJson[T](x: T)(implicit converter: Jsonable[T]): Json = {
  converter.serialize(x)
}

/*
* Scala shorthand notation
*/

def convertToJson[T: Jsonable](x: T): Json = {
  implicitly[Jsonable[T]].serialize(x)
}