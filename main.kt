import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun sum(a: Double, b: Double) = a + b
fun subtract(a: Double, b: Double) = a - b
fun multiply(a: Double, b: Double) = a * b
fun divide(a: Double, b: Double) = if(b != 0.0) a / b else "ERROR: [DIVISION BY ZERO]"

fun calculate(a: Double, b: Double, operation: String): String {
    var result: String = ""
    
    when(operation) {
        "+" -> result = "$a + $b = ${sum(a, b)}"
        "-" -> result = "$a - $b = ${subtract(a, b)}"
        "*" -> result = "$a x $b = ${multiply(a, b)}"
        "/" -> result = "$a : $b = ${divide(a, b)}"
    }
    
    return result
}

fun main() {
    val history = mutableListOf<String>()
    val currentDateAndTime = LocalDateTime.now()
    val appliedFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss")
    val currentDateAndTimeFormatted = currentDateAndTime.format(appliedFormat)
    
    history.add("[" + currentDateAndTimeFormatted + "] " + calculate(15.0, 5.0, "+"))
    history.add("[" + currentDateAndTimeFormatted + "] " + calculate(15.0, 5.0, "-"))
    history.add("[" + currentDateAndTimeFormatted + "] " + calculate(15.0, 5.0, "*"))
    history.add("[" + currentDateAndTimeFormatted + "] " + calculate(15.0, 5.0, "/"))
    history.add("[" + currentDateAndTimeFormatted + "] " + calculate(15.0, 0.0, "/"))
    
    println("======= HISTORY OF OPERATIONS =======\n")
    history.forEach { println(it) }
    println("\n=====================================")
}
