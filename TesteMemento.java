import java.awt.event.*;
import javax.swing.*;


public class TesteMemento extends JFrame{
    
    public static void main(String[] args){

        new TesteMemento();

    }

    private JButton salvarB, voltarB, refazerB;
    private JTextArea oTexto = new JTextArea(40, 60);

    Caretaker caretaker = new Caretaker();

    Originator originator = new Originator();

    int arquivosSalvos = 0, textoAtual = 0;

    public TesteMemento(){

        this.setSize(750, 780);
        this.setTitle("Padrão de Projeto Memento");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel1 = new JPanel();

        panel1.add(new JLabel("Texto"));

        panel1.add(oTexto);

        ButtonListener salvarListener = new ButtonListener();
        ButtonListener voltarListener = new ButtonListener();
        ButtonListener refazerListener = new ButtonListener();

        salvarB = new JButton("Salvar");
        salvarB.addActionListener(salvarListener);

        voltarB = new JButton("Voltar");
        voltarB.addActionListener(voltarListener);

        refazerB = new JButton("Refazer");
        refazerB.addActionListener(refazerListener);

        panel1.add(salvarB);
        panel1.add(voltarB);
        panel1.add(refazerB);

        this.add(panel1);
        this.setVisible(true);

    }

    class ButtonListener implements ActionListener{

        public void actionPerformed(ActionEvent e){

            if(e.getSource() == salvarB){

                String textInTextArea = oTexto.getText();

                originator.set(textInTextArea);

                caretaker.addMemento(originator.armazenarNoMemento());
             
                arquivosSalvos++;
                textoAtual++;

                System.out.println("Arquivos Salvos " + arquivosSalvos);

                voltarB.setEnabled(true);

            } else

                if(e.getSource() == voltarB){

                    if(textoAtual >= 1){

                        textoAtual--;

                        String textBoxString = originator.restaurarDoMemento(caretaker.getMemento(textoAtual));

                        oTexto.setText(textBoxString);

                        voltarB.setEnabled(true);

                    } else {

                        voltarB.setEnabled(false);

                    }

                } else

                    if(e.getSource() == refazerB){

                        if((arquivosSalvos - 1) > textoAtual){

                            textoAtual++;

                            String textBoxString = originator.restaurarDoMemento(caretaker.getMemento(textoAtual));

                            oTexto.setText(textBoxString);

                            voltarB.setEnabled(true);

                        } else {

                            refazerB.setEnabled(false);

                        }

                    }

        }
    }
}