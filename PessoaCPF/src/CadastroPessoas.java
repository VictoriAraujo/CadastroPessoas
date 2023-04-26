import java.util.ArrayList;
import java.util.Collections;
public class CadastroPessoas {
    private ArrayList<Pessoa> colecao = new ArrayList<>();

    public int getNumeroDePessoas(){
        return colecao.size();
    }
    public boolean addPessoa(String texto, CPF cpf){
        if(texto == null || cpf == null)
            return false;

        colecao.add(new Pessoa(texto, cpf));
        return true;
    }
    public boolean remove(String texto, CPF cpf) {
        if(!colecao.contains(new Pessoa(texto, cpf)))
            return false;

        colecao.remove(new Pessoa(texto, cpf));
        return true;
    }
    public int recuperaIndice(String texto, CPF cpf){
        return procuraPorCpf(cpf.getCPF(), colecao);
    }
    public static int procuraPorCpf(String cpf, ArrayList<Pessoa> colecao){
        for(Pessoa pessoa : colecao){
            if(pessoa.getCPF().getCPF().equals(cpf)) {
                return colecao.indexOf(pessoa);
            }
        }
        return -1;
    }
    public void ordena(){
        ArrayList<String> cpfs = new ArrayList<>();
        for (Pessoa pessoa : colecao) {
            cpfs.add(pessoa.getCPF().getCPF());
        }

        Collections.sort(cpfs);
        ArrayList<Pessoa> colecaoOrdenada = new ArrayList<>();
        for(String cpf : cpfs){
            colecaoOrdenada.add(colecao.get(procuraPorCpf(cpf, colecao)));
        }
        colecao = colecaoOrdenada;
    }
    public boolean contem(String texto, CPF cpf){
        return colecao.contains(new Pessoa(texto, cpf));
    }
    @Override
    public String toString(){

        String stringFinal = "";
        for(Pessoa pessoa : colecao){
            stringFinal+=pessoa.getNome()+" "+pessoa.getCPF().getCPF()+"\n";
        }
        return stringFinal;
    }

}
