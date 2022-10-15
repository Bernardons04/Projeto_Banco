/*Projeto onde eu simulo um banco, onde é possível o cliente sacar, depositar e 
realizar pagamentos com o seu dinheiro, entre outras ações.*/

package com.mycompany.projetobanco;

import javax.swing.JOptionPane;

public class ProjetoBanco {

    public static void main(String[] args) {
        ContaBanco usuario1 = new ContaBanco();
        int opção;
        do { 
            opção = Integer.parseInt(JOptionPane.showInputDialog("Digite 1, caso você queira abrir uma conta.\n" 
                    + "\nDigite 2, caso você já tenha uma conta e queira acessa-la.\n" 
                    + "\nDigite 3, caso você queira fechar a sua conta existente.\n" 
                    + "\nDigite 0, caso você queira sair do programa!"));
            if (opção == 1) {
                String nome = JOptionPane.showInputDialog("Digite o seu nome: ");
                usuario1.setDono(nome);
                int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da sua conta: "));
                usuario1.setNumConta(numeroConta);
                String tipo = JOptionPane.showInputDialog("Digite CC, caso você queira uma conta corrente, " 
                        + "\ne CP, caso você queira uma conta poupança.");
                usuario1.abrirConta(tipo);
            } else if (opção == 2) {
                int opção2;
                if (usuario1.getStatus() == false) {
                    JOptionPane.showMessageDialog(null, "Conta inexistente!");
                } else {
                do { 
                        usuario1.estadoAtual();
                        opção2 = Integer.parseInt(JOptionPane.showInputDialog("Digite 1, caso você queira fazer um depósito.\n" 
                            + "\nDigite 2, caso você queira realizar um saque.\n" 
                            + "\nDigite 3, caso você queira pagar a mensalidade.\n" 
                            + "\nDigite 0, caso você queira sair do programa!"));;
                        if (opção2 == 1) {
                            float deposito = Float.parseFloat(JOptionPane.showInputDialog("Digite abaixo o valor que você gostaria de depositar!"));
                            usuario1.depositar(deposito);
                        } else if (opção2 == 2) {
                            float saque = Float.parseFloat(JOptionPane.showInputDialog("Digite abaixo o valor que você gostaria de sacar!"));
                            usuario1.sacar(saque);
                        } else if (opção2 == 3) {
                            float pgtMensal = 0;
                            usuario1.pagarMensal(pgtMensal);
                        }
                    } while (opção2 != 0);
                }
            } else if (opção == 3) {
                usuario1.fecharConta();
            }
        } while (opção != 0);
    }
}
