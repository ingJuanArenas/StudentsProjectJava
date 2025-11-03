import model.Student;
import service.StudentService;

public class App {
    public static void main(String[] args) throws Exception {
        var salir = false;
        StudentService.loadStudents();
        do {
           System.out.println("1. Listar estudiantes");
            System.out.println("2. Agregar estudiante");
            System.out.println("3. Calcular promedio");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            var opcion = Integer.parseInt(System.console().readLine());
            switch (opcion) {
                case 1:
                    StudentService.getStudents();
                    break;
                case 2:
                    System.out.print("Nombre del estudiante: ");
                    var name = System.console().readLine();
                    System.out.print("Nota del estudiante: ");
                    var grade = Double.parseDouble(System.console().readLine());
                    StudentService.addStudent(new Student(name, grade));
                    break;
                case 3:
                    StudentService.calculate_average();
                    break;
                case 4:
                    StudentService.getOrderedStudents();
                    break;
                case 0:
                    salir= true;
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (salir != true);
    }
}
