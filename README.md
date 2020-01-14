## POO PROJECT - VOID TEAM
#####POO Project created by GitHub Classroom
<br>
UNIVERSIDADE FEDERAL DA PARAÍBA
<br>CENTRO DE CIÊNCIAS APLICADAS A EDUCAÇÃO
<br>DEPARTAMENTO DE CIÊNCIA EXATAS
<br>SISTEMAS DE INFORMAÇÃO
<br>Disciplina: Programação Orientada a Objetos
<br<Professor Dr.: Fábio Morais</br>

#####Equipe (Void Team)
<br>Jeane Cardoso dos Santos – Matrícula: 20170049656
<br>Oilzon Inácio dos Santos Filho - Matrícula: 81501610
<br>Waldir Marques de Sousa - Matrícula: 20170149713


####Relatório sobre o sistema do jogo “Banco Imobiliário” 

   <p>O sistema sisBanco_Imobiliario tem até o momento 11 classes (Companhia, Dado, Jogador, Jogo, NormaisCartas, Prisao, Propriedades, SorteOuReves, Tabuleiro e SisBanco_Imobiliario, sendo a última, responsável pela execução principal do sistema, o Main), e 1 interface (Cartas). Todas elas, são por sua vez,   responsáveis pelo armazenamento das propriedades e métodos que o sistema tem.</p> 
   
   <p>Algumas classes, como Companhia, NormaisCartas, Prisao, Propriedades e SorteOuReves, por terem em comum o fato de serem cartas que pertencem ao tabuleiro, são atribuídas a todas, à incumbência de implementar a interface chamada Cartas, criada para fazer o polimorfismo no sistema referente à compra, venda e checagem dos proprietários em propriedades ou companhias, devido elas serem as únicas classes que tem algumas ações implementadas até o momento. Um dos métodos utilizados é o status, que retorna uma string com o nome da carta em questão, podendo ser utilizado por qualquer uma das classes acima  que implementar a interface, e um toString, que retorna todas as informações contidas em cada uma dessas classes.</p>
   
   <p>A classe Tabuleiro é responsável por instanciar dentro do seu construtor, cada uma das classes que implementam a interface Cartas, e o coloca dentro de um ArrayList do mesmo tipo, essa lista fará o papel do tabuleiro do jogo. 
A classe Jogo, cadastra os jogadores colocando-os dentro de uma ArrayList do tipo jogador, além disso, ela possui métodos que verifica se os jogadores pegam peças iguais, se escolhem uma cor estabelecida pelo sistema e se o usuário coloca uma quantidade de jogadores que o sistema consegue suportar.</p>
   
   <p>Na classe Jogador, além os atributos essenciais como nome, saldo, cor referente ao peão e demais atributos, possui o método que cadastra carta em um ArrayList do tipo Cartas, quando ele efetua a compra da carta, e um método statusJogador, que printa o algumas das propriedades e outras informações que jogador possui.
Dado, é classe responsável por simulam as ações de um dado no jogo, onde um dos seus métodos arremessa dois deles, e outro retorna a soma dos mesmos, soma essa que sinaliza a quantidade de casas que o jogador deve pular no tabuleiro. A classe Banco que tem como atributo um jogador, permite que seja perante os métodos sacarDeConta e creditarEmConta, possível diminuir e aumentar saldo do jogador.</p> 

####Como utilizar o sistema do jogo Banco Imobiliário - Manual
 
<blockquote>int numeroDeJogador = inputComInt("Digite o número de jogadores [2-8]: ", leitor);</blockquote> 
 
<p>Nesse input, se o usuário selecionar um número entre 2 e 8, o jogo começa a pedir o nome do jogador e a cor do peão que ele pretende selecionar, se por caso o jogador selecione uma cor já cadastrada no sistema, será reportada uma mensagem dizendo "Peça não suportada ou Peça já selecionada por outro jogador!", então é permitido nova tentativa de fazer a inscrição. Se o número informado for diferente dessa faixa, o sistema manda uma mensagem dizendo "Número de Jogadores não suportado pelo sistema!", e o jogo é finalizado.</p>
 
