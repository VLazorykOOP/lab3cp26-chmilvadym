public class Student {
    private int id;
    private String name;
    private int course;
    private double averageMark;
    private Faculty faculty;
    private StudentState state;


    private Student(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.course = builder.course;
        this.averageMark = builder.averageMark;
        this.faculty = builder.faculty;
        this.state = builder.state;
    }


    public String getName() {
        return name;
    }

    public Faculty getFaculty() {
        return faculty;
    }


    public void setState(StudentState state) {
        this.state = state;
    }


    public void performAction() {
        if (state != null) {
            state.performAction();
        } else {
            System.out.println("Стан студента не встановлено.");
        }
    }


    public static class Builder {
        private int id;
        private String name;
        private int course;
        private double averageMark;
        private Faculty faculty;
        private StudentState state; // можна залишити null

        public Builder(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder setCourse(int course) {
            this.course = course;
            return this;
        }

        public Builder setAverageMark(double averageMark) {
            this.averageMark = averageMark;
            return this;
        }

        public Builder setFaculty(Faculty faculty) {
            this.faculty = faculty;
            return this;
        }

        public Builder setState(StudentState state) {
            this.state = state;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
