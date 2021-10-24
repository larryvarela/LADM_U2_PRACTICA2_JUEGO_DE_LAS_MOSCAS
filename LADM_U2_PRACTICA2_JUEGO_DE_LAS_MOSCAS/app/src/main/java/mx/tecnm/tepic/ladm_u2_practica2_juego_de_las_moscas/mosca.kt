package mx.tecnm.tepic.ladm_u2_practica2_juego_de_las_moscas

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class Mosca(l:Lienzo, image: Int, posX:Float, posY:Float) {
    var n = l
    var x  = posX;
    var y  = posY;
    var tam = 0f
    var num = 0f
    var imagen = BitmapFactory.decodeResource(l.resources,image)

    init {

        tam = ((Math.random()*5)+5).toFloat()
    }


    fun pintarMosca(c:Canvas){
        (0..100).forEach{
            x = (Math.random()*950).toFloat()
            y = (Math.random()*1600).toFloat()
            c.drawBitmap(imagen,x,y, Paint())
        }
    }
    fun pintarSlime(c:Canvas){
        c.drawBitmap(imagen,x,y, Paint())
    }

    fun estaEnArea(toqueX: Float, toqueY: Float):Boolean{
        var x2 = x+imagen.width
        var y2 = y+imagen.height
        if(toqueX >= x && toqueX <= x2){
            if (toqueY >= y && toqueY <= y2){
                return true
            }
        }
        return false
    }

    fun colision(objetoB: Mosca) : Boolean{
        var x2 = x+imagen.width
        var y2 = y+imagen.height
        //caso 1
        if(objetoB.estaEnArea(x2,y2)) return true;
        //caso 4
        if(objetoB.estaEnArea(x,y)) return true;
        //caso 3 arriba-dere
        if(objetoB.estaEnArea(x2,y)) return true;
        //caso 4 abajo-esquina
        if(objetoB.estaEnArea(x,y2)) return true;
        return false
    }
}