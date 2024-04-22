import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static int nextId = 11;
    private static ArrayList<Employee> employees = new ArrayList<>();
    public static void main(String[] args) {

        // Dữ liệu của 10 nhân viên
        int[] ids = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] names = {"Pham", "Duc", "Nam", "Mai", "Quoc", "Doan", "Nguyen", "Duy", "Tai", "Minh"};
        int[] ages = {11, 12, 14, 19, 20, 10, 15, 33, 37, 34};
        String[] departments = {"HR", "IT", "Editor", "Marketing", "Editor", "Sales", "Teacher", "Designer", "Telesale", "Research"};
        String[] codes = {"A1", "A2", "B1", "B2", "B3", "B4", "C1", "C2", "C3", "D0"};
        double[] salaryRates = {1000.0, 2000.0, 34000.0, 37000.0, 3800.0, 3400.500, 3700.450, 3300.0, 3600.0, 3900.0};

        // Khởi tạo mỗi nhân viên và thêm vào mảng employees
        for (int i = 0; i < 10; i++) {
            employees.add(new Employee(ids[i], names[i], ages[i], departments[i], codes[i], salaryRates[i]));
        }

        // Hiển thị thông tin của từng nhân viên
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1.Them mot nhan vien vao danh sach");
            System.out.println("2.Xoa mot nhan vien khoi danh sach");
            System.out.println("3.Danh sach sinh vien");
            System.out.println("4. Thoat");

            System.out.print("Lua chon: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    addEmployee(scanner);
                    break;
                case 2:
                    deleteEmployee(scanner);
                    break;
                case 3:
                    showAllEmployee();
                case 4:
                    System.out.println("Thoat");
                    break;
                default:
                    System.out.println("Khong hop le, vui long nhap lai !");
            }
        } while (choice != 4);

        scanner.close();
    }
    private static void addEmployee(Scanner scanner) {
        System.out.print("name: ");
        String name = scanner.nextLine();
        System.out.print("age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // consume newline
        System.out.print("departmanet: ");
        String department = scanner.nextLine();
        System.out.print("code: ");
        String code = scanner.nextLine();
        System.out.print("salary rate: ");
        double salaryRate = scanner.nextDouble();
        scanner.nextLine();  // consume newline

        employees.add(new Employee(nextId++, name, age, department, code, salaryRate));
        System.out.println("Them thanh cong.");
    }
private static void showAllEmployee() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
}
    private static void deleteEmployee(Scanner scanner) {
        System.out.print("Nhap id nhan vien muon xoa: ");
        int idToDelete = scanner.nextInt();
        scanner.nextLine();  // consume newline

        boolean found = false;
        for (Employee emp : employees) {
            if (emp.getId() == idToDelete) {
                employees.remove(emp);
                found = true;
                System.out.println("Xoa thanh cong.");
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay nhan vien: " + idToDelete);
        }
    }
}