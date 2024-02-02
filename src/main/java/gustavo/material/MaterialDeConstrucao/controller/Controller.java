package gustavo.material.MaterialDeConstrucao.controller;
import gustavo.material.MaterialDeConstrucao.model.Cliente;
import gustavo.material.MaterialDeConstrucao.model.Material;
import gustavo.material.MaterialDeConstrucao.model.MaterialDeConstrucao;
import gustavo.material.MaterialDeConstrucao.model.Usuario;
import gustavo.material.MaterialDeConstrucao.view.EntradaSaida;

import javax.swing.*;
import java.math.BigDecimal;


public class Controller {

    MaterialDeConstrucao matConstr = null;

    public void start() {
        this.matConstr = new MaterialDeConstrucao();
        int opcaoDeUsuario;
        int escolha;
        int opt2;
        int opcaoEntradaSistema;
        int escolhaDeRelatorios;


        do {

            opcaoEntradaSistema = EntradaSaida.solicitaOpcaoDeEntradaNoSoftware();
            switch (opcaoEntradaSistema) {
                case 0:
                    opt2 = EntradaSaida.solicitaOpcaoCadastro();
                    switch (opt2) {
                        //cadastros
                        case 0:
                            cadastraUsuario();
                            break;
                        case 1:
                            cadastraCliente();
                            break;
                    }
                    break;
                case 1:
                    do {
                        escolha = EntradaSaida.solicitaUsarioOuComprador();
                        switch (escolha) {
                            case 0:
                                //login
                                loginUsuario();

                                //opcoaes de user
                                do {
                                    opcaoDeUsuario = EntradaSaida.solicitaEscolha();
                                    switch (opcaoDeUsuario) {
                                        case 0:
                                            Long id = EntradaSaida.gerarNovoCodigo();
                                            String descricao =EntradaSaida.solicitaDescricao();
                                            BigDecimal preco = EntradaSaida.solicitaPreco();
                                            Integer qtdMaterial = EntradaSaida.solicitaQtdMaterial();
                                            Material material = new Material(id,descricao,preco,qtdMaterial);
                                            matConstr.adicionaMaterial(material);
                                            break;
                                        case 1:
                                            Long idEntrada = EntradaSaida.darEntradaNoEstoque(matConstr.listaDeMateriaisEmEstoque());
                                            while(!matConstr.validaCodigoProdt(idEntrada)){
                                                EntradaSaida.msgGeral("Codigo nao Cadastrado!!!",JOptionPane.ERROR_MESSAGE);
                                                idEntrada = EntradaSaida.darEntradaNoEstoque(matConstr.listaDeMateriaisEmEstoque());
                                            }
                                            int qtdAdicionar = EntradaSaida.solicitaQtdMaterial();
                                            matConstr.adicionaNoEstoque(idEntrada, qtdAdicionar);
                                            break;
                                        case 2:
                                            escolhaDeRelatorios=EntradaSaida.solicitaEscolhaDeLista();
                                            switch (escolhaDeRelatorios){
                                                case 0:
                                                    EntradaSaida.listaDeEstoque(matConstr.estoqueGeral());
                                                    break;
                                                case 1:

                                                    break;
                                                case 2:
                                                    break;
                                            }
                                            break;

                                    }
                                }while (opcaoDeUsuario!=3);



                                break;
                            case 1:
                                String nomeDeCliente;
                                nomeDeCliente = EntradaSaida.nomeDeCliente();
                                while (!matConstr.verificaCliente(nomeDeCliente)){
                                    EntradaSaida.msgGeral("Nome de cliente nao cadastrado no sistema", JOptionPane.WARNING_MESSAGE);
                                    nomeDeCliente = EntradaSaida.nomeDeCliente();
                                }
                                System.out.println("%%%%%%%%%%%%%%%%%%%%%%%");




                                break;
                        }
                    }while (escolha!=2);
                    break;
            }
        }while(opcaoEntradaSistema!=2);
        EntradaSaida.msgGeral("Encerrando...", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
    public void cadastraUsuario() {
        String usuario = EntradaSaida.cadastrarUsuarioLogin();
        String senha = EntradaSaida.cadastrarUsuarioSenha();
        Usuario usuario1 = new Usuario(usuario, senha);
        matConstr.cadastraUsuario(usuario1);
    }
    public void cadastraCliente() {
        String nomeCliente = EntradaSaida.cadastroDeCliente();
        Cliente cliente = new Cliente(nomeCliente);
        matConstr.cadastraCliente(cliente);
    }
    public void loginUsuario(){
        String usuario;
        String senha;

        usuario = EntradaSaida.loginDeEntrada();
        while (!matConstr.verificaUsuario(usuario)) {
            EntradaSaida.msgGeral("Usuario Não cadastrado", JOptionPane.WARNING_MESSAGE);
            usuario = EntradaSaida.loginDeEntrada();
        }
        senha = EntradaSaida.senhaDeEntrada(usuario);
        while (!matConstr.verificaSenha(senha, usuario)) {
            EntradaSaida.msgGeral("Senha errada", JOptionPane.WARNING_MESSAGE);
            senha = EntradaSaida.senhaDeEntrada(usuario);
        }
    }
}
