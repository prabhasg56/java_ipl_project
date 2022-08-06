import javax.swing.text.html.parser.Entity;
import java.io.*;
import java.io.FileReader;
import java.util.*;
import java.lang.*;

public class Main {
    static String matchCsv = "/home/prabhas/Desktop/MountBlueAssignment/Java/Java_IPL_Project/src/MatchDeliveriesData/matches.csv";
    static String deliveriesCsv = "/home/prabhas/Desktop/MountBlueAssignment/Java/Java_IPL_Project/src/MatchDeliveriesData/deliveries.csv";
    static String eachLine = "";

    public static List<MatchesData> getMatchesData() {
        List<MatchesData> matchData = new ArrayList();
        int skipFirstLine = 0;
        try {
            FileReader frObj = new FileReader(matchCsv);
            BufferedReader brObj = new BufferedReader(frObj);

            while ((eachLine = brObj.readLine()) != null) {
                MatchesData matchOdj = new MatchesData();
                if (skipFirstLine == 0) {
                    skipFirstLine++;
                } else {
                    //System.out.println(skipFirstLine);
                    String[] eachLineMatchData = eachLine.split(",");
                    //System.out.println(eachLineMatchData[1]);
                    matchOdj.setId(Integer.parseInt(eachLineMatchData[0]));
                    matchOdj.setSesson(eachLineMatchData[1]);
                    matchOdj.setCity(eachLineMatchData[2]);
                    matchOdj.setDate(eachLineMatchData[3]);
                    matchOdj.setTeam1(eachLineMatchData[4]);
                    matchOdj.setTeam2(eachLineMatchData[5]);
                    matchOdj.setTossWinner(eachLineMatchData[6]);
                    matchOdj.setTossDecision(eachLineMatchData[7]);
                    matchOdj.setResult(eachLineMatchData[8]);
                    matchOdj.setDlApplied(eachLineMatchData[9]);
                    matchOdj.setWinner(eachLineMatchData[10]);
                    matchOdj.setWinByRuns(Integer.parseInt(eachLineMatchData[11]));
                    matchOdj.setWinByWickets(Integer.parseInt(eachLineMatchData[12]));
                    matchOdj.setPlayerOfMatch(eachLineMatchData[13]);
                    matchOdj.setVenue(eachLineMatchData[14]);
                    matchData.add(matchOdj);
                }
            }

        } catch (IOException ex) {
            System.out.println(ex);
        }
        return matchData;
    }

    public static List<DeliveriesData> getDeliveriesData() {
        List<DeliveriesData> deliveriesData = new ArrayList();
        int skipFirstLine = 0;
        try {
            FileReader frObj = new FileReader(deliveriesCsv);
            BufferedReader brObj = new BufferedReader(frObj);

            while ((eachLine = brObj.readLine()) != null) {
                DeliveriesData deliveriesOdj = new DeliveriesData();
                if (skipFirstLine == 0) {
                    skipFirstLine++;
                } else {
                    // System.out.println(skipFirstLine);
                    String[] eachLineDeliveriesData = eachLine.split(",");
                    //System.out.println(eachLineDeliveriesData[1]);
                    deliveriesOdj.setMatchId(Integer.parseInt(eachLineDeliveriesData[0]));
                    deliveriesOdj.setInning(Integer.parseInt(eachLineDeliveriesData[1]));
                    deliveriesOdj.setBattingTeam(eachLineDeliveriesData[2]);
                    deliveriesOdj.setBowlingTeam(eachLineDeliveriesData[3]);
                    deliveriesOdj.setOver(Integer.parseInt(eachLineDeliveriesData[4]));
                    deliveriesOdj.setBall(Integer.parseInt(eachLineDeliveriesData[5]));
                    deliveriesOdj.setBatsman(eachLineDeliveriesData[6]);
                    deliveriesOdj.setNonStriker(eachLineDeliveriesData[7]);
                    deliveriesOdj.setBowler(eachLineDeliveriesData[8]);
                    deliveriesOdj.setIsSuperOver(Integer.parseInt(eachLineDeliveriesData[9]));
                    deliveriesOdj.setWideRuns(Integer.parseInt(eachLineDeliveriesData[10]));
                    deliveriesOdj.setByeRuns(Integer.parseInt(eachLineDeliveriesData[11]));
                    deliveriesOdj.setLegbyeRuns(Integer.parseInt(eachLineDeliveriesData[12]));
                    deliveriesOdj.setNoballRuns(Integer.parseInt(eachLineDeliveriesData[13]));
                    deliveriesOdj.setPenaltyRuns(Integer.parseInt(eachLineDeliveriesData[14]));
                    deliveriesOdj.setBatsmanRuns(Integer.parseInt(eachLineDeliveriesData[15]));
                    deliveriesOdj.setExtraRuns(Integer.parseInt(eachLineDeliveriesData[16]));
                    deliveriesOdj.setTotalRuns(Integer.parseInt(eachLineDeliveriesData[17]));
                    deliveriesData.add(deliveriesOdj);
                }

            }

        } catch (IOException ex) {
            System.out.println(ex);
        }
        return deliveriesData;
    }

