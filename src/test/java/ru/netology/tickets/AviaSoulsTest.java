package ru.netology.tickets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {

    @Test
    public void shouldFindMultipleTickets() {
        AviaSouls aviaSouls = new AviaSouls();

        Ticket ticket1 = new Ticket("Москва", "Лондон", 100, 1, 5);
        Ticket ticket2 = new Ticket("Москва", "Париж", 200, 1, 10);
        Ticket ticket3 = new Ticket("Москва", "Берлин", 300, 1, 15);
        Ticket ticket4 = new Ticket("Москва", "Лондон", 400, 1, 20);
        Ticket ticket5 = new Ticket("Москва", "Лондон", 500, 1, 25);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);


        Ticket[] expected = {ticket1, ticket4, ticket5};
        Ticket[] actual = aviaSouls.search("Москва", "Лондон");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSingleTicket() {
        AviaSouls aviaSouls = new AviaSouls();

        Ticket ticket1 = new Ticket("Москва", "Лондон", 100, 1, 5);
        Ticket ticket2 = new Ticket("Москва", "Париж", 200, 1, 10);
        Ticket ticket3 = new Ticket("Москва", "Берлин", 300, 1, 15);
        Ticket ticket4 = new Ticket("Москва", "Лондон", 400, 1, 20);
        Ticket ticket5 = new Ticket("Москва", "Лондон", 500, 1, 25);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);


        Ticket[] expected = {ticket2};
        Ticket[] actual = aviaSouls.search("Москва", "Париж");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNoTickets() {
        AviaSouls aviaSouls = new AviaSouls();

        Ticket ticket1 = new Ticket("Москва", "Лондон", 100, 1, 5);
        Ticket ticket2 = new Ticket("Москва", "Париж", 200, 1, 10);
        Ticket ticket3 = new Ticket("Москва", "Берлин", 300, 1, 15);
        Ticket ticket4 = new Ticket("Москва", "Лондон", 400, 1, 20);
        Ticket ticket5 = new Ticket("Москва", "Лондон", 500, 1, 25);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Ticket[] result = aviaSouls.search("Лондон", "Берлин");
        Assertions.assertEquals(0, result.length);
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

