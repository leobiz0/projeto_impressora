public class Usuario {
    private String login;
    private String senha;

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public boolean autenticar(String loginDigitado, String senhaDigitada) {
        return login.equals(loginDigitado) && senha.equals(senhaDigitada);
    }
}