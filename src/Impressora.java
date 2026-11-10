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

    public void configurar(int tipo, String modelo, String conexao, int parametro) {
        if (conexaoAberta) {
            System.out.println("Feche a conexão antes de mudar a configuração.");
            return;
        }
        this.tipo = tipo;
        this.modelo = modelo;
        this.conexao = conexao;
        this.parametro = parametro;
        System.out.println("Configuração salva.");
    }

    public void abrirConexao() {
        if (conexaoAberta) {
            System.out.println("A conexão já está aberta.");
            return;
        }
        try {
            int retorno = ImpressoraDLL.INSTANCE.AbreConexaoImpressora(tipo, modelo, conexao, parametro);
            conexaoAberta = conferir(retorno, "Abrir conexão");
        } catch (LinkageError e) {
            System.out.println("Não foi possível carregar a DLL: " + e.getMessage());
        }
    }

    public void fecharConexao() {
        if (!conexaoAberta) {
            System.out.println("A conexão já está fechada.");
            return;
        }
        int retorno = ImpressoraDLL.INSTANCE.FechaConexaoImpressora();
        if (conferir(retorno, "Fechar conexão")) {
            conexaoAberta = false;
        }
    }

    static void configurarConexao(Impressora impressora) {
        int tipo = Entrada.lerInteiro("Tipo (1=USB, 2=Serial, 3=Rede, 4=Bluetooth): ", 1, 4);
        String modelo = Entrada.lerTexto("Modelo (i8 ou i9): ");
        String conexao = Entrada.lerTexto("Conexão (USB, COM2 ou IP): ");
        int parametro = Entrada.lerInteiro("Parâmetro (0 para USB): ", 0, 999999);
        impressora.configurar(tipo, modelo, conexao, parametro);
    }
}