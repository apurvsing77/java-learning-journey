package Interviews_prep.DesignPattern.CreationalPattern.Builder;

public class Build {
    private  final  int id ;
    private  final String name;
    private  final String subject;
    private  final String city;

    public Build(BuilderPattern builderPattern) {
        this.id = builderPattern.id;
        this.name = builderPattern.name;
        this.subject = builderPattern.subject;
        this.city = builderPattern.city;
    }

//    @Override
//    public String toString() {
//        return
//                "id=" + Objects.toString(id, "") +'\n'+
//                "name='" + Objects.toString(name, "") + '\n' +
//                "subject='" + Objects.toString(subject, "") + '\n' +
//                "city='" + Objects.toString(city, "") + '\n'
//               ;
//    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Build [");
        boolean firstField = true;

        if (id != 0) {
            sb.append("id=").append(id);
            firstField = false;
        }
        if (name != null) {
            if (!firstField) sb.append(", ");
            sb.append("name='").append(name).append("'");
            firstField = false;
        }
        if (subject != null) {
            if (!firstField) sb.append(", ");
            sb.append("subject='").append(subject).append("'");
            firstField = false;
        }
        if (city != null) {
            if (!firstField) sb.append(", ");
            sb.append("city='").append(city).append("'");
        }
        sb.append(']');
        return sb.toString();
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public String getCity() {
        return city;
    }
    public static  class BuilderPattern{

        private   int id ;
        private   String name;
        private   String subject;
        private   String city;

//        public BuilderPattern setId(int id) {
//            this.id = id;
//            return  this;
//        }


        public BuilderPattern(int id) {
            if (id == 0){
                throw new IllegalArgumentException("Id cant be null");
            }

            this.id = id;
        }

        public BuilderPattern setName(String name) {
            this.name = name;
            return  this;
        }

        public BuilderPattern setSubject(String subject) {
            this.subject = subject;
            return  this;
        }

        public BuilderPattern setCity(String city) {
            this.city = city;
            return  this;
        }

        public Build build(){
           // Build build = new Build(this);
            return new Build(this);
        }
    }
}
