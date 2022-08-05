import java.io.*;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.lang.*;
import java.util.Map;

public class Main {
    static String matchCsv = "/home/prabhas/Desktop/MountBlueAssignment/Java/Java_IPL_Project/src/MatchDeliveriesData/matches.csv";
    static String deliveriesCsv = "/home/prabhas/Desktop/MountBlueAssignment/Java/Java_IPL_Project/src/MatchDeliveriesData/deliveries.csv";
    static String eachLine = "";

    public static List<MatchData> getMatchData() {
        List<MatchData> matchData = new ArrayList();
        int skipFirstLine = 0;
        try {
            FileReader frObj = new FileReader(matchCsv);
            BufferedReader brObj = new BufferedReader(frObj);

            while ((eachLine = brObj.readLine()) != null) {
                MatchData matchOdj = new MatchData();
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
            DeliveriesData deliveriesOdj = new DeliveriesData();

            while ((eachLine = brObj.readLine()) != null) {
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
    public static void matchesPlayedPerYear(List<MatchData> matchData) {
        Map<String, Integer> resultMatchesPlayPerYear = new HashMap<>();
        for (MatchData eachLineData : matchData) {
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

    public static void matchesWonPerYear(List<MatchData> matchData) {

    }


    public static void main(String[] args) {
        List<MatchData> matchData = Main.getMatchData();
        List<DeliveriesData> deliveriesData = Main.getDeliveriesData();
        matchesPlayedPerYear(matchData);
        matchesWonPerYear(matchData);


    }
}
