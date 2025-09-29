## 📌 Descrição Geral

Este programa implementa uma calculadora simples em **Kotlin**, capaz de realizar operações matemáticas básicas (`+`, `-`, `*`, `/`) entre dois números.
Além disso, ele registra um **histórico das operações realizadas**, incluindo data e hora da execução, e exibe esses registros ao final da execução do programa.

---

## 📦 Importações

```kotlin
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
```

* `LocalDateTime`: Usado para capturar a data e a hora atuais.
* `DateTimeFormatter`: Usado para formatar a data/hora em um padrão legível.

---

## ➗ Funções Matemáticas

```kotlin
fun sum(a: Double, b: Double) = a + b
fun subtract(a: Double, b: Double) = a - b
fun multiply(a: Double, b: Double) = a * b
fun divide(a: Double, b: Double) = if(b != 0.0) a / b else "ERROR: [DIVISION BY ZERO]"
```

* `sum`: Soma dois números.
* `subtract`: Subtrai o segundo número do primeiro.
* `multiply`: Multiplica os dois números.
* `divide`: Divide o primeiro número pelo segundo. Caso o divisor seja `0.0`, retorna uma mensagem de erro (`"ERROR: [DIVISION BY ZERO]"`).

---

## 🧮 Função de Cálculo

```kotlin
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
```

* **Parâmetros:**

  * `a`: Primeiro número (`Double`)
  * `b`: Segundo número (`Double`)
  * `operation`: Operador matemático em formato `String` (`+`, `-`, `*`, `/`)

* **Retorno:** Uma `String` formatada com a operação realizada e o resultado.
  Exemplo: `"15.0 + 5.0 = 20.0"`

---

## 🏁 Função Principal (`main`)

```kotlin
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
```

### Etapas da `main`:

1. **Criação do histórico**

   * `val history = mutableListOf<String>()` → Lista mutável que armazenará todas as operações realizadas.

2. **Captura de Data/Hora**

   * `LocalDateTime.now()` → Obtém a data/hora atual.
   * `DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss")` → Define o formato da data/hora.
   * `format(appliedFormat)` → Aplica o formato definido.

3. **Registro das Operações**

   * Cada chamada de `calculate` é adicionada ao histórico, junto com a data/hora formatada.
   * São testadas operações de soma, subtração, multiplicação, divisão normal e divisão por zero.

4. **Exibição do Histórico**

   * Exibe no console todas as operações realizadas com data/hora.
   * Exemplo de saída:

     ```
     ======= HISTORY OF OPERATIONS =======

     [29/09/2025 - 14:25:12] 15.0 + 5.0 = 20.0
     [29/09/2025 - 14:25:12] 15.0 - 5.0 = 10.0
     [29/09/2025 - 14:25:12] 15.0 x 5.0 = 75.0
     [29/09/2025 - 14:25:12] 15.0 : 5.0 = 3.0
     [29/09/2025 - 14:25:12] 15.0 : 0.0 = ERROR: [DIVISION BY ZERO]

     =====================================
     ```

---
