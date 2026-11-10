public class Main {
    public static void main(String[] args) {

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