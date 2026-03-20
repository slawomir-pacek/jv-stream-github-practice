package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null) {
            return false;
        }

        // age
        if (candidate.getAge() <= 35) {
            return false;
        }

        // voting
        if (!candidate.isAllowedToVote()) {
            return false;
        }

        // nationality
        String nationality = candidate.getNationality();
        if (nationality == null || !"Ukrainian".equalsIgnoreCase(nationality.trim())) {
            return false;
        }

        // periods
        String periods = candidate.getPeriodsInUkr();
        if (periods == null || !periods.contains("-")) {
            return false;
        }

        String[] years = periods.split("-");
        if (years.length != 2) {
            return false;
        }

        int start = Integer.parseInt(years[0].trim());
        int end = Integer.parseInt(years[1].trim());

        // at least 10 years
        return (end - start) >= 10;
    }
}
