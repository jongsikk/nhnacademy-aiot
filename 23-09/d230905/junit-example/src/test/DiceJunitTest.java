package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import main.Dice;
import main.DiceCalculator;

@TestInstance(Lifecycle.PER_CLASS)
class DiceJunitTest {
    private Dice first;
    private Dice second;

    private static Stream<Arguments> provideAddParams() {
        return Stream.of(
                Arguments.of(1, 2, 3));
    }

    @BeforeEach
    void setup() {
        first = new Dice(6);
        second = new Dice(2);
    }

    @Test
    @DisplayName("addDice 성공")
    void addDice() {
        assertEquals(DiceCalculator.addDice(first, second), 8);
    }

    // @ParameterizedTest
    // @MethodSource("provideAddPraams")
    // void add_success(int a, int b, int c) {
    // assertEquals(DiceCalculator.addDice(new Dice(a), new Dice(b)), c);
    // }

    @Test
    @DisplayName("subDice 성공")
    void subDice() {
        assertEquals(DiceCalculator.subDice(first, second), 4);
    }

    @Test
    @DisplayName("mulDice 성공")
    void mulDice() {
        assertEquals(DiceCalculator.mulDice(first, second), 12);
    }

    @Test
    @DisplayName("divDice 성공")
    void divDice() {
        assertEquals(DiceCalculator.divDice(first, second), 3);
    }

    @Test
    @DisplayName("isOdd 성공")
    void isOdd() {
        assertEquals(DiceCalculator.isOdd(first), false);
    }

    @Test
    @DisplayName("isEven 성공")
    void isEven() {
        assertEquals(DiceCalculator.isEven(first), true);
    }

    @Test
    @DisplayName("음수 값의 주사위를 생성할 수 없을 떄, IllegalArgumentException을 던짐")
    void negativeDice_throwIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Dice(-1));
        assertEquals(exception.getMessage(), "1 미만 6 초과 주사위는 생서할 수 없습니다.");
    }

    @AfterAll
    void done() {
        System.out.println("a");
    }
}
