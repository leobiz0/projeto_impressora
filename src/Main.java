public class Main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("admin", "1234");
        Impressora impressora = new Impressora();

        if (!fazerLogin(usuario)) {
            return;
        }

        int opcao;
        do {
            mostrarMenu();
            opcao = Entrada.lerInteiro("Escolha uma opção: ", 0, 12);
            switch (opcao) {
                case 1 -> Impressora.configurarConexao(impressora);
                case 2 -> impressora.abrirConexao();
                case 3 -> impressora.fecharConexao();
                case 4 -> {
                    if (impressora.verificarConexao()) {
                        String texto = Entrada.lerTexto("Texto a imprimir: ");
                        int copias = Entrada.lerInteiro("Quantas cópias (1 a 5)? ", 1, 5);
                        impressora.imprimirTexto(texto, copias);
                    }
                }

                case 0 -> System.out.println("Saindo...");
            }
        } while (opcao != 0);

        impressora.fecharConexao();
    }

    static void mostrarMenu() {
        System.out.println("\n===== MENU IMPRESSORA ELGIN =====");
        System.out.println("1  - Configurar conexão");
        System.out.println("2  - Abrir conexão");
        System.out.println("3  - Fechar conexão");
        System.out.println("4  - Imprimir texto");
        System.out.println("5  - Imprimir QR Code");
        System.out.println("6  - Imprimir código de barras");
        System.out.println("7  - Imprimir XML SAT");
        System.out.println("8  - Imprimir XML de cancelamento SAT");
        System.out.println("9  - Abrir gaveta");
        System.out.println("10 - Sinal sonoro");
        System.out.println("11 - Avançar papel");
        System.out.println("12 - Status do papel");
        System.out.println("0  - Sair");
    }

    static boolean fazerLogin(Usuario usuario) {
        final int MAX_TENTATIVAS = 3;
        for (int tentativa = 1; tentativa <= MAX_TENTATIVAS; tentativa++) {
            String login = Entrada.lerTexto("Usuário: ");
            String senha = Entrada.lerTexto("Senha: ");
            if (usuario.autenticar(login, senha)) {
                System.out.println("Login realizado com sucesso!");
                return true;
            }
            int restantes = MAX_TENTATIVAS - tentativa;
            if (restantes > 0) {
                System.out.println("Usuário ou senha incorretos. Tentativas restantes: " + restantes);
            }
        }
        System.out.println("Número máximo de tentativas atingido. Encerrando.");
        return false;
    }
}