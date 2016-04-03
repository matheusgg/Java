import java.text.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;

public class Cryptonita {
    /***************** Áreas de Texto ********************/
	private JFrame frame = new JFrame("Cryptonita 3.0");
	private JTextArea text_crip;
    private JTextArea text_descrip;
    private String[] textCripUser;
    private String[] textDescripUser;
    private JFileChooser chooseWindow;    
    
    public static void main(String[] args) {
        new Cryptonita().gui();
    }
        
    private void gui(){ // Constrói a Interface Gráfica de usuário
        /******************* Menus **************************/       
        JMenuItem open = new JMenuItem("Abrir");
        JMenuItem save = new JMenuItem("Salvar");
        JMenuItem exit = new JMenuItem("Sair");
        JMenuItem about = new JMenuItem("Sobre");
        
        open.addActionListener(new Abrir());       
        save.addActionListener(new Salvar());
        about.addActionListener(new Sobre());  
        exit.addActionListener(new Exit());
        
        JMenu menuArquivo = new JMenu("Arquivo");
        menuArquivo.add(open);
        menuArquivo.add(save);
        menuArquivo.add(exit);
        
        JMenu menuAjuda = new JMenu("Ajuda");        
        menuAjuda.add(about);
        
        JMenuBar menuBar = new JMenuBar();  
        menuBar.add(menuArquivo);
        menuBar.add(menuAjuda);       
        
        /******************* Botões e Labels **************************/
        JButton cripButton = new JButton("Criptografar");
        JButton descripButton = new JButton("Descriptografar");
        JButton clean = new JButton("Limpar");
        
        cripButton.addActionListener(new Crip());       
        descripButton.addActionListener(new Descrip());
        clean.addActionListener(new Limpar());
        
        cripButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        descripButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        clean.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        JLabel text_c = new JLabel("Texto Criptografado:");
        JLabel text_d = new JLabel("Texto Descriptografado:");
        
        /******************** Áreas de Texto*******************/       
        text_descrip = new JTextArea(5, 8);
        text_descrip.setLineWrap(true);
        text_descrip.setWrapStyleWord(true);
        
        JScrollPane scrollPane1 = new JScrollPane(text_descrip);
        scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); 
        
        text_crip = new JTextArea(5, 8);
        text_crip.setLineWrap(true);
        text_crip.setWrapStyleWord(true);
        text_crip.setEditable(false);      
                
