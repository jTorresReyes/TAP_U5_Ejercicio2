package mx.edu.ittepic.tap_u5_ejercicio2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main5.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        abrir.setOnClickListener {
            if(abrirMemoriaInterna()==true){
                AlertDialog.Builder(this)
                    .setMessage("SE RECUPERO LA DATA")
                    .show()
            }
        }

        regresarArchivos2.setOnClickListener {
            finish()
        }
    }

    fun abrirMemoriaInterna() : Boolean {
        var data = ""

        try {
            var flujoEntrada = BufferedReader(InputStreamReader(openFileInput("almacen.txt")))

            data = flujoEntrada.readLine()
            resultado.setText(data)
            flujoEntrada.close()
        } catch (io:Exception){
            AlertDialog.Builder(this)
                .setMessage("ERROR! No se pudo abrir los archivos")
                .setTitle("ATENCION!")
                .show()
        }

        return false
    }
}