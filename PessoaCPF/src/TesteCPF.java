import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class testCPF {

    CPF cpf = new CPF("199.292.293-23");

    @Test
    void testGetCPF() {
        assertEquals("199.292.293-23", cpf.getCPF());
        assertTrue(cpf.valido());

    }

    @Test
    void testToString() {
        assertEquals("199.292.293-23", cpf.toString());
    }

    @Test
    void testIsValido() throws IllegalArgumentException{
        CPF cpfValido = new CPF("123.456.789-09");
        assertTrue(cpfValido.valido());

        CPF cpfSemNúmero = new CPF("asc.dof.kam-bb");
        assertThrows(IllegalArgumentException.class, () -> cpfSemNúmero.valido());

        CPF cpfComMenosDe11Digitos = new CPF("123.456.789-0");
        assertThrows(IllegalArgumentException.class, () -> cpfComMenosDe11Digitos.valido());

        CPF cpfComMaisDe11Digitos = new CPF("123.4536.789-090");
        assertThrows(IllegalArgumentException.class, () -> cpfComMaisDe11Digitos.valido());
    }

}