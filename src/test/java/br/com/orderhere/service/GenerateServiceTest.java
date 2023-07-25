package br.com.orderhere.service;


import br.com.orderhere.domain.ClientOrderDomain;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class GenerateServiceTest {

    @Test
    public void generateDescriptionTest() {
        GenerateService generateServiceMock = new GenerateService();
        String description = "Eu quero ";

        String[] foods = {
                "Cookies", "Mil shake", "Esfiha", "Macarrão", "Marmita G", "Marmita M", "Marmita P", "Açai",
                "Lanche", "Macarronada", "Pizza Familia", "Pizza Pequena", "Churrasco", "Strogonoff", "Pudim", "Pavê", "Milho Verde",
                "Pastel", "Lasanha", "Hot Dog", "Comida Japonesa", "Comida Árabe", "Petit Gateau", "Chocolate", "Salgado assado",
                "Temaki", "Tilápia", "Salmão grelhado", "Carne de panela", "Amendoim", "Miojo", "Carbonara", "Torta de frango",
                "Acarajé", "Arroz Carreteiro", "Baião de dois", "Bobó de camarão", "Batata frita", "Bolinho de chuva", "Tapioca",
                "Brigadeiro", "Camarão no abacaxi", "Caranguejo", "Casquinha de siri", "Carne de carneiro", "Costela no fogo de chão",
                "Frango empanado", "Parmegiana", "Feijoada", "Galinhada", "Torresmo com cerveja", "Pamonha", "Pão de queijo"
        };

        String generatedDescription = generateServiceMock.generateDescription();

        assertTrue(generatedDescription.startsWith(description));

        String food = generatedDescription.substring(description.length());
        assertTrue(Arrays.asList(foods).contains(food));

    }

    @Test
    public void generateClientInformations () {
        GenerateService generateServiceMock = new GenerateService();
        ClientOrderDomain clientOrderDomain = new ClientOrderDomain();

        BigDecimal biggerNumber = new BigDecimal(200);
        BigDecimal smallerNumber = new BigDecimal(0);

        clientOrderDomain.setMoney(new BigDecimal(50));
        clientOrderDomain.setNickName("James");
        clientOrderDomain.setClientDomainId(UUID.randomUUID().toString());

        String[] nickNames = {
                "James", "Miguelito", "Arthero", "Gael", "Théo", "Heitor", "Ravi", "Davizin", "Maitê", "Liz",
                "Cecília", "Bernardo", "Noah", "Bielzinho", "Helena", "Alice", "Laura", "Maria Alice", "Sophia", "Manu",
                "Belinha", "Causador", "Pudinzinho", "Flora", "Lua", "Baunilha", "Smurf", "Alecrim dourado", "Amendoim",
                "Sereia", "Chica", "Amora", "Sugar", "Honey", "Jimmy", "Turner", "Johnson's Baby", "Musa", "Lady",
                "Aqua", "Floquinho", "Mustache", "Luna", "Caracol", "Vanilla", "Aurora", "Batman", "Butterfly"
        };

        assertTrue(generateServiceMock.generateClientInformations().getMoney().longValue() > smallerNumber.longValue() &&
                            generateServiceMock.generateClientInformations().getMoney().longValue() < biggerNumber.longValue());

        assertTrue(Arrays.asList(nickNames).contains(generateServiceMock.generateClientInformations().getNickName()));
        assertNotNull(generateServiceMock.generateClientInformations().getClientDomainId());

        assertTrue(generateServiceMock.generateClientInformations().getClientDomainId().toString()
                .matches("[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}"));
    }

    @Test
    public void generateNickNameTest() {
        GenerateService generateServiceMock = new GenerateService();

        String[] nickNames = {
                "James", "Miguelito", "Arthero", "Gael", "Théo", "Heitor", "Ravi", "Davizin", "Maitê", "Liz",
                "Cecília", "Bernardo", "Noah", "Bielzinho", "Helena", "Alice", "Laura", "Maria Alice", "Sophia", "Manu",
                "Belinha", "Causador", "Pudinzinho", "Flora", "Lua", "Baunilha", "Smurf", "Alecrim dourado", "Amendoim",
                "Sereia", "Chica", "Amora", "Sugar", "Honey", "Jimmy", "Turner", "Johnson's Baby", "Musa", "Lady",
                "Aqua", "Floquinho", "Mustache", "Luna", "Caracol", "Vanilla", "Aurora", "Batman", "Butterfly"
        };

        assertTrue(Arrays.asList(nickNames).contains(generateServiceMock.generateNickName()));
    }

    @Test
    public void generateOrderPriceTest() {
        GenerateService generateServiceMock = new GenerateService();

        BigDecimal biggerNumber = new BigDecimal(60);
        BigDecimal smallerNumber = new BigDecimal(1);

        assertTrue(generateServiceMock.generateOrderPrice().longValue() > smallerNumber.longValue() &&
                            generateServiceMock.generateOrderPrice().longValue() < biggerNumber.longValue());
    }
}