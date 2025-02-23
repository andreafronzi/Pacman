package it.unibo.model.api;

import java.util.function.BiFunction;
import it.unibo.model.api.Position;

public interface SpeedVector {

    int X();

    int Y();

    Position URM(BiFunction<SpeedVector,Long,Position> converter, Long dt);

}
