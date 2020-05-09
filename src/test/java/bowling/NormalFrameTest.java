package bowling;

import bowling.domain.Frame;
import bowling.domain.NormalFrame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NormalFrameTest {

    @Test
    @DisplayName("스트라이크가 나오면 다음 프레임으로 넘어간다")
    public void bowlNextFrameWhenStrike() {
        Frame frame = new NormalFrame(1);
        Frame nextFrame = frame.bowl(10);
        assertThat(nextFrame.getNumber()).isEqualTo(2);

        nextFrame = nextFrame.bowl(10);
        assertThat(nextFrame.getNumber()).isEqualTo(3);
    }

    @Test
    @DisplayName("스페어 처리 후 다음 프레임으로 넘어간다")
    public void bowlNextFrameWhenSpare() {
        Frame frame = new NormalFrame(1);
        Frame nextFrame = frame.bowl(9);
        assertThat(nextFrame.getNumber()).isEqualTo(1);

        nextFrame = frame.bowl(1);
        assertThat(nextFrame.getNumber()).isEqualTo(2);
    }

    @Test
    @DisplayName("미스가 나도 2번을 던졌다면 다음 프레임으로 넘어간다")
    public void bowlNextFrameWhenMiss() {
        Frame frame = new NormalFrame(1);
        Frame nextFrame = frame.bowl(7);
        assertThat(nextFrame.getNumber()).isEqualTo(1);

        nextFrame = frame.bowl(1);
        assertThat(nextFrame.getNumber()).isEqualTo(2);
    }

    @Test
    @DisplayName("보드에 각 프레임의 결과로 표시될 문자열을 얻어온다")
    public void getRecordEachFrameForBoardDescription() {
        Frame frame = new NormalFrame(1);
        Frame frame2 = frame.bowl(7).bowl(3);
        assertThat(frame.getRecord()).isEqualTo("7|/");

        Frame frame3 = frame2.bowl(10);
        assertThat(frame2.getRecord()).isEqualTo("X");

        frame3.bowl(8);
        assertThat(frame3.getRecord()).isEqualTo("8");
        Frame frame4 = frame3.bowl(1);
        assertThat(frame3.getRecord()).isEqualTo("8|1");

        frame4.bowl(0);
        assertThat(frame4.getRecord()).isEqualTo("-");
    }
}