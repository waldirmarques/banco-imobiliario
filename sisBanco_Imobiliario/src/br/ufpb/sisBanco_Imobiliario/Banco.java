package br.ufpb.sisBanco_Imobiliario;

public class Banco {
    
    public Banco(){}
    
     // Credita no saldo do jogador;
    public void creditarEmConta(Jogador jogador, int valorCreditar) {
        try {
            if (valorCreditar > 0)
                jogador.setSaldo(jogador.getSaldo() + valorCreditar);
        } catch (Exception ex) {
            System.out.println("Valor impossível de ser creditado!");
        }
    }

    // Saca do saldo do jogador;
    public void sacaDoSaldo(Jogador jogador, int valorDebitado) {
        try {
            if (valorDebitado > 0 && valorDebitado <= jogador.getSaldo())
                jogador.setSaldo(jogador.getSaldo() - valorDebitado);
        } catch (Exception ex) {
            System.out.println("Valor impossível de ser debitado!");
        }
    }
    
    //Banco precisa de um método que verifica quando o jogador passar pelo ponto de partida e credite 200 na conta do jogador.
    public void creditaPontoPartida (Jogador jogador) {
        int valorCreditar = 200;
        jogador.setSaldo(jogador.getSaldo()+valorCreditar);
    }
    //TODO: Implementar método depois;
}
