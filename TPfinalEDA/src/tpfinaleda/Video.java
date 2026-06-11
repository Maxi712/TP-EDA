
package tpfinaleda;

public class Video {
    public String nombre;
    public int resolucion;
    public int bits;
    public int audio;

    public Video(String nombre, int resolucion, int bits, int audio) {
        this.nombre = nombre;
        this.resolucion = resolucion;
        this.bits = bits;
        this.audio = audio;
    }
    
    public String toString(){
        return nombre + " / " + resolucion+" / " + bits +" / " + audio;
    }
    
}
