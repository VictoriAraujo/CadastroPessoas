public class Pessoa {
    private String nome;
    private final CPF cpf;

    public Pessoa(String nome, CPF cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }


    public String getNome() {
        return nome;
    }
    public CPF getCPF() {
        return cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString() {
        return "Nome " + nome + ", cpf " + cpf;
    }

    public boolean equals(Object objeto) {
        if(! (objeto instanceof Pessoa)) {
            return false;
        }
        Pessoa outra = (Pessoa)objeto;
        return getNome().equals(outra.getNome())
                && getCPF().equals(outra.getCPF());
    }
}
