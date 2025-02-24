# Appium Automation - Álcool ou Gasolina

## Descrição
Este projeto tem como objetivo automatizar testes de um aplicativo móvel que auxilia na decisão entre álcool ou gasolina. A automação foi desenvolvida utilizando **Java 21**, **Appium**, **JUnit Jupiter** e **Allure Reports** para garantir testes eficientes, confiáveis e bem documentados.

## Tecnologias Utilizadas
- **Java 21**: Linguagem de programação utilizada no projeto.
- **Appium 9.4.0**: Framework para automação de testes mobile.
- **JUnit Jupiter 5.11.0**: Estrutura de testes para organização e execução dos casos de teste.
- **Allure Reports 2.25.0**: Geração de relatórios interativos para análise dos testes.
- **Maven**: Gerenciamento de dependências e execução dos testes automatizados.
- **Android SDK**

## Configuração do Ambiente
1. Instale o [Java 21]
2. Instale o [Maven] e configure a variável de ambiente.
3. Instale o [Appium] e seus drivers necessários.
4.  Instale o [Allure] Para visualizar o relatório.
5.  Instale o [Androis SDK] para executar o emulador.
6.  Instale o [Androis Studio] para criar o emulador.
7. Clone este repositório:
   ```sh
   git clone https://github.com/seu-usuario/Appium_automation_alcool_ou_gasolina.git
   ```
8. Navegue até o diretório do projeto e execute os testes:
   ```sh
   mvn clean test
   ```
## Geração de Relatórios
Após a execução dos testes, os relatórios Allure podem ser gerados e visualizados com os comandos:
```sh
allure generate
allure open
```
Isso abrirá um relatório interativo no navegador.
