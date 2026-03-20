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
        if (periods == null || periods.isEmpty()) {
            return false;
        }

        // wyciągamy TYLKO lata (pierwsze i ostatnie 4 cyfry)
        String startYearStr = periods.substring(0, 4);
        String endYearStr = periods.substring(periods.length() - 4);

        int start = Integer.parseInt(startYearStr);
        int end = Integer.parseInt(endYearStr);

        return (end - start) >= 10;
    }
}
