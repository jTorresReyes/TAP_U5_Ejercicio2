package mx.edu.ittepic.tap_u5_ejercicio2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        /*
        1. Oyente del boton
        2. Concatenacion de textos
        3. Asignacion de la concatenacion a la etiqueta
         */

        button3.setOnClickListener {
            var text1 = texto1.text.toString()
            var text2 = texto2.text.toString()
            var textResultado = text1+" "+text2

            textView.setText(textResultado)

            texto1.setText("")
            texto2.setText("")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //este metodo sirve para AGREGAR al activity un menu contextual
        menuInflater.inflate(R.menu.menuoculto , menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.regresarmenu -> {
                finish()
            }

            R.id.acercademenu -> {
                Toast.makeText(this, "C Jaime Torres a.k.a. kiddtorres", Toast.LENGTH_LONG)
                    .show()
            }
        }
        return true
    }
}