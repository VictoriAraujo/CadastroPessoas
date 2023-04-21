public class CPF {
    private String CPF;

    public CPF( String CPF){
        this.CPF = CPF;
    }
    public String getCPF() {
        return CPF;
    }
    public boolean valido() throws IllegalArgumentException {
        CPF = CPF.replaceAll("\\D", "");

        if (CPF.length() != 11) {
            throw new IllegalArgumentException("CPF inválido.");
        }

        return true;
    }
    @Override
    public String toString() {
        return CPF;
    }
}
