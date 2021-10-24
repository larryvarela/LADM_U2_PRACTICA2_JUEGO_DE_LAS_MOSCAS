package mx.tecnm.tepic.ladm_u2_practica2_juego_de_las_moscas

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View

class Lienzo(p:MainActivity) : View(p) {
    var apuntador : Mosca ?= null
    var mosca1 = Mosca(this, R.drawable.mosca1, x, y)
    init {

    }
    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        var p = Paint()

        c.drawColor(Color.GREEN)
        mosca1.pintarMosca(c)

     /*   (0..499).forEach {
            hiloNieve.nieve[it].pintarCopo(c)
        }*/
    }
    override fun onTouchEvent(e: MotionEvent): Boolean {
        super.onTouchEvent(e)
        val accion = e.action

        when(accion){
            MotionEvent.ACTION_DOWN->{
                if (mosca1.estaEnArea(e.x,e.y)){
                    return true
                }
            }
            MotionEvent.ACTION_UP->{
                   mosca1 = Mosca(this, R.drawable.slime1, x, y)
                //apuntador = null
            }
        }

        //INFORMACION SOBRE TOQUE

        invalidate()
        return true
    }
}

//clase lienzo



