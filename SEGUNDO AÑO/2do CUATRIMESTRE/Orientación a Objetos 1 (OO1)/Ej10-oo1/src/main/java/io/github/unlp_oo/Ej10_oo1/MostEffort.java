package io.github.unlp_oo.Ej10_oo1;
import java.util.List;

public class MostEffort implements Strategy{
	
	public JobDescription next(List<JobDescription> jobs) {
		JobDescription nextJob = null;
		
		nextJob = jobs.stream()
					.max((j1, j2) -> Double.compare(j1.getEffort(), j2.getEffort()))
					.orElse(null);
		
		return nextJob;
	}

}
