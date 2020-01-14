package br.ufpb.sisBanco_Imobiliario;

import java.util.ArrayList;

public class Tabuleiro {

    private ArrayList<Cartas> cartaTabuleiro;
    private ArrayList<Cartas> cartaSorteOuReves;

    //Instancia todas as posições do tabuleiro.
    public Tabuleiro() {
        this.cartaTabuleiro = new ArrayList<>(); //Cria a lista de peças do tabuleiro.
        
        this.cartaTabuleiro.add(new NormaisCartas("Ponto de partida"));
        this.cartaTabuleiro.add(new Propriedades("Leblon", "roxo", 100, 6, 30, 90, 270, 400, 500, 50, 50));
        this.cartaTabuleiro.add(new SorteOuReves("Sorte ou Revés"));
        this.cartaTabuleiro.add(new Propriedades("Av.Presidente Vargas", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 50));
        this.cartaTabuleiro.add(new Propriedades("Av. Nossa Senhora de Copacabana", "roxo", 60, 2, 10, 30, 90, 160, 250, 30, 50));
        this.cartaTabuleiro.add(new Companhia("Companhia Ferroviaria", 200, 100, 50));
        this.cartaTabuleiro.add(new Propriedades("Av. Brigadeiro Faria lima", "azul", 240, 20, 100, 300, 750, 925, 1100, 120, 150));
        this.cartaTabuleiro.add(new Companhia("Companhia de Viação", 200, 100, 50));
        this.cartaTabuleiro.add(new Propriedades("Av. Rebouças", "azul", 220, 18, 90, 250, 700, 875, 1050, 110, 150));
        this.cartaTabuleiro.add(new Propriedades("Av. 9 de Julho", "azul", 220, 18, 90, 250, 700, 875, 1050, 110, 150));
        this.cartaTabuleiro.add(new Prisao("Prisão(visitante)"));
        this.cartaTabuleiro.add(new Propriedades("Av. Europa", "roxo", 200, 16, 80, 220, 600, 800, 1000, 100, 100));
        this.cartaTabuleiro.add(new SorteOuReves("Sorte ou Revés"));
        this.cartaTabuleiro.add(new Propriedades("Rua Augusta", "roxo", 180, 14, 70, 200, 550, 750, 950, 90, 100));
        this.cartaTabuleiro.add(new Propriedades("Av. Pacaembu", "roxo", 180, 14, 70, 200, 550, 750, 950, 90, 100));
        this.cartaTabuleiro.add(new Companhia("Companhia de Táxi", 150, 75, 40));
        this.cartaTabuleiro.add(new SorteOuReves("Sorte ou Revés"));
        this.cartaTabuleiro.add(new Propriedades("Interlagos", "laranja", 350, 35, 175, 500, 1100, 1300, 1500, 175, 200));
        this.cartaTabuleiro.add(new NormaisCartas("Lucros e Dividendos"));
        this.cartaTabuleiro.add(new Propriedades("Morumbi", "laranja", 400, 50, 200, 600, 1400, 1700, 2000, 200, 200));
        this.cartaTabuleiro.add(new NormaisCartas("Parada livre"));
        this.cartaTabuleiro.add(new Propriedades("Flamengo", "vermelho", 120, 8, 40, 100, 300, 450, 600, 60, 50));
        this.cartaTabuleiro.add(new SorteOuReves("Sorte ou Revés"));
        this.cartaTabuleiro.add(new Propriedades("Botafogo", "vermelho", 100, 6, 30, 90, 270, 400, 500, 50, 50));
        this.cartaTabuleiro.add(new NormaisCartas("Imposto de Renda"));
        this.cartaTabuleiro.add(new Companhia("Companhia de Navegação", 150, 75, 40));
        this.cartaTabuleiro.add(new Propriedades("Av. Brasil", "amarelo", 160, 12, 60, 180, 500, 700, 900, 80, 100));
        this.cartaTabuleiro.add(new SorteOuReves("Sorte ou Revés"));
        this.cartaTabuleiro.add(new Propriedades("Av. Paulista", "amarelo", 140, 10, 50, 150, 450, 625, 750, 70, 100));
        this.cartaTabuleiro.add(new Propriedades("Jardim Europa", "amarelo", 140, 12, 60, 180, 500, 700, 900, 80, 100));
        this.cartaTabuleiro.add(new Prisao("Vá para a prisão"));
        this.cartaTabuleiro.add(new Propriedades("Copacabana", "verde", 260, 22, 110, 330, 800, 975, 1150, 130, 150));
        this.cartaTabuleiro.add(new Companhia("Companhia de Aviação", 200, 100, 50));
        this.cartaTabuleiro.add(new Propriedades("Av. Vieira Souto", "verde", 320, 28, 150, 450, 1000, 1200, 1400, 160, 200));
        this.cartaTabuleiro.add(new Propriedades("Av. Atlântica", "verde", 300, 26, 130, 390, 900, 1100, 1275, 150, 200));
        this.cartaTabuleiro.add(new Companhia("Companhia de Táxi Aéreo", 200, 100, 50));
        this.cartaTabuleiro.add(new Propriedades("Ipanema", "verde", 300, 26, 130, 390, 900, 1100, 1275, 150, 200));
        this.cartaTabuleiro.add(new SorteOuReves("Sorte ou Revés"));
        this.cartaTabuleiro.add(new Propriedades("Jardim Paulista", "azul", 280, 24, 120, 360, 850, 1025, 1200, 140, 150));
        this.cartaTabuleiro.add(new Propriedades("Brooklin", "azul", 260, 22, 110, 330, 800, 975, 1150, 130, 150));
        

        this.cartaSorteOuReves = new ArrayList<>();     //cria as cartas do sorte ou reves

        this.cartaSorteOuReves.add(new SorteOuReves("Sua empresa foi multada por poluir demais", 200, 0));
        this.cartaSorteOuReves.add(new SorteOuReves("O dia do seu casamento chegou, receba os presentes", 0, 50)); //recebe 50 de cada jogador
        this.cartaSorteOuReves.add(new SorteOuReves("Reformou sua casa", 50, 0));
        this.cartaSorteOuReves.add(new SorteOuReves("Seu livro será publicado por uma grande editora", 0, 50));
        this.cartaSorteOuReves.add(new SorteOuReves("Utilize este cartão para se livrar da prisão", 0, 0));
        this.cartaSorteOuReves.add(new SorteOuReves("Vá para a prisão", 0, 0));
        this.cartaSorteOuReves.add(new SorteOuReves("Vá até o início", 0, 200));
        this.cartaSorteOuReves.add(new SorteOuReves("Suas ações na bolsa de valores estão em alta", 0, 100));
        this.cartaSorteOuReves.add(new SorteOuReves("Você vai começar um curso de MBA e ganhou um bom desconto para pagamento a vista", 20, 0));
        this.cartaSorteOuReves.add(new SorteOuReves("Férias com a familia pague ", 20, 0));
        this.cartaSorteOuReves.add(new SorteOuReves(" Recebeu o prêmio de profissional do ano e ganhou um carro", 0, 10));
        this.cartaSorteOuReves.add(new SorteOuReves("Jogue os dados novamente", 0, 0));
        this.cartaSorteOuReves.add(new SorteOuReves("Sua empresa irá patrocinar uma expedição a Antártida", 50, 0));
        this.cartaSorteOuReves.add(new SorteOuReves("Vendeu a parte de sua empresa para um investidor", 0, 75));
        this.cartaSorteOuReves.add(new SorteOuReves("Apostou no cavalo azarão e ganhou", 0, 100));
        this.cartaSorteOuReves.add(new SorteOuReves("A falta de chuva prejudicou a colheita", 0, 45));
        this.cartaSorteOuReves.add(new SorteOuReves("Recebeu uma herança inesperada", 0, 75));
        this.cartaSorteOuReves.add(new SorteOuReves("Seu filho decidiu fazer intercâmbio", 20, 0));
        this.cartaSorteOuReves.add(new SorteOuReves("Sua casa será desapropriada para a construção de um metro e ganhará uma gorda indenização", 0, 60));
        this.cartaSorteOuReves.add(new SorteOuReves("Venceu licitação para grande obra", 0, 150));
        this.cartaSorteOuReves.add(new SorteOuReves("Seu iate afundou, mas você tinha seguro!", 0, 25));
        this.cartaSorteOuReves.add(new SorteOuReves("Seus funcionários entraram em greve", 30, 0));
        this.cartaSorteOuReves.add(new SorteOuReves("Comprou obra de arte falsificada", 22, 0));
        this.cartaSorteOuReves.add(new SorteOuReves("Sorte se tirou o número par da soma dos dados e revés caso contrário", 100, 100));
        this.cartaSorteOuReves.add(new SorteOuReves("Seu jatinho precisa de manutenção", 9, 0));
        this.cartaSorteOuReves.add(new SorteOuReves("Renovou a frota de carros da sua empresa", 100, 0));
        this.cartaSorteOuReves.add(new SorteOuReves("Ganhou sozinho na loteria", 0, 80));
        this.cartaSorteOuReves.add(new SorteOuReves("Atualizou os computadores da sua empresa", 30, 0));
        this.cartaSorteOuReves.add(new SorteOuReves("Um navio afundou com suas mercadorias (não tinha seguro)", 40, 0));
        this.cartaSorteOuReves.add(new SorteOuReves("Produção de leite de suas fazendas ficou abaixo da expectativa", 60, 0));
        this.cartaSorteOuReves.add(new SorteOuReves("Tirou primeiro lugar no torneio de golfe receba", 0, 100));

    }