        JScrollPane scrollPane2 = new JScrollPane(text_crip);
        scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);        
        
        /********************* Painels ************************/        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(cripButton);
        buttonPanel.add(descripButton);
        buttonPanel.add(clean);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(text_d);        
        mainPanel.add(scrollPane1);
        mainPanel.add(text_c);
        mainPanel.add(scrollPane2);
        
        /******************** Frame **********************/ 
        frame.setSize(400, 350);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocation(50, 50);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);
        frame.setJMenuBar(menuBar);
    }
    
    /********************** Evento para exibir sobre o autor ********************************/
    private class Sobre implements ActionListener{
        public void actionPerformed(ActionEvent event){
            JOptionPane.showMessageDialog(text_crip, "Programa Cryptonita 3.0\nDesenvolvido por M.A.R.", "Sobre", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    /********************** Evento para limpar as duas Áreas de texto ********************************/
    private class Limpar implements ActionListener{
        public void actionPerformed(ActionEvent event){
        	text_crip.setText("");
            text_descrip.setText("");
        }
        
    }
    
    /********************** Evento para criptografar o Texto ********************************/
    private class Crip implements ActionListener{
        public void actionPerformed(ActionEvent event){
        	if(text_descrip.getText().equals("")){ // Verifica se há texto no campo "Texto Criptografado"
        		JOptionPane.showMessageDialog(text_descrip, "O campo \"Texto Descriptografado\" está vazio.\nPor favor, digite uma frase para ser criptografada.", "Aviso", JOptionPane.WARNING_MESSAGE);
        	} else{
        		if(text_descrip.getText().length() > 128){
            		JOptionPane.showMessageDialog(text_crip, "Este campo permite apenas frases de até 128 bits.\nPor favor, tente novamente.", "Aviso", JOptionPane.WARNING_MESSAGE);
            	} else{
            		text_crip.setText("");
            		textDescripUser = text_descrip.getText().split("\n");         		
            		
            		for (int i = 0; i < textDescripUser.length; i++) { 
            			textDescripUser[i] = retirarCE(textDescripUser[i]);
            			textDescripUser[i] = textDescripUser[i].toUpperCase();
            			textDescripUser[i] = textDescripUser[i].replaceAll("\t", " ");
            			textDescripUser[i] = Criptografia.Crip(textDescripUser[i]);
            			
            			if (textDescripUser[i].equals("*e*r*r*o*")) {
            				JOptionPane.showMessageDialog(text_descrip, "A frase não pode ser descriptografada.\nProvavelmente há algum caractere inválido.\nPor favor, tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
            				break;
    					} else {						
    						text_crip.append(textDescripUser[i] + "\n");
    					}       			      			
            			
            			/* A instrução abaixo faz a mesma coisa do código acima */
            			//text_crip.append(Criptografia.Crip(retirarCE(textDescripUser[i].toUpperCase()).replaceAll("\t", " ")) + "\n");
            		}   
            	}
        	}       	            
        }
    }
    
    /********************** Evento para descriptografar o Texto ********************************/
    private class Descrip implements ActionListener{
        public void actionPerformed(ActionEvent event){
        	descripFrase(text_crip.getText());
        }
        
        private void descripFrase(String frase){
        	if(text_crip.getText().equals("")){ // Verifica se há texto no campo "Texto Criptografado"
        		JOptionPane.showMessageDialog(text_crip, "O campo \"Texto Criptografado\" está vazio.\nPor favor, escolha um arquivo com o conteúdo\na ser descriptogradado.", "Aviso", JOptionPane.WARNING_MESSAGE);        		
        	} else{
        		if(frase.length() >128){
            		JOptionPane.showMessageDialog(text_crip, "Este campo permite apenas frases de até 128 bits.\nPor favor, tente novamente.", "Aviso", JOptionPane.WARNING_MESSAGE);
            	} else{
            		text_descrip.setText("");        	
                	textCripUser = frase.split("\n");
                	for (int i = 0; i < textCripUser.length; i++) {
                		textCripUser[i] = textCripUser[i].replaceAll("\t", " ");
                		textCripUser[i] = Criptografia.Descrip(textCripUser[i]);
                		
                		if (textCripUser[i].equals("*e*r*r*o*")) {
        					JOptionPane.showMessageDialog(text_descrip, "A frase não pode ser descriptografada.\nProvavelmente há algum caractere inválido.\nPor favor, tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
        				} else {
        					text_descrip.append(textCripUser[i] + "\n"); 
        				}       		      		
                		
                		/* A instrução abaixo faz a mesma coisa do código acima */
        				//text_descrip.append(Criptografia.Descrip(textCripUser[i]).replaceAll("\t", " ") + "\n");      		      		
                	}
            	}
        	}       	       	 
        }
    }
    
    /********************** Método para retirar caracteres especiais, acentos, etc. ********************************/
    private String retirarCE(String palavra) {
        if (palavra != null) {
           palavra = Normalizer.normalize(palavra, Normalizer.Form.NFD);
           palavra = palavra.replaceAll("[^\\p{ASCII}]", "");
           palavra = palavra.replaceAll("[\'\"!@#$%¨&*()_+=-?°ºª¬¢£³²¹§|^~{}´`/.,:;<>]", "");
        }
        return palavra;
    }

    /********************** Evento para salvar a frase criptografada ********************************/
	private class Salvar implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(text_crip.getText().equals("")){
        		JOptionPane.showMessageDialog(text_crip, "O campo \"Texto Criptografado\" está vazio.\nPor favor, criptografe a frase antes de salvá-la.", "Aviso", JOptionPane.WARNING_MESSAGE);
        	} else{
        		salvarFrase();
        	}		
		}
		private void salvarFrase(){
			chooseWindow = new JFileChooser();
			try{
				chooseWindow.showSaveDialog(text_crip);		
				File file = new File(chooseWindow.getSelectedFile() + ".cyp");	
				
				if(!file.getPath().contains("null")){
					BufferedWriter writer = new BufferedWriter(new FileWriter(file));					
					writer.write(text_crip.getText());
					writer.close();					
					JOptionPane.showMessageDialog(text_crip, "O arquivo foi salvo com sucesso!!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				} 		
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(text_crip, "O arquivo não pode ser salvo.\nPor favor, tente Novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/********************** Evento para abrir a frase criptografada ********************************/
	private class Abrir implements ActionListener{
		public void actionPerformed(ActionEvent event){
        	abrirFrase();
		}
		private void abrirFrase(){
			chooseWindow = new JFileChooser();			
			try{
				chooseWindow.showOpenDialog(text_crip);		
				
				if (chooseWindow.getSelectedFile().getName().contains(".cyp")) {
					BufferedReader reader = new BufferedReader(new FileReader(chooseWindow.getSelectedFile()));
					String linha = null;
					text_crip.setText("");
					text_descrip.setText("");					
					while ((linha = reader.readLine()) != null) {
						text_crip.append(linha + "\n");						
					}
					reader.close();					
				} else {
					JOptionPane.showMessageDialog(text_crip, "O arquivo não possui uma extensão válida.\nSomente arquivos .cyp podem ser lidos.\nPor favor, tente novamente.", "Aviso", JOptionPane.WARNING_MESSAGE);
				}			
				
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(text_crip, "Ocorreu um erro durante leitura do arquivo.\nPor favor, tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	 /********************** Evento para sair do aplicativo ********************************/
    private class Exit implements ActionListener{
        public void actionPerformed(ActionEvent event){
            System.exit(0);
        }
    }
}

final class Criptografia{	
	
	public static String Crip(String LINHA){
        /************************ VARIÁVEIS *******************************/
        String chave = "CRIPTOGRAFIA", c2, c3 = "", text = LINHA, crip2 = "";
        String text_chave[][] = new String[2][text.length()];
        String crip1[] = new String[text.length()];
        char zero = '0', padrao = ' ';
        int c = 0, p = 0, k = 0, i = 0;
        /******************* FIM DA DECLARAÇÃO DAS VARIÁVEIS ********************/
        
        for (int cont = 0; cont < text.length(); cont++) {
            
            if (chave.length() < text.length()) {
                
                for (int cont2 = 0; cont2 < (text.length() - chave.length()); cont2++) {
                    
                    chave += chave.substring(cont2, cont2 + 1);                    
                }                
            }
            
            text_chave[0][cont] = chave.substring(cont, cont + 1);
            text_chave[1][cont] = text.substring(cont, cont + 1);
            
            switch(text_chave[1][cont]){
                    case "A": p = 1; break;
                    case "B": p = 2; break;
                    case "C": p = 3; break;
                    case "D": p = 4; break;
                    case "E": p = 5; break;
                    case "F": p = 6; break;
                    case "G": p = 7; break;
                    case "H": p = 8; break;
                    case "I": p = 9; break;
                    case "J": p = 10; break;
                    case "K": p = 11; break;
                    case "L": p = 12; break;
                    case "M": p = 13; break;
                    case "N": p = 14; break;
                    case "O": p = 15; break;
                    case "P": p = 16; break;
                    case "Q": p = 17; break;
                    case "R": p = 18; break;
                    case "S": p = 19; break;
                    case "T": p = 20; break;
                    case "U": p = 21; break;
                    case "V": p = 22; break;
                    case "W": p = 23; break;
                    case "X": p = 24; break;
                    case "Y": p = 25; break;
                    case "Z": p = 26; break;
                    case " ": p = 27; break;
                    case "0": p = 28; break;
                    case "1": p = 29; break;
                    case "2": p = 30; break;
                    case "3": p = 31; break;
                    case "4": p = 32; break;
                    case "5": p = 33; break;
                    case "6": p = 34; break;
                    case "7": p = 35; break;
                    case "8": p = 36; break;
                    case "9": p = 37; break;
                    default: padrao = '*'; break;               
            }
            
            if (padrao == '*') {
                
                crip2 = "*e*r*r*o*";
                break;
            }
            else{
                switch(text_chave[0][cont]){
                   case "A": k = 1; break;
                   case "C": k = 3; break;
                   case "F": k = 6; break;
                   case "G": k = 7; break;
                   case "I": k = 9; break;
                   case "O": k = 15; break;
                   case "P": k = 16; break;
                   case "R": k = 18; break;
                   case "T": k = 20; break;                  
                }
                
                c = p+k;
                
                if (c > 37){
                        c -= 37; 
                        if (c <= 9){
                            c2 = Integer.toString(c);
                            c3 += (zero + c2); 
                        }
                        else{
                            c2 = Integer.toString(c);
                            c3 += c2; 
                        }
                    }
                    else {
                        if (c <= 9){
                            c2 = Integer.toString(c); 
                            c3 += (zero + c2); 
                        }
                        else{
                            c2 = Integer.toString(c);
                            c3 += c2; 
                        }
                    }
                crip1[cont] = c3.substring(i, i + 2);
                for (i = 0; i < c3.length(); i++) {
                    
                    switch(crip1[cont]){
                            case "01": crip1[cont] = "Ç"; break;
                            case "02": crip1[cont] = "ü"; break;
                            case "03": crip1[cont] = "é"; break;
                            case "04": crip1[cont] = "ï"; break;
                            case "05": crip1[cont] = "î"; break;
                            case "06": crip1[cont] = "Ä"; break;
                            case "07": crip1[cont] = "Å"; break;
                            case "08": crip1[cont] = "æ"; break;
                            case "09": crip1[cont] = "Æ"; break;
                            case "10": crip1[cont] = "ô"; break;
                            case "11": crip1[cont] = "ÿ"; break;
                            case "12": crip1[cont] = "Ü"; break;
                            case "13": crip1[cont] = "ø"; break;
                            case "14": crip1[cont] = "£"; break;
                            case "15": crip1[cont] = "Ø"; break;
                            case "16": crip1[cont] = "×"; break;
                            case "17": crip1[cont] = "ƒ"; break;
                            case "18": crip1[cont] = "á"; break;
                            case "19": crip1[cont] = "Ñ"; break;
                            case "20": crip1[cont] = "¿"; break;
                            case "21": crip1[cont] = "®"; break;
                            case "22": crip1[cont] = "¬"; break;
                            case "23": crip1[cont] = "½"; break;
                            case "24": crip1[cont] = "«"; break;
                            case "25": crip1[cont] = "¦"; break;
                            case "26": crip1[cont] = "©"; break;
                            case "27": crip1[cont] = "¢"; break;
                            case "28": crip1[cont] = "¥"; break;
                            case "29": crip1[cont] = "¤"; break;
                            case "30": crip1[cont] = "ð"; break;
                            case "31": crip1[cont] = "Ð"; break;
                            case "32": crip1[cont] = "Ì"; break;
                            case "33": crip1[cont] = "ß"; break;
                            case "34": crip1[cont] = "µ"; break;
                            case "35": crip1[cont] = "Þ"; break;
                            case "36": crip1[cont] = "¶"; break;
                            case "37": crip1[cont] = "§"; break;
                    }                    
                }
            }
            crip2 += crip1[cont];
        }
        return crip2;    
    }	
	
	public static String Descrip(String LINHA){
        /************************ VARIÁVEIS *******************************/
        String chave = "CRIPTOGRAFIA", c2, c3 = "", text = LINHA, crip2 = "";
        String text_chave[][] = new String[2][text.length()];
        String crip1[] = new String[text.length()];
        char zero = '0', padrao = ' ';
        int c = 0, p = 0, k = 0, i = 0;
        /******************* FIM DA DECLARAÇÃO DAS VARIÁVEIS ********************/
        
        for (int cont = 0; cont < text.length(); cont++) {
            
            if (chave.length() < text.length()) {
                
                for (int cont2 = 0; cont2 < (text.length() - chave.length()); cont2++) {
                    
                    chave += chave.substring(cont2, cont2 + 1);                    
                }                
            }
            
            text_chave[0][cont] = text.substring(cont, cont + 1);
            text_chave[1][cont] = chave.substring(cont, cont + 1);
            
            switch(text_chave[0][cont]){
                    case "Ç": c = 1; break;
                    case "ü": c = 2; break;
                    case "é": c = 3; break;
                    case "ï": c = 4; break;
                    case "î": c = 5; break;
                    case "Ä": c = 6; break;
                    case "Å": c = 7; break;
                    case "æ": c = 8; break;
                    case "Æ": c = 9; break;
                    case "ô": c = 10; break;
                    case "ÿ": c = 11; break;
                    case "Ü": c = 12; break;
                    case "ø": c = 13; break;
                    case "£": c = 14; break;
                    case "Ø": c = 15; break;
                    case "×": c = 16; break;
                    case "ƒ": c = 17; break;
                    case "á": c = 18; break;
                    case "Ñ": c = 19; break;
                    case "¿": c = 20; break;
                    case "®": c = 21; break;
                    case "¬": c = 22; break;
                    case "½": c = 23; break;
                    case "«": c = 24; break;
                    case "¦": c = 25; break;
                    case "©": c = 26; break;
                    case "¢": c = 27; break;
                    case "¥": c = 28; break;
                    case "¤": c = 29; break;
                    case "ð": c = 30; break;
                    case "Ð": c = 31; break;
                    case "Ì": c = 32; break;
                    case "ß": c = 33; break;
                    case "µ": c = 34; break;
                    case "Þ": c = 35; break;
                    case "¶": c = 36; break;
                    case "§": c = 37; break;   
                    default: padrao = '*'; break;
            }
            
            if (padrao == '*') {
            	
            	crip2 = "*e*r*r*o*";
                break;
			} else {			
            
            switch(text_chave[1][cont]){
                   case "A": k = 1; break;
                   case "C": k = 3; break;
                   case "F": k = 6; break;
                   case "G": k = 7; break;
                   case "I": k = 9; break;
                   case "O": k = 15; break;
                   case "P": k = 16; break;
                   case "R": k = 18; break;
                   case "T": k = 20; break;                                    
                }
            
            if (c - k > 0) {                
                p = c - k;                
                if (p <= 9){
                    c2 = Integer.toString(p);
                    c3 += (zero + c2); 
                }
                else{
                    c2 = Integer.toString(p);
                    c3 += c2; 
                }
            }
            else {
                p = (c - k) + 37; 
                    if (p <= 9){
                        c2 = Integer.toString(p); 
                        c3 += (zero + c2); 
                    }
                    else{
                        c2 = Integer.toString(p);
                        c3 += c2; 
                    }
            }
                crip1[cont] = c3.substring(i, i + 2);
                for (i = 0; i < c3.length(); i++) {
                    
                    switch(crip1[cont]){
                        case "01": crip1[cont] = "A"; break;
                        case "02": crip1[cont] = "B"; break;
                        case "03": crip1[cont] = "C"; break;
                        case "04": crip1[cont] = "D"; break;
                        case "05": crip1[cont] = "E"; break;
                        case "06": crip1[cont] = "F"; break;
                        case "07": crip1[cont] = "G"; break;
                        case "08": crip1[cont] = "H"; break;
                        case "09": crip1[cont] = "I"; break;
                        case "10": crip1[cont] = "J"; break;
                        case "11": crip1[cont] = "K"; break;
                        case "12": crip1[cont] = "L"; break;
                        case "13": crip1[cont] = "M"; break;
                        case "14": crip1[cont] = "N"; break;
                        case "15": crip1[cont] = "O"; break;
                        case "16": crip1[cont] = "P"; break;
                        case "17": crip1[cont] = "Q"; break;
                        case "18": crip1[cont] = "R"; break;
                        case "19": crip1[cont] = "S"; break;
                        case "20": crip1[cont] = "T"; break;
                        case "21": crip1[cont] = "U"; break;
                        case "22": crip1[cont] = "V"; break;
                        case "23": crip1[cont] = "W"; break;
                        case "24": crip1[cont] = "X"; break;
                        case "25": crip1[cont] = "Y"; break;
                        case "26": crip1[cont] = "Z"; break;
                        case "27": crip1[cont] = " "; break;
                        case "28": crip1[cont] = "0"; break;
                        case "29": crip1[cont] = "1"; break;
                        case "30": crip1[cont] = "2"; break;
                        case "31": crip1[cont] = "3"; break;
                        case "32": crip1[cont] = "4"; break;
                        case "33": crip1[cont] = "5"; break;
                        case "34": crip1[cont] = "6"; break;
                        case "35": crip1[cont] = "7"; break;
                        case "36": crip1[cont] = "8"; break;
                        case "37": crip1[cont] = "9"; break;
                    }                    
                }
			}
                crip2 += crip1[cont];
            }
        return crip2;            
        }
}
