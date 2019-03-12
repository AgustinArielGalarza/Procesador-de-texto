package procesadordetexto;

import java.awt.BorderLayout;
import javax.swing.*;

public class ProcesadorDeTexto {

    public static void main(String[] args) {
        Marco mimarco = new Marco();
    }
    
}
class Marco extends JFrame{
     public Marco(){
            setVisible(true);
            setTitle("Procesador de Texto");
            setBounds(250, 200, 600, 450);
            Lamina milam = new Lamina();
            add(milam);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
}
class Lamina extends JPanel{
    public Lamina (){
        setLayout(new BorderLayout());
        JPanel lamenu = new JPanel();
        JMenuBar barra = new JMenuBar();
        JMenu fuentes = new JMenu("Fuentes");
        JMenu estilos = new JMenu("Estilos");
        JMenu tamano = new JMenu("Tamaño");
        barra.add(fuentes);
        barra.add(estilos);
        barra.add(tamano);
        lamenu.add(barra);
        add(lamenu,BorderLayout.NORTH);
    }
}