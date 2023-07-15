package org.indigo.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquadTest {

    @Test
    @DisplayName("Squad: ensure that getName() returns the name set with setName")
    void getName() {
        Squad squad = new Squad();
        squad.setName("Paw Patrol");
        Assertions.assertEquals("Paw Patrol", squad.getName());
    }
}