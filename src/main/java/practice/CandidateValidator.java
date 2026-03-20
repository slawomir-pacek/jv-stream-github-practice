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

        if (candidate.getNationality() == null
                || !"Ukrainian".equalsIgnoreCase(candidate.getNationality().trim())) {
            return false;
        }

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
