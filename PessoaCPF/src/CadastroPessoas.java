import java.util.Map;
import java.util.HashMap;

public class CadastroPessoas {
    private Map<String,CPF> pessoas = new HashMap<>();

    public Map<String, CPF> getPessoas() {
        return pessoas;
    }
    public boolean addPessoa(String nome, String numeroCpf) {
        CPF cpf = new CPF(numeroCpf);
        Pessoa pessoa = new Pessoa(nome, cpf);

        if (cpf.valido()) {
            pessoas.put(pessoa.getNome(), pessoa.getCPF());
            return true;
        } else {
            throw new IllegalArgumentException("CPF inválido: " + numeroCpf);
        }
    }

}