    //1. Number of matches played per year of all the years in IPL.
    public static void matchesPlayedPerYear(List<MatchesData> matchData) {
        Map<String, Integer> resultMatchesPlayPerYear = new HashMap<>();
        for (MatchesData eachLineData : matchData) {
            String matchYear = eachLineData.getSesson();
            // System.out.println(matchYear);
            if (resultMatchesPlayPerYear.containsKey(matchYear)) {
                //System.out.println(resultMatchesPlayPerYear.get(matchYear));
                resultMatchesPlayPerYear.put(matchYear, (resultMatchesPlayPerYear.get(matchYear) + 1));
            } else {
                resultMatchesPlayPerYear.put(matchYear, 1);
            }
        }
        System.out.println(resultMatchesPlayPerYear);
    }

    //2. Number of matches won of all teams over all the years of IPL.

    public static void matchesWonPerYear(List<MatchesData> matchData) {
        Map<String, Object> resultMatchesWonByTeam = new HashMap<>();
        Map<String, Integer> winnerWon = new HashMap<>();

        for (MatchesData eachLineData : matchData) {
            String sesson = eachLineData.getSesson();
            String winners = eachLineData.getWinner();
            if (winners.isBlank()) {
                continue;
            }
            if (winnerWon.containsKey(winners)) {
                winnerWon.put(winners, (winnerWon.get(winners) + 1));
                resultMatchesWonByTeam.put(sesson, winnerWon);
            } else {
                winnerWon.put(winners, 1);
                resultMatchesWonByTeam.put(sesson, winnerWon);
            }
        }
        //System.out.println(resultMatchesWonByTeam);
    }

    //3. For the year 2016 get the extra runs conceded per team.

    public static void extraRunByPerTeam(List<MatchesData> matchesData, List<DeliveriesData> deliveriesData, String year) {
        Map<String, Integer> resultExtraRuns = new HashMap<>();

        for (MatchesData eachLineData : matchesData) {
            if (eachLineData.getSesson().equals(year)) {
                //System.out.println("2016");
                for (DeliveriesData eachLineDelvData : deliveriesData) {
                    String bowlingTeam = eachLineDelvData.getBattingTeam();
                    int extraRuns = eachLineDelvData.getExtraRuns();
                    if (eachLineData.getId() == eachLineDelvData.getMatchId()) {
                        if (resultExtraRuns.containsKey(bowlingTeam)) {
                            // System.out.println("yes");
                            if (extraRuns == 0) {
                                continue;
                            } else {
                                resultExtraRuns.put(bowlingTeam, resultExtraRuns.get(bowlingTeam) + extraRuns);
                            }
                        } else {
                            resultExtraRuns.put(bowlingTeam, extraRuns);
                        }
                    }

                }

            }
        }
        System.out.println(resultExtraRuns);
    }

    //4. For the year 2015 get the top economical bowlers.

    public static void topEconomicalBowlers2015(List<MatchesData> matchesData, List<DeliveriesData> deliveriesData, String year) {
        Map<String, Integer> topEconomicalBowlers = new HashMap<>();
        Map<String, Integer> totalOverByBowler2015 = new HashMap<>();
        Map<String, Integer> runsGivenByBowler2015 = new HashMap<>();

        for (MatchesData eachLineData : matchesData) {
            if (eachLineData.getSesson().equals(year)) {
                for (DeliveriesData eachLineDelvData : deliveriesData) {
                    String bowler = eachLineDelvData.getBowler();
                    if (eachLineData.getId() == eachLineDelvData.getMatchId()) {
                        if (runsGivenByBowler2015.containsKey(bowler)) {
                            runsGivenByBowler2015.put(bowler, runsGivenByBowler2015.get(bowler) + eachLineDelvData.getTotalRuns());
                        } else {
                            runsGivenByBowler2015.put(bowler, eachLineDelvData.getTotalRuns());
                        }
                        if (totalOverByBowler2015.containsKey(bowler)) {
                            totalOverByBowler2015.put(bowler, totalOverByBowler2015.get(bowler) + eachLineDelvData.getBall() / 6);

                        } else {
                            totalOverByBowler2015.put(bowler, 0);
                        }
                    }
                }
            }
        }
        for (Map.Entry<String, Integer> entry : runsGivenByBowler2015.entrySet()) {

            topEconomicalBowlers.put(entry.getKey(), (runsGivenByBowler2015.get(entry.getKey()) / totalOverByBowler2015.get(entry.getKey())));
        }
        //Sorting Map datas
        Set<Map.Entry<String, Integer>> entrySet = topEconomicalBowlers.entrySet();
        List<Map.Entry<String, Integer>> sortedResult = new ArrayList<>(entrySet);
        Collections.sort(sortedResult, (val1, val2) -> val1.getValue().compareTo(val2.getValue()));

        System.out.println(sortedResult);
    }

    public static void main(String[] args) {
        try {
            List<MatchesData> matchesData = Main.getMatchesData();
            List<DeliveriesData> deliveriesData = Main.getDeliveriesData();
            matchesPlayedPerYear(matchesData);
            matchesWonPerYear(matchesData);
            String year = "2016";
            extraRunByPerTeam(matchesData, deliveriesData, year);
            String year1 = "2015";
            topEconomicalBowlers2015(matchesData, deliveriesData, year1);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
