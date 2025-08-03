package com.java.functional.programming;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Course  {
    private String name;

    private String category;

    private int numberOfStudents;

    private int reviewScore;

    public Course(String name, String category, int numberOfStudents, int reviewScore) {
        this.name = name;
        this.category = category;
        this.numberOfStudents = numberOfStudents;
        this.reviewScore = reviewScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name=" + name +
                ", category=" + category +
                ", numberOfStudents=" + numberOfStudents +
                ", reviewScore=" + reviewScore +
                '}';
    }
}
public class Example7 {

    public static void main(String[] args) {
        List<Course> courses = List.of(
                new Course("Spring", "Framework", 500, 4),
                new Course("SpringBoot", "Framework", 500, 5),
                new Course("MicroServices", "Architecture", 50, 4),
                new Course("AWS", "Cloud", 800, 4),
                new Course("Azure", "Cloud", 600, 4),
                new Course("Docker", "Devops", 200, 4)
        );

        /// allMatch
        Predicate<Course> courseScoreGreaterThanFour = (course) -> course.getReviewScore() > 4;
        System.out.println(courses.stream().allMatch(courseScoreGreaterThanFour));
        System.out.println(courses.stream().allMatch(course -> course.getNumberOfStudents() > 100));

        /// anyMatch
        System.out.println(courses.stream().anyMatch((course) -> course.getReviewScore() == 5));
        System.out.println(courses.stream().anyMatch(course -> course.getNumberOfStudents() > 100));

        /// noneMatch
        System.out.println(courses.stream().noneMatch((course) -> course.getReviewScore() < 3));
        System.out.println(courses.stream().noneMatch(course -> course.getNumberOfStudents() > 100));

        /// sorted
        Comparator<Course> courseComparator = Comparator.comparingInt((Course::getNumberOfStudents));
        Comparator<Course> courseReviewComp = new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                if(o1.getReviewScore() > o2.getReviewScore()) return -1;
                else if(o1.getReviewScore()< o2.getReviewScore()) return  1;
                else return 0;
            }
        };
        List<Course> sortedCourse = courses.stream().sorted(courseComparator.thenComparing(courseReviewComp)).toList();
        System.out.println(sortedCourse);

        /// sorted
        Comparator<Course> courseComparator1 = new Comparator<Course>() {
            @Override
            public int compare(Course c1, Course c2) {
                if (c1.getNumberOfStudents() > c2.getNumberOfStudents()) return -1;
                else if (c1.getNumberOfStudents() < c2.getNumberOfStudents()) {
                    return 1;
                } else return 0;
            }
        };
        List<Course> sortedCourse1 = courses.stream().sorted(courseComparator1.thenComparing(Comparator.comparingInt(Course::getReviewScore))).toList();
        System.out.println(sortedCourse1);

        ///skip
        System.out.println(courses.stream().skip(4).toList());

        ///max
        System.out.println(courses.stream().max(Comparator.comparing(Course::getNumberOfStudents)));

        /// min
        System.out.println(courses.stream().min(Comparator.comparing(Course::getNumberOfStudents)));

        ///limit
        System.out.println(courses.stream().limit(3).toList());

        ///takeWhile
        Predicate<Course> takeCourse = (course) -> course.getReviewScore() == 4;
        System.out.println("----------------");
        System.out.println(courses.stream().takeWhile(takeCourse).toList());

        /// dropWhile
        Predicate<Course> dropCourse = (course) -> course.getReviewScore() <= 4;
        System.out.println("----------------");
        System.out.println(courses.stream().dropWhile(dropCourse).toList());

        ///findFirst
        System.out.println(courses.stream().sorted(courseReviewComp).findFirst());
        System.out.println(courses.stream().max(Comparator.comparing(Course::getReviewScore)));

        /// findAny
        System.out.println("---------------------");
        System.out.println(courses.stream().findAny());

        /// sum
        System.out.println(courses.stream().map(Course::getNumberOfStudents).mapToInt(Integer::valueOf).sum());
        System.out.println(courses.stream().mapToInt(Course::getNumberOfStudents).sum());

        /// avg
        System.out.println(courses.stream().mapToInt(Course::getNumberOfStudents).average());

        /// count
        System.out.println(courses.stream().count());

        /// ----------------------------------------------------------------------
        /// groupingBy
        System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory)));
        System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory)).keySet());
        System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory)).values());


        System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));
        System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));
        System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.mapping(Course::getName, Collectors.toList()))));
        System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getName, Collectors.mapping(Course::getNumberOfStudents, Collectors.toList()))));


        ///
        int cutOffReview = 4;
        Predicate<Course> dropCourse1 = getCoursePredicate(cutOffReview);


        /// Steams on Map - EntrySet, keySet(), values()
        Map<String, Integer> map = Map.of("A", 1, "B", 2, "C", 3);

        map.entrySet().stream()
                .forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));

        Map<String, Integer> result = map.entrySet().stream()
                .filter(e -> e.getValue() > 2)
                .collect(Collectors.toMap(k -> k.getKey(),v -> v.getValue()));

        System.out.println(result);
    }

    private static Predicate<Course> getCoursePredicate(int cutOffReview) {
        return (course) -> course.getReviewScore() <= cutOffReview;
    }
}
