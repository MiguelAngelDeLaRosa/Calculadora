package mx.edu.itson.potros.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cero : Button = findViewById(R.id.btn0)
        val uno : Button = findViewById(R.id.btn1)
        val dos : Button = findViewById(R.id.btn2)
        val tres : Button = findViewById(R.id.btn3)
        val cuatro : Button = findViewById(R.id.btn4)
        val cinco : Button = findViewById(R.id.btn5)
        val seis : Button = findViewById(R.id.btn6)
        val siete : Button = findViewById(R.id.btn7)
        val ocho : Button = findViewById(R.id.btn8)
        val nueve : Button = findViewById(R.id.btn9)

        val suma : Button = findViewById(R.id.btnPlus)
        val resta : Button = findViewById(R.id.btnMinus)
        val mutliplicacion : Button = findViewById(R.id.btnX)
        val division : Button = findViewById(R.id.btnDivide)

        val result : Button = findViewById(R.id.btnResult)
        val borrar : Button = findViewById(R.id.btnBorrar)

        val escribir : TextView = findViewById(R.id.numeros)
        val resultado : TextView = findViewById(R.id.Result)

        var cadena : String = ""

        borrar.setOnClickListener {
            cadena = ""
            escribir.setText("")
            resultado.setText("0")
        }

        result.setOnClickListener {
            if (!cadena.isEmpty()){
                resultado.setText(operacion(cadena))
                cadena = ""
                escribir.setText("")
            } else {
                escribir.setText("Ingrese un numero")
            }
        }

        suma.setOnClickListener {
            cadena += " + "
            escribir.setText(cadena)
        }

        resta.setOnClickListener {
            cadena += " - "
            escribir.setText(cadena)
        }

        mutliplicacion.setOnClickListener {
            cadena += " * "
            escribir.setText(cadena)
        }

        division.setOnClickListener {
            cadena += " / "
            escribir.setText(cadena)
        }

        cero.setOnClickListener {
            cadena += "0"
            escribir.setText(cadena)

        }

        uno.setOnClickListener {
            cadena += "1"
            escribir.setText(cadena)
        }

        dos.setOnClickListener {
            cadena += "2"
            escribir.setText(cadena)
        }

        tres.setOnClickListener {
            cadena += "3"
            escribir.setText(cadena)
        }

        cuatro.setOnClickListener {
            cadena += "4"
            escribir.setText(cadena)
        }

        cinco.setOnClickListener {
            cadena += "5"
            escribir.setText(cadena)
        }

        seis.setOnClickListener {
            cadena += "6"
            escribir.setText(cadena)
        }

        siete.setOnClickListener {
            cadena += "7"
            escribir.setText(cadena)
        }

        ocho.setOnClickListener {
            cadena += "8"
            escribir.setText(cadena)
        }

        nueve.setOnClickListener {
            cadena += "9"
            escribir.setText(cadena)
        }
    }

    fun operacion(operacion:String): String {
        val ultimo = operacion[operacion.length - 1]
        if(ultimo.equals("+") || ultimo.equals("-") || ultimo.equals("*") || ultimo.equals("/")){
            return "Error"
        }
        val numerosYOperadores = operacion.split(Regex("\\s+"))

        val numeros = numerosYOperadores.filter { it.matches(Regex("[0-9]+")) }.map { it.toDouble() }

        val operadores = numerosYOperadores.filter { it.matches(Regex("[+\\-*/]")) }

        var resultado = numeros[0]
        for (i in 1 until numeros.size) {
            when (operadores[i - 1]) {
                "+" -> resultado += numeros[i]
                "-" -> resultado -= numeros[i]
                "*" -> resultado *= numeros[i]
                "/" -> resultado /= numeros[i]
            }
        }

        return resultado.toString()
    }

    fun obtenerNumero(cadena: String): Double {
        val patronNumerico = Regex("\\d+")
        val matchResult = patronNumerico.find(cadena)
        val numero = matchResult?.value?.toDoubleOrNull() ?: 0.0
        return  numero
    }
}