    //Método que dada uma posição do tabuleiro, retorna uma carta.
    public Cartas retornaCartaAtual(int posicao) {
        return this.cartaTabuleiro.get(posicao);
    }

    //fazer metodo que embaralha as cartas do sorte ou reves e retorna uma delas
    public Cartas retornaCartaSorteOuReves() {
        Cartas carta = this.cartaSorteOuReves.get(0);  //Pega a primeira carta do baralho
        this.cartaSorteOuReves.remove(carta); // Remove ela
        this.cartaSorteOuReves.add(carta); // Depois a coloca no fim do baralho     
        return carta;  //retorna a carta     
    }

    //Método que embaralha as cartas do sorte ou reves.
    public void embaralhaCartasDoSorteOuReves() {
        for (int i = 0; i < this.cartaSorteOuReves.size(); i++) {
            int indexSorteado = (int) (Math.random() * this.cartaSorteOuReves.size());
            Cartas carta = this.cartaSorteOuReves.get(indexSorteado);
            int indexSetado = (int) (Math.random() * this.cartaSorteOuReves.size());
            this.cartaSorteOuReves.set(indexSetado, carta);
        }
        this.setCartaSorteOuReves(this.cartaSorteOuReves);
    }

    //Método que realiza as açoes do sorte ou reves
    public void acoesDoSorteOuReves(SorteOuReves carta, Jogador jogador, ArrayList<Jogador> jogadores, Banco banco, Dado dado, int duplaIgual) {
        //Implementações de ações especiais
        if (carta.getPague() == 0 && carta.getReceba() == 50 &&
            carta.getDescricao().equals("O dia do seu casamento chegou, receba os presentes.")) {
            System.out.println("Receba de cada jogador R$ 50");
            for (Jogador j : jogadores) {
                if (!j.equals(jogador)) {  //se jogador da lista diferente do jogador que foi passado é descontado dos outros jogadores.
                    banco.sacaDoSaldo(j, carta.getReceba());
                    banco.creditarEmConta(jogador, carta.getReceba());
                }
            }
        } else if (carta.getPague() == 0 && carta.getReceba() == 200 &&
            carta.getDescricao().equals("Vá até o início!")) {
            banco.creditarEmConta(jogador, 200);
            jogador.setPosicao(0);        
        
        } else if (carta.getPague() == 0 && carta.getReceba() == 0 &&
            carta.getDescricao().equals("Utilize este cartão para se livrar da prisão!")) {
            jogador.cadastrarCartasDoJogador(carta);

        } else if (carta.getPague() == 0 && carta.getReceba() == 0 &&
            carta.getDescricao().equals("Vá para a prisão.")) {
            jogador.setPosicao(30);   //coloca o jogador na casa da prisão

        } else if (carta.getPague() == 0 && carta.getReceba() == 0 &&
            carta.equals("Jogue os dados novamente.")) {
            dado.setDado1(1);    //faz com que os dados fiquem iguais e quando finda esse método
            dado.setDado2(1);     //os dados são lançados novamente.
            duplaIgual--;
        
        } else if (carta.getPague() == 100 && carta.getReceba() == 100 &&
            carta.getDescricao().equals("Sorte se tirou o número par da soma dos dados e revés caso contrário.")) {
            if ((dado.getDado1() + dado.getDado2()) % 2 != 0) {
                System.out.println("Revés, a soma dos dados deram ímpar.");
                banco.sacaDoSaldo(jogador, carta.getPague());
            } else {
                System.out.println("Sorte, a soma dos dados deram par.");
                banco.creditarEmConta(jogador, carta.getReceba());
            }
        
        }else if (carta.getPague() > 0 && carta.getReceba() == 0) {  //se pague for maior que zero e receba for igual a zero faça:
            System.out.println("Pague ao Banco R$" + carta.getPague());
            banco.sacaDoSaldo(jogador, carta.getPague());
        } else if (carta.getPague() == 0 && carta.getReceba() > 0) {  //se pague for igual a zero e receba for maior que zero faça:
            System.out.println("O banco lhe pagou R$" + carta.getReceba());
        }
    }
    
