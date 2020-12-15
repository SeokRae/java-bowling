package bowling.model.state.finishedState;

import bowling.model.Score;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class SpareTest {
    @Test
    void of_정상() {
        assertThat(Spare.of(Score.from(0), Score.from(10)));
    }

    @ParameterizedTest
    @MethodSource("spareParams")
    void of_Spare의_조건에_맞지_않는_경우(Score previous, Score totalScore) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Spare.of(previous, totalScore))
                .withMessage("Spare의 조건에 맞지 않습니다.");
    }

    @Test
    void isFinished() {
        assertThat(Spare.of(Score.from(8), Score.from(10)).isFinished()).isTrue();
    }

    @Test
    void bowling() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Spare.of(Score.from(8), Score.from(10)).bowling(1))
                .withMessage("해당 프레임에서는 더 이상 던질 수 없습니다.");
    }

    private static Stream<Arguments> spareParams() {
        return Stream.of(
                Arguments.of(Score.from(10), Score.from(10)),
                Arguments.of(Score.from(1), Score.from(9))
        );
    }
}