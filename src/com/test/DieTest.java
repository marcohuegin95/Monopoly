package com.test;

import org.junit.jupiter.api.Test;
import com.game.*;

public class DieTest {

    @Test
    public void TestDieOnce() {
        Die die1 = new Die();

        //Test
        die1.roll();

        //
        boolean test = die1.getEyeCount() <= 6;
    }
}