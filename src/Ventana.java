

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Ventana extends javax.swing.JFrame {
    
    
    int banlex=0;
    int bansin=0;
    int renglon=0;
    int columna=0;
    char vector[];
    int i=0;
    int inicio=0;
    static String lexema="";
    //MATRIZ LÉXICO
    private int matriz[][] =

/*0*/ //matriz lexica   L     l    d   _    .    E    e     '    "   %    +    -    /    *    =     >    <   !    &    |   [    ]    (     )    ,    ;    #    \n   \t    b
                     {{  1,   2,   3, 500, 500, 500, 500,   9,  11, 111, 107, 108, 110, 109,  15,  17,  16,  14,  13,  12, 124, 125, 122, 123, 126, 127,  18,   0,   0,   0},
                      {  1,   2,   2,   2, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100},
                      {  2,   2,   2,   2, 101, 101, 101, 101, 101, 101, 101, 101, 101, 101, 101, 101, 101, 101, 101, 101, 101, 101, 101, 101, 101, 101, 101, 101, 101, 101},
                      {102, 102,   3, 102,   4, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102, 102},
                      {501, 501,   5, 501, 501, 501, 501, 501, 501, 501, 501, 501, 501, 501, 501, 501, 501, 501, 501, 501, 501, 501, 501, 501, 501, 501, 501, 501, 501, 501},
                      {103, 103,   5, 103, 103,   6,   6, 103, 103, 103, 103, 103, 103, 103, 103, 103, 103, 103, 103, 103, 103, 103, 103, 103, 103, 103, 103, 103, 103, 103},
                      {502, 502,   8, 502, 502, 502, 502, 502, 502, 502,   7,   7, 502, 502, 502, 502, 502, 502, 502, 502, 502, 502, 502, 502, 502, 502, 502, 502, 502, 502},
                      {503, 503,   8, 503, 503, 503, 503, 503, 503, 503, 503, 503, 503, 503, 503, 503, 503, 503, 503, 503, 503, 503, 503, 503, 503, 503, 503, 503, 503, 503},
                      {104, 104,   8, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104},
                      { 10,  10,  10,  10,  10,  10,  10, 504,  10,  10,  10,  10,  10,  10,  10,  10,  10,  10,  10,  10,  10,  10,  10,  10,  10,  10,  10,  10,  10,  10},
                      {505, 505, 505, 505, 505, 505, 505, 105, 505, 505, 505, 505, 505, 505, 505, 505, 505, 505, 505, 505, 505, 505, 505, 505, 505, 505, 505, 505, 505, 505},
                      { 11,  11,  11,  11,  11,  11,  11,  11, 106,  11,  11,  11,  11,  11,  11,  11,  11,  11,  11,  11,  11,  11,  11,  11,  11,  11,  11,  11,  11,  11},
                      {506, 506, 506, 506, 506, 506, 506, 506, 506, 506, 506, 506, 506, 506, 506, 506, 506, 506, 506, 112, 506, 506, 506, 506, 506, 506, 506, 506, 506, 506},
                      {507, 507, 507, 507, 507, 507, 507, 507, 507, 507, 507, 507, 507, 507, 507, 507, 507, 507, 113, 507, 507, 507, 507, 507, 507, 507, 507, 507, 507, 507},
                      {114, 114, 114, 114, 114, 114, 114, 114, 114, 114, 114, 114, 114, 114, 115, 114, 114, 114, 114, 114, 114, 114, 114, 114, 114, 114, 114, 114, 114, 114},
                      {116, 116, 116, 116, 116, 116, 116, 116, 116, 116, 116, 116, 116, 116, 117, 116, 116, 116, 116, 116, 116, 116, 116, 116, 116, 116, 116, 116, 116, 116},
                      {118, 118, 118, 118, 118, 118, 118, 118, 118, 118, 118, 118, 118, 118, 119, 118, 118, 118, 118, 118, 118, 118, 118, 118, 118, 118, 118, 118, 118, 118},
                      {120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 121, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120, 120},
                      { 18,  18,  18,  18,  18,  18,  18,  18,  18,  18,  18,  18,  18,  18,  18,  18,  18,  18,  18,  18,  18,  18,  18,  18,  18,  18,  18, 128,  18,  18}}; 

   
    String reservadas[]={"CLASS",
                         "BEGIN",
                         "ENDCLASS",
                         "INTEGER",
                         "FLOAT",
                         "CHAR",
                         "STRING",   
                         "BOOLEAN",
                         "READ",
                         "PRINT",
                         "IF",
                         "ENDIF",
                         "WHILE",
                         "ENDWHILE",
                         "FOR",
                         "ENDFOR",
                         "TRUE",
                         "FALSE"};
    
  
    public boolean reser(String valor)
    {
        for(int y=0;y<reservadas.length;y++)
        {
            if(reservadas[y].equals(valor))
                
               
                return true;
        }
        return false;
    }
    
    public void lexico()
    {
        inserProd(1);
        String cad=codigo.getText()+" "; 
        inicio=0;
        i=0;
        vector=cad.toCharArray(); 
        
        for(i=0;i<vector.length;i++)
        {
            
           columna=buscarC(vector[i],i);
           System.out.println("renglon "+renglon+"columna "+columna);
           renglon=matriz[renglon][columna];
           lexema="";
           if(renglon==0)
           {
               inicio=i;
           }
           if(renglon>=100&&renglon<=199) 
           {
               finAceptado(renglon);
               
             /*  if(sintactico(renglon)==1)
               {
                   return;
               }
               */
               renglon=0;
               inicio=i+1;
              sinta.append(lexema+"   : "   +"Estado ..."+gramema+"\n"); 
              System.out.println(lexema+"   : "   +"Estado ..."+gramema+"\n");
           }
           if(renglon>=500&&renglon<=507) 
            {
                finError(renglon);
                banlex=1;
              sinta.append("Error léxico\n");
                return;
            }
           
           

        }
        
    }
    
    
     int buscarC(char car,int index)
    {
       
        if ((String.valueOf(vector[index])).equals(" ")) {
            return 29;
        }        
        if(Character.isLetter(car))
        {
            if((car=='E' && (String.valueOf(vector[index+1]).equals(" "))) && (String.valueOf(vector[index-1]).equals(" ")) && i!=0)
            {
                return 5;
            }
            else if((car=='e'))
            {
                return 6;
            }
            else if(Character.isUpperCase(car))
            {
                return 0;
            }
            else
            {
                return 1;
            }
        }
        if(Character.isDigit(car))
        {
            return 5;
        }
        switch(car)
        {
            case '_':return 3;
            case '.':return 4;
            case '+':return 10;
            case '-':return 11;
            case '*':return 13;
            case '/':return 12;
            case '<':return 16;
            case '>':return 15;
            case '=':return 14;
            case '!':return 17;
            case '&':return 18;
            case '|':return 19;
            case '"':return 8;
            case ';':return 25;
            case '(':return 22;
            case ')':return 23;
            case ',':return 24;
            case '%':return 9;
            case '[':return 20;
            case ']':return 21;
            case '#':return 26;
             
             
        }
        
        return 29;
    }
    
   
    public void finAceptado(int f)
    {
        switch(f)
        {
            case 100: 
                i--;
                for(int x=inicio;x<=i;x++)
                {
                    lexema+=vector[x];
                }
                boolean ban=false;
                if(reser(lexema))
                {
                    lexema= lexema.replaceAll("[\n\r]", ""); 
                    if(lexema.equals("CLASS"))
                    {
                        gramema=200;
                        renglon = 0;
                        columna = 0;
                    }
                    if(lexema.equals("BEGIN"))
                    {
                        gramema=201;
                        renglon = 0;
                        columna = 0;
                    }
                     if(lexema.equals("ENDCLASS"))
                    {
                        gramema=202;
                        renglon = 0;
                        columna = 0;
                    }
                      if(lexema.equals("INTEGER"))
                    {
                        gramema=203;
                        renglon = 0;
                        columna = 0;
                    }
                       if(lexema.equals("FLOAT"))
                    {
                        gramema=204;
                        renglon = 0;
                        columna = 0;
                    }
                        if(lexema.equals("CHAR"))
                    {
                        gramema=205;
                        renglon = 0;
                        columna = 0;
                    }
                         if(lexema.equals("STRING"))
                    {
                        gramema=206;
                        renglon = 0;
                        columna = 0;
                    }
                          if(lexema.equals("BOOLEAN"))
                    {
                        gramema=207;
                        renglon = 0;
                        columna = 0;
                    }
                           if(lexema.equals("READ"))
                    {
                        gramema=208;
                        renglon = 0;
                        columna = 0;
                    }
                            if(lexema.equals("PRINT"))
                    {
                        gramema=209;
                        renglon = 0;
                        columna = 0;
                    }
                             if(lexema.equals("IF"))
                    {
                        gramema=210;
                        renglon = 0;
                        columna = 0;
                    }
                              if(lexema.equals("ENDIF"))
                    {
                        gramema=211;
                        renglon = 0;
                        columna = 0;
                    }
                               if(lexema.equals("ELSE"))
                    {
                        gramema=212;
                        renglon = 0;
                        columna = 0;
                    }
                                if(lexema.equals("WHILE"))
                    {
                        gramema=213;
                        renglon = 0;
                        columna = 0;
                    }
                                 if(lexema.equals("ENDWHILE"))
                    {
                        gramema=214;
                        renglon = 0;
                        columna = 0;
                    }
                                  if(lexema.equals("FOR"))
                    {
                        gramema=215;
                        renglon = 0;
                        columna = 0;
                    }
                                   if(lexema.equals("ENDFOR"))
                    {
                        gramema=216;
                        renglon = 0;
                        columna = 0;
                    }
                                    if(lexema.equals("TRUE"))
                    {
                        gramema=217;
                        renglon = 0;
                        columna = 0;
                    }
                                     if(lexema.equals("FALSE"))
                    {
                        gramema=218;
                        renglon = 0;
                        columna = 0;
                    }
                    ban=true;
                }
                if(ban)//SI ES UNA PALABRA RESERVADA DE LA LISTA
                {
                    resultados.append("Palabra reservada: "+lexema+"\n");
                }
                else
                {
                    resultados.append("Palabra desconocida: "+lexema+"\n");
                }
                break;
             case 101://ESTADO FINAL: IDENTIFICADOR
                i--;
                for(int z=inicio;z<=i;z++)
                {
                    lexema+=vector[z];
                }
                resultados.append("Identificador    "+lexema+"\n");
                gramema=208;
                break;
             case 102://ESTADO FINAL: ENTERO
                i--;
                for(int z=inicio;z<=i;z++)
                {
                    lexema+=vector[z];
                }   
                resultados.append("Entero    "+lexema+"\n");
                gramema=209;
                break;
             case 103://ESTADO FINAL: REAL
                i--;
                for(int z=inicio;z<=i;z++)
                {
                    lexema+=vector[z];
                }   
                resultados.append("Real      "+lexema+"\n");
                gramema=210;
                break;
             case 104://ESTADO FINAL: NOTACIÓN CIENTÍFICA
                i--;
                for(int z=inicio;z<=i;z++)
                {
                    lexema+=vector[z];
                }   
                resultados.append("Notación   "+lexema+"\n");
                gramema=211;
                break;
             case 105://ESTADO FINAL: CTE CARACTER
                for(int z=inicio;z<=i;z++)
                {
                    lexema+=vector[z];
                }   
                resultados.append("cte caracter  "+lexema+"\n");
                gramema=212;
                break;
             case 106://ESTADO FINAL: CTE STRING
                i--;
                for(int z=inicio;z<=i;z++)
                {
                    lexema+=vector[z];
                }   
                resultados.append("cte string  "+lexema+"\n");
                gramema=213;
                break;
             case 107://ESTADO FINAL: SUMA
                for(int z=inicio;z<=i;z++)
                {
                    lexema+=vector[z];
                }   
                resultados.append("Suma      "+lexema+"\n");
                gramema=214;
                break;
             case 108://ESTADO FINAL: RESTA
                for(int z=inicio;z<=i;z++)
                {
                    lexema+=vector[z];
                }   
                resultados.append("Resta   "+lexema+"\n");
                gramema=215;
                break;
            case 109://ESTADO FINAL: MULTIPLICACIÓN
                for(int z=inicio;z<=i;z++)
                {
                    lexema+=vector[z];
                }   
                resultados.append("Multiplicación   "+lexema+"\n");
                gramema=216;
                break;
            case 110://ESTADO FINAL: DIVISIÓN
                for(int z=inicio;z<=i;z++)
                {
                    lexema+=vector[z];
                }   
                resultados.append("División    "+lexema+"\n");
                gramema=217;
                break;
             case 113://ESTADO FINAL: AND
                for(int z=inicio;z<=i;z++)
                {
                    lexema+=vector[z];
                }   
                resultados.append("AND    "+lexema+"\n");
                gramema=218;
                break;
             case 112://ESTADO FINAL: OR
                for(int z=inicio;z<=i;z++)
                {
                    lexema+=vector[z];
                }   
                resultados.append("OR    "+lexema+"\n");
                gramema=219;
                break;
             case 114://ESTADO FINAL: NOT
                i--;
                for(int z=inicio;z<=i;z++)
                {
                    lexema+=vector[z];
                }   
                resultados.append("NOT  "+lexema+"\n");
                gramema=220;
                break;
             case 118://ESTADO FINAL: MENOR
                i--;
                for(int z=inicio;z<=i;z++)
                {
                    lexema+=vector[z];
                }   
                resultados.append("Menor    "+lexema+"\n");
                gramema=221;
                break;
            case 119://ESTADO FINAL: MENOR IGUAL
                for(int z=inicio;z<=i;z++)
                {
                    lexema+=vector[z];
                }   
                resultados.append("Menor igual    "+lexema+"\n");
                gramema=222;
                break;
           case 120://ESTADO FINAL: MAYOR
                i--;
                for(int z=inicio;z<=i;z++)
                {
                    lexema+=vector[z];
                }   
                resultados.append("Mayor   "+lexema+"\n");
                gramema=223;
                break;
            case 121://ESTADO FINAL: MAYOR IGUAL
                for(int z=inicio;z<=i;z++)
                {
                    lexema+=vector[z];
                }   
                resultados.append("Mayor igual  "+lexema+"\n");
                gramema=224;
                break;
           case 115://ESTADO FINAL: DIFERENTE
                for(int z=inicio;z<=i;z++)
                {
                    lexema+=vector[z];
                }   
                resultados.append("Diferente    "+lexema+"\n");
                gramema=225;
                break;
           case 117://ESTADO FINAL: IGUAL
                for(int z=inicio;z<=i;z++)
                {
                    lexema+=vector[z];
                }   
                resultados.append("Igual    "+lexema+"\n");
                gramema=226;
                break;
           case 116://ESTADO FINAL: ASIGNA
                i--;
                for(int z=inicio;z<=i;z++)
                {
                    lexema+=vector[z];
                }   
                resultados.append("Asigna    "+lexema+"\n");
                gramema=227;
                break;
           case 122://ESTADO FINAL: PARÉNTESIS QUE ABRE
                for(int z=inicio;z<=i;z++)
                {
                    lexema+=vector[z];
                }   
                resultados.append("Paréntesis que abre   "+lexema+"\n");
                gramema=228;
                break;
           case 123://ESTADO FINAL: PARÉNTESIS QUE CIERRA
                for(int z=inicio;z<=i;z++)
                {
                    lexema+=vector[z];
                }   
                resultados.append("Paréntesis que cierra    "+lexema+"\n");
                gramema=229;
                break;
           case 127://ESTADO FINAL: PUNTO Y COMA
                for(int z=inicio;z<=i;z++)
                {
                    lexema+=vector[z];
                }   
                resultados.append("Punto y coma            "+lexema+"\n");
                gramema=230;
                break;
           case 128://ESTADO FINAL: COMENTARIOS DE LÍNEA
               for(int z=inicio;z<=i;z++)
                {
                    lexema+=vector[z];
                }   
                resultados.append("Comentario en linea    "+lexema+"\n");
                gramema=232;
                break;
            case 126://coma
                for(int z=inicio;z<=i;z++)
                {
                    lexema+=vector[z];
                }   
                resultados.append("Coma                  "+lexema+"\n");
                gramema=231;
                break;
               
        }
    }
    
    
    public void finError(int fi)
    {
        switch(fi)
        {
            case 500:
                resultados.append("ERROR 500: Identificador mal formado.\n");
                return;
            case 501:
                resultados.append("ERROR 501: Real mal formado.\n");
                return;
            case 502:
                resultados.append("ERROR 502: N.C mal formado.\n");
                return;
            case 503:
                resultados.append("ERROR 503: N.C mal formado.\n");
                return;
            case 504:
                resultados.append("ERROR 504: Char mal formado.\n");
                return;
            case 505:
                resultados.append("ERROR 505: Char mal formado\n");
                return;
            case 506:
                resultados.append("ERROR 506: AND mal formado\n");
                return;
            case 507:
                resultados.append("ERROR 507: OR mal formado\n");
                return;
        }
    }
   
    public Ventana() {
        setUndecorated(true) ; 
         this.setLocation(0, 0);
        initComponents();
        llenarproducciones();
        pila.push("$");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        codigo = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        resultados = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        sinta = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        abrir = new javax.swing.JButton();
        lexico = new javax.swing.JButton();
        limpiar = new javax.swing.JButton();
        cerrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("LENGUAJES Y AUTOMATAS I");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(250, 70, 0, 0));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setForeground(new java.awt.Color(0, 204, 204));
        jPanel1.setLayout(null);

        codigo.setColumns(20);
        codigo.setRows(5);
        jScrollPane2.setViewportView(codigo);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(70, 140, 280, 290);

        resultados.setEditable(false);
        resultados.setColumns(20);
        resultados.setRows(5);
        jScrollPane3.setViewportView(resultados);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(420, 140, 300, 190);

        sinta.setColumns(20);
        sinta.setRows(5);
        jScrollPane1.setViewportView(sinta);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(420, 330, 300, 96);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Primitive");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(220, 0, 340, 90);

        abrir.setBackground(new java.awt.Color(255, 255, 255));
        abrir.setFont(new java.awt.Font("Perpetua Titling MT", 3, 14)); // NOI18N
        abrir.setText("Abrir archivo");
        abrir.setMaximumSize(new java.awt.Dimension(157, 25));
        abrir.setMinimumSize(new java.awt.Dimension(157, 25));
        abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirActionPerformed(evt);
            }
        });
        jPanel1.add(abrir);
        abrir.setBounds(10, 440, 170, 30);

        lexico.setBackground(new java.awt.Color(255, 255, 255));
        lexico.setFont(new java.awt.Font("Perpetua Titling MT", 3, 12)); // NOI18N
        lexico.setText("analizar");
        lexico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lexicoActionPerformed(evt);
            }
        });
        jPanel1.add(lexico);
        lexico.setBounds(210, 440, 170, 30);

        limpiar.setBackground(new java.awt.Color(255, 255, 255));
        limpiar.setFont(new java.awt.Font("Perpetua Titling MT", 3, 12)); // NOI18N
        limpiar.setText("Borrar");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });
        jPanel1.add(limpiar);
        limpiar.setBounds(420, 440, 170, 30);

        cerrar.setFont(new java.awt.Font("Perpetua Titling MT", 3, 12)); // NOI18N
        cerrar.setText("Cerrar");
        cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarActionPerformed(evt);
            }
        });
        jPanel1.add(cerrar);
        cerrar.setBounds(620, 440, 170, 30);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ARCHIVO ANALIZADO");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(460, 120, 250, 18);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ARCHIVO");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(90, 120, 250, 18);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_cerrarActionPerformed

    private void abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirActionPerformed
        // TODO add your handling code here:
        abrir();
    }//GEN-LAST:event_abrirActionPerformed

    private void lexicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lexicoActionPerformed
        // TODO add your handling code here:
        renglon=0;
        lexico();
        if(pila.peek().toString().equals("$"))
        {
            sinta.append("Compilación completa\n");
        }
        else
        {
            sinta.append("Error sintáctico\n");
            bansin=1;
        }
    }//GEN-LAST:event_lexicoActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        codigo.setText("");
        resultados.setText("");
        sinta.setText("");

        i=0;
        inicio=0;
        renglon=0;
        columna=0;
        lexema="";
    }//GEN-LAST:event_limpiarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abrir;
    private javax.swing.JButton cerrar;
    private javax.swing.JTextArea codigo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton lexico;
    private javax.swing.JButton limpiar;
    private javax.swing.JTextArea resultados;
    private javax.swing.JTextArea sinta;
    // End of variables declaration//GEN-END:variables

    //MÉTODO PARA ABRIR ARCHIVOS CON LA EXTENSIÓN .txt
