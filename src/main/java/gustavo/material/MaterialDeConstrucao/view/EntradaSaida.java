package gustavo.material.MaterialDeConstrucao.view;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.Random;

public class EntradaSaida {

    public static int solicitaOpcaoDeEntradaNoSoftware(){
        String[] options ={"Cadastrar", "Login", "Sair"};
        return JOptionPane.showOptionDialog(null,"Digite a opcao de uso do sistema","Material de Construção",JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
    }
    public static int solicitaOpcaoCadastro(){
        String[]options ={"Usuario", "Cliente"};
        return JOptionPane.showOptionDialog(null, "Escolha a opcao de Cadastro a ser feita", "Material de construção", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
    }
    public static String cadastroDeCliente() {
        return JOptionPane.showInputDialog(null, "Escreva seu nome:");
    }
    public static String cadastrarUsuarioLogin(){
        return JOptionPane.showInputDialog("Digite o nome de usuario:");
    }
    public static String cadastrarUsuarioSenha(){
        return JOptionPane.showInputDialog("Digite a senha de usuario:");
    }
    public static int solicitaUsarioOuComprador() {
        String[]opcoes = {"Usuario", "Cliente","Desconectar"};
        return JOptionPane.showOptionDialog(null, "Escolha a opcao de serviços do material de construçao", "Material de Construçao ", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
    }
    public static int solicitaEscolha() {
        String []opcoes = {"Cadastrar Novo Produto", "Entrada de produto", "Relatorios", "Sair"};
        JComboBox<String>menu = new JComboBox<>(opcoes);
        JOptionPane.showConfirmDialog(null,menu,  "Escolha a opcao que deseja executar", JOptionPane.DEFAULT_OPTION );
        return menu.getSelectedIndex();
    }

    public static int solicitaEscolhaDeLista(){
        String [] option = {"Estoque geral ", "Notas Fiscais", "Total Vendido"};
        return JOptionPane.showOptionDialog(null,"Escolha a Lista de Controle ", "Material de construção", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null , option, option[0] );

    }

    public static Long gerarNovoCodigo(){
        int codigoGerado;
        String[] opcoes = {"Gerar", "Digitar"};
        int  escolha = JOptionPane.showOptionDialog(null, "Opcoes de criação de codigo novo", "Material de Construçao ", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
        if (escolha == 0 ){
            Random random = new Random();
            return random.nextLong(1,99);
        }else{
            codigoGerado= Integer.parseInt(JOptionPane.showInputDialog(null, "Digite Um valor com (2) digitos para cadastrar como o codigo do produto "));
            while(codigoGerado>99){
                codigoGerado= Integer.parseInt(JOptionPane.showInputDialog(null, "Digite Novamente  o codigo do novo Produto"));
            }
            return (long) codigoGerado;
        }
    }
    public static String loginDeEntrada(){
        return JOptionPane.showInputDialog(null, "Digite o usuario", "Login de acesso de usuario", JOptionPane.QUESTION_MESSAGE);
    }
    public static String senhaDeEntrada(String login){
        return JOptionPane.showInputDialog(null, "Usuario :" +login, "Login de acesso de usuario", JOptionPane.QUESTION_MESSAGE);
    }
    public static String nomeDeCliente(){
        return JOptionPane.showInputDialog(null, "Digite seu nome:");
    }
    public static void msgGeral(String mensagem, int tipoDeMenagem  ){
        JOptionPane.showMessageDialog(null, mensagem, "Material de Construçao", tipoDeMenagem);
    }
    public static String solicitaDescricao(){
        return JOptionPane.showInputDialog(null, "Escreava a descrição do produto");
    }
    public static BigDecimal solicitaPreco(){
        String preco = JOptionPane.showInputDialog(null, "Digite o preco do produto.");
        return new BigDecimal(preco);
    }
    public static int solicitaQtdMaterial(){
        return Integer.parseInt(JOptionPane.showInputDialog(null,"Digite a quantidade a ser adicionada no estoque"));
    }
    public static Long darEntradaNoEstoque(String lista){

        return Long.parseLong(JOptionPane.showInputDialog(null, lista,"Materiais em estoque",JOptionPane.PLAIN_MESSAGE));
    }
    public static void listaDeEstoque(String lista){
        JOptionPane.showMessageDialog(null,lista, "Lista em Estoque",JOptionPane.PLAIN_MESSAGE);
    }





}
