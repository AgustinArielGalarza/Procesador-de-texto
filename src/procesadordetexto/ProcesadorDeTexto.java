package procesadordetexto;

import java.awt.BorderLayout;
import javafx.scene.text.Font;
import javax.swing.*;

public class ProcesadorDeTexto {

    public static void main(String[] args) {
        Marco mimarco = new Marco();
        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
    

class Marco extends JFrame{
     public Marco(){
            setTitle("Procesador de Texto");
            setBounds(250, 200, 600, 450);
            Lamina milam = new Lamina();
            add(milam);
            
            setVisible(true);
        }
}
class Lamina extends JPanel{
    
    JTextPane papel;
    JMenu fuentes,estilos,tamano;
    Font letras;
    
    public Lamina (){
        setLayout(new BorderLayout());
        JPanel lamenu = new JPanel();
        JMenuBar barra = new JMenuBar();
        fuentes = new JMenu("Fuentes");
        estilos = new JMenu("Estilos");
        tamano = new JMenu("Tamaño");
        //----------------------------------------------------------------------
        Configura_menu("Arial", "Fuentes");
      
        barra.add(fuentes);
        barra.add(estilos);
        barra.add(tamano);
        lamenu.add(barra);
        
        add(lamenu,BorderLayout.NORTH);
        papel = new JTextPane();
        add(papel,BorderLayout.CENTER);
        
    }
    public void Configura_menu (String rotulo, String menu){
        
        JMenu elem_menu = new JMenu(rotulo);
        
        if(menu =="Fuentes"){
            
            fuentes.add(elem_menu);
            
        }else if (menu == "Estilos"){
            estilos.add(elem_menu);
        }else {
            tamano.add(elem_menu);
        }
    }

}
