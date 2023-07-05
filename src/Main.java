import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> classes = new HashMap<>(); //Her sınıf için bir liste yapar

        addStudentsToClasses(classes, "1-a", "Hakan Sağlam");
        addStudentsToClasses(classes, "2-a", "Furkan Ekici");
        addStudentsToClasses(classes, "1-a", "Burak Tanrıverdi");
        addStudentsToClasses(classes, "4-a", "Ali Can");
        addStudentsToClasses(classes, "4-a", "Serkan Korkmaz");
        addStudentsToClasses(classes, "6-a", "Enes İşeri");
        addStudentsToClasses(classes, "8-a", "Oğulcan Sayar ");
        addStudentsToClasses(classes, "3-a", "Harun Yılmaz");
        addStudentsToClasses(classes, "1-a", "Furkan Aydın");
        addStudentsToClasses(classes, "9-a", "İbrahim Soğamvı");

        List<String> andWithAn = filterStudent(classes);

        System.out.println("Sonu 'an' ile biten öğrenciler:");
        for (String student : andWithAn) {
            System.out.println(student);
        }
    }

    public static void addStudentsToClasses(Map<String, List<String>> classes, String clas, String student) {
        List<String> students = classes.getOrDefault(clas, new ArrayList<>());
        students.add(student);
        classes.put(clas, students);
    }

    public static List<String> filterStudent(Map<String, List<String>> classes) {
        List<String> sonuAnIleBitenOgrenciler = new ArrayList<>();

        for (List<String> students : classes.values()) {
            for (String student : students) {
                String[] studentParts = student.split(" ");
                String endWord = studentParts[studentParts.length - 2];
                if (endWord.toLowerCase().endsWith("an")) {
                    sonuAnIleBitenOgrenciler.add(student);
                }
            }
        }

        return sonuAnIleBitenOgrenciler;
    }
}