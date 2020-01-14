package br.ufpb.sisBanco_Imobiliario;

import java.util.Scanner;

public class SisBanco_Imobiliario {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Dado dado = new Dado();                          //Instancia dado
        Tabuleiro tabuleiro = new Tabuleiro();           //Instancia tabuleiro
        Jogo jogo = new Jogo();                          //Instancia Jogo
        Banco banco = new Banco();                       //Instancia Banco

        System.out.println("\n⟝ ★★★★★★★★★★    BANCO IMOBILIÁRIO    ★★★★★★★★★★ ⟞\n\n");

        int numeroDeJogador = inputComInt("DIGITE O NÚMERO DE JOGADORES [2-8]: ", leitor);          //Pega a quantidade de jogadores para iniciar o jogo.
        boolean verificaNumJogadores = jogo.verificaNumeroDeJogadores(numeroDeJogador);                         //Verifica se a quantidade de jogadores é suportada.
        if (verificaNumJogadores) {
            int index = 1;              //Usado para mostrar qual dos jogadores está digitando.
            while (index <= numeroDeJogador) {
                String nomeJogador = input("\nDIGITE O NOME DO JOGADOR " + index + ":", leitor);
                String corPeca = input(nomeJogador + ", escolha a cor de um peão entre as opções seguintes: \n\n"
                        + "{preto} ★ {branco} ★ {vermelho} ★ {verde} ★ {azul} ★ {amarelo} ★ {laranja} ★ {rosa}\n\nDIGITE APENAS O NOME DA COR:", leitor);
                boolean verificaCorJogador = jogo.verificaPecaJogador(corPeca);
                boolean verificaPecasIguais = jogo.verificaPecaIguais(corPeca);
                if (verificaCorJogador && (!verificaPecasIguais)) {
                    jogo.cadastrarJogadores(new Jogador(nomeJogador, corPeca));                 //Cadastra um novo jogador em cada iteração do laço.
                    index++;
                } else {
                    System.out.println("Peça não suportada ou selecionada por outro jogador!");
                }
            }
            System.out.println("\nO jogo vai começar. Aproveite!");

            tabuleiro.embaralhaCartasDoSorteOuReves(); // Método que embaralha as cartas do jogo (sorte e reves)
            int localDoJogador = 0;               //Indice necessario para pegar jogador na lista de jogadores que se encontra no objeto jogo.

            while (jogo.getJogadores().size() != 1) {   //Enquanto não existe um unico jogador na lista, o jogo não tem campeão, e como consequencia o jogo continua
                Jogador jogador = jogo.getJogadores().get(localDoJogador);          //Pega da lista de jogadores de jogo, um sogador. E o instacia como um objeto do mesmo
                String comando = "";  //String comando é responsavel por guardar o comando
                Jogador presoJogador = tabuleiro.retornaJogadorPreso(jogador);  //Pega jogador que está preso
                SorteOuReves carta = (SorteOuReves) jogo.verificaCartaSaidaLivrePrisao(jogador);

                if (presoJogador != null) {  //Verifica se tem jogador preso
                    System.out.println(jogador.getNome() + " está na prisão.");  //Mostra as opções caso o jogador tenha uma carta de saída livre da prisão
                    System.out.println("Comandos disponíveis: [jogar][status][sair][pagar][carta]");
                    String comando2 = input("Entre com um comando: ", leitor);
                    switch (comando2) {
                        case "pagar":
                            System.out.println("Comandos disponíveis: [jogar][status][sair]");
                            comando = input("Digite um comando: ", leitor);
                            tabuleiro.tiraJogadorDaPrisao(jogador);
                            break;
                        case "carta":
                            if (carta != null) { //caso o jogador tenha uma carta que permite sua saida da prisão
                                System.out.println("Comandos disponíveis: [jogar][status][sair]");
                                comando = input("Digite um comando: ", leitor);
                                jogo.removeCartaDepoisDeUsada(jogador, carta); //tira a carta de saída livre do jogador para que ele não use novamente.
                                tabuleiro.tiraJogadorDaPrisao(jogador);
                            } else {
                                System.out.println("Você não tem cartas para ser liberto da prisão!");
                            }
                            break;
                        case "jogar":
                            dado.lancarDado();
                            if (dado.verificaIguais(dado.getDado1(), dado.getDado2())) {
                                comando = "jogar";
                                //Arrumar uma maneira de fazer com que o dado não seja jogado mais de uma vez aqui e lá em baixo.
                            } else {
                                System.out.println("\nO jogador " + jogador.getNome() + " (" + jogador.getCor() + ") "
                                        + "tirou " + dado.getDado1() + " , " + dado.getDado2() + " e não conseguiu sair da prisão");
                            }
                            break;
                        case "status":
                            comando = "status";
                            break;
                        case "sair":
                            comando = "sair";
                            break;

                        default:
                            comando = "";
                            localDoJogador--;
                            break;
                    }

                } else {

                    System.out.println("\nA jogada de " + jogador.getNome() + " (" + jogador.getCor() + ") começou");
                    System.out.println("Comandos disponíveis: [jogar][status][sair]");
                    comando = input("Digite um comando: ", leitor);
                }

                if (comando.equals("jogar")) {
                    boolean continuacao = true;
                    while (continuacao) {
                        dado.lancarDado();
                        int numeroDeCasas = 0;
                        int duplaIgual = 0;
                        numeroDeCasas += dado.somaDoLancamentoDado(dado.getDado1(), dado.getDado2());        //Mosta a quantidade de casa para pular.

                        jogador.aumentarPosicao(numeroDeCasas);                 //Método que Seta posição atual do jogador no tabuleiro, e que apartir de seu avanço aumenta no tabuleiro.
                        System.out.println("\nO jogador " + jogador.getNome() + " (" + jogador.getCor() + ") "
                                + "tirou " + dado.getDado1() + " , " + dado.getDado2() + " e o peão avançou para " + jogador.getPosicao() + " --- "
                                + tabuleiro.retornaCartaAtual(jogador.getPosicao()).status());

                        Cartas cartaDoJogador = tabuleiro.retornaCartaAtual(jogador.getPosicao());         //método que busca uma cata na lista de cartas, tendo como indece número que se é sorteado na class Dado.


                        //TODO: Resolver posteriormente problema de code duplicado;
                        //Provavelmente, factory method;
                        if (cartaDoJogador instanceof Propriedades) {
                            Propriedades propriedade = (Propriedades) cartaDoJogador;
                            if (propriedade.getDono() == null) {                                  //A propriedade tem dono?, se não continua.
                                System.out.println("O título da propriedade " + propriedade.getNome() + " está disponível por R$ " + propriedade.getPreco());
                                System.out.println(jogador.getNome() + ", você possui R$ " + jogador.getSaldo());
                                String compraCarta = input("Você deseja comprar " + propriedade.getNome() + " de tipo " + propriedade.getCor() + (" S/N?"), leitor);
                                if (jogador.getSaldo() < propriedade.getPreco()) {
                                    System.out.println("\nDinheiro insuficiente para obter propriedade!");
                                } else if (compraCarta.equalsIgnoreCase("n")) {
                                    System.out.println("\nCompra não realizada!");
                                } else if (jogador.getSaldo() >= propriedade.getPreco() && compraCarta.equalsIgnoreCase("s")) {
                                    jogador.cadastrarCartasDoJogador(cartaDoJogador);     //Chama método que cadastra uma carta em jogador, e cadastra uma.
                                    banco.sacaDoSaldo(jogador, propriedade.getPreco());//Chama método debitar de jogador e diminui dependendo do preço do aluguel da casa.
                                    propriedade.setDono(jogador);                         //Seta dono  na casa, tendo em vista que jogador agora tem a carta que caba de comprar.
                                    System.out.println("\nCompra realizada com sucesso!");
                                } else {
                                    System.out.println("\nComando não aceito pelo sistema!");
                                    dado.setDado1(0); // faz com que o jogador mesmo tiraando uma dupla igual, não arremece os
                                    dado.setDado2(1); // dados novamente por motivo de ter dado uma entrada errada.
                                    localDoJogador--; //evita que o jogador mude de posição na proxima rodada depois que o jogador erra o comando.
                                    jogador.setPosicao(dado.somaDoLancamentoDado(dado.getDado1(), dado.getDado2() - 1));
                                    
                                    
                                }
                            } else {
                                //Quando o jogador cai na casa que tem como dono outro jogador, se paga um aluguel.
                                System.out.println("A propriedade já tem dono, você vai pagar " + propriedade.getAluguelSemCasas() + " de aluguel");
                                banco.sacaDoSaldo(jogador, propriedade.getAluguelSemCasas());  //Diminui do dinheiro de jogador o valor da propriedade.
                                banco.creditarEmConta(propriedade.getDono(), propriedade.getAluguelSemCasas());  //Credita no dono da carta o valor do aluguel sem casas que o jogador tirou.
                            }
                        } else if (cartaDoJogador instanceof Companhia ) {
                            //Caso a carta seja uma companhia acontece ações  que seram definidas.
                            Companhia companhia = (Companhia) cartaDoJogador;
                            if (companhia.getDono() == null) {                                  //A companhia tem dono?, se não, continua.
                                System.out.println("O título da companhia " + companhia.getNome() + " está disponível por R$ " + companhia.getPreco());
                                System.out.println(jogador.getNome() + ", você possui R$ " + jogador.getSaldo());
                                String compraCarta = input("Você deseja comprar " + companhia.getNome() + (" S/N?"), leitor);
                                if (jogador.getSaldo() < companhia.getPreco()) {
                                    System.out.println("\nDinheiro insuficiente para obter companhia!");
                                } else if (compraCarta.equalsIgnoreCase("n")) {
                                    System.out.println("\nCompra não realizada!");
                                } else if (jogador.getSaldo() >= companhia.getPreco() && compraCarta.equalsIgnoreCase("s")) {
                                    jogador.cadastrarCartasDoJogador(cartaDoJogador);      //Chama método que cadastra uma carta em jogador, e cadastra uma.
                                    banco.sacaDoSaldo(jogador, companhia.getPreco());             //Chama método debitar de jogador e diminui dependendo do preço do aluguel da casa.
                                    companhia.setDono(jogador);                            //Seta dono  na casa, tendo em vista que jogador agora tem a carta que caba de comprar.
                                    System.out.println("\nCompra realizada com sucesso!");
                                } else {
                                    System.out.println("\nComando não aceito pelo sistema!");
                                    dado.setDado1(0); // faz com que o jogador mesmo tiraando uma dupla igual, não arremesse os
                                    dado.setDado2(1); // dados novamente por motivo de ter dado uma entrada errada.
                                    localDoJogador--; //evita que o jogador mude de posição na proxima rodada depois que o jogador erra o comando.
                                    jogador.setPosicao(dado.somaDoLancamentoDado(dado.getDado1(), dado.getDado2() - 1));
                                 
                                }

                            } else {
                                int valorPagar = (dado.getDado1() + dado.getDado2() * companhia.getMultiplicador());
                                System.out.println("A Companhia já tem dono, você vai pagar " + valorPagar + " de aluguel.");
                                banco.sacaDoSaldo(jogador, valorPagar);  //Diminui do dinheiro de jogador o valor da propriedade.
                                banco.creditarEmConta(companhia.getDono(), valorPagar);  //Credita no dono da carta o valor do aluguel sem casas que o jogador tirou
                            }
                        } else if (cartaDoJogador instanceof SorteOuReves) {
                            SorteOuReves sorteOuReves = (SorteOuReves) tabuleiro.retornaCartaSorteOuReves();
                            System.out.println(sorteOuReves.getDescricao());
                            tabuleiro.acoesDoSorteOuReves(sorteOuReves, jogador, jogo.getJogadores(), banco, dado, duplaIgual);
                            leitor.nextLine();

                        } else if (cartaDoJogador instanceof Prisao) {
                            Prisao prisao = (Prisao) cartaDoJogador;
                            System.out.println("Testando quantidade = " + prisao.getPreso().size());
                            if (prisao.getNome().equals("Vá para a prisão!")) {
                                tabuleiro.prendeJogador(prisao, jogador); //faz com que o jogador fique preso
                            }
                        } else {
                            //Implementação nas proximas story às ações a serem realizadas caso o jogador pegue algum outro tipo de carta.
                            System.out.println("Nada aconteceu!");
                        }

                        if (dado.verificaIguais(dado.getDado1(), dado.getDado2())) {   //Verifica se os dados dão uma dupla igual, caso de é permitido o lançamento do daado novamente.
                            System.out.println("\nOs dados seram arremessados novamente! ");
                            duplaIgual += 1;
                            if (duplaIgual == 3) {
                                System.out.println("\nO jogador vai para a prisão!");
                                jogador.setPosicao(30);   //Faz com que o jogador vá para a carta de prisão que se localiza na posição 30 do tabuleiro
                                continuacao = false;         //sai do laço
                            }
                        } else {
                            continuacao = false;   //sai do laço
                        }
                    }
                } else if (comando.equals("status")) {   //case "status":
                    System.out.println("\nO status de " + jogador.getNome() + " -- " + jogador.getCor() + " é o seguinte: ");
                    jogador.statusJogador();   // chamada de método que apresenta o status do jogador.
                    localDoJogador++;         //Responsavel por incrementar o local do jogador
                } else if (comando.equalsIgnoreCase("sair")) {  //caso o jogador queira sair
                    String opcao = input("\nVocê realmente quer sair (S/N)?", leitor);
                    if (opcao.equalsIgnoreCase("s")) {
                        System.out.println("\nJogo encerrado!");
                        break;
                    }
                } else {
                    System.out.println("\nComando inválido!"); // informa que o comando é invalido e decrementa vez do jogador para que
                    localDoJogador--;       // não mude de jogador.
                }
                localDoJogador++;       //Responsável por incrementar o local do jogador
                if (localDoJogador >= jogo.getJogadores().size()) {   //Verifica se o local do jogador é o último
                    localDoJogador = 0;                               //Zera local do jogador para continuar pegando a posição correta do jogador.
                }
            }
        } else { //entra quando o usuário entra com um número não suportado pelo sistema
            System.out.println("Quantidade de Jogadores não suportado pelo sistema!");
            leitor.close();
        }
    }
    //Método statico que que os inputs do tipo String do usuário.
    private static String input(String textoMostrado, Scanner leitor) {
        System.out.println(textoMostrado);
        return leitor.nextLine();
    }

    //Método estático: inputs do tipo int do usuário.
    private static int inputComInt(String textoMostrado, Scanner leitor) {
        return Integer.parseInt(input(textoMostrado, leitor));
    }

}