package org.concertManagement.entities.dto;

import org.concertManagement.entities.Arena;

import java.util.List;

public class ArenasDTO {
    private List<Arena> arenas;

    public List<Arena> getArenas() {
        return arenas;
    }

    public void setArenas(List<Arena> arenas) {
        this.arenas = arenas;
    }
}
