package br.com.orderhere.service;

import br.com.orderhere.domain.ClientOrderDomain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Service
public class GenerateService {

    public String generateDescription() {
        StringBuilder stringBuilder = new StringBuilder();
        String description = "Eu quero ";
        String[] foods = {"Cookies", "Mil shake", "Esfiha", "Macarrão", "Marmita G", "Marmita M", "Marmita P", "Açai",
                "Lanche", "Macarronada", "Pizza Familia", "Pizza Pequena", "Churrasco", "Strogonoff", "Pudim", "Pavê", "Milho Verde",
                "Pastel", "Lasanha", "Hot Dog", "Comida Japonesa", "Comida Árabe", "Petit Gateau", "Chocolate", "Salgado assado",
                "Temaki", "Tilápia", "Salmão grelhado", "Carne de panela", "Amendoim", "Miojo", "Carbonara", "Torta de frango",
                "Acarajé", "Arroz Carreteiro", "Baião de dois", "Bobó de camarão", "Batata frita", "Bolinho de chuva", "Tapioca",
                "Brigadeiro", "Camarão no abacaxi", "Caranguejo", "Casquinha de siri", "Carne de carneiro", "Costela no fogo de chão",
                "Frango empanado", "Parmegiana", "Feijoada", "Galinhada", "Torresmo com cerveja", "Pamonha", "Pão de queijo"
        };

        int index = ThreadLocalRandom.current().nextInt(foods.length);
        String randomFoods = foods[index];

        return String.valueOf(stringBuilder.append(description).append(randomFoods));
    }

    public ClientOrderDomain generateClientInformations() {
        final Random random = new Random();
        double randomMoney = random.nextDouble(101);
        ClientOrderDomain clientOrderDomain = new ClientOrderDomain();

        try {
            clientOrderDomain.setClientDomainId(UUID.randomUUID().toString());
            clientOrderDomain.setNickName(generateNickName());
            clientOrderDomain.setMoney(new BigDecimal(randomMoney).setScale(2, BigDecimal.ROUND_HALF_EVEN));
        } catch (Exception e) {
            log.error("Error to generate Client Informations", new Exception());
        }

        return clientOrderDomain;
    };

    public String generateNickName() {
        String[] nickNames = {"James", "Miguelito", "Arthero", "Gael", "Théo", "Heitor", "Ravi", "Davizin", "Maitê", "Liz",
                "Cecília", "Bernardo", "Noah", "Bielzinho", "Helena", "Alice", "Laura", "Maria Alice", "Sophia", "Manu",
                "Belinha", "Causador", "Pudinzinho", "Flora", "Lua", "Baunilha", "Smurf", "Alecrim dourado", "Amendoim",
                "Sereia", "Chica", "Amora", "Sugar", "Honey", "Jimmy", "Turner", "Johnson's Baby", "Musa", "Lady",
                "Aqua", "Floquinho", "Mustache", "Luna", "Caracol", "Vanilla", "Aurora", "Batman", "Butterfly"};

        int index = ThreadLocalRandom.current().nextInt(nickNames.length);
        String randomNickNames = nickNames[index];

        return randomNickNames;
    }

    public BigDecimal generateOrderPrice() {
        Random random = new Random();
        double randomMoney = random.nextInt(51) + 10;

        BigDecimal returnPrice = BigDecimal.valueOf(randomMoney).setScale(2, BigDecimal.ROUND_HALF_EVEN);

        return returnPrice;
    }
}
