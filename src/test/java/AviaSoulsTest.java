import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    @Test
    public void shouldCompare() {
        Ticket ticket1 = new Ticket("Москва", "Париж", 100, 10, 15);
        Ticket ticket2 = new Ticket("Лондон", "Берлин", 200, 12, 14);
        Ticket ticket3 = new Ticket("Нью-Йорк", "Токио", 200, 8, 20);

        Assertions.assertTrue(ticket1.compareTo(ticket2) < 0);
        Assertions.assertTrue(ticket2.compareTo(ticket1) > 0);
        Assertions.assertEquals(0, ticket2.compareTo(ticket3));
    }


    @Test
    public void shouldSortByPrice() {
        AviaSouls aviaSouls = new AviaSouls();

        Ticket ticket1 = new Ticket("Москва", "Лондон", 300, 1, 5);
        Ticket ticket2 = new Ticket("Москва", "Лондон", 500, 1, 15);
        Ticket ticket3 = new Ticket("Москва", "Лондон", 100, 1, 10);
        Ticket ticket4 = new Ticket("Москва", "Лондон", 400, 1, 20);
        Ticket ticket5 = new Ticket("Москва", "Лондон", 200, 1, 25);


        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Ticket[] expected = {ticket3, ticket5, ticket1, ticket4, ticket2};
        Ticket[] actual = aviaSouls.search("Москва", "Лондон");

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSortByTime() {
        AviaSouls aviaSouls = new AviaSouls();

        Ticket ticket1 = new Ticket("Москва", "Лондон", 300, 1, 5);
        Ticket ticket2 = new Ticket("Москва", "Лондон", 500, 1, 15);
        Ticket ticket3 = new Ticket("Москва", "Лондон", 100, 1, 10);
        Ticket ticket4 = new Ticket("Москва", "Лондон", 400, 1, 25);
        Ticket ticket5 = new Ticket("Москва", "Лондон", 200, 1, 20);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        String from = "Москва";
        String to = "Лондон";

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket1, ticket3, ticket2, ticket5, ticket4};
        Ticket[] actual = aviaSouls.searchAndSortBy(from, to, comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}

