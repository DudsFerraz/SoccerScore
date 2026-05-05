# SoccerScore

Aplicativo Android desenvolvido como exercício prático para a disciplina de Programação para Dispositivos Móveis - IFSP - Câmpus São Carlos.

## 📱 Sobre o Projeto

O SoccerScore é um simulador de placar de futebol que permite ao usuário inserir os dados de uma partida e visualizar o resultado final. O fluxo do aplicativo é dividido em três telas:
1. **Configuração da Partida:** Coleta o nome e a quantidade de gols do Time A e do Time B. Realiza a validação para garantir que os gols sejam valores numéricos inteiros maiores ou iguais a zero.
2. **Resumo da Partida:** Exibe os nomes dos times e o placar informado, permitindo retornar para edição ou confirmar o resultado.
3. **Resultado Final:** Aplica a regra de negócio para determinar o vencedor ou exibir um empate, com a opção de iniciar um novo jogo retornando à tela inicial.

## 🛠 Tecnologias e Arquitetura

*   **Linguagem:** Kotlin
*   **UI Toolkit:** Jetpack Compose (Programação Declarativa)
*   **Gerenciamento de Estado:** Uso de `rememberSaveable` para retenção dos dados e inputs durante a rotação da tela.
*   **Navegação:** Uso da biblioteca *Navigation Compose* para o tráfego entre telas e passagem de parâmetros via rotas (Single-Activity Architecture).

## ✨ Boas Práticas Implementadas

Além dos requisitos básicos da especificação, este projeto conta com:
*   **Conventional Commits:** Histórico de versionamento limpo e semântico, com o uso de commits atômicos para cada funcionalidade e tela implementada.
*   **Version Catalog:** Gerenciamento centralizado de dependências utilizando o arquivo `libs.versions.toml`, seguindo os padrões mais modernos de build do Android.
*   **Organização e Modularização:** Código devidamente comentado e interface quebrada em funções `@Composable` separadas por arquivos, facilitando a manutenção.
*   **Gerenciamento de Backstack:** Uso da propriedade `popUpTo` na navegação final para limpar a pilha de telas, prevenindo que o usuário volte acidentalmente para a tela de resultado após iniciar um "Novo Jogo".