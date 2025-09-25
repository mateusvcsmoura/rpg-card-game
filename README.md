# RPG Card Game de Turnos

Bem-vindo ao RPG Card Game de Turnos! Um jogo de estratégia e sorte para dois jogadores, executado diretamente no seu terminal. Monte seu time de campeões, escolha os melhores para cada duelo e derrote seu oponente em uma batalha épica de melhor de cinco!

## 🔮 Características Principais

* **Batalhas Estratégicas em Turnos:** Pense bem em cada movimento. Atacar com força total ou adotar uma postura defensiva para sobreviver ao próximo golpe? A escolha é sua!
* **Sistema de Classes:** O jogo conta com 3 classes distintas: **Guerreiro**, **Mago** e **Ladino**. Cada uma possui uma faixa de atributos única.
* **Atributos Aleatórios:** Cada personagem gerado no início da partida é único! Seus pontos de vida, poder e defesa são sorteados, garantindo que nenhuma batalha seja igual à outra.
* **Sistema de Vantagens (Counters):** Existe uma relação de "pedra, papel e tesoura" entre as classes. Escolher o campeão certo para enfrentar o oponente pode ser a chave para a vitória!
* **Persistência de Status:** A vida de um personagem não é resetada entre os rounds! Se o seu campeão venceu uma luta por um triz, ele continuará com a vida baixa na próxima vez que você o escolher, adicionando uma camada extra de estratégia.
* **Modo de Jogo MD5:** A partida é uma "melhor de cinco". O primeiro jogador a acumular 3 vitórias é o grande campeão. Caso a partida chegue ao 5º round, o jogador com a maior pontuação vence.

## ⚔️ As Classes

Cada classe tem um estilo de jogo, definido pela sua distribuição de atributos.

| Classe      | Pontos de Poder   | Pontos de Vida | Pontos de Defesa |
| :---------- | :---------------- | :------------- | :--------------- |
| **Guerreiro** | Médio (50-65)     | Alto (68-100)  | Alto (50-66)     |
| **Mago** | Alto (65-81)      | Médio (48-71)  | Baixo (27-43)    |
| **Ladino** | Muito Alto (81-95)| Baixo (26-40)  | Muito Baixo (21-37)|

### Sistema de Vantagens

A classe do seu personagem influencia o dano e a chance de falha ao atacar certos alvos.

* 🪓 **Guerreiro** causa dano massivo contra **Mago**.
* 📜 **Mago** tem vantagem de dano contra **Ladino**.
* 🗡️ **Ladino** causa dano devastador contra **Guerreiro**.

Usar essas vantagens a seu favor é fundamental para vencer!

## 🎮 Como Jogar

1.  **O Início:** No começo da partida, cada jogador recebe um "deck" com 5 personagens gerados aleatoriamente.
2.  **A Escolha do Campeão:** A cada round, você e seu oponente deverão escolher um de seus personagens **vivos** para o duelo. Personagens que morreram em rounds anteriores não podem ser escolhidos novamente.
3.  **O Combate:** A luta acontece em turnos. Na sua vez, você terá duas opções:
    * **1: Atacar:** Causa dano ao oponente baseado no seu poder, na defesa do alvo e nas vantagens de classe. Cuidado, todo ataque tem uma chance de falhar!
    * **2: Defender:** Seu personagem adota uma postura defensiva, reduzindo o dano do próximo ataque que receber.
4.  **Fim do Round:** O combate continua até que um dos personagens seja derrotado. O jogador do personagem sobrevivente ganha 1 ponto.
5.  **A Vitória:** O primeiro jogador a marcar 3 pontos vence a batalha!

## 🚀 Como Executar o Jogo

Você precisa ter o **JDK (Java Development Kit)** instalado em sua máquina.

1.  Clone ou baixe todos os arquivos `.java` para uma única pasta.
2.  Abra o seu terminal (Prompt de Comando, PowerShell, etc.).
3.  Navegue até a pasta onde você salvou os arquivos usando o comando `cd`.
    ```bash
    cd caminho/para/a/pasta/do/jogo
    ```
4.  Compile todos os arquivos Java com o seguinte comando:
    ```bash
    javac *.java
    ```
5.  Se tudo ocorrer bem, execute o jogo:
    ```bash
    java RpgCardGame
    ```

Pronto! A batalha vai começar no seu terminal. Boa sorte!