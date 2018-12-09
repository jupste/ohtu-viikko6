package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));

        QueryBuilder query = new QueryBuilder();
        Matcher m1 = query.playsIn("PHI")
                .hasAtLeast(10, "goals")
                .hasFewerThan(20, "assists").buildAnd();

        Matcher m2 = query.playsIn("EDM")
                .hasAtLeast(60, "points").buildAnd();

        Matcher m = query.or(m1, m2).buildOr();
        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }

    }
}