<blockquote>System.out.println("Comandos disponíveis: [jogar][status][sair]");
String comando = input("Entre com um comando: ", leitor);</blockquote>
 
   <p>Nessa nova entrada de dados,o usuário do sistema é encarregado de informar qual dos três comandos acima ele quer executar, caso ele digite algum comando que não esteja na mensagem de entrada de dados, o sistema retorna para o usuário a mensagem de “Comando não aceito”, e permite novamente que ele entre com um novo comando. Caso o jogador escolha sair, o jogo pergunta se ele quer realmente essa opção, caso queira o jogo é encerrado.</p> 
   
   <p>Caso ele escolha jogar, os dados da classe Dado serão postos em ação, lançando automaticamente os dados, e então será mostrado ao jogador uma mensagem com seu nome, a cor do seu peão, o valor individual de cada um dos dois dados, e o número de casas que ele vai pular, além de retornar o nome da carta que ele caiu no tabuleiro. Dependendo do tipo da carta que o jogador parou, será verificado se a mesma possui proprietário ou não, caso tenha será cobrado aluguel ao jogador que caiu em uma propriedade alheia, pagando o proprietário da carta, caso não, será perguntado ao jogador se ele quer adquirir a propriedade da carta.</p>
   
   <p>Se na hora da compra ele digitar um comando inválido, o jogo permitirá que ele tente novamente. No momento apenas acontecem ações nas cartas de Propriedades e Companhia, as demais ainda serão implementadas nos próximos stories. Por fim, se o usuário escolher exibir seu status, será mostrado ao mesmo as suas propriedades e/ou companhias adquiridas no decorrer do jogo, além do valor que ele possuir em saldo e seu nome. Caso ele não tenha nenhuma propriedade ou companhia, será mostrada uma mensagem dizendo “O jogador não tem cartas para mostrar no status”.</p>

####Análise geral do sistema

   <p>Com base no que foi apresentado de forma geral sobre o sistema do jogo Banco Imobiliário, devemos dizer que como todo sistema em fase inicial ainda apresenta algumas falhas que poderão e deverão ser tratadas posteriormente. A cada modificação que surge no sistema, testes estão sendo elaborados e executados para testar métodos em determinadas classes para fazer o uso de forma apropriada, sem trazer complicações para o usuário final.</p> 

   <p>A ferramenta utilizada é o JUnit, um framework que facilita a criação dos códigos, que pode tornar os testes automáticos e fazer melhor uso dos métodos no sistema. A princípio, um pacote “extra” (Monopoly2) do sistema foi criado para fazer o teste com o lançamento dos dados, que verificava se o random não produzia números maiores que 6 e menores que um e se a soma de ambos dados não excedia a quantidade máxima permitida dos números dos dados, no caso 12.</p> 
   
   <p>Outro teste elaborado, utilizou a classe Jogador e Banco. O objetivo dos testes seria aprimorar o código que selecionava o nome da peça que o jogador escolhe no início do jogo. Caso ele escolhesse uma peça que não esteja disponível das cores, o objetivo é retornar um erro para o jogador e fazer com que ele escolha uma cor válida para o peão. Posteriormente, o outro teste pegava o saldo que o jogador possui em conta e testava os métodos que creditava e debitava saldo do jogador.</p>
   
   <p>Os testes serão modificados, pois a cada mudança que existe nos códigos de determinadas classes, alteram parte do que já existe, mas tudo será aprimorado para poder fazer um sistema funcional e fácil de ser executado.</p>

####Mudanças na implementação de novos stories 
<br>
    <p>Após a implementação dos outros stories acrescentamos a classe Banco, com o propósito inicial de creditar e debitar do saldo da conta dos jogadores, pois futuramente será necessário implementar outras funções relativas ao Banco.</p>
    <p>A jogabilidade possui a mesma funcionalidade do stories anterior, porém, quando o jogador pedia para exibir o <i>status</i> nada era exibido, e na medida que os dados são lançados e o jogador compra alguma companhia, propriedade ou título, tudo isso fica armazenado no status, por exemplo:</p>
