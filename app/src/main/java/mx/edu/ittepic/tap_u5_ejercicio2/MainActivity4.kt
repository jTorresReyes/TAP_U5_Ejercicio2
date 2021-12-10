package mx.edu.ittepic.tap_u5_ejercicio2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main4.*
import java.io.OutputStreamWriter
import java.lang.Exception

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        guardar.setOnClickListener {
            if(guardarEnMemoriaInterna(contenidoArchivo.text.toString()) == true){
                contenidoArchivo.setText("")
                AlertDialog.Builder(this)
                    .setTitle("EXITO!")
                    .setMessage("Se guardo correctamente! :)")
                    .setPositiveButton("OK", {d,i -> d.dismiss()})
                    .show()
            }
        }

        regresarArchivos.setOnClickListener {
            finish()
        }
    }

    fun guardarEnMemoriaInterna(conten:String) : Boolean{
        if (conten.isEmpty()){
            Toast.makeText(this, "ERROR! Debes de poner una frase a guardar", Toast.LENGTH_LONG)
                .show()
            return false
        }

        try {
            var flujoSalida = OutputStreamWriter(openFileOutput("almacen.txt", MODE_PRIVATE) )

            flujoSalida.write(conten) //se guarda
            flujoSalida.flush() //forza a que Android GUARDE sobre el archivo
            flujoSalida.close() //cerrando archivo
            return true

        } catch (io:Exception){
            AlertDialog.Builder(this)
                .setTitle("ERROR!")
                .setMessage("No se pudo guardar el archivo! :(")
                .show()
        }
        return false
    }
}