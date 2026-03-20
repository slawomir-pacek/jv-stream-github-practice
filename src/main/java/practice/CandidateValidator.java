package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null) {
            return false;
        }

        // warunek 1: wiek
        if (candidate.getAge() <= 35) {
            return false;
        }

        // warunek 2: prawo do głosowania
        if (!candidate.isAllowedToVote()) {
            return false;
        }

        // warunek 3: narodowość
        if (candidate.getNationality() == null
                || !"Ukrainian".equals(candidate.getNationality().trim())) {
            return false;
        }

        // warunek 4: lata w Ukrainie
        String periods = candidate.getPeriodsInUkr();
        if (periods == null || !periods.contains("-")) {
            return false;
        }

        String[] years = periods.split("-");
        int start = Integer.parseInt(years[0].trim());
        int end = Integer.parseInt(years[1].trim());

        return (end - start + 1) >= 10;
    }
}