public void abrir()
    {
        String path="";
        String nombrea="";
        File routar;
        JFileChooser JFC = new JFileChooser();
        JFC.setFileSelectionMode(JFileChooser.FILES_ONLY);
        JFC.setFileFilter(new FileNameExtensionFilter("todos los archivos *.TXT", "txt",",txt"));
        int abrir = JFC.showDialog(null, "Abrir");
        
        if (abrir == JFileChooser.APPROVE_OPTION)
     {
         FileReader FR = null;
         BufferedReader BR = null;
         nombrea=JFC.getSelectedFile().getName();
         nombrea=nombrea.replaceAll(".txt","");
         routar=JFC.getSelectedFile();
         
         try
         {
             File archivo = JFC.getSelectedFile();
             String PATH = JFC.getSelectedFile().getAbsolutePath();
             if(PATH.endsWith(".txt")||PATH.endsWith(".txt"))
             {
                 FR = new FileReader(archivo);
                 BR = new BufferedReader(FR);
                 
                 String linea;
                 if(path.compareTo(archivo.getAbsolutePath())==0)
                 {
                     JOptionPane.showMessageDialog(null,"NO se pudo abrir archivo","ERROR",JOptionPane.ERROR_MESSAGE);
                 }
                 else
                 {
                     path = archivo.getAbsolutePath();
                     codigo.setText(null);
                     while((linea=BR.readLine())!=null)
                     {
                         codigo.append(linea+"\n");
                     }
                 }
             }
             else
             {
                 JOptionPane.showMessageDialog(null,"Archivo no soportado","ERROR",JOptionPane.ERROR_MESSAGE);
                 abrir();
             }
         }
         catch (FileNotFoundException ex)
         {
             ex.printStackTrace();
         }  catch (IOException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
         finally
         {
             try
             {
                 if(null!= FR)
                 {
                     FR.close();
                 }
             }
             catch (IOException ex)
             {
                 ex.printStackTrace();
             }
         }
     }
    }


//Analizador sintactico 
int producciones[][];
//Las 64 producciones
int prox[], pro0[], pro1[],pro2[],pro3[],pro4[],pro5[],pro6[],pro7[],pro8[],pro9[],pro10[],pro11[],pro12[],pro13[],pro14[],pro15[],pro16[],pro17[],pro18[],pro19[],
        pro20[],pro21[],pro22[],pro23[], pro24[], pro25[], pro26[], pro27[], pro28[], pro29[], pro30[], pro31[], pro32[], pro33[], pro34[], pro35[],
        pro36[], pro37[], pro38[], pro39[], pro40[], pro41[], pro42[], pro43[], pro44[], pro45[],pro46[], pro47[], pro48[], pro49[], pro50[], pro51[],
        pro52[], pro53[], pro54[], pro55[], pro56[], pro57[], pro58[], pro59[], pro60[], pro61[], pro62[], pro63[], pro64[], pro65[];

static int terminal;
Stack pila=new Stack();//Pila de ejecución
int gramema=0;
String ret=" ";


private int matriz_p[][] =
 /*                CLASS  ENDCLASS  id    BEGIN  INTEGER  FLOAT  CHAR  STRING BOOLEAN   ,    =    READ   PRINT   (     )     ;     IF   ELSE ENDIF  WHILE  ENDWHILE     FOR ENDFOR  ||    &&     !       <        <=          >       >=     ==        !=      +      -      *      /  cteentera ctereal ctenotacion  c.caracter  c.string      TRUE    FALSE 
/*0 PROGRAMA */  {{    1,   1000,   1000,  1000,   1000,  1000,  1000,  1000,  1000,  1000, 1000, 1000,  1000,  1000, 1000, 1000, 1000, 1000, 1000, 1000,   1000,      1000, 1000, 1000, 1000,  1000,   1000,     1000,     1000,    1000,   1000,    1000,  1000,   1000,  1000,  1000, 1000,   1000,     1000,        1000,       1000,       1000,    1000,  },
/*1 Estatutos*/   { 1000,   1000,      3,  1000,      2,     2,     2,     2,     2,  1000, 1000,    4,     5,  1000, 1000, 1000,    6, 1000, 1000,    7,   1000,         8, 1000, 1000, 1000,  1000,   1000,     1000,     1000,    1000,   1000,    1000,  1000,   1000,  1000,  1000, 1000,   1000,     1000,        1000,       1000,       1000,    1000,  },
/*2 Estatutos2*/  { 1000,     10,      9,  1000,      9,     9,     9,     9,     9,  1000, 1000,    9,     9,  1000, 1000, 1000,    9,   10,   10,    9,     10,         9,   10, 1000, 1000,  1000,   1000,     1000,     1000,    1000,   1000,    1000,  1000,   1000,  1000,  1000, 1000,   1000,     1000,        1000,       1000,       1000,    1000,  },                     
/*3 EST_DECLARA*/ { 1000,   1000,   1000,  1000,     11,    11,    11,    11,    11,  1000, 1000, 1000,  1000,  1000, 1000, 1000, 1000, 1000, 1000, 1000,   1000,      1000, 1000, 1000, 1000,  1000,   1000,     1000,     1000,    1000,   1000,    1000,  1000,   1000,  1000,  1000, 1000,   1000,     1000,        1000,       1000,       1000,    1000,  },         
/*4 TIPOS*/       { 1000,   1000,   1000,  1000,     12,    13,    14,    15,    16,  1000, 1000, 1000,  1000,  1000, 1000, 1000, 1000, 1000, 1000, 1000,   1000,      1000, 1000, 1000, 1000,  1000,   1000,     1000,     1000,    1000,   1000,    1000,  1000,   1000,  1000,  1000, 1000,   1000,     1000,        1000,       1000,       1000,    1000,  }, 
/*5 ID2*/         { 1000,   1000,   1000,  1000,   1000,  1000,  1000,  1000,  1000,    17, 1000, 1000,  1000,  1000, 1000,   18, 1000, 1000, 1000, 1000,   1000,      1000, 1000, 1000, 1000,  1000,   1000,     1000,     1000,    1000,   1000,    1000,  1000,   1000,  1000,  1000, 1000,   1000,     1000,        1000,       1000,       1000,    1000,  }, 
/*6 ID3*/         { 1000,   1000,   1000,  1000,   1000,  1000,  1000,  1000,  1000,    19, 1000, 1000,  1000,  1000,   20, 1000, 1000, 1000, 1000, 1000,   1000,      1000, 1000, 1000, 1000,  1000,   1000,     1000,     1000,    1000,   1000,    1000,  1000,   1000,  1000,  1000, 1000,   1000,     1000,        1000,       1000,       1000,    1000,  },   
/*7 EST_ASIGNA*/  { 1000,   1000,     21,  1000,   1000,  1000,  1000,  1000,  1000,  1000, 1000, 1000,  1000,  1000, 1000, 1000, 1000, 1000, 1000, 1000,   1000,      1000, 1000, 1000, 1000,  1000,   1000,     1000,     1000,    1000,   1000,    1000,  1000,   1000,  1000,  1000, 1000,   1000,     1000,        1000,       1000,       1000,    1000,  },
/*8 EST_LEER*/    { 1000,   1000,   1000,  1000,   1000,  1000,  1000,  1000,  1000,  1000, 1000,   22,  1000,  1000, 1000, 1000, 1000, 1000, 1000, 1000,   1000,      1000, 1000, 1000, 1000,  1000,   1000,     1000,     1000,    1000,   1000,    1000,  1000,   1000,  1000,  1000, 1000,   1000,     1000,        1000,       1000,       1000,    1000,  },  
/*9 EST_IMPRIMIR*/{ 1000,   1000,   1000,  1000,   1000,  1000,  1000,  1000,  1000,  1000, 1000, 1000,    23,  1000, 1000, 1000, 1000, 1000, 1000, 1000,   1000,      1000, 1000, 1000, 1000,  1000,   1000,     1000,     1000,    1000,   1000,    1000,  1000,   1000,  1000,  1000, 1000,   1000,     1000,        1000,       1000,       1000,    1000,  }, 
/*10 PRINT*/      { 1000,   1000,   1000,  1000,   1000,  1000,  1000,  1000,  1000,    24, 1000, 1000,  1000,  1000,   25, 1000, 1000, 1000, 1000, 1000,   1000,      1000, 1000, 1000, 1000,  1000,   1000,     1000,     1000,    1000,   1000,    1000,  1000,   1000,  1000,  1000, 1000,   1000,     1000,        1000,       1000,       1000,    1000,  },
/*11 EST_IF*/     { 1000,   1000,   1000,  1000,   1000,  1000,  1000,  1000,  1000,  1000, 1000, 1000,  1000,  1000, 1000, 1000,   26, 1000, 1000, 1000,   1000,      1000, 1000, 1000, 1000,  1000,   1000,     1000,     1000,    1000,   1000,    1000,  1000,   1000,  1000,  1000, 1000,   1000,     1000,        1000,       1000,       1000,    1000,  },  
/*12 EST_IFBIS*/  { 1000,   1000,   1000,  1000,   1000,  1000,  1000,  1000,  1000,  1000, 1000, 1000,  1000,  1000, 1000, 1000, 1000,   27,   28, 1000,   1000,      1000, 1000, 1000, 1000,  1000,   1000,     1000,     1000,    1000,   1000,    1000,  1000,   1000,  1000,  1000, 1000,   1000,     1000,        1000,       1000,       1000,    1000,  },         
/*13 EST_WHILE*/  { 1000,   1000,   1000,  1000,   1000,  1000,  1000,  1000,  1000,  1000, 1000, 1000,  1000,  1000, 1000, 1000, 1000, 1000, 1000,   29,   1000,      1000, 1000, 1000, 1000,  1000,   1000,     1000,     1000,    1000,   1000,    1000,  1000,   1000,  1000,  1000, 1000,   1000,     1000,        1000,       1000,       1000,    1000,  }, 
/*14 EST_FOR*/    { 1000,   1000,   1000,  1000,   1000,  1000,  1000,  1000,  1000,  1000, 1000, 1000,  1000,  1000, 1000, 1000, 1000, 1000, 1000, 1000,   1000,        30, 1000, 1000, 1000,  1000,   1000,     1000,     1000,    1000,   1000,    1000,   1000,  1000,  1000,  1000, 1000,   1000,     1000,        1000,       1000,       1000,    1000,  },
/*15 EXPRESION*/  { 1000,   1000,     31,  1000,   1000,  1000,  1000,  1000,  1000,  1000, 1000, 1000,  1000,    31, 1000, 1000, 1000, 1000, 1000, 1000,   1000,      1000, 1000, 1000, 1000,    31,   1000,     1000,     1000,    1000,   1000,    1000,   1000,  1000,  1000,  1000,   31,     31,       31,          31,         31,         31,      31,  },
/*16 EEXPR_OR*/   { 1000,   1000,   1000,  1000,   1000,  1000,  1000,  1000,  1000,    33, 1000, 1000,  1000,  1000,   33,   33, 1000, 1000, 1000, 1000,   1000,      1000, 1000,   32, 1000,  1000,   1000,     1000,     1000,    1000,   1000,    1000,   1000,  1000,  1000,  1000, 1000,   1000,     1000,        1000,       1000,       1000,    1000,  },                                                                                              
/*17 EXPR2*/      { 1000,   1000,     34,  1000,   1000,  1000,  1000,  1000,  1000,  1000, 1000, 1000,  1000,    34, 1000, 1000, 1000, 1000, 1000, 1000,   1000,      1000, 1000, 1000, 1000,    34,   1000,     1000,     1000,    1000,   1000,    1000,   1000,  1000,  1000,  1000,   34,     34,       34,          34,         34,         34,      34,  },      
/*18 EXPR_AND*/   { 1000,   1000,   1000,  1000,   1000,  1000,  1000,  1000,  1000,    36, 1000, 1000,  1000,  1000,   36,   36, 1000, 1000, 1000, 1000,   1000,      1000, 1000,   36,   35,  1000,   1000,     1000,     1000,    1000,   1000,    1000,   1000,  1000,  1000,  1000, 1000,   1000,     1000,        1000,       1000,       1000,    1000,  }, 
/*19 EXPR3*/      { 1000,   1000,     37,  1000,   1000,  1000,  1000,  1000,  1000,  1000, 1000, 1000,  1000,    37, 1000, 1000, 1000, 1000, 1000, 1000,   1000,      1000, 1000, 1000, 1000,    37,   1000,     1000,     1000,    1000,   1000,    1000,   1000,  1000,  1000,  1000,   37,     37,       37,          37,         37,         37,      37,  },       
/*20 EXPR_NOT*/   { 1000,   1000,     39,  1000,   1000,  1000,  1000,  1000,  1000,  1000, 1000, 1000,  1000,    39, 1000, 1000, 1000, 1000, 1000, 1000,   1000,      1000, 1000, 1000, 1000,    38,   1000,     1000,     1000,    1000,   1000,    1000,   1000,  1000,  1000,  1000,   39,     39,       39,          39,         39,         39,      39,  }, 
/*21 EXPR4*/      { 1000,   1000,     40,  1000,   1000,  1000,  1000,  1000,  1000,  1000, 1000, 1000,  1000,    40, 1000, 1000, 1000, 1000, 1000, 1000,   1000,      1000, 1000, 1000, 1000,  1000,   1000,     1000,     1000,    1000,   1000,    1000,   1000,  1000,  1000,  1000,   40,     40,       40,          40,         40,         40,      40,  },
/*22 EXP_REL*/    { 1000,   1000,   1000,  1000,   1000,  1000,  1000,  1000,  1000,    42, 1000, 1000,  1000,  1000,   42,   42, 1000, 1000, 1000, 1000,   1000,      1000, 1000,   42,   42,  1000,     41,       41,       41,      41,     41,      41,   1000,  1000,  1000,  1000, 1000,   1000,     1000,        1000,       1000,       1000,    1000,  },    
/*23 OP_REL*/     { 1000,   1000,   1000,  1000,   1000,  1000,  1000,  1000,  1000,  1000, 1000, 1000,  1000,  1000, 1000, 1000, 1000, 1000, 1000, 1000,   1000,      1000, 1000, 1000, 1000,  1000,     43,       44,       45,      46,     47,      48,   1000,  1000,  1000,  1000, 1000,   1000,     1000,        1000,       1000,       1000,    1000,  },
/*24 EXPR5*/      { 1000,   1000,     49,  1000,   1000,  1000,  1000,  1000,  1000,  1000, 1000, 1000,  1000,    49, 1000, 1000, 1000, 1000, 1000, 1000,   1000,      1000, 1000, 1000, 1000,  1000,   1000,     1000,     1000,    1000,   1000,    1000,   1000,  1000,  1000,  1000,   49,     49,       49,          49,         49,         49,      49,  },
/*25 EXPR5BIS*/   { 1000,   1000,   1000,  1000,   1000,  1000,  1000,  1000,  1000,    52, 1000, 1000,  1000,  1000,   52,   52, 1000, 1000, 1000, 1000,   1000,      1000, 1000,   52,   52,  1000,     52,       52,       52,      52,     52,      52,     50,    51,  1000,  1000, 1000,   1000,     1000,        1000,       1000,       1000,    1000,  },
/*26 TERM*/       { 1000,   1000,     53,  1000,   1000,  1000,  1000,  1000,  1000,  1000, 1000, 1000,  1000,    53, 1000, 1000, 1000, 1000, 1000, 1000,   1000,      1000, 1000, 1000, 1000,  1000,   1000,     1000,     1000,    1000,   1000,    1000,   1000,  1000,  1000,  1000,   53,     53,       53,          53,         53,         53,      53,  },
/*27 TERMBIS*/    { 1000,   1000,   1000,  1000,   1000,  1000,  1000,  1000,  1000,    56, 1000, 1000,  1000,  1000,   56,   56, 1000, 1000, 1000, 1000,   1000,      1000, 1000,   56,   56,  1000,     56,       56,       56,      56,     56,      56,     56,    56,    54,    55, 1000,   1000,     1000,        1000,       1000,       1000,    1000,  },
/*28 FACT*/       { 1000,   1000,     57,  1000,   1000,  1000,  1000,  1000,  1000,  1000, 1000, 1000,  1000,    65, 1000, 1000, 1000, 1000, 1000, 1000,   1000,      1000, 1000, 1000, 1000,  1000,    1000,     1000,     1000,    1000,   1000,    1000,   1000,  1000,  1000,  1000,   58,     59,       60,          61,         62,         63,      64,  },    };


    void llenarproducciones()
    {
       
       pro1 = new int [] {200,1,201};
       pro2= new int [] {2,230,27};
       pro3= new int [] {3,230,27};
       pro4= new int [] {5,230,27};
       pro5= new int [] {6,230,27};
       pro6= new int [] {9,230,27};
       pro7= new int [] {208,227,12};
       pro8= new int [] {202,228,12,229,1,4,204};
       pro9= new int [] {203,1};
       pro10= new int [] {};
       pro11= new int [] {205,228,12,229,1,204};
       pro12= new int [] {206,228,7,229};
       pro13= new int [] {208,8};
       pro14= new int [] {231,7};
       pro15= new int [] {};
       pro16= new int [] {207,228,10,229};
       pro17= new int [] {12,11};
       pro18= new int [] {231,10};
       pro19= new int [] {};
       pro20= new int [] {13,14};
       pro21= new int [] {219,12};
       pro22= new int [] {};
       pro23= new int [] {16,15};
       pro24= new int [] {218,13};
       pro25= new int [] {};
       pro26= new int [] {17};
       pro27= new int [] {18};
       pro28= new int [] {19};
       pro29= new int [] {220,19};
       pro30= new int [] {21,20};
       pro31= new int [] {23,21};
       pro32= new int [] {};
       pro33= new int [] {24,22};
       pro34= new int [] {214,21};
       pro35= new int [] {215,21};
       pro36= new int [] {};
       pro37= new int [] {226};
       pro38= new int [] {225};
       pro39= new int [] {221};
       pro40= new int [] {222};
       pro41= new int [] {223};
       pro42= new int [] {224};
       pro43= new int [] {25,26};
       pro44= new int [] {216,24};
       pro45= new int [] {217,24};
       pro46= new int [] {};
       pro47= new int [] {208};
       pro48= new int [] {209};
       pro49= new int [] {210};
       pro50= new int [] {211};
       pro51= new int [] {212};
       pro52= new int [] {213};
       pro53= new int [] {228,12,229};
       pro54= new int [] {1};
       pro55= new int [] {};
       pro56= new int [] {};
       pro57= new int [] {};
       pro58= new int [] {};
       pro59= new int [] {};
       pro60= new int [] {};
       pro61= new int [] {};
       pro62= new int [] {};
       pro63= new int [] {};
       pro64= new int [] {};
       pro65= new int [] {};
       
   
       int prox[]=new int[]{};
       
       producciones = new int [][]{prox,pro1,pro2,pro3,pro4,pro5,pro6,pro7,pro8,pro9,pro10,pro11,pro12,pro13,pro14,pro15,pro16,pro17,pro18,pro19,
        pro20,pro21,pro22,pro23, pro24, pro25, pro26, pro27, pro28, pro29, pro30, pro31, pro32, pro33, pro34, pro35,
        pro36, pro37, pro38, pro39, pro40, pro41, pro42, pro43, pro44, pro45,pro46, pro47, pro48, pro49, pro50, pro51,
        pro52, pro53, pro54, pro55, pro56, pro57, pro58, pro59, pro60, pro61, pro62, pro63, pro64, pro65};
    }
    
   
    void inserProd(int p){
        for(int i=producciones[p].length-1;i>=0;i--){
            pila.push(producciones[p][i]);
        }
    }
     
    
    public int sintactico(int colu)
    {
        int px;
        //int top;
        String tope;
        int top;
        int c;
        pila.empty();
        tope=pila.peek().toString();
        if(colu==128)//CHECA SI SON COMENTARIOS
        {
            System.out.println("Comentarios");
        }
        else
        {
        while(!pila.isEmpty())
        {
            tope=pila.peek().toString();
            c=buscarCS(colu);
            if(!"$".equals(tope))
            {
                top=Integer.parseInt(tope);
                if(top>=0 && top<=28)
                {
                    px=matriz_p[top][c];
                    if(px==1000)
                    {
                        System.out.println("ERROR");
                        return 1;
                        
                    }
                    pila.pop();
                    inserProd(px);
                    System.out.println("Inserte: "+px);
                }
                if(top>=200 && top<=260)
                {
                    if(top==terminal)
                    {
                        pila.pop();
                        
                        return 0;
                    }
                    else
                    {
                        return 1;
                    }
                }
            }   
           if(tope=="$")
            {                System.out.println("ERROR SINTACTICO");
                return 1;                 
            }
            
        }
        }
        return 0;
    }
    
    
   
    static int buscarCS(int xxx)
    {
        switch(xxx)
        {
            case 100:
                if(lexema.equals("CLASS"))
                {
                    terminal=200;
                    return 0;
                }
                if(lexema.equals("BEGIN"))
                {
                    terminal=201;
                    return 1;
                }
                if(lexema.equals("ENDCLASS"))
                {
                    terminal=206;
                    return 2;
                }
                if(lexema.equals("INTEGER"))
                {
                    terminal=202;
                    return 3;
                }
                if(lexema.equals("FLOAT"))
                {
                    terminal=203;
                    return 6;
                }
                if(lexema.equals("CHAR"))
                {
                    terminal=204;
                    return 7;
                }
                if(lexema.equals("STRING"))
                {
                    terminal=205;
                    return 15;
                }
                if(lexema.equals("BOOLEAN"))
                {
                    terminal=207;
                    return 16;
                }
            if(lexema.equals("READ"))
                {
                    terminal=208;
                    return 22;
                }
            if(lexema.equals("PRINT"))
                {
                    terminal=209;
                    return 23;
                }
            if(lexema.equals("IF"))
                {
                    terminal=210;
                    return 26;
                }
            if(lexema.equals("ENDIF"))
                {
                    terminal=211;
                    return 26;
                }
            if(lexema.equals("ELSE"))
                {
                    terminal=212;
                    return 27;
                }
            if(lexema.equals("WHILE"))
                {
                    terminal=213;
                    return 29;
                }
            if(lexema.equals("ENDWHILE"))
                {
                    terminal=214;
                    return 30;
                }
            if(lexema.equals("FOR"))
                {
                    terminal=215;
                    return 30;
                }
            if(lexema.equals("ENDFOR"))
                {
                    terminal=216;
                    return 30;
                }
            if(lexema.equals("TRUE"))
                {
                    terminal=217;
                    return 63;
                }
                if(lexema.equals("FALSE"))
                {
                    terminal=218;
                    return 64;
                }
            
                
            case 101://Identificador
                terminal=208;
                return 25;
            case 102://Entero
                terminal=209;
                return 26;
            case 103://Real
                terminal=210;
                return 27;
            case 104://Notación
                terminal=211;
                return 28;
            case 107://Suma
                terminal=214;
                return 15;
            case 108://Resta
                terminal=215;
                return 16;
            case 109://Multiplicación
                terminal=216;
                return 23;
            case 110://División
                terminal=217;
                return 24;
            case 120://Asigna
                terminal=227;
                return 9;
            case 119://Igualdad
                terminal=226;
                return 17;
            case 114://Menor
                terminal=221;
                return 19;
            case 115://Menor igual
                terminal=222;
                return 20;
            case 116://Mayor
                terminal=223;
                return 21;
            case 117://Mayor igual
                terminal=224;
                return 22;
            case 118://Diferente
                terminal=225;
                return 18;
            case 113://Not
                terminal=220;
                return 14;
            case 111://And
                terminal=218;
                return 13;
            case 112://Or
                terminal=219;
                return 12;
            case 121://Paréntesis que abre
                terminal=228;
                return 4;
            case 122://Paréntesis que cierra
                terminal=229;
                return 5;
            case 123://Punto y coma
                terminal=230;
                return 31;
            case 125://Coma
                terminal=231;
                return 10;
            case 105://Caracter
                terminal=212;
                return 29;
            case 106://string
                terminal=213;
                return 30;
        }
        return 0;
    }
   
    
    
    
}