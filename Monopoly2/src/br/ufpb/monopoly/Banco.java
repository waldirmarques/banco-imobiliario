package br.ufpb.monopoly;

public class Banco {

    private double saldo;

    public Banco (double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo () {
        return this.saldo;
    }
    public void setSaldo (double saldo) {
        this.saldo = saldo;
    }

    public double sacaDoSaldo (double valorDebitado) {
        if (this.saldo > valorDebitado) {
           return this.saldo = this.saldo - valorDebitado;
        }
        return -1;
    }

    public double creditaSaldo (double valorCreditar) {
        return this.saldo = this.saldo + valorCreditar;
    }

}
