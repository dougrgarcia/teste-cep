## Teste CEP

### API para retorno do endereço do CEP informado

<!--ts-->
   * [Sobre](#Sobre)
   * [Instalação](#Instalação)
   * [Baixar_Projeto](#Baixar_Projeto)
   * [Importar_Projeto](#Importar_Projeto)
   * [Executar_Projeto](#Executar_Projeto)
   * [Executar_Testes](#Executar_Testes)
   * [Autor](#Autor)
<!--te-->

# Sobre
Para a realização do teste foi usada a linguagem Java, utilizando a ferramenta Spring Boot.
A escolha dessa linguagem foi feita, pois funciona de forma otimizada em diferentes sistemas operacionais, é gratuita, está no mercado há muito tempo e também por ser a mais usada, tornando a busca de solução para os problemas e dúvidas bem mais fácil!

A IDE Spring foi escolhida, e utilizada, por facilitar algumas configurações necessárias  para uma maior produtividade, como por exemplo o "Maven".
Para a documentação, foi disponibilizado este arquivo README, além dos comentários no código e as rotinas de teste usando o JUnity e também o Swagger.

O projeto tem o objetivo retornar o endereço do CEP informado. 
Caso não encontre, ele mesmo fará alteração dos números (da direira para a esquerda) por "0",  até que encontre. Se por ventura, substituir todos os números por "0" e ficar "00000000", o sistema retorna "CEP inválido"; essa mensagem também será exibida, quando o CEP  não contiver  a quantidade correta de (oito) dígitos, ou que tenha algum caracter não numérico.

# Instalação
	Para a execução do projeto será necessário ter instalado o Java, em sua máquina, que pode ser baixado no link abaixo:
	https://www.java.com/pt-BR/download/ 
Neste link será sugerido a versão compatível  com sua máquina, basta baixar e instalar.
Será necessário também ter o JDK que pode ser baixado em: https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html, 
Ao entrar no link acima, basta baixar a versão compatível com o seu sistema operacional e instalar.
Também é preciso ter o SpringBoot instalado, para isso basta acessar o link: https://spring.io/tools Sempre lembrando em escolher a versão compatível com o seu sistema operacional para instalar.

# Baixar_Projeto
	Para baixar o projeto basta ter o git instalado na sua maquina, caso não tenha baixe-o em: https://git-scm.com/downloads e instale, lembrando sempre de escolher a versão compativel com o seu S.O.
	Crie uma pasta onde ficará o projeto.
	Execute o Git Bash e navegue até à pasta criada
	Já na pasta, basta colocar o comando: git clone https://github.com/dougrgarcia/teste-cep.git

# Importar_Projeto
	Abrir o Spring.
	Clicar em "File".
	Clicar em "Import".
	Clicar em "Maven" -> "Existing Maven Projects" -> "Next".
	Clicar em "Browse", escolher o diretório onde está o projeto.
	Clicar em "Finish".

# Executar_Projeto
#### Após abrir o projeto no Spring, na lateral esquerda na aba denominada "Workspace", aparecerá o projeto denominado "cep", basta:
	clicar com o botão direito do mouse sobre "cep"
	clicar em "Run As" 
	depois clicar em "Spring Boot App"
#### Após executar o procedimento acima já é possível consumir essa API, através do navegador, onde basta colocar a url: "http://localhost:8080/cep/" e adicionar o CEP desejado na frente.Obs: use somente números.
#### Também é possível usar o PostMan usando a mesma URL usada acima.
#### Exemplo de uso: http://localhost:8080/cep/14406515
#### Ainda é possível executar a API e ver exemplos acessando: "http://localhost:8080/swagger-ui.html" que é o link da documentação utilizando o Swagger.

# Executar_Testes
Para a execução da classe de testes basta abrir o Projeto no SpringBoot e na aba "Workspaces" navegar até o diretório "/cep/src/test/java/br/com/teste/cep", assim será exibida uma classe chamada "CepApplicationTests.java", basta clicar com o botão direito do mouse sobre esta classe e clicar em:
	Run As
	JUnit Test
Neste momento, os testes deverão ser executados e mostrar todos verdes, indicando o sucesso em sua execução!


# Autor
#### Douglas Rodrigues Garcia
#### e-mail: dougrgarcia92@gmail.com
