package co.uceva.libovaweb.javaLib;

import javax.swing.*;

public class OvaWeb {
    public native String ejecutarComandosGit(String IP, String rutaKey, String comando);

    public OvaWeb() {
        try{
            System.loadLibrary("ovaweb");
            System.out.println("Libreria cargada");
        }catch(UnsatisfiedLinkError e){
            System.err.println("Error al cargar la libreria");
        }
    }

}
