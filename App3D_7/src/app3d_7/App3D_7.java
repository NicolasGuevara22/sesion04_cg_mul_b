package app3d_7;

import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.universe.SimpleUniverse;
import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.vecmath.Vector3f;

public class App3D_7 extends JPanel{
    
    public App3D_7(){
        GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
        Canvas3D canvas3d = new Canvas3D(config);
        
        setLayout(new BorderLayout());
        add(canvas3d);
        
        SimpleUniverse universo = new SimpleUniverse(canvas3d);
        universo.getViewingPlatform().setNominalViewingTransform();
        
        BranchGroup escena = crearGrafoEscena();
        escena.compile(); 
        
        universo.addBranchGraph(escena);
    }
    
    public BranchGroup crearGrafoEscena(){
        BranchGroup objetoRaiz = new BranchGroup();
        
        Transform3D traslacion = new Transform3D();
        traslacion.set(new Vector3f(0,0,0));
        
        Transform3D rotacion = new Transform3D();
        rotacion.rotX(Math.toRadians(45));
        //rotacion.rotY(Math.toRadians(45));
        //rotacion.rotZ(Math.toRadians(45));
        
        traslacion.mul(rotacion); 
        
        TransformGroup tgl = new TransformGroup(traslacion);
        
        ColorCube cubo = new ColorCube(0.3f);
        
        tgl.addChild(cubo);
        
        objetoRaiz.addChild(tgl);
        
        return objetoRaiz;
    }

    
    public static void main(String[] args) {
        System.setProperty("sun.awt.noerasebackground", "true");
        JFrame ventana = new JFrame("Java 3D - Rotacion");
        App3D_7 panel = new App3D_7();
        ventana.add(panel);
        ventana.setSize(700, 700);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}

//Fuente del codigo : https://www.youtube.com/watch?v=RzzFlV_o5GI