    //Metodo que pende jogador
    public void prendeJogador(Prisao p, Jogador jogador){
        p.getPreso().add(jogador);
    }
    
    //Retorna jogador que está preso na prisão.
    public Jogador retornaJogadorPreso(Jogador jogador) {
        for (Cartas p : this.cartaTabuleiro) {
            if (p instanceof Prisao) {
                Prisao prisao = (Prisao) p;
                if (prisao.getPreso().contains(jogador)) {
                    return jogador;
                }
            }
        }
        return null ;
    }
    
    //Tira Jogador da Prisao
    public void tiraJogadorDaPrisao(Jogador jogador) {
        for (Cartas p : this.cartaTabuleiro) {
            if (p instanceof Prisao) {
                Prisao prisao = (Prisao) p;
                if (prisao.getPreso().contains(jogador)) {
                    prisao.getPreso().remove(jogador);
                }
            }
        }
    }

    //Método que retorna toda a lista de cartas.
    public ArrayList<Cartas> getcartaTabuleiro() {
        return this.cartaTabuleiro;
    }

    //Método que retorna toda a lista de cartas do sorte ou reves
    public ArrayList<Cartas> getCartaSorteOuReves() {
        return cartaSorteOuReves;
    }

    //Metodo que seta a lista de carta embaralhada do sorte ou reves
    public void setCartaSorteOuReves(ArrayList<Cartas> cartaSorteOuReves) {
        this.cartaSorteOuReves = cartaSorteOuReves;
    }

}
