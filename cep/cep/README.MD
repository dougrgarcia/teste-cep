#Teste CEP

###API para retorno do endereço do CEP informado

<!--ts-->
   * [Sobre](#Sobre)
   * [Instalação](#Instalação)
   * [Importar Projeto](#Importar Projeto)
   * [Executar Projeto](#Executar Projeto)
   * [Executar Testes](#Executar Testes)
   * [Autor](#Autor)
<!--te-->

#Sobre
Para a realização do teste foi usado a linguagem java, utilizando o a ferramenta Spring Boot.
A escolha da linguagem foi feita devido a funcionar bem em diferentes sistemas operacionais, ser gratuita, estar no mercado a muito tempo além de ser a mais usada, tornando a busca solução para problemas e duvidas bem mais facil!

A IDE Spring escolhida e utilizada por facilitar algumas configurações necesarias para uma maior produtividade, como por exemplo o "Maven".
Para a documentação, foi disponibilizado este arquivo README, além dos comentarios no código e as rotinas de teste usando o JUnity e também foi usado o Swagger.

O projeto tem o objetivo retornar o endereço do cep informado, caso não encontre vai alterando os numero da direira para a esquerda por "0" até que encontre, caso substitua todos os numero por "0" e fique "00000000" o sistema retorna "cep invalido", essa mensagem também é exibida, quando o cep não contem o numero correto de caracteres que é oito, ou que tenha algum caracter não numerico.

#Instalação
	Para a execução do projeto será necessário ter instalado na maquina o Java que pode ser baixado no link https://www.java.com/pt-BR/download/ neste link já será sugerido a versão compativel com sua maquina, basta baixar e instalar.
	Será necessário também ter o JDK que pode ser baixado em https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html, ao entrar neste link basta baixar a versão compativel com o seu sistema operacional e instalar.
	Também será necessário ter o SpringBoot instalado, para isso basta acessar o link https://spring.io/tools escolher a versão compativel com o seu sistema operacional e instalar.

#Importar Projeto
	Abrir o Spring.
	Clicar em "File".
	Clicar em "Import".
	Clicar em "Maven" -> "Existing Maven Projects" -> "Next".
	Clicar em "Browse", escolher o diretorio onde está o projeto.
	Clicar em "Finish".

#Executar Projeto
####Após abrir o projeto no Spring, na lateral esquerda na aba denominada "Workspace", aparecerá o projeto denominado "cep", basta:
	clicar com o botão direito do mouse sobre "cep"
	clicar em "Run As" 
	depois clicar em "Spring Boot App"
####Após executar o procedimento acima já é possivel consumir essa api, atavés do navegador, onde basta colocar no navegador a url "http://localhost:8080/cep/" e adicionar o cep desejado na frente, obs: somente numeros.
####Também é possivel usar o PostMan usando a mesma URL usada acima.
####Exemplo de uso: http://localhost:8080/cep/14406515
####Também é possivel executar a api e ver exemplos acessando "http://localhost:8080/swagger-ui.html" que é o link da documentação utilizando o Swagger.

#Executar Testes
Para a execução da classe de testes basta abrir o Projeto no SpringBoot e na aba "Workspaces" navehar até o diretorio "/cep/src/test/java/br/com/teste/cep", neste momento será possivel ver uma classe chamada "CepApplicationTests.java", basta clicar com o botão direito do mouse sobre esta classe e clicar em:
	Run As
	JUnit Test
Neste momento os testes deverão ser executados e mostrar todos verdes, indicando o sucesso em sua execução!


#Autor
Douglas Rodrigues Garcia
e-mail: dougrgarcia92@gmail.com
