package StreamsApi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AppleInterviewPrep {
    /**
     * The Class Student.
     */

    public static void main(String[] args) {
        class Student {

            /** The id. */
            private int id;

            /** The first name. */
            private String firstName;

            /** The last name. */
            private String lastName;

            /** The age. */
            private int age;

            /** The gender. */
            private String gender;

            /** The departmant name. */
            private String departmantName;

            /** The joined year. */
            private int joinedYear;

            /** The city. */
            private String city;

            /** The rank. */
            private int rank;

            /**
             * Instantiates a new employee.
             *
             * @param id the id
             * @param firstName the first name
             * @param lastName the last name
             * @param age the age
             * @param gender the gender
             * @param departmantName the departmant name
             * @param joinedYear the joined year
             * @param city the city
             * @param rank the rank
             */
            public Student(int id, String firstName, String lastName, int age, String gender, String departmantName,
                           int joinedYear, String city, int rank) {
                super();
                this.id = id;
                this.firstName = firstName;
                this.lastName = lastName;
                this.age = age;
                this.gender = gender;
                this.departmantName = departmantName;
                this.joinedYear = joinedYear;
                this.city = city;
                this.rank = rank;
            }

            /**
             * Gets the id.
             *
             * @return the id
             */
            public int getId() {
                return id;
            }

            /**
             * Sets the id.
             *
             * @param id the new id
             */
            public void setId(int id) {
                this.id = id;
            }

            /**
             * Gets the first name.
             *
             * @return the first name
             */
            public String getFirstName() {
                return firstName;
            }

            /**
             * Sets the first name.
             *
             * @param firstName the new first name
             */
            public void setFirstName(String firstName) {
                this.firstName = firstName;
            }

            /**
             * Gets the last name.
             *
             * @return the last name
             */
            public String getLastName() {
                return lastName;
            }

            /**
             * Sets the last name.
             *
             * @param lastName the new last name
             */
            public void setLastName(String lastName) {
                this.lastName = lastName;
            }

            /**
             * Gets the age.
             *
             * @return the age
             */
            public int getAge() {
                return age;
            }

            /**
             * Sets the age.
             *
             * @param age the new age
             */
            public void setAge(int age) {
                this.age = age;
            }

            /**
             * Gets the gender.
             *
             * @return the gender
             */
            public String getGender() {
                return gender;
            }

            /**
             * Sets the gender.
             *
             * @param gender the new gender
             */
            public void setGender(String gender) {
                this.gender = gender;
            }

            /**
             * Gets the departmant name.
             *
             * @return the departmant name
             */
            public String getDepartmantName() {
                return departmantName;
            }

            /**
             * Sets the departmant name.
             *
             * @param departmantName the new departmant name
             */
            public void setDepartmantName(String departmantName) {
                this.departmantName = departmantName;
            }

            /**
             * Gets the joined year.
             *
             * @return the joined year
             */
            public int getJoinedYear() {
                return joinedYear;
            }

            /**
             * Sets the joined year.
             *
             * @param joinedYear the new joined year
             */
            public void setJoinedYear(int joinedYear) {
                this.joinedYear = joinedYear;
            }

            /**
             * Gets the city.
             *
             * @return the city
             */
            public String getCity() {
                return city;
            }

            /**
             * Sets the city.
             *
             * @param city the new city
             */
            public void setCity(String city) {
                this.city = city;
            }

            /**
             * Gets the rank.
             *
             * @return the rank
             */
            public int getRank() {
                return rank;
            }

            /**
             * Sets the rank.
             *
             * @param rank the new rank
             */
            public void setRank(int rank) {
                this.rank = rank;
            }

            /**
             * To string.
             *
             * @return the string
             */
            @Override
            public String toString() {
                return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
                        + ", gender=" + gender + ", departmantName=" + departmantName + ", joinedYear=" + joinedYear + ", city="
                        + city + ", rank=" + rank + "]";
            }

        }
        List<Student> list = Arrays.asList(
                new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
                new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
                new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
                new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
                new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
                new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
                new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
                new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
                new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
                new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98));


        List<Student> st = list.stream().filter(x -> x.getFirstName().startsWith("A")).collect(Collectors.toList());
        System.out.println(st);

        var mp = list.stream().collect(Collectors.groupingBy(Student::getDepartmantName));
        System.out.println(mp);

        System.out.println(list.stream().count());

        System.out.println(list.stream().mapToInt(x -> x.getAge()).max());

        System.out.println(list.stream().map(x -> x.getDepartmantName()).distinct().collect(Collectors.toList()));

//        System.out.println(list.stream().collect(Collectors.groupingBy(Student::getDepartmantName),Collectors.counting()));

        System.out.println(list.stream().filter(x -> x.getAge() < 30).collect(Collectors.toList()));

        System.out.println(list.stream().collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()));
    }




}
