// package dev_java.weak2;

// import static org.junit.jupiter.api.Assertions.assertTrue;

// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.params.ParameterizedTest;
// import org.junit.jupiter.params.provider.ValueSource;

// @DisplayName("파라미터 테스트 활용")
// public class ParameterTest1 {
//     @ParameterizedTest           // 파라미터를 테스트해주는 어노테이션
//     @ValueSource(ints = {1, 5})
//     @DisplayName("ValueSource를 통해서 매개변수를 지정 가능")
//     void isPositive(int number) {
//         assertTrue(number > 0);
//     }
// }
