package mx.edu.ittepic.tap_u5_ejercicio2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        menuprincipal.setOnItemClickListener { parent, view, position, id ->
            //En java usamos switch-case
            //En KOTLIN usamos WHEN

            when(position){
                0 -> {
                    //invocacion de una 2da activity desde la activity principal
                    //objeto Intent invoca una activity
                    var ventana2 = Intent(this, MainActivity2::class.java)
                    startActivity(ventana2)
                }
                1 -> {
                    var ventana3 = Intent(this, MainActivity3::class.java)
                    startActivity(ventana3)
                }
                2 -> {
                    var ventana4 = Intent(this, MainActivity4::class.java)
                    startActivity(ventana4)
                }
                3 -> {
                    var ventana5 = Intent(this, MainActivity5::class.java)
                    startActivity(ventana5)
                }
                4 -> { mensaje() }
                5 -> { cerrar() }
            }
        }
    }

    //construccion de un metodo
    //en java usamos public void mensaje(tipo de parametro)
    //en kotlin es:

    fun mensaje(){
        AlertDialog.Builder(this)
            .setTitle("ATENCION")
            .setMessage("(C) Reservados JAIME TORRES a.k.a. kiddtorres\nTECNOLOGICO DE TEPIC 2021")
            .setPositiveButton("OK",{d,i -> d.dismiss()})
            .show()
    }

    fun cerrar(){
        finish()
    }
}