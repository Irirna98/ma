import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000;
        boolean registered = true;
        long expected = 30;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);
        System.out.println(actual + " зарегистрированная сумма");
        System.out.println(actual + " не зарегистрированная сумма");

        // производим проверку (сравниваем ожидаемый и фактический):
        service.equals("expected, actual");
    }

    @org.junit.jupiter.api.Test
    public void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);
        System.out.println(actual + " зарегистрированная сумма");
        System.out.println(actual + " не зарегистрированная сумма");
        // производим проверку (сравниваем ожидаемый и фактический):
        service.equals("expected,actual");
    }

    @org.junit.jupiter.api.Test
    public void shouldCalculateForUnRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1_000_000;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);
        System.out.println(actual + " больше лимита");
        service.equals("expected,actual");
    }

    @Test
    public void shouldCalculateForUnRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 100;
        boolean registered = false;
        long expected = 30;

        long actual = service.calculate(amount, registered);
        System.out.println(actual + " меньше лимита");
        service.equals("expected,actual");

    }
}