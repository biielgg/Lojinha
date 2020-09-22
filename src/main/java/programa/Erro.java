/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

import javax.swing.JOptionPane;

/**
 *
 * @author biiel
 */
public class Erro {

    public Erro() { //construtor
    } 

    public void erro(String titulo, String mensagem, String icone) {
        JOptionPane.showMessageDialog(null, mensagem, titulo, getIcone(icone));
    }

    public int getIcone(String icone) {
        switch (icone) {
            case "erro":
                return JOptionPane.ERROR_MESSAGE;
            case "info":
                return JOptionPane.INFORMATION_MESSAGE;
            case "atencao":
                return JOptionPane.WARNING_MESSAGE;
            case "nada":
                return JOptionPane.PLAIN_MESSAGE;
        }
        return 0;
    }
}
