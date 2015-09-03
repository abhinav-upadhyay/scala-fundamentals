import scala.collection.mutable.Stack
object Postfix {

    def handleOperator(operator: String, stack: Stack[Int]): Boolean = 
        operator match {
            case "+" =>
                val op1 = stack.pop()
                val op2 = stack.pop()
                stack.push(op2 + op1)
                true
            case "-" =>
                val op1 = stack.pop()
                val op2 = stack.pop()
                stack.push(op2 - op1)
                true
            case "*" =>
                val op1 = stack.pop()
                val op2 = stack.pop()
                stack.push(op2 * op1)
                true
            case "/" => 
                val op1 = stack.pop()
                val op2 = stack.pop()
                stack.push(op2 / op1)
                true
            case _ => false
        }

    def handleOperand(operand: String, stack: Stack[Int]): Boolean =
        try {
            stack.push(operand.toInt)
            true
        } catch {
            case _ : NumberFormatException =>
                false
        }

    def calculate(expression: String): Int = {
        val stack = new Stack[Int]
        for (token <- expression.split(" "))
            if (!handleOperator(token, stack) && !handleOperand(token, stack))
                throw new IllegalArgumentException()
        stack.pop()
    }


    def main(args: Array[String]) {
        if (args.length != 1) {
            throw new IllegalArgumentException()
        }
        println(calculate(args(0)))
    }
}
