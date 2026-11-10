import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class Impressora {
    private int tipo = 1;            // 1 = USB
    private String modelo = "i9";
    private String conexao = "USB";
    private int parametro = 0;
    private boolean conexaoAberta = false;

    private static final String ASS_QRCODE_CANCELAMENTO = "CFe13180314200166000166599000108160001324252883";

    public boolean verificarConexao() {
        if (!conexaoAberta) {
            System.out.println("Conexão fechada. Abra a conexão antes.");
        }
        return conexaoAberta;
    }

    private boolean conferir(int retorno, String operacao) {
        if (retorno == 0) {
            System.out.println(operacao + ": sucesso.");
            return true;
        }
        System.out.println("Erro em " + operacao + ". Código: " + retorno);
        return false;
    }
}