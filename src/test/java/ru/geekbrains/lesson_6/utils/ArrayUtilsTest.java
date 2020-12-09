package ru.geekbrains.lesson_6.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ArrayUtilsTest {

    @ParameterizedTest
    @MethodSource("intsArrayProvider")
    void shouldCreateAndReturnArrayAfterLastFour(int[] exp, int[] res){
        Assertions.assertArrayEquals(exp, res);
    }
    static Stream<Arguments> intsArrayProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 7}, ArrayUtils.createArrayOfIntsAfterLastFour(
                        new int[]{1, 2, 4, 3, 2, 4, 1, 1, 7}
                )),
                Arguments.of(new int[]{1, 3, 2, 5, 1, 6, 7}, ArrayUtils.createArrayOfIntsAfterLastFour(
                        new int[]{1, 4, 1, 3, 2, 5, 1, 6, 7}
                )),
                Arguments.of(new int[]{7}, ArrayUtils.createArrayOfIntsAfterLastFour(
                        new int[]{1, 2, 4, 3, 2, 4, 1, 4, 7}
                )),
                Arguments.of(new int[]{2, 1, 1, 7}, ArrayUtils.createArrayOfIntsAfterLastFour(
                        new int[]{1, 2, 4, 3, 4, 2, 1, 1, 7}
                ))
        );
    }

    @Test
    void shouldThrowRuntimeExceptionIfFourNotFound(){
        Throwable exception = Assertions.assertThrows(
                RuntimeException.class,
                () -> ArrayUtils.createArrayOfIntsAfterLastFour(new int[]{1}
                ));
        Assertions.assertEquals("There is no '4' digits found in array...", exception.getMessage());
    }

    @ParameterizedTest
    @MethodSource("trueProvider")
    void shouldReturnTrueIfFoundOneOrFourInArrayOrFalseIfNot(boolean src){
        Assertions.assertTrue(src);
    }

    static Stream<Arguments> trueProvider() {
        return Stream.of(
                Arguments.of(ArrayUtils.searchArrayForOneAndFour(
                        new int[]{1, 2, 4, 3, 2, 4, 1, 1, 7}
                )),
                Arguments.of(ArrayUtils.searchArrayForOneAndFour(
                        new int[]{1, 4, 1, 3, 2, 5, 1, 6, 7}
                )),
                Arguments.of(ArrayUtils.searchArrayForOneAndFour(
                        new int[]{1, 2, 4, 3, 2, 4, 1, 4, 7}
                )),
                Arguments.of(ArrayUtils.searchArrayForOneAndFour(
                        new int[]{1, 2, 4, 3, 4, 2, 1, 1, 7}
                ))
        );
    }

    @ParameterizedTest
    @MethodSource("falseProvider")
    void shouldReturnFalseIfNotFoundOneOrFourInArray(boolean src){
        Assertions.assertFalse(src);
    }
    static Stream<Arguments> falseProvider() {
        return Stream.of(
                Arguments.of(ArrayUtils.searchArrayForOneAndFour(
                        new int[]{5, 2, 2, 3, 2, 5, 6, 9, 7}
                )),
                Arguments.of(ArrayUtils.searchArrayForOneAndFour(
                        new int[]{3, 2, 5, 3, 2, 5, 8, 6, 7}
                )),
                Arguments.of(ArrayUtils.searchArrayForOneAndFour(
                        new int[]{9, 2, 2, 3, 2, 7, 5, 8, 7}
                )),
                Arguments.of(ArrayUtils.searchArrayForOneAndFour(
                        new int[]{9, 2, 0, 3, 3, 2, 5, 3, 7}
                ))
        );
    }
}
