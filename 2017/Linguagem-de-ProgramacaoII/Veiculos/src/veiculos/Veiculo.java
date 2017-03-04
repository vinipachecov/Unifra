/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veiculos;

import javax.swing.JOptionPane;

/**
 *
 * @author root
 */
public class Veiculo {
    
    private String marca;
    private String modelo;
    private String anoFabricacao;
    
    public Veiculo(){
        marca = JOptionPane.showInputDialog("Escreva o nome da marca: ");
        modelo = JOptionPane.showInputDialog("Escreva o nome do modelo do carro: ");
        anoFabricacao = JOptionPane.showInputDialog("Escreva o ano de Fabricacao: ");
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getAnoFabricacao() {
        return anoFabricacao;
    }
    
    

    
    
}
