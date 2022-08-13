import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.io.IOException;

public class TestIplProject {
    Main mainObj = new Main();

    List<MatchesData> matchesData = mainObj.getMatchesData();
    List<DeliveriesData> deliveriesData = mainObj.getDeliveriesData();
    Map<String, Integer> matchesCount = new LinkedHashMap<>();
    Map<String, Integer> winnerCount = new HashMap<>();
    Map<String, Integer> extraRunsPerTeams = new LinkedHashMap<>();
    Map<String, Float> topEconomyBowlers = mainObj.topEconomicalBowlers2015(matchesData, deliveriesData);
    Set<String> dispWonMatchAndToss = new HashSet<>();


    @Nested
    class MatchesPlayedYearly {
        @BeforeEach
        void matchesPlayedPerYear() {
            matchesCount.put("2009", 57);
            matchesCount.put("2008", 58);
            matchesCount.put("2017", 59);
            matchesCount.put("2016", 60);
            matchesCount.put("2015", 59);
            matchesCount.put("2014", 60);
            matchesCount.put("2013", 76);
            matchesCount.put("2012", 74);
            matchesCount.put("2011", 73);
            matchesCount.put("2010", 60);
        }


        @Test
        void matchesPlayedPerYearTest1() throws IOException {
            Assertions.assertEquals(matchesCount, mainObj.matchesPlayedPerYear(matchesData));
        }

        @Test
        void matchesPlayedPerYearTest2() throws IOException {
            Assertions.assertTrue(matchesCount.equals(mainObj.matchesPlayedPerYear(matchesData)));
        }

        @Test
        void matchesPlayedPerYearTest3() throws IOException {
            Assertions.assertNotNull(mainObj.matchesPlayedPerYear(matchesData));
        }
    }


    @Nested
    class MatchesWonPerTeamAllYears {
        @BeforeEach
        @Test
        void matchesWonByTeam() {
            winnerCount.put("Mumbai Indians", 92);
            winnerCount.put("Sunrisers Hyderabad", 42);
            winnerCount.put("Pune Warriors", 12);
            winnerCount.put("Rajasthan Royals", 63);
            winnerCount.put("Kolkata Knight Riders", 77);
            winnerCount.put("Royal Challengers Bangalore", 73);
            winnerCount.put("Gujarat Lions", 13);
            winnerCount.put("Rising Pune Supergiant", 10);
            winnerCount.put("Kochi Tuskers Kerala", 6);
            winnerCount.put("Kings XI Punjab", 70);
            winnerCount.put("Deccan Chargers", 29);
            winnerCount.put("Delhi Daredevils", 62);
            winnerCount.put("Rising Pune Supergiants", 5);
            winnerCount.put("Chennai Super Kings", 79);
        }

        @Test
        void matchesWonByTeamTest1() throws IOException {
            Assertions.assertEquals(winnerCount, mainObj.matchesWonPerYear(matchesData));
        }

        @Test
        void matchesWonByTeamTest2() throws IOException {
            Assertions.assertTrue(winnerCount.equals(mainObj.matchesWonPerYear(matchesData)));
        }

        @Test
        void matchesWonByTeamTest3() throws IOException {
            Assertions.assertNotNull(mainObj.matchesWonPerYear(matchesData));
        }
    }


    @Nested
    class ExtraRuns {
        @BeforeEach
        @Test
        void ExtraRunsIn2016() {
            extraRunsPerTeams.put("Gujarat Lions", 132);
            extraRunsPerTeams.put("Mumbai Indians", 102);
            extraRunsPerTeams.put("Sunrisers Hyderabad", 124);
            extraRunsPerTeams.put("Kings XI Punjab", 83);
            extraRunsPerTeams.put("Delhi Daredevils", 109);
            extraRunsPerTeams.put("Rising Pune Supergiants", 101);
            extraRunsPerTeams.put("Kolkata Knight Riders", 130);
            extraRunsPerTeams.put("Royal Challengers Bangalore", 118);
        }

        @Test
        void extraRunsPerTeamIn2016Test1() throws IOException {
            Assertions.assertEquals(extraRunsPerTeams, mainObj.extraRunByPerTeam(mainObj.getMatchesData(), mainObj.getDeliveriesData(), "2016"));
        }

        @Test
        void extraRunsPerTeamIn2016Test2() throws IOException {
            Assertions.assertTrue(extraRunsPerTeams.equals(mainObj.extraRunByPerTeam(mainObj.getMatchesData(), mainObj.getDeliveriesData(), "2016")));
        }

        @Test
        void extraRunsPerTeamIn2016Test3() throws IOException {
            Assertions.assertNotNull(mainObj.extraRunByPerTeam(mainObj.getMatchesData(), mainObj.getDeliveriesData(), "2016"));
        }
    }


    @Nested
    class TopEconomyBowlers {
        @Test
        void economyRatePerBowlerIn2015Test1() throws IOException {
            Assertions.assertEquals(topEconomyBowlers, mainObj.topEconomicalBowlers2015(matchesData, deliveriesData));
        }

        @Test
        void economyRatePerBowlerIn2015Test2() throws IOException {
            Assertions.assertTrue(topEconomyBowlers.equals(mainObj.topEconomicalBowlers2015(matchesData, deliveriesData)));
        }

        @Test
        void economyRatePerBowlerIn2015Test3() throws IOException {
            Assertions.assertNotNull(mainObj.topEconomicalBowlers2015(matchesData, deliveriesData));
        }
    }

    @Nested
    class DispTeamWonMatchAndTossTest {
       @BeforeEach
       @Test
       void dispTeamWonMatchAndToss(){
           dispWonMatchAndToss.add("Mumbai Indians");
           dispWonMatchAndToss.add("Sunrisers Hyderabad");
           dispWonMatchAndToss.add("Pune Warriors");
           dispWonMatchAndToss.add("Rajasthan Royals");
           dispWonMatchAndToss.add("Kolkata Knight Riders");
           dispWonMatchAndToss.add("Royal Challengers Bangalore");
           dispWonMatchAndToss.add("Gujarat Lions");
           dispWonMatchAndToss.add("Rising Pune Supergiant");
           dispWonMatchAndToss.add("Kochi Tuskers Kerala");
           dispWonMatchAndToss.add("Kings XI Punjab");
           dispWonMatchAndToss.add("Deccan Chargers");
           dispWonMatchAndToss.add("Delhi Daredevils");
           dispWonMatchAndToss.add("Rising Pune Supergiants");
           dispWonMatchAndToss.add("Chennai Super Kings");
       }
       @Test
       void dispTeamWonMatchAndTossTest1(){
           Assertions.assertEquals(dispWonMatchAndToss, mainObj.displayTeamWonMatchAndToss(matchesData));
       }
        @Test
        void dispTeamWonMatchAndTossTest2(){
            Assertions.assertTrue(dispWonMatchAndToss.equals(mainObj.displayTeamWonMatchAndToss(matchesData)));
        }
        @Test
        void dispTeamWonMatchAndTossTest3(){
            Assertions.assertNotNull(mainObj.displayTeamWonMatchAndToss(matchesData));
        }
    }

}
