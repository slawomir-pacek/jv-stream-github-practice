package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null) {
            return false;
        }

        if (candidate.getAge() <= 35) {
            return false;
        }

        if (!candidate.isAllowedToVote()) {
            return false;
        }

        if (!"Ukrainian".equals(candidate.getNationality())) {
            return false;
        }

        String periods = candidate.getPeriodsInUkr();
        if (periods == null || !periods.contains("-")) {
            return false;
        }

        String[] years = periods.split("-");
        int start = Integer.parseInt(years[0]);
        int end = Integer.parseInt(years[1]);

        int currentYear = java.time.LocalDate.now().getYear();

        return (end - start) >= 10 && end >= currentYear;
    }
}
