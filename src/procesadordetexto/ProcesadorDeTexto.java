package procesadordetexto;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
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
        Configura_menu("Arial", "Fuentes","Arial",9,12);
        Configura_menu("Courier New", "Fuentes","Courier New",9,12);
        Configura_menu("Verdana", "Fuentes","Verdana",19,12);
        //----------------------------------------------------------------------
        Configura_menu("Negrita", "Estilos","",Font.BOLD,1);
        Configura_menu("Cursiva", "Estilos","",Font.ITALIC,1);
        //----------------------------------------------------------------------
        Configura_menu("12", "Tamaño","",9,12);
        Configura_menu("16", "Tamaño","",9,16);
        Configura_menu("20", "Tamaño","",9,20);
        Configura_menu("24", "Tamaño","",9,24);
        
        barra.add(fuentes);
        barra.add(estilos);
        barra.add(tamano);
        lamenu.add(barra);
        
        add(lamenu,BorderLayout.NORTH);
        papel = new JTextPane();
        add(papel,BorderLayout.CENTER);
        
    }
    public void Configura_menu (String rotulo, String menu, String tipo_letra, int tema, int tamanio){
        
        JMenuItem elem_menu = new JMenuItem(rotulo);
        
        if(menu =="Fuentes"){
            
            fuentes.add(elem_menu);
            
        }else if (menu == "Estilos"){
            estilos.add(elem_menu);
        }else {
            tamano.add(elem_menu);
        }
        elem_menu.addActionListener(new Gestiona_evento(rotulo, tipo_letra, tema, tamanio));
    }
    private class Gestiona_evento implements ActionListener{

         String tipo_texto, menu;
         int estilo_letra, tamanio_letra;
         
         public Gestiona_evento (String elemento, String texto2, int estilo2, int tam_letra){
             menu=elemento;
             tipo_texto=texto2;
             estilo_letra= estilo2;
             tamanio_letra=tam_letra;
         }
        @Override
        public void actionPerformed(ActionEvent e) {
            letras =papel.getFont();
            
            if(menu == "Arial"||menu =="Courier New"|| menu =="Verdana"){
                estilo_letra = letras.getStyle();
                tamanio_letra=letras.getSize();
            }else if (menu == "Cursiva"||menu == "Negrita"){
                if(letras.getStyle() == 1 || letras.getStyle() == 2){
                    estilo_letra = 3;
                }
                tipo_texto=letras.getFontName();
                tamanio_letra=letras.getSize();
            }else if (menu == "12"||menu == "16"||menu == "20"||menu == "24"){
                tipo_texto=letras.getFontName();
                estilo_letra=letras.getStyle();
            }
            
            papel.setFont(new Font(tipo_texto, estilo_letra, tamanio_letra));
        }
           
        
    }

}

