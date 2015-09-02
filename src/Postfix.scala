import scala.collection.mutable.Stack
object Postfix {
  def main(args: Array[String]) {
    if (args.length != 1) {
      throw new IllegalArgumentException()
    }

    val stack = new Stack[Int]
    for (token <- args(0).split(" "))
        token match {
            case "+" =>
                val op1 = stack.pop()
                val op2 = stack.pop()
                stack.push(op2 + op1)
            case "-" =>
                val op1 = stack.pop()
                val op2 = stack.pop()
                stack.push(op2 - op1)
            case "*" =>
                val op1 = stack.pop()
                val op2 = stack.pop()
                stack.push(op2 * op1)
            case "/" => 
                val op1 = stack.pop()
                val op2 = stack.pop()
                stack.push(op2 / op1)
            case _ => try {
                stack.push(token.toInt)
            } catch {
                case e: NumberFormatException => throw new IllegalArgumentException()
            }
        }
    println(stack.pop())
  }

}