<br>
   <p>Logo abaixo, vemos o exemplo da compra de uma companhia, onde o sistema do jogo questiona e o jogador responde de acordo com os comandos disponíveis:
     
     A jogada de Mathew (preto) começou
     Comandos disponíveis: [jogar][status][sair]
     Digite um comando:
     jogar
     
     O jogador Mathew (preto) tirou 1 , 4 e o peão avançou para 5 --- Companhia Ferroviaria
     O título da companhia Companhia Ferroviaria está disponível por R$ 200
     Mathew, você possui R$ 1500
     Você deseja comprar Companhia Ferroviaria S/N?
     s    
   
   <p>Aqui abaixo, vemos um exemplo prático do funcionamento do <i>SisBanco_Imobiliario</i>:</p>
        
        
       Digite o número de jogadores [2-8]: 
       2
       Digite o nome do jogador 1:
       Mathew
       Escolha a cor do peão do jogador 1 entre as opções seguintes: 
       [preto][branco][vermelho][verde][azul][amarelo][laranja][rosa]:
       preto
       Digite o nome do jogador 2:
       Sharon
       Escolha a cor do peão do jogador 2 entre as opções seguintes: 
       [preto][branco][vermelho][verde][azul][amarelo][laranja][rosa]:
       branco
       
       O Banco Imobiliário vai começar. Aproveite!
       
       A jogada de Mathew (preto) começou
       Comandos disponíveis: [jogar][status][sair]
       Digite um comando: 
       jogar
       
       O jogador Mathew (preto) tirou 5 , 3 e o peão avançou para 8 --- Av. Rebouças
       O título da propriedade Av. Rebouças está disponível por R$ 220
       Mathew, você possui R$ 1500
       Você deseja comprar Av. Rebouças de tipo azul S/N?
       s
       
       Compra realizada com sucesso!
       
       A jogada de Sharon (branco) começou
       Comandos disponíveis: [jogar][status][sair]
       Digite um comando: 
       jogar
       
       O jogador Sharon (branco) tirou 6 , 2 e o peão avançou para 8 --- Av. Rebouças
       A propriedade já tem dono, você vai pagar 18 de aluguel
       
       A jogada de Mathew (preto) começou
       Comandos disponíveis: [jogar][status][sair]
       Digite um comando: 
       status
       
       O status de Mathew -- preto é o seguinte: 
       Situado na posição 8 - Av. Rebouças Possui R$ 1298
       Titulos: 
       [Av. Rebouças] propriedade azul, aluguel 18

   
   <p>Vimos aqui um exemplo de como as jogadas do sistema funciona. O jogador <i>Mathew</i> em sua primeira jogada, compra uma propriedade no valor de R$220,00. Quando o jogador <i>Sharon</i> lança os dados, acontece de cair no mesmo local que o primeiro jogador já havia comprado e em sequencia, o segundo jogador paga um aluguel ao primeiro jogador, pelo fato de ter caído na propriedade que já possui um dono.</p>
   <p>Esse é o funcionamento básico do sistema, e em breve serão implantados outros <i>stories</i> para dar continuidade a uma boa jogabilidade aos usuários.
   <p>Com algumas pequenas mudanças o <i>SisBanco_Imobiliario</i> ficou da seguinte forma:</p>
       
        ⟝ ★★★★★★★★★★    BANCO IMOBILIÁRIO    ★★★★★★★★★★ ⟞
        
        
        DIGITE O NÚMERO DE JOGADORES [2-8]: 
        2
        
        DIGITE O NOME DO JOGADOR 1:
        Mathew
        
        Mathew, escolha a cor de um peão entre as opções seguintes: 
        
        {preto} ★ {branco} ★ {vermelho} ★ {verde} ★ {azul} ★ {amarelo} ★ {laranja} ★ {rosa}
        
        DIGITE APENAS O NOME DA COR:
        preto
        
        DIGITE O NOME DO JOGADOR 2:
        Sharon
        Sharon, escolha a cor de um peão entre as opções seguintes: 
        
        {preto} ★ {branco} ★ {vermelho} ★ {verde} ★ {azul} ★ {amarelo} ★ {laranja} ★ {rosa}
        
        DIGITE APENAS O NOME DA COR:
        branco
        
        O jogo vai começar. Aproveite!
        
        A jogada de Mathew (preto) começou
        Comandos disponíveis: [jogar][status][sair]
        Digite um comando: 
        status
        
        O status de Mathew -- preto é o seguinte: 
        Você ainda não possui nenhum título, companhia ou propriedade. Tente realizar uma jogada!
        
        A jogada de Mathew (preto) começou
        Comandos disponíveis: [jogar][status][sair]
        Digite um comando: 
        jogar
        
        O jogador Mathew (preto) tirou 4 , 3 e o peão avançou para 7 --- Companhia de Viação
        O título da companhia Companhia de Viação está disponível por R$ 200
        Mathew, você possui R$ 1500
        Você deseja comprar Companhia de Viação S/N?
        s
        
        Compra realizada com sucesso!

   <p> O exemplo acima mostra as funcionalidades básicas do sistema e a cada modificação mais funções irão sendo implementadas. Há ainda uma duplicação de código na classe principal, e estamos avaliando a melhor forma possível de fazer um refatoramento do código para melhorar a legibilidade e o seu funcionamento.</p> 