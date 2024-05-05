package br.com.allanflm.screenmatch.model;

import br.com.allanflm.screenmatch.exceptions.YearConversationErrorException;

public class Title implements Comparable<Title> {
    private String name;
    private int releaseYear;
    private boolean includedPlan;
    private double sumOfRatings;
    private int totalAssessment;
    private int durationInMinutes;

    public Title(String name, int releaseYear) {
        this.name = name;
        this.releaseYear = releaseYear;
    }

    public Title(OMDBTitle omdbTitle) {
        this.name = omdbTitle.title();

        if (omdbTitle.year().length() > 4) {
            throw new YearConversationErrorException("I can't convert the year because it has more than 4 characters.");
        }

        this.releaseYear = Integer.valueOf(omdbTitle.year());
        this.durationInMinutes = Integer.valueOf(omdbTitle.runtime().substring(0, 2));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setFilmDurationInMinutes(int filmDurationInMinutes) {
        this.durationInMinutes = filmDurationInMinutes;
    }

    public void setTotalAssessment(int totalAssessment) {
        this.totalAssessment = totalAssessment;
    }

    public double getSumOfRatings() {
        return sumOfRatings;
    }

    public void setSumOfRatings(double sumOfRatings) {
        this.sumOfRatings = sumOfRatings;
    }

    public boolean isIncludedPlan() {
        return includedPlan;
    }

    public void setIncludedPlan(boolean includedPlan) {
        this.includedPlan = includedPlan;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getTotalAssessment() {
        return totalAssessment;
    }

    public void filmTechnicalSheet() {
        System.out.println("Name: " + getName());
        System.out.println("Release Year: " + releaseYear);
        System.out.println("Duration In Minutes: " + getDurationInMinutes() + "min.");
    }

    public void filmReview(double note) {
        sumOfRatings += note;
        totalAssessment++;
    }

    public double returnTheEvaluation() {
        return sumOfRatings / totalAssessment;
    }

    @Override
    public int compareTo(Title anotherTitle) {
        return this.getName().compareTo(anotherTitle.getName());
    }

    @Override
    public String toString() {
        return "Movie [ " +
                "Name = " + name + " | Release Year = " + releaseYear + " | Duration= " + durationInMinutes + " min." + "]";
    }
}
