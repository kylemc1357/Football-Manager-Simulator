package com.simulator.leauge;

import com.simulator.club.Club;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeaugeTable {
    private Map<Club, LeaugeTableEntry> leaugeTable; //for quick lookup times
    private List<LeaugeTableEntry> tableEntries; //for quick sorting the whole table

    public LeaugeTableEntry getSpecificEntry(Club club){
        return leaugeTable.get(club);
    }
    public void updateTable(Club homeTeam, Club awayTeam, int homeGoals, int awayGoals){
        this.getSpecificEntry(homeTeam).updateResult(homeGoals - awayGoals);
        this.getSpecificEntry(awayTeam).updateResult(awayGoals - homeGoals);
    }

    public LeaugeTable(List<Club> clubs){
        leaugeTable = new HashMap<>();
        tableEntries = new ArrayList<>();
        for(Club club : clubs){
            LeaugeTableEntry entry = new LeaugeTableEntry(club);
            leaugeTable.put(club, entry);
            tableEntries.add(entry);
        }
    }
}
