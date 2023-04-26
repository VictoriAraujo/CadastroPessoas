import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CadastroPessoasTeste {
    CadastroPessoas cadastro;
    CPF cpf;

    @BeforeEach
    void setUp() throws Exception {
        cadastro = new CadastroPessoas();
        cpf = new CPF("123.456.789-00");
    }

    @Test
    public void testGetNumeroDePessoas() {
        assertEquals(0, cadastro.getNumeroDePessoas());

        cadastro.addPessoa("Maria Araujo", cpf);

        assertEquals(1, cadastro.getNumeroDePessoas());
    }

    @Test
    public void testAddPessoa() {
        CPF cpf2 = new CPF("999.694.203-00");
        assertTrue(cadastro.addPessoa("Luiz Santos", cpf2));
        assertFalse(cadastro.addPessoa(null, cpf));
        assertFalse(cadastro.addPessoa("Jorge Santos", null));

        assertEquals(1, cadastro.getNumeroDePessoas());
    }

    @Test
    public void testRemove() {
        cadastro.addPessoa("Maria", cpf);

        assertTrue(cadastro.remove("Maria", cpf));

        assertEquals(0, cadastro.getNumeroDePessoas());
    }

    @Test
    public void testRecuperaIndice() {
        CPF cpf2 = new CPF("222.456.789-10");
        cadastro.addPessoa("João da Silva", cpf);
        cadastro.addPessoa("Victoria", cpf2);

        assertEquals(0, cadastro.recuperaIndice("João da Silva", cpf));
        assertEquals(1, cadastro.recuperaIndice("Victoria", cpf2));
    }

    @Test
    public void testContem() {
        cadastro.addPessoa("Lana", cpf);
        cadastro.addPessoa("Maria Araujo", cpf);

        assertTrue(cadastro.contem("Lana", cpf));
        assertFalse(cadastro.contem("Pedro Oliveira", cpf));
    }
    @Test
    public void testOrdena() {
        CPF cpf1 = new CPF("123.456.789-00");
        CPF cpf2 = new CPF("987.654.321-00");
        CPF cpf3 = new CPF("111.222.333-44");

        cadastro.addPessoa("Maria Araujo", cpf2);
        cadastro.addPessoa("João da Silva", cpf1);
        cadastro.addPessoa("Pedro Oliveira", cpf3);
        // Ordena por CPF
        cadastro.ordena();
        String expected = "Pedro Oliveira 111.222.333-44\nJoão da Silva 123.456.789-00\nMaria Araujo 987.654.321-00\n";
        assertEquals(expected, cadastro.toString());
    }
    @Test
    public void testToString() {
        CPF cpf1 = new CPF("123.456.789-00");
        CPF cpf2 = new CPF("987.654.321-00");
        cadastro.addPessoa("Edelaine Marcelino", cpf1);
        cadastro.addPessoa("Maria Araujo", cpf2);

        String esperada = "Edelaine Marcelino 123.456.789-00\nMaria Araujo 987.654.321-00\n";
        assertEquals(esperada, cadastro.toString());
    }
}
