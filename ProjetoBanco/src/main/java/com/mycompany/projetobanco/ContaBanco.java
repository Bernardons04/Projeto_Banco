package com.mycompany.projetobanco;

import javax.swing.JOptionPane;

public class ContaBanco {
    public int numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;
    
    public void estadoAtual(){
        JOptionPane.showMessageDialog(null, "------------------------------" 
                + "\nConta: " + this.getNumConta() 
                + "\nTipo: " + this.getTipo() 
                + "\nDono: " + this.getDono() 
                + "\nSaldo: " + this.getSaldo());
    }
   
    public void abrirConta(String t){
        this.setTipo(t);
        this.setStatus(true);
        if ("CC".equals(t) || "cc".equals(t)) {
            this.setSaldo(50);
        } else if ("CP".equals(t) || "cp".equals(t)){
            this.setSaldo(150);
        }
        JOptionPane.showMessageDialog(null, "Conta aberta com sucesso!");
    }
    
    public void fecharConta(){
        if (this.getSaldo() > 0) {
            JOptionPane.showMessageDialog(null, "Conta não pode ser fechada, pois ainda há dinheiro");
        } else if (this.getSaldo() < 0) {
            JOptionPane.showMessageDialog(null, "Conta não pode fechar pois está em débito");
        } else {
            this.setNumConta(0);
            this.setDono("");
            this.setTipo("");
            this.setSaldo(0);
            this.setStatus(false);
            JOptionPane.showMessageDialog(null, "Conta fechada com sucesso");
        }
    }
    
    public void depositar(float v){
        if (this.getStatus()) {
            this.setSaldo(this.getSaldo() + v);
            JOptionPane.showMessageDialog(null, "Depósito realizado na conta de " + this.getDono());
        } else {
            JOptionPane.showMessageDialog(null, "Impossível depositar em uma conta fechada!");
        }
    }
    
    public void sacar(float s){        
        if (this.getStatus()) {
            if (this.getSaldo() >= s) {
                this.setSaldo(this.getSaldo() - s);
                JOptionPane.showMessageDialog(null, "Saque realizado na conta de " + this.getDono());
            } else {
                JOptionPane.showMessageDialog(null, "Impossível sacar, saldo insuficiente!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Impossível sacar em uma conta fechada!");
        }
    }
    
    public void pagarMensal(float pgt){
        if ("CC".equals(this.getTipo()) || "cc".equals(this.getTipo())) {
            pgt = 12;
        } else if ("CP".equals(this.getTipo()) || "cp".equals(this.getTipo())) {
            pgt = 20;
        }
        
        if (this.getStatus() == true) {
            if (this.getSaldo() >= pgt) {
                this.setSaldo(this.getSaldo() - pgt);
                JOptionPane.showMessageDialog(null, "Mensalidade paga com sucesso por " + this.getDono());
            } else {
                JOptionPane.showMessageDialog(null, "Impossível pagar a mensalidade, saldo insuficiente!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Impossível pagar a mensalidade em uma conta fechada!");
        }
    }
    
    public int getNumConta() {
        return numConta;
    }
    public void setNumConta(int n) {
        this.numConta = n;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String t) {
        this.tipo = t;
    }
    public String getDono() {
        return dono;
    }
    public void setDono(String dono) {
        this.dono = dono;
    }
    public float getSaldo() {
        return saldo;
    }
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    public boolean getStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }   
}
